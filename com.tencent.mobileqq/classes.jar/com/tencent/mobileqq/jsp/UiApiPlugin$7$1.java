package com.tencent.mobileqq.jsp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.qphone.base.util.QLog;

class UiApiPlugin$7$1
  implements ITroopMemberApiClientApi.Callback
{
  UiApiPlugin$7$1(UiApiPlugin.7 param7, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    if (paramBundle.getBoolean("isSuccess", false))
    {
      int i = paramBundle.getInt("appid");
      Object localObject = paramBundle.getString("openId");
      if ((i == this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin$7.jdField_a_of_type_JavaLangInteger.intValue()) && (((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin$7.jdField_a_of_type_JavaLangString)))
      {
        paramBundle = paramBundle.getString("uin");
        if (!TextUtils.isEmpty(paramBundle))
        {
          localObject = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin$7.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.a(), null);
          ((Intent)localObject).putExtra("troopUin", this.jdField_a_of_type_JavaLangString);
          ((Intent)localObject).putExtra("memberUin", paramBundle);
          this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin$7.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.a().startActivity((Intent)localObject);
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("UiApiPlugin", 2, "appId != appID || !openId.equals(openID)");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.7.1
 * JD-Core Version:    0.7.0.1
 */