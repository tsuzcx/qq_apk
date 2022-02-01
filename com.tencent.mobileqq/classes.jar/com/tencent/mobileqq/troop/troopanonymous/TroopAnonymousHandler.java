package com.tencent.mobileqq.troop.troopanonymous;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.observer.TroopAnonymousObserver;
import com.tencent.mobileqq.troop.troopanonymous.api.ITroopAnonymousHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.cs.cmd0x3bb.cmd0x3bb.AnonyMsg;
import tencent.im.cs.cmd0x3bb.cmd0x3bb.AnonyStatus;
import tencent.im.cs.cmd0x3bb.cmd0x3bb.ReqBody;
import tencent.im.cs.cmd0x3bb.cmd0x3bb.RspBody;

public class TroopAnonymousHandler
  extends TroopBaseHandler
  implements ITroopAnonymousHandler
{
  public TroopAnonymousHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        notifyUI(TroopAnonymousObserver.b, false, null);
        return;
      }
      paramFromServiceMsg = new cmd0x3bb.AnonyMsg();
    }
    try
    {
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      paramFromServiceMsg = (cmd0x3bb.RspBody)paramFromServiceMsg.msg_anony_rsp.get();
      if (paramFromServiceMsg == null)
      {
        notifyUI(TroopAnonymousObserver.b, false, null);
        return;
      }
      if (paramFromServiceMsg.int32_ret.get() != 0)
      {
        notifyUI(TroopAnonymousObserver.b, false, null);
        return;
      }
      paramObject = paramToServiceMsg.extraData.getString("troopUin");
      str = new String(paramFromServiceMsg.str_anony_name.get().toByteArray());
      j = paramFromServiceMsg.uint32_portrait_index.get();
      k = paramFromServiceMsg.uint32_bubble_index.get();
      m = paramFromServiceMsg.uint32_expired_time.get();
      paramToServiceMsg = (cmd0x3bb.AnonyStatus)paramFromServiceMsg.msg_anony_status.get();
      if (paramToServiceMsg == null) {
        break label282;
      }
      i = paramToServiceMsg.uint32_forbid_talking.get();
      paramToServiceMsg = new String(paramToServiceMsg.str_err_msg.get().toByteArray());
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        String str;
        int j;
        int k;
        int m;
        continue;
        paramToServiceMsg = "";
        int i = 0;
      }
    }
    paramFromServiceMsg = paramFromServiceMsg.color.get();
    notifyUI(TroopAnonymousObserver.b, true, new Object[] { paramObject, str, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), paramToServiceMsg, paramFromServiceMsg });
    return;
    notifyUI(TroopAnonymousObserver.b, false, null);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    Object localObject2 = new cmd0x3bb.ReqBody();
    try
    {
      ((cmd0x3bb.ReqBody)localObject2).uint64_uin.set(Long.parseLong(paramString1));
      ((cmd0x3bb.ReqBody)localObject2).uint64_group_code.set(Long.parseLong(paramString2));
      localObject1 = new cmd0x3bb.AnonyMsg();
      ((cmd0x3bb.AnonyMsg)localObject1).uint32_cmd.set(paramInt);
      ((cmd0x3bb.AnonyMsg)localObject1).msg_anony_req.set((MessageMicro)localObject2);
      localObject2 = new ToServiceMsg("mobileqq.service", this.appRuntime.getCurrentAccountUin(), "group_anonymous_generate_nick.group");
      ((ToServiceMsg)localObject2).putWupBuffer(((cmd0x3bb.AnonyMsg)localObject1).toByteArray());
      ((ToServiceMsg)localObject2).setTimeout(30000L);
      ((ToServiceMsg)localObject2).extraData.putString("troopUin", paramString2);
      sendPbReq((ToServiceMsg)localObject2);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("TroopHandler.getAnonymousChatNick, memberUin: ");
        ((StringBuilder)localObject1).append(paramString1);
        ((StringBuilder)localObject1).append(" troopUin: ");
        ((StringBuilder)localObject1).append(paramString2);
        QLog.d("TroopAnonymousHandler", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      Object localObject1;
      label173:
      break label173;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getAnonymousChatNick error, NumberFormatException, uin : ");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(", troopUin : ");
      ((StringBuilder)localObject1).append(paramString2);
      QLog.d("TroopAnonymousHandler", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  protected String dv_()
  {
    return "TroopAnonymousHandler";
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("group_anonymous_generate_nick.group");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopAnonymousObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAnonymousHandler", 2, "onReceive,resp == null");
      }
      return;
    }
    String str = paramFromServiceMsg.getServiceCmd();
    if (msgCmdFilter(str))
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("cmdfilter error=");
        paramToServiceMsg.append(str);
        QLog.d("TroopAnonymousHandler", 2, paramToServiceMsg.toString());
      }
      return;
    }
    if ("group_anonymous_generate_nick.group".equals(paramFromServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopanonymous.TroopAnonymousHandler
 * JD-Core Version:    0.7.0.1
 */