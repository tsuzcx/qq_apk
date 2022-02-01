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

final class BridgeModuleHelper$23
  implements Runnable
{
  BridgeModuleHelper$23(String paramString, File paramFile) {}
  
  public void run()
  {
    int i = HttpDownloadUtil.downloadData((QQAppInterface)ReadInJoyUtils.b(), this.a, this.b);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveImageToLocal imageUrl code=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(",url= ");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("BridgeModuleHelper", 2, ((StringBuilder)localObject).toString());
    }
    if (i == 0) {}
    try
    {
      localObject = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("file://");
      localStringBuilder.append(this.b.getPath());
      ((Intent)localObject).setData(Uri.parse(localStringBuilder.toString()));
      BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject);
      ThreadManagerV2.getUIHandlerV2().post(new BridgeModuleHelper.23.1(this));
      return;
    }
    catch (Exception localException)
    {
      ThreadManagerV2.getUIHandlerV2().post(new BridgeModuleHelper.23.3(this));
      if (!QLog.isColorLevel()) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveImageToLocal imageUrl error=");
      localStringBuilder.append(localException.getMessage());
      localStringBuilder.append(",url= ");
      localStringBuilder.append(this.a);
      QLog.e("BridgeModuleHelper", 2, localStringBuilder.toString());
    }
    ThreadManagerV2.getUIHandlerV2().post(new BridgeModuleHelper.23.2(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModuleHelper.23
 * JD-Core Version:    0.7.0.1
 */