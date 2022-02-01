package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

final class RealNearbyProfileCardUtils$1
  implements BusinessObserver
{
  RealNearbyProfileCardUtils$1(String paramString, Context paramContext, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle == null) {
        break label229;
      }
      Object localObject = new WebSsoBody.WebSsoResponseBody();
      ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
      paramBundle = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject).data.get());
      if (paramBundle.optInt("retcode") != 0) {
        break label229;
      }
      paramBundle = paramBundle.optString(this.a);
      localObject = SharedPreUtils.ag(this.b, this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("&uid=");
      localStringBuilder.append(paramBundle);
      localStringBuilder.append("&from=");
      localStringBuilder.append(this.c);
      paramBundle = localStringBuilder.toString();
      localObject = new Intent(this.b, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramBundle);
      this.b.startActivity((Intent)localObject);
      if (!QLog.isColorLevel()) {
        break label229;
      }
      localObject = RealNearbyProfileCardUtils.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("openProfileCard web url:");
      localStringBuilder.append(paramBundle);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
      return;
    }
    catch (Exception paramBundle)
    {
      label214:
      label229:
      break label214;
    }
    if (QLog.isColorLevel()) {
      QLog.d(RealNearbyProfileCardUtils.a(), 2, "openProfileCard, exception");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.RealNearbyProfileCardUtils.1
 * JD-Core Version:    0.7.0.1
 */