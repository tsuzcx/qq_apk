package com.tencent.mobileqq.config.splashlogo;

import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import oicq.wlogin_sdk.tools.MD5;

class ConfigServlet$3
  implements Runnable
{
  public void run()
  {
    k = 0;
    int i;
    boolean bool1;
    if (!this.jdField_a_of_type_JavaIoFile.exists())
    {
      i = 0;
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "begin download url is " + this.jdField_a_of_type_JavaLangString + " file is " + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " md5 " + this.b);
      }
      bool1 = HttpDownloadUtil.download(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoFile);
      if (bool1) {
        if (!this.jdField_a_of_type_JavaIoFile.exists()) {}
      }
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          boolean bool2 = MD5.getFileMD5(this.jdField_a_of_type_JavaIoFile).equalsIgnoreCase(this.b);
          k = bool1;
          if (bool2) {}
        }
        catch (Throwable localThrowable1)
        {
          int j;
          k = bool1;
        }
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "down load success but check md5 failed");
          }
          k = 0;
          j = i + 1;
          if (k != 0) {
            break label290;
          }
          i = j;
          if (j < 2) {
            break;
          }
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            k = 0;
          }
        }
      }
      if ((k == 0) && (this.jdField_a_of_type_JavaIoFile != null) && (this.jdField_a_of_type_JavaIoFile.exists())) {
        this.jdField_a_of_type_JavaIoFile.delete();
      }
      return;
      localThrowable1.printStackTrace();
      continue;
      k = 0;
      continue;
      k = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("SPLASH_ConfigServlet", 2, "down load pic failed try again");
        k = bool1;
        continue;
        try
        {
          bool1 = MD5.getFileMD5(this.jdField_a_of_type_JavaIoFile).equalsIgnoreCase(this.b);
          if (bool1) {
            k = 1;
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "splash has a file don't need download but check md5 get a exception");
          }
          localException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.splashlogo.ConfigServlet.3
 * JD-Core Version:    0.7.0.1
 */