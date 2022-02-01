package com.tencent.mobileqq.mini.appbrand.ui;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class PreloadingFragment$7$1
  implements Runnable
{
  PreloadingFragment$7$1(PreloadingFragment.7 param7, JSONObject paramJSONObject) {}
  
  public void run()
  {
    long l = this.val$ret.optLong("retCode");
    String str = this.val$ret.optString("errMsg");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("GetAppInfoByLink failed. retCode=");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append(" errMsg=");
    ((StringBuilder)localObject).append(str);
    QLog.e("PreloadingFragment", 1, ((StringBuilder)localObject).toString());
    try
    {
      localObject = BaseApplicationImpl.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(str);
      QQToast.makeText((Context)localObject, 1, localStringBuilder.toString(), 1).show();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("PreloadingFragment", 1, "", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.7.1
 * JD-Core Version:    0.7.0.1
 */