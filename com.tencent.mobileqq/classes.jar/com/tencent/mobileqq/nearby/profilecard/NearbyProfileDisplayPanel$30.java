package com.tencent.mobileqq.nearby.profilecard;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.NearbyCGIReporter;
import org.json.JSONException;
import org.json.JSONObject;

class NearbyProfileDisplayPanel$30
  implements DialogInterface.OnClickListener
{
  NearbyProfileDisplayPanel$30(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.d == 4) && (NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel))) {
      NearbyProfileDisplayPanel.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel);
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("opername", "now#nearby#datacard");
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.d == 4)
        {
          paramDialogInterface = "limitpop_continue_button";
          localJSONObject.put("module", paramDialogInterface);
          localJSONObject.put("action", "click");
          localJSONObject.put("fromuin", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a.app.getCurrentAccountUin());
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.d != 4) {
            break label210;
          }
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
      paramDialogInterface = "limitpop_cancal_button";
      continue;
      label210:
      paramDialogInterface = "1";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.30
 * JD-Core Version:    0.7.0.1
 */