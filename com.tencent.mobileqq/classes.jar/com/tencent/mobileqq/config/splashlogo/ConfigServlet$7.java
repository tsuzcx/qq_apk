package com.tencent.mobileqq.config.splashlogo;

import com.tencent.mobileqq.app.NearbyGrayTipsManager;
import com.tencent.mobileqq.app.NearbyGrayTipsManager.GrayTipsConfig;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import oicq.wlogin_sdk.tools.MD5;

class ConfigServlet$7
  implements Runnable
{
  ConfigServlet$7(ConfigServlet paramConfigServlet, QQAppInterface paramQQAppInterface, String paramString1, File paramFile, String paramString2, NearbyGrayTipsManager paramNearbyGrayTipsManager) {}
  
  public void run()
  {
    try
    {
      Object localObject;
      if (HttpDownloadUtil.download(this.a, this.b, this.c))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("file download succeed. url=");
          ((StringBuilder)localObject).append(this.b);
          QLog.d("nearby_aio_operation_gray_tips", 2, ((StringBuilder)localObject).toString());
        }
        localObject = MD5.getFileMD5(this.c);
        if ((StringUtil.isEmpty(this.d)) || ((localObject != null) && (this.d.equals(((String)localObject).toLowerCase()))))
        {
          localObject = NearbyGrayTipsManager.a(this.c);
          if (localObject != null)
          {
            this.e.a((NearbyGrayTipsManager.GrayTipsConfig)localObject);
            this.e.a((NearbyGrayTipsManager.GrayTipsConfig)localObject, true);
            this.e.b((NearbyGrayTipsManager.GrayTipsConfig)localObject, true);
            NearbyGrayTipsManager.b((NearbyGrayTipsManager.GrayTipsConfig)localObject);
          }
          this.c.delete();
        }
      }
      else if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("file download failed. url=");
        ((StringBuilder)localObject).append(this.b);
        QLog.d("nearby_aio_operation_gray_tips", 2, ((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("nearby_aio_operation_gray_tips", 2, "download file exp=", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.splashlogo.ConfigServlet.7
 * JD-Core Version:    0.7.0.1
 */