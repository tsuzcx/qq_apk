package com.tencent.mobileqq.newfriend.observer;

import android.os.Bundle;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class NewFriendMessageObserver
  extends BaseMessageObserver
{
  public void a()
  {
    b();
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    a((String)paramToServiceMsg.getAttribute("_tag_LOGSTR"));
  }
  
  protected void a(String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  protected void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg)
  {
    String str3 = (String)paramToServiceMsg.getAttribute("_tag_LOGSTR");
    int i = paramToServiceMsg.extraData.getInt("system_msg_action_type");
    Object localObject = paramToServiceMsg.extraData.getString("system_msg_action_resp_key");
    String str1 = paramToServiceMsg.extraData.getString("system_msg_action_resp_error_key");
    int j = paramToServiceMsg.extraData.getInt("system_msg_action_resp_result_code_key");
    int k = paramToServiceMsg.extraData.getInt("system_msg_action_resp_type_key");
    String str2 = paramToServiceMsg.extraData.getString("system_msg_action_resp_invalid_decided_key");
    int m = paramToServiceMsg.extraData.getInt("system_msg_action_resp_remark_result_key");
    if (localObject == null) {
      paramToServiceMsg = "";
    } else {
      paramToServiceMsg = (ToServiceMsg)localObject;
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
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(";msgDetail=");
      ((StringBuilder)localObject).append(paramToServiceMsg);
      ((StringBuilder)localObject).append(";resultCode=");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(";respType=");
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append(";msgFail=");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(";msgInvalidDecided=");
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append(";remarkRet=");
      ((StringBuilder)localObject).append(m);
      QLog.d("MessageObserver", 2, ((StringBuilder)localObject).toString());
    }
    a(paramBoolean, str3, i, paramToServiceMsg, j, k, str1, str2, m);
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    b(paramBoolean1, paramBoolean2, paramList);
  }
  
  public void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 1)) {
      a(paramBoolean, ((Integer)paramArrayOfObject[0]).intValue());
    }
  }
  
  protected void b() {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object[] arrayOfObject;
    if ((paramObject instanceof Object[])) {
      arrayOfObject = (Object[])paramObject;
    } else {
      arrayOfObject = null;
    }
    if (8039 == paramInt)
    {
      a(paramBoolean, arrayOfObject);
      return;
    }
    if (4015 == paramInt)
    {
      a();
      return;
    }
    if (4014 == paramInt)
    {
      a(paramBoolean);
      return;
    }
    if (4005 == paramInt)
    {
      a(paramBoolean, false, (List)paramObject);
      return;
    }
    if (4006 == paramInt)
    {
      a(false, true, null);
      return;
    }
    if (4011 == paramInt)
    {
      a(paramBoolean, (ToServiceMsg)paramObject);
      return;
    }
    if (4012 == paramInt) {
      a((ToServiceMsg)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.observer.NewFriendMessageObserver
 * JD-Core Version:    0.7.0.1
 */