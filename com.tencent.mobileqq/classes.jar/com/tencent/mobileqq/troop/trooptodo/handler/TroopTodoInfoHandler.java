package com.tencent.mobileqq.troop.trooptodo.handler;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.trooptodo.TroopTodoInfoObserver;
import com.tencent.mobileqq.troop.trooptodo.api.ITroopTodoInfoHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0xf8e.oidb_0xf8e.InfoValue;
import tencent.im.oidb.cmd0xf8e.oidb_0xf8e.ReqBody;
import tencent.im.oidb.cmd0xf8e.oidb_0xf8e.RspBody;

public class TroopTodoInfoHandler
  extends TroopBaseHandler
  implements ITroopTodoInfoHandler
{
  public TroopTodoInfoHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      long l = 0L;
      int i;
      if (paramToServiceMsg.extraData != null)
      {
        i = paramToServiceMsg.extraData.getInt("req_type", 0);
        l = paramToServiceMsg.extraData.getLong("req_group_code");
      }
      else
      {
        i = 0;
      }
      paramToServiceMsg = new oidb_0xf8e.RspBody();
      int j = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      paramObject = new StringBuilder();
      paramObject.append("[handleTroopTodoInfo] invoke 0xf8e,, groupCode = ");
      paramObject.append(l);
      paramObject.append(", reqType = ");
      paramObject.append(i);
      paramObject.append(", cmd = ");
      paramObject.append(paramFromServiceMsg.getServiceCmd());
      paramObject.append(", result = ");
      paramObject.append(j);
      QLog.i("TroopTodoInfoHandler-TodoInfo", 2, paramObject.toString());
      if (j != 0)
      {
        if ("OidbSvcTrpcTcp.0xf8e_1".equals(paramFromServiceMsg.getServiceCmd()))
        {
          notifyUI(TroopTodoInfoObserver.b, false, new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          return;
        }
        notifyUI(TroopTodoInfoObserver.c, false, new Object[] { Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(l) });
        return;
      }
      j = paramToServiceMsg.exp_time.get();
      if ("OidbSvcTrpcTcp.0xf8e_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        paramToServiceMsg = (oidb_0xf8e.InfoValue)paramToServiceMsg.info.get();
        notifyUI(TroopTodoInfoObserver.b, true, new Object[] { paramToServiceMsg, Integer.valueOf(j), Integer.valueOf(i) });
        return;
      }
      paramToServiceMsg = paramToServiceMsg.rpt_group_list.get();
      notifyUI(TroopTodoInfoObserver.c, true, new Object[] { paramToServiceMsg, Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(l) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TroopTodoInfoHandler-TodoInfo", 2, "[handleTroopTodoInfo] 0xf8e, resp == null || res == null");
    }
  }
  
  private void a(Long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[getGroupTodoInfo] 0xf8e invoke, groupCode = ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(", cmd = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", serType = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", reqType =");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.i("TroopTodoInfoHandler-TodoInfo", 2, ((StringBuilder)localObject).toString());
    localObject = new oidb_0xf8e.ReqBody();
    ((oidb_0xf8e.ReqBody)localObject).group_code.set(paramLong.longValue());
    paramString = makeOIDBPkg(paramString, 3982, paramInt1, ((oidb_0xf8e.ReqBody)localObject).toByteArray());
    localObject = new Bundle();
    ((Bundle)localObject).putInt("req_type", paramInt2);
    ((Bundle)localObject).putLong("req_group_code", paramLong.longValue());
    paramString.extraData = ((Bundle)localObject);
    paramString.setTimeout(30000L);
    sendPbReq(paramString);
  }
  
  public void a(Long paramLong, int paramInt)
  {
    a(paramLong, "OidbSvcTrpcTcp.0xf8e_1", 1, paramInt);
  }
  
  public void b(Long paramLong, int paramInt)
  {
    a(paramLong, "OidbSvcTrpcTcp.0xf8e_2", 2, paramInt);
  }
  
  protected String dv_()
  {
    return "TroopTodoInfoHandler-TodoInfo";
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvcTrpcTcp.0xf8e_1");
      this.allowCmdSet.add("OidbSvcTrpcTcp.0xf8e_2");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopTodoInfoObserver.class;
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
          paramToServiceMsg.append("[onReceive] cmdfilter error = ");
          paramToServiceMsg.append(str);
          QLog.w("TroopTodoInfoHandler-TodoInfo", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if (!dv_().equals(paramToServiceMsg.extraData.getString("REQ_TAG")))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("[onReceive] REQ_TAG doesn't match. cmd:  ");
          paramToServiceMsg.append(str);
          QLog.w("TroopTodoInfoHandler-TodoInfo", 2, paramToServiceMsg.toString());
        }
        return;
      }
      str = paramFromServiceMsg.getServiceCmd();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onReceive] getServiceCmd = ");
      localStringBuilder.append(str);
      QLog.i("TroopTodoInfoHandler-TodoInfo", 2, localStringBuilder.toString());
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TroopTodoInfoHandler-TodoInfo", 2, "[onReceive] resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.trooptodo.handler.TroopTodoInfoHandler
 * JD-Core Version:    0.7.0.1
 */