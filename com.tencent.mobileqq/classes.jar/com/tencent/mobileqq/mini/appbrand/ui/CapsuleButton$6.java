package com.tencent.mobileqq.mini.appbrand.ui;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class CapsuleButton$6
  implements MiniAppCmdInterface
{
  CapsuleButton$6(CapsuleButton paramCapsuleButton) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      QLog.d("CapsuleButton", 2, "sendSetUserAppTopRequest, success to set top");
      return;
    }
    QLog.e("CapsuleButton", 1, "sendSetUserAppTopRequest, fail to set top");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton.6
 * JD-Core Version:    0.7.0.1
 */