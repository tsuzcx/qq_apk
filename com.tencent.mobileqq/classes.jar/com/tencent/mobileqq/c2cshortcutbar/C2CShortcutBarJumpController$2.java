package com.tencent.mobileqq.c2cshortcutbar;

import android.app.Activity;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class C2CShortcutBarJumpController$2
  implements MiniAppCmdInterface
{
  C2CShortcutBarJumpController$2(C2CShortcutBarJumpController paramC2CShortcutBarJumpController, Activity paramActivity) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.optInt("retCode") == -12998002)) {
      this.b.a(this.a);
    }
    if (QLog.isColorLevel())
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("onCmdListener() isSuc = ");
      paramJSONObject.append(paramBoolean);
      QLog.d("C2CShortcutBarJumpController", 2, paramJSONObject.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarJumpController.2
 * JD-Core Version:    0.7.0.1
 */