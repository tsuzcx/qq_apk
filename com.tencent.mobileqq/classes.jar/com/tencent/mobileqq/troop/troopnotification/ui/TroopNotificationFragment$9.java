package com.tencent.mobileqq.troop.troopnotification.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class TroopNotificationFragment$9
  extends BaseMessageObserver
{
  TroopNotificationFragment$9(TroopNotificationFragment paramTroopNotificationFragment) {}
  
  protected void a(String paramString)
  {
    if ((TroopNotificationFragment.j(this.a) != null) && (TroopNotificationFragment.j(this.a).isShowing()))
    {
      TroopNotificationFragment.j(this.a).dismiss();
      paramString = this.a.g.getResources().getString(2131916977);
      QQToast.makeText(this.a.g, 1, paramString, 0).show(this.a.b());
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    TroopNotificationFragment.a(this.a, paramBoolean, paramString1, paramInt1, paramString2, paramInt2, paramInt3, paramString3, paramString4, paramInt4);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotificationFragment", 2, "onGetSuspiciousSystemMsgFin.bengin");
    }
    if (((Activity)this.a.g).isFinishing()) {
      return;
    }
    TroopNotificationFragment.a(this.a, paramBoolean1, paramBoolean2, paramList);
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotificationFragment", 2, "onGetSystemMsgFin.bengin");
    }
    TroopNotificationFragment.a(this.a, paramBoolean1, paramList);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 4019)
    {
      a(paramBoolean, false, (List)paramObject);
      return;
    }
    if (paramInt == 4005)
    {
      b(paramBoolean, false, (List)paramObject);
      return;
    }
    if (paramInt == 4006)
    {
      b(paramBoolean, true, null);
      return;
    }
    if (paramInt == 4011)
    {
      Object localObject = (ToServiceMsg)paramObject;
      String str3 = (String)((ToServiceMsg)localObject).getAttribute("_tag_LOGSTR");
      paramInt = ((ToServiceMsg)localObject).extraData.getInt("system_msg_action_type");
      paramObject = ((ToServiceMsg)localObject).extraData.getString("system_msg_action_resp_key");
      String str1 = ((ToServiceMsg)localObject).extraData.getString("system_msg_action_resp_error_key");
      int i = ((ToServiceMsg)localObject).extraData.getInt("system_msg_action_resp_result_code_key");
      int j = ((ToServiceMsg)localObject).extraData.getInt("system_msg_action_resp_type_key");
      String str2 = ((ToServiceMsg)localObject).extraData.getString("system_msg_action_resp_invalid_decided_key");
      int k = ((ToServiceMsg)localObject).extraData.getInt("system_msg_action_resp_remark_result_key");
      if (paramObject == null) {
        paramObject = "";
      }
      if (str1 == null) {
        str1 = "";
      }
      if (str2 == null) {
        str2 = "";
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sendSystemMsgActionResult logStr=");
        ((StringBuilder)localObject).append(str3);
        ((StringBuilder)localObject).append(";actionType=");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(";msgDetail=");
        ((StringBuilder)localObject).append(paramObject);
        ((StringBuilder)localObject).append(";resultCode=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(";respType=");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(";msgFail=");
        ((StringBuilder)localObject).append(str1);
        ((StringBuilder)localObject).append(";msgInvalidDecided=");
        ((StringBuilder)localObject).append(str2);
        ((StringBuilder)localObject).append(";remarkRet=");
        ((StringBuilder)localObject).append(k);
        QLog.d("MessageObserver", 2, ((StringBuilder)localObject).toString());
      }
      a(paramBoolean, str3, paramInt, paramObject, i, j, str1, str2, k);
      return;
    }
    if (paramInt == 4012) {
      a((String)((ToServiceMsg)paramObject).getAttribute("_tag_LOGSTR"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.ui.TroopNotificationFragment.9
 * JD-Core Version:    0.7.0.1
 */