package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.content.Intent;
import android.net.Uri;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

final class BridgeModuleHelper$11
  implements Runnable
{
  BridgeModuleHelper$11(String paramString1, File paramFile, BridgeModule paramBridgeModule, String paramString2) {}
  
  public void run()
  {
    int i = HttpDownloadUtil.downloadData((QQAppInterface)ReadInJoyUtils.a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoFile);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveImage imageUrl code=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(",url= ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.d("BridgeModuleHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new JSONObject();
    if (i == 0) {}
    try
    {
      ((JSONObject)localObject).put("retCode", 0);
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.invokeCallJS(this.b, localObject);
      localObject = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("file://");
      localStringBuilder.append(this.jdField_a_of_type_JavaIoFile.getPath());
      ((Intent)localObject).setData(Uri.parse(localStringBuilder.toString()));
      BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject);
      return;
    }
    catch (Exception localException)
    {
      if (!QLog.isColorLevel()) {
        break label238;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveImage imageUrl error=");
      localStringBuilder.append(localException.getMessage());
      localStringBuilder.append(",url= ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.e("BridgeModuleHelper", 2, localStringBuilder.toString());
      label238:
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.invokeErrorCallJS(this.b, "saveImage error");
    }
    ((JSONObject)localObject).put("retCode", -1);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.invokeCallJS(this.b, localObject);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModuleHelper.11
 * JD-Core Version:    0.7.0.1
 */