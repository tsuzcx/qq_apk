package com.tencent.mobileqq.voicechange;

import android.content.Context;
import android.media.AudioTrack;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.ptt.processor.IPttProcessor;
import com.tencent.mobileqq.ptt.processor.IPttProcessor.ProcessData;
import com.tencent.mobileqq.ptt.processor.IPttProcessorListener;
import com.tencent.mobileqq.ptt.processor.PttCompositeProcessor;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.utils.AmrInputStreamWrapper;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.mobileqq.utils.WechatNsWrapper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class QQVoiceChangerThread
  extends Thread
  implements IPttProcessorListener
{
  int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private AudioTrack jdField_a_of_type_AndroidMediaAudioTrack;
  private PttCompositeProcessor jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor;
  IVoiceChangeListener jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener;
  VoiceChangeBasicParams jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams;
  VoiceChangeModeParams jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams;
  private FileInputStream jdField_a_of_type_JavaIoFileInputStream;
  private FileOutputStream jdField_a_of_type_JavaIoFileOutputStream;
  public String a;
  public volatile boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[960];
  int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  int c = 0;
  
  public QQVoiceChangerThread(Context paramContext, VoiceChangeBasicParams paramVoiceChangeBasicParams, VoiceChangeModeParams paramVoiceChangeModeParams, String paramString, IVoiceChangeListener paramIVoiceChangeListener)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_JavaLangString = paramVoiceChangeBasicParams.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams = paramVoiceChangeBasicParams;
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams = paramVoiceChangeModeParams;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener = paramIVoiceChangeListener;
    if (QLog.isColorLevel()) {
      QLog.d("QQVoiceChanger", 2, "new QQVoiceChangerThread filePath=" + this.jdField_b_of_type_JavaLangString + " sampleRate=" + paramVoiceChangeBasicParams.jdField_b_of_type_Int + " bitRate=" + paramVoiceChangeBasicParams.d + " voiceType=" + paramVoiceChangeBasicParams.e + " changeType=" + paramVoiceChangeBasicParams.f);
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = (int)AudioHelper.a(this.jdField_a_of_type_AndroidContentContext, paramArrayOfByte, paramInt, 1.0F);
    if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener.a(i, this.c * 100 / this.jdField_b_of_type_Int, this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_AndroidMediaAudioTrack.write(paramArrayOfByte, 0, paramInt);
  }
  
  private void e()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams.jdField_a_of_type_JavaLangString;
    if (!TextUtils.isEmpty(str)) {}
    for (this.jdField_b_of_type_JavaLangString = str;; this.jdField_b_of_type_JavaLangString = VoiceTuneUtil.a(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaIoFileInputStream = new FileInputStream(this.jdField_b_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("QQVoiceChanger", 2, "open:" + this.jdField_b_of_type_JavaLangString + " a=" + this.jdField_a_of_type_JavaIoFileInputStream.available());
      }
      return;
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioTrack != null) {
      this.jdField_a_of_type_AndroidMediaAudioTrack.release();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor != null) {
      this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor.a();
    }
    if (this.jdField_a_of_type_JavaIoFileInputStream != null) {
      this.jdField_a_of_type_JavaIoFileInputStream.close();
    }
    if (this.jdField_a_of_type_JavaIoFileOutputStream != null) {
      this.jdField_a_of_type_JavaIoFileOutputStream.close();
    }
    if (this.jdField_b_of_type_Boolean) {
      VoiceTuneUtil.a(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQVoiceChanger", 2, "clean up requestToCancel=" + this.jdField_b_of_type_Boolean);
    }
  }
  
  protected void a()
  {
    int i = AudioTrack.getMinBufferSize(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.c);
    this.jdField_a_of_type_AndroidMediaAudioTrack = new AudioTrack(3, this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_b_of_type_Int, 4, 2, i, 1);
    this.jdField_a_of_type_AndroidMediaAudioTrack.play();
  }
  
  protected void a(int paramInt)
  {
    File localFile = new File(VoiceTuneUtil.a(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_a_of_type_JavaLangString, paramInt));
    localFile.createNewFile();
    this.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(localFile);
  }
  
  public void a(IPttProcessor paramIPttProcessor, IPttProcessor.ProcessData paramProcessData)
  {
    if (((paramIPttProcessor instanceof SilkCodecWrapper)) || ((paramIPttProcessor instanceof AmrInputStreamWrapper)))
    {
      this.jdField_a_of_type_Int += (int)QQRecorder.a(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_b_of_type_Int, 4, 2, paramProcessData.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams.jdField_a_of_type_Boolean) {
        a(paramProcessData.jdField_a_of_type_ArrayOfByte, paramProcessData.jdField_a_of_type_Int);
      }
    }
  }
  
  protected void b()
  {
    this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaIoFileInputStream.available();
    if (QLog.isColorLevel()) {
      QLog.d("QQVoiceChanger", 2, "start progress totalSize=" + this.jdField_b_of_type_Int + " filePath=" + this.jdField_b_of_type_JavaLangString + "pcmFilePath=" + this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_a_of_type_JavaLangString);
    }
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j;
      if (this.jdField_a_of_type_Boolean)
      {
        j = k;
        if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams.e)
        {
          j = k;
          if (k == 0)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.e != 0) {
              break label260;
            }
            this.jdField_a_of_type_JavaIoFileInputStream.skip("#!AMR\n".length());
            j = 1;
          }
        }
      }
      label260:
      IPttProcessor.ProcessData localProcessData;
      try
      {
        k = this.jdField_a_of_type_JavaIoFileInputStream.read(this.jdField_a_of_type_ArrayOfByte, 0, 960);
        if (k == -1)
        {
          this.jdField_a_of_type_Boolean = false;
          if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener != null) {
            this.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener.b();
          }
          PttInfoCollector.a(4, this.jdField_a_of_type_Int);
          VoiceChangeManager.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.f, this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.e);
          if (QLog.isColorLevel()) {
            QLog.d("QQVoiceChanger", 2, "finishedCompress playedTime=" + this.jdField_a_of_type_Int);
          }
          for (;;)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener != null) {
              this.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener.a();
            }
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.e == 1)
            {
              this.jdField_a_of_type_JavaIoFileInputStream.skip(10L);
              break;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.e != 2) {
              break;
            }
            j = this.jdField_a_of_type_JavaIoFileInputStream.read(this.jdField_a_of_type_ArrayOfByte, 0, 64);
            if ((j == 64) && (this.jdField_a_of_type_JavaIoFileOutputStream != null))
            {
              this.jdField_a_of_type_JavaIoFileOutputStream.write(this.jdField_a_of_type_ArrayOfByte, 0, j);
              this.jdField_a_of_type_JavaIoFileOutputStream.flush();
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("QQVoiceChanger", 2, "copy AFPCM failed!");
            }
          }
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.d("QQVoiceChanger", 2, "read failed" + localIOException.getStackTrace());
          }
        }
        this.c += k;
        localProcessData = this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor.a(this.jdField_a_of_type_ArrayOfByte, 0, k);
        PttInfoCollector.b();
        if ((this.jdField_a_of_type_JavaIoFileOutputStream != null) && (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams.c))
        {
          int m = i;
          if (i == 0)
          {
            byte[] arrayOfByte = RecordParams.a(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.e, this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_b_of_type_Int);
            this.jdField_a_of_type_JavaIoFileOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
            this.jdField_a_of_type_JavaIoFileOutputStream.flush();
            m = 1;
          }
          k = j;
          i = m;
          if (localProcessData == null) {
            continue;
          }
          this.jdField_a_of_type_JavaIoFileOutputStream.write(localProcessData.jdField_a_of_type_ArrayOfByte, 0, localProcessData.jdField_a_of_type_Int);
          this.jdField_a_of_type_JavaIoFileOutputStream.flush();
          k = j;
          i = m;
          continue;
        }
        k = j;
      }
      if (this.jdField_a_of_type_JavaIoFileOutputStream != null)
      {
        k = j;
        if (localProcessData != null)
        {
          this.jdField_a_of_type_JavaIoFileOutputStream.write(localProcessData.jdField_a_of_type_ArrayOfByte, 0, localProcessData.jdField_a_of_type_Int);
          this.jdField_a_of_type_JavaIoFileOutputStream.flush();
          k = j;
        }
      }
    }
  }
  
  public void b(IPttProcessor paramIPttProcessor, IPttProcessor.ProcessData paramProcessData)
  {
    if (((paramIPttProcessor instanceof VoiceChange)) && (!this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams.c) && (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams.jdField_a_of_type_Boolean)) {
      a(paramProcessData.jdField_a_of_type_ArrayOfByte, paramProcessData.jdField_a_of_type_Int);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener = null;
    if (QLog.isColorLevel()) {
      QLog.d("QQVoiceChanger", 2, "requestToSend isRunning=" + this.jdField_a_of_type_Boolean);
    }
  }
  
  public void d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      VoiceTuneUtil.b(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQVoiceChanger", 2, "requestToCancel isRunning=" + this.jdField_a_of_type_Boolean);
    }
  }
  
  public void run()
  {
    Process.setThreadPriority(-19);
    this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor = new PttCompositeProcessor();
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.f == 0) {
          this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams.d = false;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams.d) {
          this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor.a(new VoiceChange(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.f, this.jdField_a_of_type_JavaLangString));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor.a(new WechatNsWrapper(this.jdField_a_of_type_AndroidContentContext));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams.c)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.e == 0) {
            this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor.a(new AmrInputStreamWrapper(this.jdField_a_of_type_AndroidContentContext));
          }
        }
        else
        {
          e();
          a(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.f);
          this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor.a(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.d, this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.e);
          this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor.a(this);
          a();
          b();
        }
      }
      catch (IOException localIOException1)
      {
        localIOException1 = localIOException1;
        localIOException1.printStackTrace();
        if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener.c();
        }
        try
        {
          f();
          return;
        }
        catch (IOException localIOException2)
        {
          localIOException2.printStackTrace();
          return;
        }
      }
      catch (Exception localException)
      {
        localException = localException;
        if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener.c();
        localException.printStackTrace();
        try
        {
          f();
          return;
        }
        catch (IOException localIOException4)
        {
          localIOException4.printStackTrace();
          return;
        }
      }
      finally {}
      try
      {
        f();
        return;
      }
      catch (IOException localIOException3)
      {
        localIOException3.printStackTrace();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor.a(new SilkCodecWrapper(this.jdField_a_of_type_AndroidContentContext));
    }
    try
    {
      f();
      throw localObject;
    }
    catch (IOException localIOException5)
    {
      for (;;)
      {
        localIOException5.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.voicechange.QQVoiceChangerThread
 * JD-Core Version:    0.7.0.1
 */