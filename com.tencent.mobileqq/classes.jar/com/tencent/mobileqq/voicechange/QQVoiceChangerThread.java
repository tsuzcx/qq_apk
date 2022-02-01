package com.tencent.mobileqq.voicechange;

import android.content.Context;
import android.media.AudioTrack;
import android.os.Process;
import android.text.TextUtils;
import baii;
import baij;
import baik;
import baim;
import bhhd;
import bibz;
import bica;
import bicd;
import bicf;
import bicj;
import com.tencent.mobileqq.transfile.PttInfoCollector;
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
  implements baik
{
  int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private AudioTrack jdField_a_of_type_AndroidMediaAudioTrack;
  private baim jdField_a_of_type_Baim;
  bibz jdField_a_of_type_Bibz;
  bica jdField_a_of_type_Bica;
  bicf jdField_a_of_type_Bicf;
  private FileInputStream jdField_a_of_type_JavaIoFileInputStream;
  private FileOutputStream jdField_a_of_type_JavaIoFileOutputStream;
  public String a;
  public volatile boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[960];
  int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  int c = 0;
  
  public QQVoiceChangerThread(Context paramContext, bica parambica, bicf parambicf, String paramString, bibz parambibz)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_JavaLangString = parambica.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Bica = parambica;
    this.jdField_a_of_type_Bicf = parambicf;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bibz = parambibz;
    if (QLog.isColorLevel()) {
      QLog.d("QQVoiceChanger", 2, "new QQVoiceChangerThread filePath=" + this.jdField_b_of_type_JavaLangString + " sampleRate=" + parambica.jdField_b_of_type_Int + " bitRate=" + parambica.d + " voiceType=" + parambica.e + " changeType=" + parambica.f);
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = (int)AudioHelper.a(this.jdField_a_of_type_AndroidContentContext, paramArrayOfByte, paramInt, 1.0F);
    if (this.jdField_a_of_type_Bibz != null) {
      this.jdField_a_of_type_Bibz.onSlicePlayed(i, this.c * 100 / this.jdField_b_of_type_Int, this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_AndroidMediaAudioTrack.write(paramArrayOfByte, 0, paramInt);
  }
  
  private void e()
  {
    String str = this.jdField_a_of_type_Bicf.jdField_a_of_type_JavaLangString;
    if (!TextUtils.isEmpty(str)) {}
    for (this.jdField_b_of_type_JavaLangString = str;; this.jdField_b_of_type_JavaLangString = bicj.a(this.jdField_b_of_type_JavaLangString))
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
    if (this.jdField_a_of_type_Baim != null) {
      this.jdField_a_of_type_Baim.a();
    }
    if (this.jdField_a_of_type_JavaIoFileInputStream != null) {
      this.jdField_a_of_type_JavaIoFileInputStream.close();
    }
    if (this.jdField_a_of_type_JavaIoFileOutputStream != null) {
      this.jdField_a_of_type_JavaIoFileOutputStream.close();
    }
    if (this.jdField_b_of_type_Boolean) {
      bicj.a(this.jdField_a_of_type_Bica.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQVoiceChanger", 2, "clean up requestToCancel=" + this.jdField_b_of_type_Boolean);
    }
  }
  
  protected void a()
  {
    int i = AudioTrack.getMinBufferSize(this.jdField_a_of_type_Bica.jdField_b_of_type_Int, this.jdField_a_of_type_Bica.jdField_a_of_type_Int, this.jdField_a_of_type_Bica.c);
    this.jdField_a_of_type_AndroidMediaAudioTrack = new AudioTrack(3, this.jdField_a_of_type_Bica.jdField_b_of_type_Int, 4, 2, i, 1);
    this.jdField_a_of_type_AndroidMediaAudioTrack.play();
  }
  
  protected void a(int paramInt)
  {
    File localFile = new File(bicj.a(this.jdField_a_of_type_Bica.jdField_a_of_type_JavaLangString, paramInt));
    localFile.createNewFile();
    this.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(localFile);
  }
  
  public void a(baii parambaii, baij parambaij)
  {
    if (((parambaii instanceof SilkCodecWrapper)) || ((parambaii instanceof AmrInputStreamWrapper)))
    {
      this.jdField_a_of_type_Int += (int)QQRecorder.a(this.jdField_a_of_type_Bica.jdField_b_of_type_Int, 4, 2, parambaij.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Bicf.jdField_a_of_type_Boolean) {
        a(parambaij.jdField_a_of_type_ArrayOfByte, parambaij.jdField_a_of_type_Int);
      }
    }
  }
  
  protected void b()
  {
    this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaIoFileInputStream.available();
    if (QLog.isColorLevel()) {
      QLog.d("QQVoiceChanger", 2, "start progress totalSize=" + this.jdField_b_of_type_Int + " filePath=" + this.jdField_b_of_type_JavaLangString + "pcmFilePath=" + this.jdField_a_of_type_Bica.jdField_a_of_type_JavaLangString);
    }
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j;
      if (this.jdField_a_of_type_Boolean)
      {
        j = k;
        if (this.jdField_a_of_type_Bicf.e)
        {
          j = k;
          if (k == 0)
          {
            if (this.jdField_a_of_type_Bica.e != 0) {
              break label260;
            }
            this.jdField_a_of_type_JavaIoFileInputStream.skip("#!AMR\n".length());
            j = 1;
          }
        }
      }
      label260:
      baij localbaij;
      try
      {
        k = this.jdField_a_of_type_JavaIoFileInputStream.read(this.jdField_a_of_type_ArrayOfByte, 0, 960);
        if (k == -1)
        {
          this.jdField_a_of_type_Boolean = false;
          if (this.jdField_a_of_type_Bibz != null) {
            this.jdField_a_of_type_Bibz.onPlayEnd();
          }
          PttInfoCollector.reportGcAndMemoryUse(4, this.jdField_a_of_type_Int);
          bicd.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Bica.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Bica.f, this.jdField_a_of_type_Bica.e);
          if (QLog.isColorLevel()) {
            QLog.d("QQVoiceChanger", 2, "finishedCompress playedTime=" + this.jdField_a_of_type_Int);
          }
          for (;;)
          {
            if (this.jdField_a_of_type_Bibz != null) {
              this.jdField_a_of_type_Bibz.onPlayStop();
            }
            return;
            if (this.jdField_a_of_type_Bica.e == 1)
            {
              this.jdField_a_of_type_JavaIoFileInputStream.skip(10L);
              break;
            }
            if (this.jdField_a_of_type_Bica.e != 2) {
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
        localbaij = this.jdField_a_of_type_Baim.a(this.jdField_a_of_type_ArrayOfByte, 0, k);
        PttInfoCollector.noteOneFrameProcessed();
        if ((this.jdField_a_of_type_JavaIoFileOutputStream != null) && (this.jdField_a_of_type_Bicf.c))
        {
          int m = i;
          if (i == 0)
          {
            byte[] arrayOfByte = bhhd.a(this.jdField_a_of_type_Bica.e, this.jdField_a_of_type_Bica.jdField_b_of_type_Int);
            this.jdField_a_of_type_JavaIoFileOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
            this.jdField_a_of_type_JavaIoFileOutputStream.flush();
            m = 1;
          }
          k = j;
          i = m;
          if (localbaij == null) {
            continue;
          }
          this.jdField_a_of_type_JavaIoFileOutputStream.write(localbaij.jdField_a_of_type_ArrayOfByte, 0, localbaij.jdField_a_of_type_Int);
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
        if (localbaij != null)
        {
          this.jdField_a_of_type_JavaIoFileOutputStream.write(localbaij.jdField_a_of_type_ArrayOfByte, 0, localbaij.jdField_a_of_type_Int);
          this.jdField_a_of_type_JavaIoFileOutputStream.flush();
          k = j;
        }
      }
    }
  }
  
  public void b(baii parambaii, baij parambaij)
  {
    if (((parambaii instanceof VoiceChange)) && (!this.jdField_a_of_type_Bicf.c) && (this.jdField_a_of_type_Bicf.jdField_a_of_type_Boolean)) {
      a(parambaij.jdField_a_of_type_ArrayOfByte, parambaij.jdField_a_of_type_Int);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Bicf.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Bibz = null;
    if (QLog.isColorLevel()) {
      QLog.d("QQVoiceChanger", 2, "requestToSend isRunning=" + this.jdField_a_of_type_Boolean);
    }
  }
  
  public void d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      bicj.b(this.jdField_a_of_type_Bica.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Bibz = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQVoiceChanger", 2, "requestToCancel isRunning=" + this.jdField_a_of_type_Boolean);
    }
  }
  
  public void run()
  {
    Process.setThreadPriority(-19);
    this.jdField_a_of_type_Baim = new baim();
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Bica.f == 0) {
          this.jdField_a_of_type_Bicf.d = false;
        }
        if (this.jdField_a_of_type_Bicf.d) {
          this.jdField_a_of_type_Baim.a(new VoiceChange(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bica.f, this.jdField_a_of_type_JavaLangString));
        }
        if (this.jdField_a_of_type_Bicf.jdField_b_of_type_Boolean)
        {
          WechatNsWrapper localWechatNsWrapper = new WechatNsWrapper(this.jdField_a_of_type_AndroidContentContext);
          if (WechatNsWrapper.jdField_a_of_type_Boolean) {
            this.jdField_a_of_type_Baim.a(localWechatNsWrapper);
          }
        }
        if (this.jdField_a_of_type_Bicf.c)
        {
          if (this.jdField_a_of_type_Bica.e == 0) {
            this.jdField_a_of_type_Baim.a(new AmrInputStreamWrapper(this.jdField_a_of_type_AndroidContentContext));
          }
        }
        else
        {
          e();
          a(this.jdField_a_of_type_Bica.f);
          this.jdField_a_of_type_Baim.a(this.jdField_a_of_type_Bica.jdField_b_of_type_Int, this.jdField_a_of_type_Bica.d, this.jdField_a_of_type_Bica.e);
          this.jdField_a_of_type_Baim.a(this);
          a();
          b();
        }
      }
      catch (IOException localIOException1)
      {
        localIOException1 = localIOException1;
        localIOException1.printStackTrace();
        if (this.jdField_a_of_type_Bibz != null) {
          this.jdField_a_of_type_Bibz.onError();
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
        if (this.jdField_a_of_type_Bibz == null) {
          continue;
        }
        this.jdField_a_of_type_Bibz.onError();
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
      this.jdField_a_of_type_Baim.a(new SilkCodecWrapper(this.jdField_a_of_type_AndroidContentContext));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.voicechange.QQVoiceChangerThread
 * JD-Core Version:    0.7.0.1
 */