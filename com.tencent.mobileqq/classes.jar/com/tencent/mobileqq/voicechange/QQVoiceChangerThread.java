package com.tencent.mobileqq.voicechange;

import android.content.Context;
import android.media.AudioTrack;
import android.os.Process;
import android.text.TextUtils;
import audl;
import audm;
import audn;
import audp;
import axte;
import bahn;
import bawr;
import baws;
import bawv;
import bawx;
import baxb;
import com.tencent.mobileqq.utils.AmrInputStreamWrapper;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.mobileqq.utils.WechatNsWrapper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class QQVoiceChangerThread
  extends Thread
  implements audn
{
  int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private AudioTrack jdField_a_of_type_AndroidMediaAudioTrack;
  private audp jdField_a_of_type_Audp;
  bawr jdField_a_of_type_Bawr;
  baws jdField_a_of_type_Baws;
  bawx jdField_a_of_type_Bawx;
  private FileInputStream jdField_a_of_type_JavaIoFileInputStream;
  private FileOutputStream jdField_a_of_type_JavaIoFileOutputStream;
  public String a;
  public volatile boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[960];
  int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  int c = 0;
  
  public QQVoiceChangerThread(Context paramContext, baws parambaws, bawx parambawx, String paramString, bawr parambawr)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_JavaLangString = parambaws.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Baws = parambaws;
    this.jdField_a_of_type_Bawx = parambawx;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bawr = parambawr;
    if (QLog.isColorLevel()) {
      QLog.d("QQVoiceChanger", 2, "new QQVoiceChangerThread filePath=" + this.jdField_b_of_type_JavaLangString + " sampleRate=" + parambaws.jdField_b_of_type_Int + " bitRate=" + parambaws.d + " voiceType=" + parambaws.e + " changeType=" + parambaws.f);
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = (int)AudioHelper.a(this.jdField_a_of_type_AndroidContentContext, paramArrayOfByte, paramInt, 1.0F);
    if (this.jdField_a_of_type_Bawr != null) {
      this.jdField_a_of_type_Bawr.a(i, this.c * 100 / this.jdField_b_of_type_Int, this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_AndroidMediaAudioTrack.write(paramArrayOfByte, 0, paramInt);
  }
  
  private void e()
  {
    String str = this.jdField_a_of_type_Bawx.jdField_a_of_type_JavaLangString;
    if (!TextUtils.isEmpty(str)) {}
    for (this.jdField_b_of_type_JavaLangString = str;; this.jdField_b_of_type_JavaLangString = baxb.a(this.jdField_b_of_type_JavaLangString))
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
    if (this.jdField_a_of_type_Audp != null) {
      this.jdField_a_of_type_Audp.a();
    }
    if (this.jdField_a_of_type_JavaIoFileInputStream != null) {
      this.jdField_a_of_type_JavaIoFileInputStream.close();
    }
    if (this.jdField_a_of_type_JavaIoFileOutputStream != null) {
      this.jdField_a_of_type_JavaIoFileOutputStream.close();
    }
    if (this.jdField_b_of_type_Boolean) {
      baxb.a(this.jdField_a_of_type_Baws.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQVoiceChanger", 2, "clean up requestToCancel=" + this.jdField_b_of_type_Boolean);
    }
  }
  
  protected void a()
  {
    int i = AudioTrack.getMinBufferSize(this.jdField_a_of_type_Baws.jdField_b_of_type_Int, this.jdField_a_of_type_Baws.jdField_a_of_type_Int, this.jdField_a_of_type_Baws.c);
    this.jdField_a_of_type_AndroidMediaAudioTrack = new AudioTrack(3, this.jdField_a_of_type_Baws.jdField_b_of_type_Int, 4, 2, i, 1);
    this.jdField_a_of_type_AndroidMediaAudioTrack.play();
  }
  
  protected void a(int paramInt)
  {
    File localFile = new File(baxb.a(this.jdField_a_of_type_Baws.jdField_a_of_type_JavaLangString, paramInt));
    localFile.createNewFile();
    this.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(localFile);
  }
  
  public void a(audl paramaudl, audm paramaudm)
  {
    if (((paramaudl instanceof SilkCodecWrapper)) || ((paramaudl instanceof AmrInputStreamWrapper)))
    {
      this.jdField_a_of_type_Int += (int)QQRecorder.a(this.jdField_a_of_type_Baws.jdField_b_of_type_Int, 4, 2, paramaudm.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Bawx.jdField_a_of_type_Boolean) {
        a(paramaudm.jdField_a_of_type_ArrayOfByte, paramaudm.jdField_a_of_type_Int);
      }
    }
  }
  
  protected void b()
  {
    this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaIoFileInputStream.available();
    if (QLog.isColorLevel()) {
      QLog.d("QQVoiceChanger", 2, "start progress totalSize=" + this.jdField_b_of_type_Int + " filePath=" + this.jdField_b_of_type_JavaLangString + "pcmFilePath=" + this.jdField_a_of_type_Baws.jdField_a_of_type_JavaLangString);
    }
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j;
      if (this.jdField_a_of_type_Boolean)
      {
        j = k;
        if (this.jdField_a_of_type_Bawx.e)
        {
          j = k;
          if (k == 0)
          {
            if (this.jdField_a_of_type_Baws.e != 0) {
              break label260;
            }
            this.jdField_a_of_type_JavaIoFileInputStream.skip("#!AMR\n".length());
            j = 1;
          }
        }
      }
      label260:
      audm localaudm;
      try
      {
        k = this.jdField_a_of_type_JavaIoFileInputStream.read(this.jdField_a_of_type_ArrayOfByte, 0, 960);
        if (k == -1)
        {
          this.jdField_a_of_type_Boolean = false;
          if (this.jdField_a_of_type_Bawr != null) {
            this.jdField_a_of_type_Bawr.b();
          }
          axte.a(4, this.jdField_a_of_type_Int);
          bawv.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Baws.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Baws.f, this.jdField_a_of_type_Baws.e);
          if (QLog.isColorLevel()) {
            QLog.d("QQVoiceChanger", 2, "finishedCompress playedTime=" + this.jdField_a_of_type_Int);
          }
          for (;;)
          {
            if (this.jdField_a_of_type_Bawr != null) {
              this.jdField_a_of_type_Bawr.a();
            }
            return;
            if (this.jdField_a_of_type_Baws.e == 1)
            {
              this.jdField_a_of_type_JavaIoFileInputStream.skip(10L);
              break;
            }
            if (this.jdField_a_of_type_Baws.e != 2) {
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
        localaudm = this.jdField_a_of_type_Audp.a(this.jdField_a_of_type_ArrayOfByte, 0, k);
        axte.b();
        if ((this.jdField_a_of_type_JavaIoFileOutputStream != null) && (this.jdField_a_of_type_Bawx.c))
        {
          int m = i;
          if (i == 0)
          {
            byte[] arrayOfByte = bahn.a(this.jdField_a_of_type_Baws.e, this.jdField_a_of_type_Baws.jdField_b_of_type_Int);
            this.jdField_a_of_type_JavaIoFileOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
            this.jdField_a_of_type_JavaIoFileOutputStream.flush();
            m = 1;
          }
          k = j;
          i = m;
          if (localaudm == null) {
            continue;
          }
          this.jdField_a_of_type_JavaIoFileOutputStream.write(localaudm.jdField_a_of_type_ArrayOfByte, 0, localaudm.jdField_a_of_type_Int);
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
        if (localaudm != null)
        {
          this.jdField_a_of_type_JavaIoFileOutputStream.write(localaudm.jdField_a_of_type_ArrayOfByte, 0, localaudm.jdField_a_of_type_Int);
          this.jdField_a_of_type_JavaIoFileOutputStream.flush();
          k = j;
        }
      }
    }
  }
  
  public void b(audl paramaudl, audm paramaudm)
  {
    if (((paramaudl instanceof VoiceChange)) && (!this.jdField_a_of_type_Bawx.c) && (this.jdField_a_of_type_Bawx.jdField_a_of_type_Boolean)) {
      a(paramaudm.jdField_a_of_type_ArrayOfByte, paramaudm.jdField_a_of_type_Int);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Bawx.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Bawr = null;
    if (QLog.isColorLevel()) {
      QLog.d("QQVoiceChanger", 2, "requestToSend isRunning=" + this.jdField_a_of_type_Boolean);
    }
  }
  
  public void d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      baxb.b(this.jdField_a_of_type_Baws.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Bawr = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQVoiceChanger", 2, "requestToCancel isRunning=" + this.jdField_a_of_type_Boolean);
    }
  }
  
  public void run()
  {
    Process.setThreadPriority(-19);
    this.jdField_a_of_type_Audp = new audp();
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Baws.f == 0) {
          this.jdField_a_of_type_Bawx.d = false;
        }
        if (this.jdField_a_of_type_Bawx.d) {
          this.jdField_a_of_type_Audp.a(new VoiceChange(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Baws.f, this.jdField_a_of_type_JavaLangString));
        }
        if (this.jdField_a_of_type_Bawx.jdField_b_of_type_Boolean)
        {
          WechatNsWrapper localWechatNsWrapper = new WechatNsWrapper(this.jdField_a_of_type_AndroidContentContext);
          if (WechatNsWrapper.jdField_a_of_type_Boolean) {
            this.jdField_a_of_type_Audp.a(localWechatNsWrapper);
          }
        }
        if (this.jdField_a_of_type_Bawx.c)
        {
          if (this.jdField_a_of_type_Baws.e == 0) {
            this.jdField_a_of_type_Audp.a(new AmrInputStreamWrapper(this.jdField_a_of_type_AndroidContentContext));
          }
        }
        else
        {
          e();
          a(this.jdField_a_of_type_Baws.f);
          this.jdField_a_of_type_Audp.a(this.jdField_a_of_type_Baws.jdField_b_of_type_Int, this.jdField_a_of_type_Baws.d, this.jdField_a_of_type_Baws.e);
          this.jdField_a_of_type_Audp.a(this);
          a();
          b();
        }
      }
      catch (IOException localIOException1)
      {
        localIOException1 = localIOException1;
        localIOException1.printStackTrace();
        if (this.jdField_a_of_type_Bawr != null) {
          this.jdField_a_of_type_Bawr.c();
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
        if (this.jdField_a_of_type_Bawr == null) {
          continue;
        }
        this.jdField_a_of_type_Bawr.c();
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
      this.jdField_a_of_type_Audp.a(new SilkCodecWrapper(this.jdField_a_of_type_AndroidContentContext));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.voicechange.QQVoiceChangerThread
 * JD-Core Version:    0.7.0.1
 */