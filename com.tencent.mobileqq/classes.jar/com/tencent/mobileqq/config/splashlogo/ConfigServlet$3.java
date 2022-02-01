package com.tencent.mobileqq.config.splashlogo;

import aqlw;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import oicq.wlogin_sdk.tools.MD5;

public class ConfigServlet$3
  implements Runnable
{
  public void run()
  {
    boolean bool1 = false;
    int i;
    if (!this.jdField_a_of_type_JavaIoFile.exists())
    {
      i = 0;
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "begin download url is " + this.jdField_a_of_type_JavaLangString + " file is " + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " md5 " + this.b);
      }
      bool1 = HttpDownloadUtil.download((AppInterface)this.this$0.getAppRuntime(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoFile);
      if (bool1) {
        if (!this.jdField_a_of_type_JavaIoFile.exists()) {}
      }
    }
    label276:
    label279:
    for (;;)
    {
      try
      {
        bool2 = MD5.getFileMD5(this.jdField_a_of_type_JavaIoFile).equalsIgnoreCase(this.b);
        if (!bool2) {}
        localThrowable1.printStackTrace();
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "down load success but check md5 failed");
          }
          bool1 = false;
          i += 1;
          if (bool1) {
            break label279;
          }
          if (i < 2) {
            break label276;
          }
          if ((!bool1) && (this.jdField_a_of_type_JavaIoFile != null) && (this.jdField_a_of_type_JavaIoFile.exists())) {
            this.jdField_a_of_type_JavaIoFile.delete();
          }
          return;
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            boolean bool2;
            bool1 = false;
          }
        }
        localThrowable1 = localThrowable1;
      }
      continue;
      bool1 = false;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "down load pic failed try again");
      }
      continue;
      try
      {
        bool2 = MD5.getFileMD5(this.jdField_a_of_type_JavaIoFile).equalsIgnoreCase(this.b);
        if (!bool2) {
          continue;
        }
        bool1 = true;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "splash has a file don't need download but check md5 get a exception");
        }
        localException.printStackTrace();
      }
      continue;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.splashlogo.ConfigServlet.3
 * JD-Core Version:    0.7.0.1
 */