package com.tencent.mobileqq.troop.handler;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.HashMap;

public abstract class TroopBaseHandler
  extends BusinessHandler
{
  private HashMap<String, Pair<Long, Integer>> a = null;
  
  public TroopBaseHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void b(ToServiceMsg paramToServiceMsg) {}
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(dv_(), 2, "sendPbRequest. request is null.");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      String str = dv_();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendPbRequest. cmd=");
      localStringBuilder.append(paramToServiceMsg.getServiceCmd());
      QLog.d(str, 2, localStringBuilder.toString());
    }
    sendPbReq(paramToServiceMsg);
  }
  
  protected String dv_()
  {
    return "";
  }
  
  public void send(ToServiceMsg paramToServiceMsg)
  {
    if (!TextUtils.isEmpty(dv_())) {
      paramToServiceMsg.extraData.putString("REQ_TAG", dv_());
    }
    super.send(paramToServiceMsg);
    b(paramToServiceMsg);
  }
  
  public void sendPbReq(ToServiceMsg paramToServiceMsg)
  {
    if (!TextUtils.isEmpty(dv_())) {
      paramToServiceMsg.extraData.putString("REQ_TAG", dv_());
    }
    super.sendPbReq(paramToServiceMsg);
    b(paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.handler.TroopBaseHandler
 * JD-Core Version:    0.7.0.1
 */