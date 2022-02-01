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

final class BridgeModuleHelper$14
  implements Runnable
{
  BridgeModuleHelper$14(String paramString1, File paramFile, BridgeModule paramBridgeModule, String paramString2) {}
  
  public void run()
  {
    int i = HttpDownloadUtil.downloadData((QQAppInterface)ReadInJoyUtils.b(), this.a, this.b);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveImage imageUrl code=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(",url= ");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("BridgeModuleHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new JSONObject();
    if (i == 0) {}
    try
    {
      ((JSONObject)localObject).put("retCode", 0);
      this.c.invokeCallJS(this.d, localObject);
      localObject = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("file://");
      localStringBuilder.append(this.b.getPath());
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
      localStringBuilder.append(this.a);
      QLog.e("BridgeModuleHelper", 2, localStringBuilder.toString());
      label238:
      this.c.invokeErrorCallJS(this.d, "saveImage error");
    }
    ((JSONObject)localObject).put("retCode", -1);
    this.c.invokeCallJS(this.d, localObject);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModuleHelper.14
 * JD-Core Version:    0.7.0.1
 */