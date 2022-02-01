package com.tencent.mobileqq.mini.appbrand.ui;

import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class CapsuleButton$7
  implements MiniAppCmdInterface
{
  CapsuleButton$7(CapsuleButton paramCapsuleButton, MiniAppInfo paramMiniAppInfo) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      AppBrandTask.runTaskOnUiThread(new CapsuleButton.7.1(this));
      QLog.d("CapsuleButton", 2, "sendSetUserAppTopRequest, success to set top");
      return;
    }
    QLog.e("CapsuleButton", 1, "sendSetUserAppTopRequest, fail to set top");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton.7
 * JD-Core Version:    0.7.0.1
 */