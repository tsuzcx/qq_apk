package com.tencent.mobileqq.troop.clockin.handler;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.troop.clockin.api.ITroopClockInHandler;
import com.tencent.mobileqq.troop.clockin.api.TroopClockInObserver;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7.ReqBody;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7.RspBody;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7.StSignInStatusReq;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7.StSignInStatusRsp;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7.StSignInWriteReq;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7.StSignInWriteRsp;

public class TroopClockInHandler
  extends TroopBaseHandler
  implements ITroopClockInHandler
{
  protected Set<String> a;
  
  public TroopClockInHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      Boolean localBoolean = Boolean.valueOf(paramToServiceMsg.extraData.getBoolean("isWrite"));
      String str1 = paramToServiceMsg.extraData.getString("troopUin");
      String str2 = paramToServiceMsg.extraData.getString("memberUin");
      int j = paramToServiceMsg.extraData.getInt("signInScene");
      int i;
      if (localBoolean.booleanValue()) {
        i = TroopClockInObserver.c;
      } else {
        i = TroopClockInObserver.b;
      }
      paramToServiceMsg = new oidb_0xeb7.RspBody();
      int k = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (k != 0)
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handleInvokeSignInStatusResp failed result: ");
          paramToServiceMsg.append(k);
          QLog.i("TroopClockInHandler", 2, paramToServiceMsg.toString());
        }
        notifyUI(i, false, null);
        return;
      }
      if (localBoolean.booleanValue())
      {
        if (paramToServiceMsg.signInWriteRsp.has())
        {
          notifyUI(i, true, new Object[] { str1, str2, (oidb_0xeb7.StSignInWriteRsp)paramToServiceMsg.signInWriteRsp.get() });
          return;
        }
        notifyUI(i, false, new Object[] { str1, str2, null });
        return;
      }
      if (paramToServiceMsg.signInStatusRsp.has())
      {
        notifyUI(i, true, new Object[] { str1, str2, (oidb_0xeb7.StSignInStatusRsp)paramToServiceMsg.signInStatusRsp.get(), Integer.valueOf(j) });
        return;
      }
      notifyUI(i, false, new Object[] { str1, str2, null, Integer.valueOf(j) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopClockInHandler", 2, "handleInvokeSignInStatusResp resp == null || res == null");
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    try
    {
      Object localObject1 = new oidb_0xeb7.ReqBody();
      Object localObject2;
      int i;
      if (paramBoolean)
      {
        localObject2 = new oidb_0xeb7.StSignInWriteReq();
        ((oidb_0xeb7.StSignInWriteReq)localObject2).groupId.set(paramString1);
        ((oidb_0xeb7.StSignInWriteReq)localObject2).uid.set(paramString2);
        ((oidb_0xeb7.StSignInWriteReq)localObject2).clientVersion.set("8.8.17");
        ((oidb_0xeb7.ReqBody)localObject1).signInWriteReq.set((MessageMicro)localObject2);
        i = 1;
      }
      else
      {
        localObject2 = new oidb_0xeb7.StSignInStatusReq();
        ((oidb_0xeb7.StSignInStatusReq)localObject2).groupId.set(paramString1);
        ((oidb_0xeb7.StSignInStatusReq)localObject2).uid.set(paramString2);
        ((oidb_0xeb7.StSignInStatusReq)localObject2).scene.set(paramInt);
        ((oidb_0xeb7.StSignInStatusReq)localObject2).clientVersion.set("8.8.17");
        ((oidb_0xeb7.ReqBody)localObject1).signInStatusReq.set((MessageMicro)localObject2);
        i = 0;
      }
      localObject1 = makeOIDBPkg("OidbSvc.0xeb7", 3767, i, ((oidb_0xeb7.ReqBody)localObject1).toByteArray(), 30000L);
      ((ToServiceMsg)localObject1).extraData.putString("troopUin", paramString1);
      ((ToServiceMsg)localObject1).extraData.putString("memberUin", paramString2);
      ((ToServiceMsg)localObject1).extraData.putInt("signInScene", paramInt);
      ((ToServiceMsg)localObject1).extraData.putBoolean("isWrite", paramBoolean);
      sendPbReq((ToServiceMsg)localObject1);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, 0, true);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    a(paramString1, paramString2, paramInt, false);
  }
  
  protected String dv_()
  {
    return "TroopClockInHandler";
  }
  
  public Set<String> getCommandList()
  {
    if (this.a == null)
    {
      this.a = new HashSet();
      this.a.add("OidbSvc.0xeb7");
    }
    return this.a;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopClockInObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramToServiceMsg != null))
    {
      String str = paramFromServiceMsg.getServiceCmd();
      if (msgCmdFilter(str))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("cmdfilter error=");
          paramToServiceMsg.append(str);
          QLog.d("TroopClockInHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if (!dv_().equals(paramToServiceMsg.extraData.getString("REQ_TAG")))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("REQ_TAG doesn't match. cmd:  ");
          paramToServiceMsg.append(str);
          QLog.d("TroopClockInHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ("OidbSvc.0xeb7".equals(paramFromServiceMsg.getServiceCmd())) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopClockInHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.clockin.handler.TroopClockInHandler
 * JD-Core Version:    0.7.0.1
 */