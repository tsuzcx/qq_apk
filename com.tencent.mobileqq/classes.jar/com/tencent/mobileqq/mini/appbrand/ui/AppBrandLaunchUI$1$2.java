package com.tencent.mobileqq.mini.appbrand.ui;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class AppBrandLaunchUI$1$2
  implements Runnable
{
  AppBrandLaunchUI$1$2(AppBrandLaunchUI.1 param1, JSONObject paramJSONObject) {}
  
  public void run()
  {
    Object localObject1 = this.val$ret;
    long l;
    if (localObject1 != null)
    {
      l = ((JSONObject)localObject1).optLong("retCode");
      localObject1 = this.val$ret.optString("errMsg");
    }
    else
    {
      l = 0L;
      localObject1 = "";
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getAppInfoById failed. retCode=");
    ((StringBuilder)localObject2).append(l);
    ((StringBuilder)localObject2).append(" errMsg=");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.e("miniapp-start_AppBrandLaunchUI", 1, ((StringBuilder)localObject2).toString());
    localObject2 = BaseApplicationImpl.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append((String)localObject1);
    QQToast.makeText((Context)localObject2, 1, localStringBuilder.toString(), 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppBrandLaunchUI.1.2
 * JD-Core Version:    0.7.0.1
 */