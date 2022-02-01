package com.tencent.mobileqq.kandian.biz.common.api.impl;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

final class PublicAccountReportUtils$1
  implements Runnable
{
  PublicAccountReportUtils$1(String paramString1, String paramString2, AppInterface paramAppInterface, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, String paramString6, String paramString7, boolean paramBoolean) {}
  
  public void run()
  {
    String str = this.a;
    Object localObject = str;
    if (!TextUtils.isEmpty(this.b)) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.a);
        localObject = null;
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        if ((localAppRuntime instanceof QQAppInterface)) {
          localObject = (QQAppInterface)localAppRuntime;
        }
        if (localObject != null)
        {
          if (!((IPublicAccountDataManager)((AppInterface)localObject).getRuntimeService(IPublicAccountDataManager.class, "all")).isFollowedUin(Long.valueOf(this.b))) {
            break label195;
          }
          localObject = "1";
          localJSONObject.put("fans", localObject);
        }
        localObject = localJSONObject.toString();
      }
      catch (Exception localException)
      {
        localObject = str;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("doVideoDataReportWithFansInfoInR5() error exception = ");
          ((StringBuilder)localObject).append(localException.getMessage());
          QLog.e("PublicAccountReportUtils", 2, ((StringBuilder)localObject).toString());
          localObject = str;
        }
      }
      PublicAccountReportUtils.a(this.c, this.b, this.d, this.e, this.f, this.g, this.h, this.i, this.j, (String)localObject, this.k);
      return;
      label195:
      localObject = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils.1
 * JD-Core Version:    0.7.0.1
 */