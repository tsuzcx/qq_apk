package dov.com.tencent.mobileqq.shortvideo.util;

import com.tencent.mobileqq.richmedia.mediacodec.utils.ShortVideoExceptionReporter;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AudioDataCache
{
  private FileOutputStream jdField_a_of_type_JavaIoFileOutputStream;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public AudioDataCache(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + File.separator + "audio_data_cache" + File.separator);
    paramString = new File(this.jdField_a_of_type_JavaLangString);
    boolean bool1 = paramString.mkdirs();
    boolean bool2 = paramString.isDirectory();
    if ((!bool1) && (!bool2))
    {
      if ((!paramString.exists()) || (bool2)) {
        break label163;
      }
      paramString.delete();
      bool1 = paramString.mkdirs();
      bool2 = paramString.isDirectory();
      if ((!bool1) && (!bool2))
      {
        paramString = new RuntimeException("AudioDataCache: mkd=" + bool1 + " isdir=" + bool2);
        QLog.e("AudioDataCache", 2, paramString, new Object[0]);
        ShortVideoExceptionReporter.a(paramString);
      }
    }
    return;
    label163:
    throw new RuntimeException("AudioDataCache: mkd=" + bool1 + " isdir=" + bool2);
  }
  
  private static void a(String paramString, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable != null) {
        QLog.d("AudioDataCache", 2, "[@] " + paramString, paramThrowable);
      }
    }
    else {
      return;
    }
    QLog.d("AudioDataCache", 2, "[@] " + paramString);
  }
  
  public String a(RMVideoStateMgr paramRMVideoStateMgr)
  {
    a("closeCache: path=" + this.b, null);
    String str = this.jdField_a_of_type_JavaLangString + this.b;
    if ((this.jdField_a_of_type_JavaIoFileOutputStream == null) || (paramRMVideoStateMgr != null)) {}
    try
    {
      paramRMVideoStateMgr.e();
      this.jdField_a_of_type_JavaIoFileOutputStream.close();
    }
    catch (IOException paramRMVideoStateMgr)
    {
      label74:
      break label74;
    }
    this.jdField_a_of_type_JavaIoFileOutputStream = null;
    this.b = null;
    return str;
  }
  
  public void a(RMVideoStateMgr paramRMVideoStateMgr)
  {
    File localFile;
    try
    {
      a("initCache: oldpath=" + this.b + " mOutStream=" + this.jdField_a_of_type_JavaIoFileOutputStream, null);
      a(paramRMVideoStateMgr);
      this.b = VidUtil.a();
      paramRMVideoStateMgr = this.jdField_a_of_type_JavaLangString + this.b;
      localFile = new File(paramRMVideoStateMgr);
      if (localFile.exists()) {
        throw new RuntimeException("AudioDataCache: file exists| " + paramRMVideoStateMgr);
      }
    }
    finally {}
    try
    {
      this.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(localFile);
      a("initCache: newPath=" + this.b, null);
      return;
    }
    catch (FileNotFoundException paramRMVideoStateMgr)
    {
      for (;;)
      {
        this.jdField_a_of_type_JavaIoFileOutputStream = null;
      }
    }
  }
  
  public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_JavaIoFileOutputStream != null) {}
    try
    {
      this.jdField_a_of_type_JavaIoFileOutputStream.write(paramArrayOfByte, paramInt1, paramInt2);
      bool = true;
      return bool;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      a("writeData: exp=", paramArrayOfByte);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.util.AudioDataCache
 * JD-Core Version:    0.7.0.1
 */