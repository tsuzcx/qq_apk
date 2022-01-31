package com.tencent.mobileqq.config.splashlogo;

import aova;
import bdje;
import com.tencent.mobileqq.app.NearbyGrayTipsManager;
import com.tencent.mobileqq.app.NearbyGrayTipsManager.GrayTipsConfig;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import oicq.wlogin_sdk.tools.MD5;

public class ConfigServlet$8
  implements Runnable
{
  public ConfigServlet$8(aova paramaova, String paramString1, File paramFile, String paramString2, NearbyGrayTipsManager paramNearbyGrayTipsManager) {}
  
  public void run()
  {
    try
    {
      if (HttpDownloadUtil.a((QQAppInterface)this.this$0.getAppRuntime(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoFile))
      {
        if (QLog.isColorLevel()) {
          QLog.d("nearby_aio_operation_gray_tips", 2, "file download succeed. url=" + this.jdField_a_of_type_JavaLangString);
        }
        Object localObject = MD5.getFileMD5(this.jdField_a_of_type_JavaIoFile);
        if ((bdje.a(this.b)) || ((localObject != null) && (this.b.equals(((String)localObject).toLowerCase()))))
        {
          localObject = NearbyGrayTipsManager.a(this.jdField_a_of_type_JavaIoFile);
          if (localObject != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a((NearbyGrayTipsManager.GrayTipsConfig)localObject);
            this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a((NearbyGrayTipsManager.GrayTipsConfig)localObject, true);
            this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.b((NearbyGrayTipsManager.GrayTipsConfig)localObject, true);
            NearbyGrayTipsManager.a((NearbyGrayTipsManager.GrayTipsConfig)localObject);
          }
          this.jdField_a_of_type_JavaIoFile.delete();
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("nearby_aio_operation_gray_tips", 2, "file download failed. url=" + this.jdField_a_of_type_JavaLangString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.splashlogo.ConfigServlet.8
 * JD-Core Version:    0.7.0.1
 */