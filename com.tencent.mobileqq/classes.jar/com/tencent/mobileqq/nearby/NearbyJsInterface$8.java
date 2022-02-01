package com.tencent.mobileqq.nearby;

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

class NearbyJsInterface$8
  implements BusinessObserver
{
  NearbyJsInterface$8(NearbyJsInterface paramNearbyJsInterface, String paramString, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle == null) {
        break label232;
      }
      Object localObject = new WebSsoBody.WebSsoResponseBody();
      ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
      paramBundle = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject).data.get());
      if (paramBundle.optInt("retcode") != 0) {
        break label232;
      }
      paramBundle = paramBundle.optString(this.jdField_a_of_type_JavaLangString);
      localObject = SharedPreUtils.d(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface.a, this.jdField_a_of_type_JavaLangString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("&uid=");
      localStringBuilder.append(paramBundle);
      localStringBuilder.append("&from=");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      paramBundle = localStringBuilder.toString();
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface.a, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface.a.startActivity((Intent)localObject);
      if (!QLog.isColorLevel()) {
        break label232;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openProfileCard web url:");
      ((StringBuilder)localObject).append(paramBundle);
      QLog.d("NearbyJsInterface", 2, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception paramBundle)
    {
      label218:
      label232:
      break label218;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NearbyJsInterface", 2, "openProfileCard, exception");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyJsInterface.8
 * JD-Core Version:    0.7.0.1
 */