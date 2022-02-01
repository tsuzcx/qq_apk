package com.tencent.mobileqq.vashealth;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

final class SSOHttpUtils$2
  implements BusinessObserver
{
  SSOHttpUtils$2(QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {
      try
      {
        paramBundle = paramBundle.getByteArray("extra_data");
        if (paramBundle == null)
        {
          QLog.e("SSOHttpUtils", 1, "report failed response data is null");
          return;
        }
        Object localObject1 = new WebSSOAgent.UniSsoServerRsp();
        ((WebSSOAgent.UniSsoServerRsp)localObject1).mergeFrom(paramBundle);
        QLog.i("SSOHttpUtils", 1, "requestRedPack report result:" + ((WebSSOAgent.UniSsoServerRsp)localObject1).rspdata.get());
        paramBundle = new JSONObject(((WebSSOAgent.UniSsoServerRsp)localObject1).rspdata.get());
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
                BannerManager.a().a(37, 2, localMessage);
                paramBundle = new Date();
                paramBundle = new SimpleDateFormat("yyyy-MM-dd").format(paramBundle);
                paramBundle = paramBundle + "-RedPack";
                localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences(this.a.getCurrentAccountUin() + ".qqsport", 4).edit();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.SSOHttpUtils.2
 * JD-Core Version:    0.7.0.1
 */