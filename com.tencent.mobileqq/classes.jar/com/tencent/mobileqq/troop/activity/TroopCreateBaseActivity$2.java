package com.tencent.mobileqq.troop.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import org.json.JSONException;
import org.json.JSONObject;

class TroopCreateBaseActivity$2
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("result", paramInt);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity.a(this.jdField_a_of_type_JavaLangString, paramDialogInterface.toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopCreateBaseActivity.2
 * JD-Core Version:    0.7.0.1
 */