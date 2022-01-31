package com.tencent.mobileqq.tts;

import android.app.Application;
import android.media.AudioTrack;
import android.os.Handler;
import bauf;
import baug;
import bauh;
import baul;
import bbev;
import bbis;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.richmedia.TtsResBody.RspBody;
import com.tencent.mobileqq.richmedia.TtsResBody.voice_item;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;

class SilkStreamPlayer$SilkStreamPlayerThread
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private AudioTrack jdField_a_of_type_AndroidMediaAudioTrack;
  private SilkCodecWrapper jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper;
  private volatile boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private boolean c;
  
  public SilkStreamPlayer$SilkStreamPlayerThread(SilkStreamPlayer paramSilkStreamPlayer, Application paramApplication)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper = new SilkCodecWrapper(paramApplication, false);
  }
  
  private void a(int paramInt)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Int = paramInt;
      this.jdField_a_of_type_Int = bbis.a(paramInt);
      this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int];
      this.jdField_b_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int];
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper == null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper = new SilkCodecWrapper(SilkStreamPlayer.a(this.this$0), false);
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper.a(paramInt, 0, 1);
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        this.jdField_a_of_type_Boolean = false;
        QLog.d("SilkStreamPlayer", 1, "SILK解码器初始化失败", localIOException);
      }
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void b(int paramInt)
  {
    if (!this.c)
    {
      int i = AudioTrack.getMinBufferSize(paramInt, 4, 2);
      if (this.jdField_a_of_type_AndroidMediaAudioTrack != null)
      {
        this.jdField_a_of_type_AndroidMediaAudioTrack.pause();
        this.jdField_a_of_type_AndroidMediaAudioTrack.flush();
        this.jdField_a_of_type_AndroidMediaAudioTrack.stop();
      }
      this.jdField_a_of_type_AndroidMediaAudioTrack = new AudioTrack(3, paramInt, 1, 2, i, 1);
      this.jdField_a_of_type_AndroidMediaAudioTrack.play();
      this.c = true;
    }
  }
  
  void a(InputStream paramInputStream, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new byte[2];
    try
    {
      if ((this.jdField_a_of_type_Boolean) && (paramInputStream.available() > 0))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper != null) {
          break label35;
        }
        this.jdField_a_of_type_Boolean = false;
      }
      for (;;)
      {
        paramInputStream.close();
        return;
        label35:
        if (paramInputStream.read(paramArrayOfByte, 0, 2) > 0) {
          break;
        }
        this.jdField_a_of_type_Boolean = false;
        if (QLog.isColorLevel()) {
          QLog.d("SilkStreamPlayer", 1, "SILK帧播size解析错误");
        }
      }
    }
    catch (IOException paramInputStream)
    {
      while (QLog.isColorLevel())
      {
        QLog.d("SilkStreamPlayer", 2, paramInputStream, new Object[0]);
        return;
        int i = bbis.a(paramArrayOfByte);
        if ((i < 0) || (i > this.jdField_a_of_type_ArrayOfByte.length))
        {
          this.jdField_a_of_type_Boolean = false;
          if (QLog.isColorLevel()) {
            QLog.d("SilkStreamPlayer", 1, "SILK帧size不在正确范围内");
          }
        }
        else
        {
          paramInputStream.read(this.jdField_a_of_type_ArrayOfByte, 0, i);
          i = this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte, i, this.jdField_b_of_type_ArrayOfByte.length);
          if (i < 0)
          {
            this.jdField_a_of_type_Boolean = false;
            if (QLog.isColorLevel()) {
              QLog.d("SilkStreamPlayer", 1, "SILK解码器解码错误");
            }
          }
          else if (this.jdField_a_of_type_Boolean)
          {
            i = this.jdField_a_of_type_AndroidMediaAudioTrack.write(this.jdField_b_of_type_ArrayOfByte, 0, i);
            this.jdField_a_of_type_AndroidMediaAudioTrack.flush();
            if (i < 0)
            {
              this.jdField_a_of_type_Boolean = false;
              if (QLog.isColorLevel()) {
                QLog.e("SilkStreamPlayer", 1, "AudioTrack播放缓冲区写入错误");
              }
            }
          }
        }
      }
    }
  }
  
  public void run()
  {
    SilkStreamPlayer.a(this.this$0, baul.a().a(MD5Coding.encodeHexStr(SilkStreamPlayer.a(this.this$0))));
    int j;
    if (SilkStreamPlayer.a(this.this$0) != null) {
      j = 1;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper != null) {}
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper.close();
        this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper.a();
        this.jdField_a_of_type_Boolean = true;
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        localbauf = new bauf(SilkStreamPlayer.a(this.this$0));
        localbaug = new baug(localByteArrayOutputStream);
        i = 1;
        if (this.jdField_a_of_type_Boolean)
        {
          if (!bbev.g(SilkStreamPlayer.a(this.this$0)))
          {
            this.jdField_a_of_type_Boolean = false;
            ThreadManagerV2.getUIHandlerV2().post(new SilkStreamPlayer.SilkStreamPlayerThread.2(this));
            i = 0;
            if ((j == 0) && (i != 0)) {
              baul.a().a(SilkStreamPlayer.a(this.this$0), localByteArrayOutputStream);
            }
            this.jdField_a_of_type_Boolean = false;
            if ((this.jdField_a_of_type_AndroidMediaAudioTrack == null) || (this.jdField_a_of_type_AndroidMediaAudioTrack.getState() == 0)) {}
          }
          try
          {
            this.jdField_a_of_type_AndroidMediaAudioTrack.pause();
            this.jdField_a_of_type_AndroidMediaAudioTrack.flush();
            this.jdField_a_of_type_AndroidMediaAudioTrack.stop();
            this.jdField_a_of_type_AndroidMediaAudioTrack.release();
            if (this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper != null) {
              this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper.a();
            }
            localbauf.close();
            if (SilkStreamPlayer.a(this.this$0).available() > 0) {
              SilkStreamPlayer.a(this.this$0).close();
            }
            SilkStreamPlayer.a(this.this$0).disconnect();
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              Object localObject3;
              Object localObject1;
              byte[] arrayOfByte;
              Object localObject4;
              Object localObject2;
              int k;
              List localList;
              int m;
              if (QLog.isColorLevel()) {
                QLog.d("SilkStreamPlayer", 1, localException2, new Object[0]);
              }
            }
          }
          this.jdField_a_of_type_AndroidMediaAudioTrack = null;
          this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper.b();
          this.jdField_b_of_type_Boolean = false;
          this.c = false;
          if (SilkStreamPlayer.a(this.this$0) != null) {
            SilkStreamPlayer.a(this.this$0).c();
          }
          do
          {
            return;
            i = 3;
            try
            {
              do
              {
                if (SilkStreamPlayer.a(this.this$0) != null) {
                  SilkStreamPlayer.a(this.this$0).a();
                }
                SilkStreamPlayer.a(this.this$0, SilkStreamPlayer.b(this.this$0));
                if (SilkStreamPlayer.a(this.this$0) != null) {
                  SilkStreamPlayer.a(this.this$0).b();
                }
                InputStream localInputStream = SilkStreamPlayer.a(this.this$0);
                if (localInputStream != null) {
                  break;
                }
                j = i - 1;
                i = j;
              } while (j > 0);
            }
            catch (IOException localIOException1)
            {
              for (;;)
              {
                if (SilkStreamPlayer.a(this.this$0) != null) {
                  SilkStreamPlayer.a(this.this$0).b();
                }
                QLog.d("SilkStreamPlayer", 2, localIOException1, new Object[0]);
              }
            }
            if ((SilkStreamPlayer.a(this.this$0) != null) && (SilkStreamPlayer.a(this.this$0) != null)) {
              break label1007;
            }
          } while (!QLog.isColorLevel());
          QLog.d("SilkStreamPlayer", 1, "InputStream / 网络连接失败");
          ThreadManagerV2.getUIHandlerV2().post(new SilkStreamPlayer.SilkStreamPlayerThread.1(this));
          return;
        }
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          bauf localbauf;
          baug localbaug;
          int i;
          if (QLog.isColorLevel())
          {
            QLog.e("SilkStreamPlayer", 1, localIOException2, new Object[0]);
            continue;
            if (!this.jdField_a_of_type_Boolean)
            {
              i = 0;
            }
            else
            {
              localObject3 = new byte[0];
              localObject1 = localObject3;
              try
              {
                if (SilkStreamPlayer.a(this.this$0) != null)
                {
                  localObject1 = localObject3;
                  SilkStreamPlayer.a(this.this$0).a();
                }
                localObject1 = localObject3;
                arrayOfByte = localbauf.a();
                if ((j == 0) && (arrayOfByte != null))
                {
                  localObject1 = arrayOfByte;
                  localbaug.b(arrayOfByte, 0, arrayOfByte.length);
                }
                localObject3 = arrayOfByte;
                localObject1 = arrayOfByte;
                if (SilkStreamPlayer.a(this.this$0) != null)
                {
                  localObject1 = arrayOfByte;
                  SilkStreamPlayer.a(this.this$0).b();
                  localObject3 = arrayOfByte;
                }
                if ((localObject3 != null) && (localObject3.length != 0)) {
                  break label718;
                }
                this.jdField_a_of_type_Boolean = false;
              }
              catch (IOException localIOException3)
              {
                for (;;)
                {
                  try
                  {
                    localbaug.close();
                    i = 1;
                  }
                  catch (Exception localException1)
                  {
                    QLog.e("SilkStreamPlayer", 1, "cout close err: ", localException1);
                    i = 0;
                  }
                  localIOException3 = localIOException3;
                  QLog.e("SilkStreamPlayer", 1, "SilkStreamPlayerThread#run byteArray contact error", localIOException3);
                  localObject4 = localObject1;
                  if (SilkStreamPlayer.a(this.this$0) != null)
                  {
                    SilkStreamPlayer.a(this.this$0).b();
                    localObject4 = localObject1;
                  }
                }
              }
              continue;
              label718:
              localObject2 = new TtsResBody.RspBody();
              try
              {
                ((TtsResBody.RspBody)localObject2).mergeFrom((byte[])localObject4);
                k = ((TtsResBody.RspBody)localObject2).pcm_sample_rate.get();
                if (k == 0)
                {
                  this.jdField_a_of_type_Boolean = false;
                  i = 0;
                }
              }
              catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
              {
                for (;;)
                {
                  QLog.e("SilkStreamPlayer", 1, "TtsResBody序列化失败" + localObject4);
                }
                a(k);
                b(k);
                if (!this.jdField_a_of_type_Boolean)
                {
                  i = 0;
                  continue;
                }
                localList = ((TtsResBody.RspBody)localObject2).voice_data.get();
                if (localList.size() <= 0)
                {
                  this.jdField_a_of_type_Boolean = false;
                  if (!QLog.isColorLevel()) {
                    break label1002;
                  }
                  QLog.e("SilkStreamPlayer", 1, "当前SILK帧无数据");
                  i = 0;
                  continue;
                }
                k = 0;
                while ((k < localList.size()) && (this.jdField_a_of_type_Boolean))
                {
                  localObject4 = ((TtsResBody.voice_item)localList.get(k)).voice.get().toByteArray();
                  localObject2 = localObject4;
                  m = i;
                  if (i != 0)
                  {
                    localObject2 = localObject4;
                    m = i;
                    if (SilkStreamPlayer.a(this.this$0, (byte[])localObject4))
                    {
                      localObject2 = SilkStreamPlayer.a(this.this$0, (byte[])localObject4, 10, localObject4.length - 10);
                      m = 0;
                    }
                  }
                  a(new ByteArrayInputStream((byte[])localObject2), (byte[])localObject2);
                  k += 1;
                  i = m;
                }
              }
              continue;
              label1002:
              i = 0;
            }
          }
        }
        label1007:
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.tts.SilkStreamPlayer.SilkStreamPlayerThread
 * JD-Core Version:    0.7.0.1
 */