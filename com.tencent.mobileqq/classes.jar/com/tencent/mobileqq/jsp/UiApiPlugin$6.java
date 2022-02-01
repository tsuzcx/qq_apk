package com.tencent.mobileqq.jsp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.qphone.base.util.QLog;

class UiApiPlugin$6
  implements ITroopMemberApiClientApi.Callback
{
  UiApiPlugin$6(UiApiPlugin paramUiApiPlugin, Integer paramInteger, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    if (paramBundle.getBoolean("isSuccess", false))
    {
      int i = paramBundle.getInt("appid");
      String str1 = paramBundle.getString("openId");
      if ((i == this.a.intValue()) && (str1.equals(this.b)))
      {
        String str2 = paramBundle.getString("uin");
        boolean bool = paramBundle.getBoolean("isFriend", false);
        str1 = paramBundle.getString("nickName");
        String str3 = paramBundle.getString("remark");
        if (!TextUtils.isEmpty(str2))
        {
          if (bool)
          {
            paramBundle = new AllInOne(str2, 1);
            paramBundle.nickname = str1;
            paramBundle.remark = str3;
          }
          else
          {
            paramBundle = new AllInOne(str2, 105);
          }
          paramBundle = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(this.c.e(), paramBundle);
          paramBundle.addFlags(536870912);
          this.c.e().startActivity(paramBundle);
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("UiApiPlugin", 2, "appId != appID || !openId.equals(openID)");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.6
 * JD-Core Version:    0.7.0.1
 */