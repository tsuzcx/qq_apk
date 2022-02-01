package com.tencent.mobileqq.jsp;

import android.content.Context;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.troopnotification.utils.TroopNotificationUtils;
import com.tencent.qphone.base.util.QLog;

class TroopApiPlugin$2
  extends TroopMngObserver
{
  TroopApiPlugin$2(TroopApiPlugin paramTroopApiPlugin) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (this.a.jdField_a_of_type_Int == -1) {
      return;
    }
    if (1 == paramInt1) {
      TroopApiPlugin.a(this.a, 2131693506);
    }
    this.a.jdField_a_of_type_Int = -1;
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (this.a.jdField_a_of_type_Int == -1) {
      return;
    }
    if (1 == paramInt1) {
      if (paramInt2 != -2)
      {
        if ((paramInt2 != 0) && (paramInt2 != 1))
        {
          if (paramInt2 != 2) {
            TroopApiPlugin.a(this.a, 2131693506);
          } else {
            TroopApiPlugin.a(this.a, 2131719932);
          }
        }
        else if ((this.a.jdField_a_of_type_Int != 2) && (this.a.jdField_a_of_type_Int != 5))
        {
          TroopApiPlugin.a(this.a, 2131693507, 2);
          paramString = this.a;
          paramString.callJs(paramString.jdField_a_of_type_JavaLangString, new String[] { "{\"result\":0,\"message\":\"ok\"}" });
        }
        else
        {
          paramString = this.a;
          paramString.callJs(paramString.jdField_a_of_type_JavaLangString, new String[] { "{\"result\":1,\"message\":\"ok\"}" });
        }
      }
      else
      {
        paramString = this.a;
        paramString.callJs(paramString.jdField_a_of_type_JavaLangString, new String[] { "{\"result\":1,\"message\":\"ok\"}" });
      }
    }
    this.a.jdField_a_of_type_Int = -1;
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (this.a.b == 0) {
      return;
    }
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopApiPlugin", 2, "AddTroop onSend0x88d_1_forJoinTroop_Ret success.");
      }
      paramLong = paramTroopInfo.troopPrivilegeFlag;
      if ((0x80 & paramLong) != 0L) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      int i;
      if ((paramLong & 0x200) != 0L) {
        i = 1;
      } else {
        i = 0;
      }
      Context localContext = TroopApiPlugin.a(this.a);
      if ((paramInt != 0) && (i != 0) && (localContext != null))
      {
        TroopNotificationUtils.a(localContext, paramTroopInfo.troopuin, "");
      }
      else if (paramTroopInfo.cGroupOption == 1)
      {
        this.a.jdField_a_of_type_Int = paramTroopInfo.cGroupOption;
        TroopApiPlugin.a(this.a, paramTroopInfo);
      }
      else
      {
        TroopApiPlugin.b(this.a, paramTroopInfo);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopApiPlugin", 2, "AddTroop onSend0x88d_1_forJoinTroop_Ret failed.");
      }
      paramTroopInfo = this.a;
      paramTroopInfo.callJs(paramTroopInfo.jdField_a_of_type_JavaLangString, new String[] { "{\"result\":-1,\"message\":\"request fail\"}" });
      TroopApiPlugin.a(this.a, 2131718218);
    }
    this.a.b = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.TroopApiPlugin.2
 * JD-Core Version:    0.7.0.1
 */