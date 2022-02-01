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
  private int jdField_a_of_type_Int;
  private AudioTrack jdField_a_of_type_AndroidMediaAudioTrack;
  private SilkStreamPlayer.OnSilkStreamPlay jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$OnSilkStreamPlay;
  private SilkCodecWrapper jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper;
  private InputStream jdField_a_of_type_JavaIoInputStream;
  private HttpsURLConnection jdField_a_of_type_JavaxNetSslHttpsURLConnection;
  private volatile boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = false;
  private int d;
  
  public SilkStreamPlayer$SilkStreamPlayerThread(SilkStreamPlayer paramSilkStreamPlayer, Application paramApplication, SilkStreamPlayer.OnSilkStreamPlay paramOnSilkStreamPlay, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper = new SilkCodecWrapper(paramApplication, false);
    this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$OnSilkStreamPlay = paramOnSilkStreamPlay;
    this.jdField_c_of_type_Int = paramInt1;
    this.d = paramInt2;
  }
  
  private void a(int paramInt)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Int = paramInt;
      this.jdField_a_of_type_Int = QQAudioUtils.a(paramInt);
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ArrayOfByte = new byte[i];
      this.jdField_b_of_type_ArrayOfByte = new byte[i];
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper == null) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper = new SilkCodecWrapper(MobileQQ.sMobileQQ, false);
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper.a(paramInt, 0, 1);
      }
      catch (IOException localIOException)
      {
        this.jdField_a_of_type_Boolean = false;
        QLog.d("SilkStreamPlayer", 1, "SILK解码器初始化失败", localIOException);
      }
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  private void b(int paramInt)
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      int i = AudioTrack.getMinBufferSize(paramInt, 4, 2);
      AudioTrack localAudioTrack = this.jdField_a_of_type_AndroidMediaAudioTrack;
      if (localAudioTrack != null)
      {
        localAudioTrack.pause();
        this.jdField_a_of_type_AndroidMediaAudioTrack.flush();
        this.jdField_a_of_type_AndroidMediaAudioTrack.stop();
      }
      if (this.jdField_c_of_type_Int == 1)
      {
        int j = this.d;
        if (j != 0)
        {
          this.jdField_a_of_type_AndroidMediaAudioTrack = new ReportAudioTrack(3, paramInt, 1, 2, i, 1, j);
          break label99;
        }
      }
      this.jdField_a_of_type_AndroidMediaAudioTrack = new ReportAudioTrack(3, paramInt, 1, 2, i, 1);
      label99:
      this.jdField_a_of_type_AndroidMediaAudioTrack.play();
      this.jdField_c_of_type_Boolean = true;
    }
  }
  
  void a(InputStream paramInputStream, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new byte[2];
    try
    {
      while ((this.jdField_a_of_type_Boolean) && (paramInputStream.available() > 0)) {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper == null)
        {
          this.jdField_a_of_type_Boolean = false;
        }
        else if (paramInputStream.read(paramArrayOfByte, 0, 2) <= 0)
        {
          this.jdField_a_of_type_Boolean = false;
          if (QLog.isColorLevel()) {
            QLog.d("SilkStreamPlayer", 1, "SILK帧播size解析错误");
          }
        }
        else
        {
          int i = QQAudioUtils.a(paramArrayOfByte);
          if ((i >= 0) && (i <= this.jdField_a_of_type_ArrayOfByte.length))
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
          else
          {
            this.jdField_a_of_type_Boolean = false;
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
    label1063:
    for (;;)
    {
      int j;
      try
      {
        this.jdField_a_of_type_JavaIoInputStream = TtsFileCache.a().b(MD5Coding.encodeHexStr(SilkStreamPlayer.a(this.this$0)));
        if (this.jdField_a_of_type_JavaIoInputStream == null) {
          break label1063;
        }
        j = 1;
      }
      catch (Exception localException1)
      {
        InputStream localInputStream;
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$OnSilkStreamPlay;
        if (localObject3 == null) {
          continue;
        }
        ((SilkStreamPlayer.OnSilkStreamPlay)localObject3).a(SilkStreamPlayer.a(this.this$0));
        QLog.d("SilkStreamPlayer", 2, localException1, new Object[0]);
        break label214;
      }
      catch (IOException localIOException)
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$OnSilkStreamPlay;
        if (localObject3 == null) {
          continue;
        }
        ((SilkStreamPlayer.OnSilkStreamPlay)localObject3).a(SilkStreamPlayer.a(this.this$0));
        QLog.d("SilkStreamPlayer", 2, localIOException, new Object[0]);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$OnSilkStreamPlay != null) {
        this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$OnSilkStreamPlay.b();
      }
      this.jdField_a_of_type_JavaxNetSslHttpsURLConnection = ((HttpsURLConnection)new URL("https://textts.qq.com/cgi-bin/tts").openConnection());
      this.jdField_a_of_type_JavaIoInputStream = SilkStreamPlayer.a(this.this$0, this.jdField_a_of_type_JavaxNetSslHttpsURLConnection, this.jdField_c_of_type_Int);
      if (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$OnSilkStreamPlay != null) {
        this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$OnSilkStreamPlay.a(SilkStreamPlayer.a(this.this$0));
      }
      localInputStream = this.jdField_a_of_type_JavaIoInputStream;
      if (localInputStream == null)
      {
        j = i - 1;
        i = j;
        if (j > 0) {
          continue;
        }
      }
      Object localObject3;
      label214:
      if ((this.jdField_a_of_type_JavaxNetSslHttpsURLConnection != null) && (this.jdField_a_of_type_JavaIoInputStream != null))
      {
        j = 0;
        SilkCodecWrapper localSilkCodecWrapper = this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper;
        if (localSilkCodecWrapper != null) {
          try
          {
            localSilkCodecWrapper.close();
            this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper.a();
          }
          catch (Exception localException2)
          {
            if (QLog.isColorLevel()) {
              QLog.e("SilkStreamPlayer", 1, localException2, new Object[0]);
            }
          }
        }
        this.jdField_a_of_type_Boolean = true;
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        ChunkedInputStream localChunkedInputStream = new ChunkedInputStream(this.jdField_a_of_type_JavaIoInputStream);
        ChunkedOutputStream localChunkedOutputStream = new ChunkedOutputStream(localByteArrayOutputStream);
        i = 1;
        while (this.jdField_a_of_type_Boolean)
        {
          Object localObject1;
          Object localObject4;
          if (!NetworkUtil.isNetworkAvailable(MobileQQ.sMobileQQ))
          {
            this.jdField_a_of_type_Boolean = false;
            ThreadManagerV2.getUIHandlerV2().post(new SilkStreamPlayer.SilkStreamPlayerThread.2(this));
          }
          else if (this.jdField_a_of_type_Boolean)
          {
            localObject3 = new byte[0];
            localObject1 = localObject3;
            try
            {
              if (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$OnSilkStreamPlay != null)
              {
                localObject1 = localObject3;
                this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$OnSilkStreamPlay.b();
              }
              localObject1 = localObject3;
              localObject5 = localChunkedInputStream.a();
              if ((j == 0) && (localObject5 != null))
              {
                localObject1 = localObject5;
                localChunkedOutputStream.b((byte[])localObject5, 0, localObject5.length);
              }
              localObject1 = localObject5;
              localObject3 = localObject5;
              if (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$OnSilkStreamPlay != null)
              {
                localObject1 = localObject5;
                this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$OnSilkStreamPlay.a(SilkStreamPlayer.a(this.this$0));
                localObject3 = localObject5;
              }
            }
            catch (Exception localException5)
            {
              QLog.e("SilkStreamPlayer", 1, "SilkStreamPlayerThread#run byteArray contact error", localException5);
              localObject5 = this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$OnSilkStreamPlay;
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
            int k;
            AudioTrack localAudioTrack;
            Object localObject2;
            break label553;
          }
          Object localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("TtsResBody序列化失败");
          ((StringBuilder)localObject5).append(Arrays.toString((byte[])localObject4));
          QLog.e("SilkStreamPlayer", 1, ((StringBuilder)localObject5).toString());
          k = ((TtsResBody.RspBody)localObject1).pcm_sample_rate.get();
          if (k == 0)
          {
            this.jdField_a_of_type_Boolean = false;
          }
          else
          {
            a(k);
            b(k);
            if (this.jdField_a_of_type_Boolean)
            {
              localObject5 = ((TtsResBody.RspBody)localObject1).voice_data.get();
              if (((List)localObject5).size() <= 0)
              {
                this.jdField_a_of_type_Boolean = false;
                if (QLog.isColorLevel()) {
                  QLog.e("SilkStreamPlayer", 1, "当前SILK帧无数据");
                }
              }
              else
              {
                k = 0;
                while ((k < ((List)localObject5).size()) && (this.jdField_a_of_type_Boolean))
                {
                  localObject4 = ((TtsResBody.voice_item)((List)localObject5).get(k)).voice.get().toByteArray();
                  int m = i;
                  localObject1 = localObject4;
                  if (i != 0)
                  {
                    m = i;
                    localObject1 = localObject4;
                    if (SilkStreamPlayer.a(this.this$0, (byte[])localObject4))
                    {
                      localObject1 = SilkStreamPlayer.a(this.this$0, (byte[])localObject4, 10, localObject4.length - 10);
                      m = 0;
                    }
                  }
                  a(new ByteArrayInputStream((byte[])localObject1), (byte[])localObject1);
                  k += 1;
                  i = m;
                }
                continue;
                this.jdField_a_of_type_Boolean = false;
                try
                {
                  localChunkedOutputStream.close();
                  i = 1;
                }
                catch (Exception localException3)
                {
                  QLog.e("SilkStreamPlayer", 1, "cout close err: ", localException3);
                }
              }
            }
          }
        }
        i = 0;
        if ((j == 0) && (i != 0)) {
          TtsFileCache.a().a(SilkStreamPlayer.a(this.this$0), localByteArrayOutputStream);
        }
        this.jdField_a_of_type_Boolean = false;
        localAudioTrack = this.jdField_a_of_type_AndroidMediaAudioTrack;
        if ((localAudioTrack != null) && (localAudioTrack.getState() != 0))
        {
          try
          {
            this.jdField_a_of_type_AndroidMediaAudioTrack.pause();
            this.jdField_a_of_type_AndroidMediaAudioTrack.flush();
            this.jdField_a_of_type_AndroidMediaAudioTrack.stop();
            this.jdField_a_of_type_AndroidMediaAudioTrack.release();
            if (this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper != null) {
              this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper.a();
            }
            localChunkedInputStream.close();
            if (this.jdField_a_of_type_JavaIoInputStream.available() > 0) {
              this.jdField_a_of_type_JavaIoInputStream.close();
            }
            this.jdField_a_of_type_JavaxNetSslHttpsURLConnection.disconnect();
          }
          catch (Exception localException4)
          {
            if (QLog.isColorLevel()) {
              QLog.d("SilkStreamPlayer", 1, localException4, new Object[0]);
            }
          }
          this.jdField_a_of_type_AndroidMediaAudioTrack = null;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper;
        if (localObject2 != null) {
          ((SilkCodecWrapper)localObject2).b();
        }
        this.jdField_b_of_type_Boolean = false;
        this.jdField_c_of_type_Boolean = false;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$OnSilkStreamPlay;
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
      label553:
      int i = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.tts.SilkStreamPlayer.SilkStreamPlayerThread
 * JD-Core Version:    0.7.0.1
 */