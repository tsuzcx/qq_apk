package com.tencent.mobileqq.jsp;

import com.tencent.mobileqq.activity.contact.troop.TroopNotificationUtils;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;

class TroopApiPlugin$2
  extends TroopBusinessObserver
{
  TroopApiPlugin$2(TroopApiPlugin paramTroopApiPlugin) {}
  
  public void onOIDB0X88D_1_Ret(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    if (this.a.b == 0) {
      return;
    }
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopApiPlugin", 2, "AddTroop onOIDB0X88D_1_Ret success.");
      }
      paramLong = paramTroopInfo.troopPrivilegeFlag;
      if ((0x80 & paramLong) != 0L)
      {
        paramInt1 = 1;
        if ((paramLong & 0x200) == 0L) {
          break label112;
        }
        paramInt2 = 1;
        label61:
        paramString = TroopApiPlugin.a(this.a);
        if ((paramInt1 == 0) || (paramInt2 == 0) || (paramString == null)) {
          break label118;
        }
        TroopNotificationUtils.a(paramString, paramTroopInfo.troopuin, "");
      }
    }
    for (;;)
    {
      this.a.b = 0;
      return;
      paramInt1 = 0;
      break;
      label112:
      paramInt2 = 0;
      break label61;
      label118:
      if (paramTroopInfo.cGroupOption == 1)
      {
        this.a.jdField_a_of_type_Int = paramTroopInfo.cGroupOption;
        TroopApiPlugin.a(this.a, paramTroopInfo);
      }
      else
      {
        TroopApiPlugin.b(this.a, paramTroopInfo);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("TroopApiPlugin", 2, "AddTroop onOIDB0X88D_1_Ret failed.");
        }
        this.a.callJs(this.a.jdField_a_of_type_JavaLangString, new String[] { "{\"result\":-1,\"message\":\"request fail\"}" });
        TroopApiPlugin.a(this.a, 2131718550);
      }
    }
  }
  
  public void onTroopManagerFailed(int paramInt1, int paramInt2)
  {
    if (this.a.jdField_a_of_type_Int == -1) {
      return;
    }
    if (1 == paramInt1) {
      TroopApiPlugin.a(this.a, 2131693551);
    }
    this.a.jdField_a_of_type_Int = -1;
  }
  
  public void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    if (this.a.jdField_a_of_type_Int == -1) {
      return;
    }
    if (1 == paramInt1) {
      switch (paramInt2)
      {
      case -1: 
      default: 
        TroopApiPlugin.a(this.a, 2131693551);
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Int = -1;
      return;
      if ((this.a.jdField_a_of_type_Int == 2) || (this.a.jdField_a_of_type_Int == 5))
      {
        this.a.callJs(this.a.jdField_a_of_type_JavaLangString, new String[] { "{\"result\":1,\"message\":\"ok\"}" });
      }
      else
      {
        TroopApiPlugin.a(this.a, 2131693552, 2);
        this.a.callJs(this.a.jdField_a_of_type_JavaLangString, new String[] { "{\"result\":0,\"message\":\"ok\"}" });
        continue;
        TroopApiPlugin.a(this.a, 2131720199);
        continue;
        this.a.callJs(this.a.jdField_a_of_type_JavaLangString, new String[] { "{\"result\":1,\"message\":\"ok\"}" });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.TroopApiPlugin.2
 * JD-Core Version:    0.7.0.1
 */