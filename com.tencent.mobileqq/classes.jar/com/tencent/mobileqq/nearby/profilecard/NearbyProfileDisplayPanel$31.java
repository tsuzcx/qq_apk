package com.tencent.mobileqq.nearby.profilecard;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.newnearby.INearbyCGIReporter;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONException;
import org.json.JSONObject;

class NearbyProfileDisplayPanel$31
  implements DialogInterface.OnClickListener
{
  NearbyProfileDisplayPanel$31(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.b.U == 4) && (NearbyProfileDisplayPanel.i(this.b))) {
      NearbyProfileDisplayPanel.j(this.b);
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("opername", "now#nearby#datacard");
        if (this.b.U == 4)
        {
          paramDialogInterface = "limitpop_continue_button";
          localJSONObject.put("module", paramDialogInterface);
          localJSONObject.put("action", "click");
          localJSONObject.put("fromuin", this.b.e.app.getCurrentAccountUin());
          if (this.b.U != 4) {
            break label213;
          }
          paramDialogInterface = "0";
          localJSONObject.put("d4", paramDialogInterface);
          localJSONObject.put("appid", String.valueOf(this.b.e.app.getAppid()));
          localJSONObject.put("timelong", String.valueOf((System.currentTimeMillis() - this.a) / 1000L));
          localJSONObject.put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
          ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson(localJSONObject);
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
      label213:
      paramDialogInterface = "1";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.31
 * JD-Core Version:    0.7.0.1
 */