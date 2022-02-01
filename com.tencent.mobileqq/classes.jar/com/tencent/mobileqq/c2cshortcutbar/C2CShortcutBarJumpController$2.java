package com.tencent.mobileqq.c2cshortcutbar;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class C2CShortcutBarJumpController$2
  implements MiniAppCmdInterface
{
  C2CShortcutBarJumpController$2(C2CShortcutBarJumpController paramC2CShortcutBarJumpController, BaseChatPie paramBaseChatPie) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.optInt("retCode") == -12998002)) {
      this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarJumpController.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    }
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarJumpController", 2, "onCmdListener() isSuc = " + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarJumpController.2
 * JD-Core Version:    0.7.0.1
 */