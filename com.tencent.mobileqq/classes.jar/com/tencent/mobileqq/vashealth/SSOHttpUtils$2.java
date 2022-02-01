package com.tencent.mobileqq.vashealth;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vashealth.websso.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

final class SSOHttpUtils$2
  implements BusinessObserver
{
  SSOHttpUtils$2(AppRuntime paramAppRuntime) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {
      try
      {
        Object localObject1 = paramBundle.getByteArray("extra_data");
        if (localObject1 == null)
        {
          QLog.e("SSOHttpUtils", 1, "report failed response data is null");
          return;
        }
        paramBundle = new WebSSOAgent.UniSsoServerRsp();
        paramBundle.mergeFrom((byte[])localObject1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("requestRedPack report result:");
        ((StringBuilder)localObject1).append(paramBundle.rspdata.get());
        QLog.i("SSOHttpUtils", 1, ((StringBuilder)localObject1).toString());
        paramBundle = new JSONObject(paramBundle.rspdata.get());
        if (paramBundle.optInt("code") == 0)
        {
          Object localObject2 = new JSONObject(paramBundle.optString("data"));
          paramInt = ((JSONObject)localObject2).optInt("redpkg_tips");
          paramBundle = ((JSONObject)localObject2).optString("icon");
          if (paramInt == 1)
          {
            paramInt = ((JSONObject)localObject2).optInt("actid");
            int i = ((JSONObject)localObject2).optInt("appid");
            localObject1 = ((JSONObject)localObject2).optString("title");
            localObject2 = ((JSONObject)localObject2).optString("link");
            if (paramInt >= 0) {
              try
              {
                Message localMessage = Message.obtain();
                JSONObject localJSONObject = new JSONObject();
                localJSONObject.put("runningState", 3);
                localJSONObject.put("cookieUrl", localObject2);
                localJSONObject.put("title", localObject1);
                localJSONObject.put("icon", paramBundle);
                localJSONObject.put("actid", paramInt);
                localJSONObject.put("appid", i);
                localMessage.obj = localJSONObject;
                BannerManager.a().a(RunningBannerProcessor.a, 2, localMessage);
                paramBundle = new Date();
                paramBundle = new SimpleDateFormat("yyyy-MM-dd").format(paramBundle);
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(paramBundle);
                ((StringBuilder)localObject1).append("-RedPack");
                paramBundle = ((StringBuilder)localObject1).toString();
                localObject1 = this.a.getApplication();
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append(this.a.getCurrentAccountUin());
                ((StringBuilder)localObject2).append(".qqsport");
                localObject1 = ((MobileQQ)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 4).edit();
                ((SharedPreferences.Editor)localObject1).putBoolean(paramBundle, false);
                ((SharedPreferences.Editor)localObject1).commit();
                return;
              }
              catch (JSONException paramBundle)
              {
                paramBundle.printStackTrace();
                return;
              }
            }
          }
        }
        return;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.SSOHttpUtils.2
 * JD-Core Version:    0.7.0.1
 */