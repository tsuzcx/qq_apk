package com.tencent.mobileqq.tts.impl;

import android.media.AudioTrack;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.richmedia.TtsResBody.RspBody;
import com.tencent.mobileqq.richmedia.TtsResBody.voice_item;
import com.tencent.mobileqq.tts.silk.IPlayerCallback;
import com.tencent.mobileqq.tts.stream.ChunkedInputStream;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import mqq.app.MobileQQ;

class TtsPlayerImpl$PlayerThread
  implements Runnable
{
  private SilkCodecWrapper a;
  private AudioTrack b;
  private volatile boolean c;
  private int d;
  private byte[] e;
  private byte[] f;
  
  private TtsPlayerImpl$PlayerThread(TtsPlayerImpl paramTtsPlayerImpl) {}
  
  private void a(int paramInt)
  {
    int i;
    if (this.a == null)
    {
      this.a = new SilkCodecWrapper(MobileQQ.sMobileQQ, false);
      try
      {
        this.a.a(paramInt, 0, 1);
        i = QQAudioUtils.a(paramInt);
        this.e = new byte[i];
        this.f = new byte[i];
      }
      catch (Exception localException1)
      {
        QLog.e("TtsPlayer", 1, "[initCodecResource] error: ", localException1);
        this.a = null;
        return;
      }
    }
    if (this.b == null) {
      try
      {
        i = AudioTrack.getMinBufferSize(paramInt, 4, 2);
        if (this.d != 0) {
          this.b = new ReportAudioTrack(3, paramInt, 1, 2, i, 1, this.d);
        } else {
          this.b = new ReportAudioTrack(3, paramInt, 1, 2, i, 1);
        }
        this.b.play();
        return;
      }
      catch (Exception localException2)
      {
        QLog.e("TtsPlayer", 1, "[initCodecResource] AudioTrack init error: ", localException2);
        this.b.release();
        this.b = null;
      }
    }
  }
  
  int a(InputStream paramInputStream)
  {
    byte[] arrayOfByte = new byte[2];
    if (paramInputStream.read(arrayOfByte, 0, 2) > 0) {
      return QQAudioUtils.b(arrayOfByte);
    }
    return -1;
  }
  
  boolean b(InputStream paramInputStream)
  {
    for (;;)
    {
      bool = false;
      try
      {
        if ((this.c) && (paramInputStream.available() > 0))
        {
          int i = a(paramInputStream);
          if ((i >= 0) && (i <= this.e.length))
          {
            if (paramInputStream.read(this.e, 0, i) < 0)
            {
              QLog.d("TtsPlayer", 1, "[playSilkStream] readSize < 0, stream end.");
            }
            else
            {
              i = this.a.a(this.e, this.f, i, this.f.length);
              if (i < 0)
              {
                QLog.d("TtsPlayer", 1, new Object[] { "[playSilkStream] silk decode error. decodeSize: ", Integer.valueOf(i) });
                break label228;
              }
              if (!this.c) {
                continue;
              }
              i = this.b.write(this.f, 0, i);
              this.b.flush();
              if (i >= 0) {
                continue;
              }
              QLog.e("TtsPlayer", 1, new Object[] { "[playSilkStream] AudioTrack error. writeSize: ", Integer.valueOf(i) });
              break label228;
            }
          }
          else {
            QLog.d("TtsPlayer", 1, new Object[] { "[playSilkStream] silk frameSize invalid. size: ", Integer.valueOf(i) });
          }
        }
      }
      catch (Exception localException)
      {
        QLog.d("TtsPlayer", 1, localException, new Object[0]);
      }
      catch (IOException localIOException)
      {
        QLog.d("TtsPlayer", 1, localIOException, new Object[0]);
      }
    }
    boolean bool = true;
    try
    {
      label228:
      paramInputStream.close();
      return bool;
    }
    catch (Exception paramInputStream)
    {
      QLog.e("TtsPlayer", 1, "musicInput close error, ", paramInputStream);
    }
    return bool;
  }
  
  public void run()
  {
    boolean bool = this.c;
    int m = 1;
    if (bool)
    {
      QLog.d("TtsPlayer", 1, "[PlayerThread] other thread is working.");
      return;
    }
    this.c = true;
    if (TtsPlayerImpl.access$000(this.this$0) == null)
    {
      QLog.d("TtsPlayer", 1, "[PlayerThread] inputStream is null.");
      return;
    }
    ChunkedInputStream localChunkedInputStream = new ChunkedInputStream(TtsPlayerImpl.access$000(this.this$0));
    int i = 1;
    for (;;)
    {
      if (this.c) {
        try
        {
          if (TtsPlayerImpl.access$100(this.this$0) != null) {
            TtsPlayerImpl.access$100(this.this$0).c();
          }
          byte[] arrayOfByte1 = localChunkedInputStream.a();
          if (TtsPlayerImpl.access$100(this.this$0) != null) {
            TtsPlayerImpl.access$100(this.this$0).d();
          }
          if ((arrayOfByte1 != null) && (arrayOfByte1.length != 0))
          {
            Object localObject = new TtsResBody.RspBody();
            try
            {
              ((TtsResBody.RspBody)localObject).mergeFrom(arrayOfByte1);
            }
            catch (Exception localException)
            {
              QLog.e("TtsPlayer", 1, "[PlayerThread] instance error.", localException);
            }
            int j = ((TtsResBody.RspBody)localObject).pcm_sample_rate.get();
            if (j == 0)
            {
              QLog.d("TtsPlayer", 1, "[PlayerThread] rate is 0.");
            }
            else
            {
              a(j);
              if ((this.b != null) && (this.a != null))
              {
                List localList = ((TtsResBody.RspBody)localObject).voice_data.get();
                if ((localList != null) && (localList.size() != 0))
                {
                  int k = 0;
                  for (;;)
                  {
                    j = i;
                    if (k >= localList.size()) {
                      break;
                    }
                    j = i;
                    if (!this.c) {
                      break;
                    }
                    byte[] arrayOfByte2 = ((TtsResBody.voice_item)localList.get(k)).voice.get().toByteArray();
                    j = i;
                    localObject = arrayOfByte2;
                    if (i != 0)
                    {
                      j = i;
                      localObject = arrayOfByte2;
                      if (TtsPlayerImpl.access$200(arrayOfByte2))
                      {
                        localObject = TtsPlayerImpl.access$300(arrayOfByte2, 10, arrayOfByte2.length - 10);
                        j = 0;
                      }
                    }
                    if (!b(new ByteArrayInputStream((byte[])localObject)))
                    {
                      this.c = false;
                      break;
                    }
                    k += 1;
                    i = j;
                  }
                  i = j;
                  continue;
                }
                QLog.e("TtsPlayer", 1, "[PlayerThread] no voice data.");
                i = m;
                break label447;
              }
              QLog.e("TtsPlayer", 1, "[PlayerThread] codec init failed.");
            }
          }
          else
          {
            QLog.d("TtsPlayer", 1, "[PlayerThread] play complete.");
            i = m;
          }
        }
        catch (IOException localIOException)
        {
          QLog.e("TtsPlayer", 1, "[PlayerThread] get chunk input stream error. ", localIOException);
          if (TtsPlayerImpl.access$100(this.this$0) != null) {
            TtsPlayerImpl.access$100(this.this$0).b();
          }
        }
      }
    }
    i = 0;
    label447:
    this.c = false;
    if ((i != 0) && (TtsPlayerImpl.access$100(this.this$0) != null)) {
      TtsPlayerImpl.access$100(this.this$0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tts.impl.TtsPlayerImpl.PlayerThread
 * JD-Core Version:    0.7.0.1
 */