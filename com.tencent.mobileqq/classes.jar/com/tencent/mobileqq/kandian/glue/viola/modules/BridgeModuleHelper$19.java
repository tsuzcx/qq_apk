package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class BridgeModuleHelper$19
  implements Runnable
{
  BridgeModuleHelper$19(String paramString, File paramFile) {}
  
  public void run()
  {
    int i = HttpDownloadUtil.downloadData((QQAppInterface)ReadInJoyUtils.a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoFile);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveImageToLocal imageUrl code=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(",url= ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.d("BridgeModuleHelper", 2, ((StringBuilder)localObject).toString());
    }
    if (i == 0) {}
    try
    {
      localObject = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("file://");
      localStringBuilder.append(this.jdField_a_of_type_JavaIoFile.getPath());
      ((Intent)localObject).setData(Uri.parse(localStringBuilder.toString()));
      BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject);
      ThreadManagerV2.getUIHandlerV2().post(new BridgeModuleHelper.19.1(this));
      return;
    }
    catch (Exception localException)
    {
      ThreadManagerV2.getUIHandlerV2().post(new BridgeModuleHelper.19.3(this));
      if (!QLog.isColorLevel()) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveImageToLocal imageUrl error=");
      localStringBuilder.append(localException.getMessage());
      localStringBuilder.append(",url= ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.e("BridgeModuleHelper", 2, localStringBuilder.toString());
    }
    ThreadManagerV2.getUIHandlerV2().post(new BridgeModuleHelper.19.2(this));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("download image error: ");
      ((StringBuilder)localObject).append(i);
      QLog.d("BridgeModuleHelper", 2, ((StringBuilder)localObject).toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModuleHelper.19
 * JD-Core Version:    0.7.0.1
 */