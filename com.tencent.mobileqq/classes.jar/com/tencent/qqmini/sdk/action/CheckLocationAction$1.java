package com.tencent.qqmini.sdk.action;

import org.json.JSONObject;

class CheckLocationAction$1
  implements PhoneNumberAction.PhoneNumberActionCallback
{
  CheckLocationAction$1(CheckLocationAction paramCheckLocationAction) {}
  
  public void onGetAuthDialogRet(boolean paramBoolean, JSONObject paramJSONObject)
  {
    CheckLocationAction.a(this.a).onCheckLocationPermissionAction(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.action.CheckLocationAction.1
 * JD-Core Version:    0.7.0.1
 */