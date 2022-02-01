package com.tencent.mobileqq.troop.troopmessage.handler;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.observer.TroopMessageObserver;
import com.tencent.mobileqq.troop.troopmessage.api.ITroopMessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0x8a7.cmd0x8a7.ReqBody;
import tencent.im.oidb.cmd0x8a7.cmd0x8a7.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopMessageHandler
  extends TroopBaseHandler
  implements ITroopMessageHandler
{
  public TroopMessageHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str;
    Object[] arrayOfObject;
    Object localObject;
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      str = paramToServiceMsg.extraData.getString("troopCode");
      arrayOfObject = new Object[4];
      arrayOfObject[0] = str;
      arrayOfObject[1] = Boolean.valueOf(false);
      localObject = "";
      arrayOfObject[2] = "";
      arrayOfObject[3] = "";
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        notifyUI(TroopMessageObserver.b, false, arrayOfObject);
        return;
      }
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    label203:
    label477:
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null)) {
        paramObject = new cmd0x8a7.RspBody();
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      boolean bool2;
      label249:
      break label477;
    }
    try
    {
      paramObject.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      bool2 = paramObject.bool_can_at_all.get();
      if (!paramObject.bytes_prompt_msg_1.has()) {
        break label496;
      }
      paramToServiceMsg = paramObject.bytes_prompt_msg_1.get().toStringUtf8();
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      break label455;
      paramToServiceMsg = "";
      break label203;
      i = 0;
      break label249;
      j = 0;
      break label271;
      bool1 = false;
      break label413;
    }
    paramFromServiceMsg = (FromServiceMsg)localObject;
    if (paramObject.bytes_prompt_msg_2.has()) {
      paramFromServiceMsg = paramObject.bytes_prompt_msg_2.get().toStringUtf8();
    }
    if (paramObject.uint32_remain_at_all_count_for_group.has())
    {
      i = paramObject.uint32_remain_at_all_count_for_group.get();
      if (!paramObject.uint32_remain_at_all_count_for_uin.has()) {
        break label508;
      }
      j = paramObject.uint32_remain_at_all_count_for_uin.get();
      label271:
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleGetAtAllRemainCountInfo:");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(", groupRemainCnt=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", memberRemainCnt=");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(", beCanAtAll=");
        ((StringBuilder)localObject).append(bool2);
        ((StringBuilder)localObject).append(", tips1=");
        ((StringBuilder)localObject).append(paramToServiceMsg);
        ((StringBuilder)localObject).append(", tips2=");
        ((StringBuilder)localObject).append(paramFromServiceMsg);
        QLog.d("TroopMessageHandler.atAll", 2, ((StringBuilder)localObject).toString());
      }
      if (!paramObject.bool_show_at_all_lable.has()) {
        break label514;
      }
      bool1 = paramObject.bool_show_at_all_lable.get();
      label413:
      notifyUI(TroopMessageObserver.b, true, new Object[] { str, Boolean.valueOf(bool2), paramToServiceMsg, paramFromServiceMsg, Boolean.valueOf(bool1) });
      return;
      label455:
      notifyUI(TroopMessageObserver.b, false, arrayOfObject);
      return;
      notifyUI(TroopMessageObserver.b, false, arrayOfObject);
      return;
      notifyUI(TroopMessageObserver.b, false, arrayOfObject);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject = new cmd0x8a7.ReqBody();
    ((cmd0x8a7.ReqBody)localObject).uint32_sub_cmd.set(1);
    ((cmd0x8a7.ReqBody)localObject).uint32_limit_interval_type_for_uin.set(2);
    ((cmd0x8a7.ReqBody)localObject).uint32_limit_interval_type_for_group.set(1);
    try
    {
      ((cmd0x8a7.ReqBody)localObject).uint64_uin.set(Long.parseLong(paramString1));
      ((cmd0x8a7.ReqBody)localObject).uint64_group_code.set(Long.parseLong(paramString2));
      paramString1 = new oidb_sso.OIDBSSOPkg();
      paramString1.uint32_command.set(2215);
      paramString1.uint32_result.set(0);
      paramString1.uint32_service_type.set(0);
      paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x8a7.ReqBody)localObject).toByteArray()));
      localObject = new ToServiceMsg("mobileqq.service", this.appRuntime.getCurrentAccountUin(), "OidbSvc.0x8a7_0");
      ((ToServiceMsg)localObject).extraData.putString("troopCode", paramString2);
      ((ToServiceMsg)localObject).putWupBuffer(paramString1.toByteArray());
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label145:
      break label145;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getAnonymousChatNick error, NumberFormatException, uin : ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", troopUin : ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("TroopMessageHandler", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  protected String dv_()
  {
    return "TroopMessageHandler";
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null) {
      this.allowCmdSet = new HashSet();
    }
    this.allowCmdSet.add("OidbSvc.0x8a7_0");
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopMessageObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMessageHandler", 2, "onReceive,resp == null");
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
        QLog.d("TroopMessageHandler", 2, paramToServiceMsg.toString());
      }
      return;
    }
    if ("OidbSvc.0x8a7_0".equals(paramFromServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopmessage.handler.TroopMessageHandler
 * JD-Core Version:    0.7.0.1
 */