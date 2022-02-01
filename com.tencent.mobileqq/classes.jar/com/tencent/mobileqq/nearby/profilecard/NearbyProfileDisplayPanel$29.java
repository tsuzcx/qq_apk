package com.tencent.mobileqq.nearby.profilecard;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.NearbyCGIReporter;
import org.json.JSONException;
import org.json.JSONObject;

class NearbyProfileDisplayPanel$29
  implements DialogInterface.OnClickListener
{
  NearbyProfileDisplayPanel$29(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a, QQBrowserActivity.class);
    paramDialogInterface.putExtra("url", "https://nearby.qq.com/qq/verify-identity/verify-identity.html?_bid=4602");
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a.startActivity(paramDialogInterface);
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("opername", "now#nearby#datacard");
        localJSONObject.put("module", "limitpop_auth_button");
        localJSONObject.put("action", "click");
        localJSONObject.put("fromuin", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a.app.getCurrentAccountUin());
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.d == 4)
        {
          paramDialogInterface = "0";
          localJSONObject.put("d4", paramDialogInterface);
          localJSONObject.put("appid", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a.app.getAppid()));
          localJSONObject.put("timelong", String.valueOf((System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L));
          localJSONObject.put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
          new NearbyCGIReporter().a(localJSONObject);
          return;
        }
      }
      catch (JSONException paramDialogInterface)
      {
        paramDialogInterface.printStackTrace();
        return;
      }
      paramDialogInterface = "1";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.29
 * JD-Core Version:    0.7.0.1
 */