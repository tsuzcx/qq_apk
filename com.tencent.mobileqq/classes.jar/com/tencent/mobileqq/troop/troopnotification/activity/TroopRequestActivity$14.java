package com.tencent.mobileqq.troop.troopnotification.activity;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.troop.util.TroopSystemMsgUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

class TroopRequestActivity$14
  extends BaseMessageObserver
{
  TroopRequestActivity$14(TroopRequestActivity paramTroopRequestActivity) {}
  
  protected void a(String paramString)
  {
    this.a.h();
    paramString = this.a.getString(2131916977);
    QQToast.makeText(this.a, 1, paramString, 0).show(this.a.getTitleBarHeight());
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    paramString = this.a;
    paramString.a(2130839806, paramString.getString(2131916595));
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = GroupSystemMsgController.a().f();
    }
    if (!paramBoolean)
    {
      this.a.h();
      if (TroopSystemMsgUtils.a(GroupSystemMsgController.a().b(paramString1), paramInt3, paramString2, paramString4)) {
        this.a.finish();
      }
    }
    else
    {
      this.a.h();
      this.a.finish();
      TroopSystemMsgUtils.a(GroupSystemMsgController.a().b(paramString1), paramInt1, paramString2, paramInt2);
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    paramString = this.a;
    paramString.a(2130839806, paramString.getString(2131916581));
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
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
    if (paramInt == 4012)
    {
      a((String)((ToServiceMsg)paramObject).getAttribute("_tag_LOGSTR"));
      return;
    }
    if (paramInt == 6001)
    {
      if ((paramObject instanceof String)) {
        a(paramBoolean, (String)paramObject);
      }
    }
    else if ((paramInt == 6002) && ((paramObject instanceof String))) {
      b(paramBoolean, (String)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestActivity.14
 * JD-Core Version:    0.7.0.1
 */