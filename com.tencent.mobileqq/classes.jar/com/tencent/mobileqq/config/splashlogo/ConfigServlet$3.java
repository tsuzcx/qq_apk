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
    boolean bool1 = this.a.exists();
    int k = 0;
    if (!bool1)
    {
      int i = 0;
      label194:
      label219:
      int j;
      do
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("begin download url is ");
          localStringBuilder.append(this.b);
          localStringBuilder.append(" file is ");
          localStringBuilder.append(this.a.getAbsolutePath());
          localStringBuilder.append(" md5 ");
          localStringBuilder.append(this.c);
          QLog.d("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
        }
        bool1 = HttpDownloadUtil.download(this.d, this.b, this.a);
        if (bool1)
        {
          if (this.a.exists())
          {
            try
            {
              boolean bool2 = MD5.getFileMD5(this.a).equalsIgnoreCase(this.c);
              k = bool1;
              if (bool2) {
                break label219;
              }
              try
              {
                if (!QLog.isColorLevel()) {
                  break label194;
                }
                QLog.d("SPLASH_ConfigServlet", 2, "down load success but check md5 failed");
              }
              catch (Throwable localThrowable1)
              {
                k = 0;
              }
              localThrowable2.printStackTrace();
            }
            catch (Throwable localThrowable2)
            {
              k = bool1;
            }
            break label219;
          }
          k = 0;
        }
        else
        {
          k = bool1;
          if (QLog.isColorLevel())
          {
            QLog.d("SPLASH_ConfigServlet", 2, "down load pic failed try again");
            k = bool1;
          }
        }
        j = i + 1;
        if (k != 0) {
          break;
        }
        i = j;
      } while (j < 2);
    }
    else
    {
      try
      {
        bool1 = MD5.getFileMD5(this.a).equalsIgnoreCase(this.c);
        k = bool1;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "splash has a file don't need download but check md5 get a exception");
        }
        localException.printStackTrace();
      }
    }
    if (k == 0)
    {
      File localFile = this.a;
      if ((localFile != null) && (localFile.exists())) {
        this.a.delete();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.splashlogo.ConfigServlet.3
 * JD-Core Version:    0.7.0.1
 */