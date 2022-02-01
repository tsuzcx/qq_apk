package com.tencent.mobileqq.mini.appbrand.ui;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class PreloadingFragment$7$2
  implements Runnable
{
  PreloadingFragment$7$2(PreloadingFragment.7 param7, JSONObject paramJSONObject) {}
  
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
    ((StringBuilder)localObject2).append("GetAppInfoByLink failed. retCode=");
    ((StringBuilder)localObject2).append(l);
    ((StringBuilder)localObject2).append(" errMsg=");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.e("PreloadingFragment", 1, ((StringBuilder)localObject2).toString());
    try
    {
      localObject2 = BaseApplicationImpl.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append((String)localObject1);
      QQToast.makeText((Context)localObject2, 1, localStringBuilder.toString(), 1).show();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("PreloadingFragment", 1, "", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.7.2
 * JD-Core Version:    0.7.0.1
 */