package com.tencent.mobileqq.tts;

import android.app.Application;
import android.media.AudioTrack;
import android.os.Handler;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.richmedia.TtsResBody.RspBody;
import com.tencent.mobileqq.richmedia.TtsResBody.voice_item;
import com.tencent.mobileqq.tts.data.TtsFileCache;
import com.tencent.mobileqq.tts.stream.ChunkedInputStream;
import com.tencent.mobileqq.tts.stream.ChunkedOutputStream;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import mqq.app.MobileQQ;

class SilkStreamPlayer$SilkStreamPlayerThread
  implements Runnable
{
  private SilkCodecWrapper a;
  private byte[] b;
  private byte[] c;
  private volatile boolean d;
  private AudioTrack e;
  private int f;
  private int g;
  private SilkStreamPlayer.OnSilkStreamPlay h;
  private InputStream i;
  private HttpsURLConnection j;
  private int k;
  private int l;
  private boolean m = false;
  private boolean n = false;
  
  public SilkStreamPlayer$SilkStreamPlayerThread(SilkStreamPlayer paramSilkStreamPlayer, Application paramApplication, SilkStreamPlayer.OnSilkStreamPlay paramOnSilkStreamPlay, int paramInt1, int paramInt2)
  {
    this.a = new SilkCodecWrapper(paramApplication, false);
    this.h = paramOnSilkStreamPlay;
    this.k = paramInt1;
    this.l = paramInt2;
  }
  
  private void a(int paramInt)
  {
    if (!this.m)
    {
      this.g = paramInt;
      this.f = QQAudioUtils.a(paramInt);
      int i1 = this.f;
      this.b = new byte[i1];
      this.c = new byte[i1];
      try
      {
        if (this.a == null) {
          this.a = new SilkCodecWrapper(MobileQQ.sMobileQQ, false);
        }
        this.a.a(paramInt, 0, 1);
      }
      catch (IOException localIOException)
      {
        this.d = false;
        QLog.d("SilkStreamPlayer", 1, "SILK解码器初始化失败", localIOException);
      }
      this.m = true;
    }
  }
  
  private void b(int paramInt)
  {
    if (!this.n)
    {
      int i1 = AudioTrack.getMinBufferSize(paramInt, 4, 2);
      AudioTrack localAudioTrack = this.e;
      if (localAudioTrack != null)
      {
        localAudioTrack.pause();
        this.e.flush();
        this.e.stop();
      }
      if (this.k == 1)
      {
        int i2 = this.l;
        if (i2 != 0)
        {
          this.e = new ReportAudioTrack(3, paramInt, 1, 2, i1, 1, i2);
          break label99;
        }
      }
      this.e = new ReportAudioTrack(3, paramInt, 1, 2, i1, 1);
      label99:
      this.e.play();
      this.n = true;
    }
  }
  
  void a(InputStream paramInputStream, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new byte[2];
    try
    {
      while ((this.d) && (paramInputStream.available() > 0)) {
        if (this.a == null)
        {
          this.d = false;
        }
        else if (paramInputStream.read(paramArrayOfByte, 0, 2) <= 0)
        {
          this.d = false;
          if (QLog.isColorLevel()) {
            QLog.d("SilkStreamPlayer", 1, "SILK帧播size解析错误");
          }
        }
        else
        {
          int i1 = QQAudioUtils.b(paramArrayOfByte);
          if ((i1 >= 0) && (i1 <= this.b.length))
          {
            paramInputStream.read(this.b, 0, i1);
            i1 = this.a.a(this.b, this.c, i1, this.c.length);
            if (i1 < 0)
            {
              this.d = false;
              if (QLog.isColorLevel()) {
                QLog.d("SilkStreamPlayer", 1, "SILK解码器解码错误");
              }
            }
            else if (this.d)
            {
              i1 = this.e.write(this.c, 0, i1);
              this.e.flush();
              if (i1 < 0)
              {
                this.d = false;
                if (QLog.isColorLevel()) {
                  QLog.e("SilkStreamPlayer", 1, "AudioTrack播放缓冲区写入错误");
                }
              }
            }
          }
          else
          {
            this.d = false;
            if (QLog.isColorLevel()) {
              QLog.d("SilkStreamPlayer", 1, "SILK帧size不在正确范围内");
            }
          }
        }
      }
      paramInputStream.close();
      return;
    }
    catch (Exception paramInputStream)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("SilkStreamPlayer", 2, paramInputStream, new Object[0]);
        return;
      }
    }
    catch (IOException paramInputStream)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SilkStreamPlayer", 2, paramInputStream, new Object[0]);
      }
    }
  }
  
  public void run()
  {
    label1064:
    for (;;)
    {
      int i2;
      try
      {
        this.i = TtsFileCache.a().b(MD5Coding.encodeHexStr(SilkStreamPlayer.a(this.this$0)));
        if (this.i == null) {
          break label1064;
        }
        i2 = 1;
      }
      catch (Exception localException1)
      {
        InputStream localInputStream;
        localObject3 = this.h;
        if (localObject3 == null) {
          continue;
        }
        ((SilkStreamPlayer.OnSilkStreamPlay)localObject3).a(SilkStreamPlayer.a(this.this$0));
        QLog.d("SilkStreamPlayer", 2, localException1, new Object[0]);
        break label214;
      }
      catch (IOException localIOException)
      {
        localObject3 = this.h;
        if (localObject3 == null) {
          continue;
        }
        ((SilkStreamPlayer.OnSilkStreamPlay)localObject3).a(SilkStreamPlayer.a(this.this$0));
        QLog.d("SilkStreamPlayer", 2, localIOException, new Object[0]);
      }
      if (this.h != null) {
        this.h.c();
      }
      this.j = ((HttpsURLConnection)new URL("https://textts.qq.com/cgi-bin/tts").openConnection());
      this.i = SilkStreamPlayer.a(this.this$0, this.j, this.k);
      if (this.h != null) {
        this.h.a(SilkStreamPlayer.a(this.this$0));
      }
      localInputStream = this.i;
      if (localInputStream == null)
      {
        i2 = i1 - 1;
        i1 = i2;
        if (i2 > 0) {
          continue;
        }
      }
      Object localObject3;
      label214:
      if ((this.j != null) && (this.i != null))
      {
        i2 = 0;
        SilkCodecWrapper localSilkCodecWrapper = this.a;
        if (localSilkCodecWrapper != null) {
          try
          {
            localSilkCodecWrapper.close();
            this.a.a();
          }
          catch (Exception localException2)
          {
            if (QLog.isColorLevel()) {
              QLog.e("SilkStreamPlayer", 1, localException2, new Object[0]);
            }
          }
        }
        this.d = true;
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        ChunkedInputStream localChunkedInputStream = new ChunkedInputStream(this.i);
        ChunkedOutputStream localChunkedOutputStream = new ChunkedOutputStream(localByteArrayOutputStream);
        i1 = 1;
        while (this.d)
        {
          Object localObject1;
          Object localObject4;
          if (!NetworkUtil.isNetworkAvailable(MobileQQ.sMobileQQ))
          {
            this.d = false;
            ThreadManagerV2.getUIHandlerV2().post(new SilkStreamPlayer.SilkStreamPlayerThread.2(this));
          }
          else if (this.d)
          {
            localObject3 = new byte[0];
            localObject1 = localObject3;
            try
            {
              if (this.h != null)
              {
                localObject1 = localObject3;
                this.h.c();
              }
              localObject1 = localObject3;
              localObject5 = localChunkedInputStream.a();
              if ((i2 == 0) && (localObject5 != null))
              {
                localObject1 = localObject5;
                localChunkedOutputStream.b((byte[])localObject5, 0, localObject5.length);
              }
              localObject1 = localObject5;
              localObject3 = localObject5;
              if (this.h != null)
              {
                localObject1 = localObject5;
                this.h.a(SilkStreamPlayer.a(this.this$0));
                localObject3 = localObject5;
              }
            }
            catch (Exception localException5)
            {
              QLog.e("SilkStreamPlayer", 1, "SilkStreamPlayerThread#run byteArray contact error", localException5);
              localObject5 = this.h;
              localObject4 = localObject1;
              if (localObject5 != null)
              {
                ((SilkStreamPlayer.OnSilkStreamPlay)localObject5).a(SilkStreamPlayer.a(this.this$0));
                localObject4 = localObject1;
              }
            }
            if ((localObject4 != null) && (localObject4.length != 0)) {
              localObject1 = new TtsResBody.RspBody();
            }
          }
          try
          {
            ((TtsResBody.RspBody)localObject1).mergeFrom((byte[])localObject4);
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
          {
            int i3;
            AudioTrack localAudioTrack;
            Object localObject2;
            break label554;
          }
          Object localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("TtsResBody序列化失败");
          ((StringBuilder)localObject5).append(Arrays.toString((byte[])localObject4));
          QLog.e("SilkStreamPlayer", 1, ((StringBuilder)localObject5).toString());
          i3 = ((TtsResBody.RspBody)localObject1).pcm_sample_rate.get();
          if (i3 == 0)
          {
            this.d = false;
          }
          else
          {
            a(i3);
            b(i3);
            if (this.d)
            {
              localObject5 = ((TtsResBody.RspBody)localObject1).voice_data.get();
              if (((List)localObject5).size() <= 0)
              {
                this.d = false;
                if (QLog.isColorLevel()) {
                  QLog.e("SilkStreamPlayer", 1, "当前SILK帧无数据");
                }
              }
              else
              {
                i3 = 0;
                while ((i3 < ((List)localObject5).size()) && (this.d))
                {
                  localObject4 = ((TtsResBody.voice_item)((List)localObject5).get(i3)).voice.get().toByteArray();
                  int i4 = i1;
                  localObject1 = localObject4;
                  if (i1 != 0)
                  {
                    i4 = i1;
                    localObject1 = localObject4;
                    if (SilkStreamPlayer.a(this.this$0, (byte[])localObject4))
                    {
                      localObject1 = SilkStreamPlayer.a(this.this$0, (byte[])localObject4, 10, localObject4.length - 10);
                      i4 = 0;
                    }
                  }
                  a(new ByteArrayInputStream((byte[])localObject1), (byte[])localObject1);
                  i3 += 1;
                  i1 = i4;
                }
                continue;
                this.d = false;
                try
                {
                  localChunkedOutputStream.close();
                  i1 = 1;
                }
                catch (Exception localException3)
                {
                  QLog.e("SilkStreamPlayer", 1, "cout close err: ", localException3);
                }
              }
            }
          }
        }
        i1 = 0;
        if ((i2 == 0) && (i1 != 0)) {
          TtsFileCache.a().a(SilkStreamPlayer.a(this.this$0), localByteArrayOutputStream);
        }
        this.d = false;
        localAudioTrack = this.e;
        if ((localAudioTrack != null) && (localAudioTrack.getState() != 0))
        {
          try
          {
            this.e.pause();
            this.e.flush();
            this.e.stop();
            this.e.release();
            if (this.a != null) {
              this.a.a();
            }
            localChunkedInputStream.close();
            if (this.i.available() > 0) {
              this.i.close();
            }
            this.j.disconnect();
          }
          catch (Exception localException4)
          {
            if (QLog.isColorLevel()) {
              QLog.d("SilkStreamPlayer", 1, localException4, new Object[0]);
            }
          }
          this.e = null;
        }
        localObject2 = this.a;
        if (localObject2 != null) {
          ((SilkCodecWrapper)localObject2).c();
        }
        this.m = false;
        this.n = false;
        localObject2 = this.h;
        if (localObject2 != null) {
          ((SilkStreamPlayer.OnSilkStreamPlay)localObject2).b(SilkStreamPlayer.a(this.this$0));
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          QLog.d("SilkStreamPlayer", 1, "InputStream / 网络连接失败");
          ThreadManagerV2.getUIHandlerV2().post(new SilkStreamPlayer.SilkStreamPlayerThread.1(this));
        }
        return;
      }
      label554:
      int i1 = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tts.SilkStreamPlayer.SilkStreamPlayerThread
 * JD-Core Version:    0.7.0.1
 */