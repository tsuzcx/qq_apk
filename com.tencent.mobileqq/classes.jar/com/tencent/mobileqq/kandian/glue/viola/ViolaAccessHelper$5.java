package com.tencent.mobileqq.kandian.glue.viola;

import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.viola.adapter.ViolaReportDelegate;
import com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoaderManager;
import com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoaderManager.Companion;
import com.tencent.mobileqq.kandian.glue.viola.utils.ViolaBizUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaSDKEngine.InitCallback;
import org.json.JSONObject;

final class ViolaAccessHelper$5
  implements ViolaSDKEngine.InitCallback
{
  ViolaAccessHelper$5(AppInterface paramAppInterface, ViolaAccessHelper.SDKInitCallback paramSDKInitCallback, ViolaReportDelegate paramViolaReportDelegate, String paramString) {}
  
  public void onFinish(int paramInt, long paramLong, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sdk initialize errCode:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.e("ViolaAccessHelper", 2, new Object[] { "QViolaSDKEngine", ((StringBuilder)localObject).toString() });
    if ((paramInt != 0) && (paramInt != 1))
    {
      if (ViolaAccessHelper.g() < 3)
      {
        ViolaAccessHelper.h();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547");
        ((StringBuilder)localObject).append(ViolaBizUtils.e());
        ViolaAccessHelper.a(((StringBuilder)localObject).toString(), new ViolaAccessHelper.5.2(this));
      }
      else
      {
        localObject = this.b;
        if (localObject != null) {
          ((ViolaAccessHelper.SDKInitCallback)localObject).a();
        }
      }
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("error_code", paramInt);
        ((JSONObject)localObject).put("error_msg", paramString);
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      PublicAccountReportUtils.a(null, null, "0X800AB6F", "0X800AB6F", 0, 0, "", "", "", ((JSONObject)localObject).toString(), false);
      return;
    }
    try
    {
      if (!ViolaSoLoaderManager.a.a().h()) {
        ViolaAccessHelper.a(this.a, true);
      }
      if (this.b != null)
      {
        new Handler(Looper.getMainLooper()).post(new ViolaAccessHelper.5.1(this, paramLong));
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("SDKInitialize Exception e: ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        QLog.e("ViolaAccessHelper", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper.5
 * JD-Core Version:    0.7.0.1
 */