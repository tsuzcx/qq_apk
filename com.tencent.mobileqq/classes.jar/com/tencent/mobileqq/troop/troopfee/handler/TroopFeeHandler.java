package com.tencent.mobileqq.troop.troopfee.handler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.observer.TroopFeeObserver;
import com.tencent.mobileqq.troop.troopfee.api.ITroopFeeHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0x406.cmd0x406.GroupFeeMemberListQuery;
import tencent.im.oidb.cmd0x406.cmd0x406.GroupFeeMemberListResult;
import tencent.im.oidb.cmd0x406.cmd0x406.ReqBody;
import tencent.im.oidb.cmd0x406.cmd0x406.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopFeeHandler
  extends TroopBaseHandler
  implements ITroopFeeHandler
{
  public TroopFeeHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopFeeHandler.troop.troop_fee", 2, "handleGroupFeeMemberListQuery : data==null");
      }
      notifyUI(TroopFeeObserver.b, false, null);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleGroupFeeMemberListQuery : resp.isSuccess=");
      paramToServiceMsg.append(paramFromServiceMsg.isSuccess());
      QLog.d("TroopFeeHandler.troop.troop_fee", 2, paramToServiceMsg.toString());
    }
    if (!paramFromServiceMsg.isSuccess())
    {
      notifyUI(TroopFeeObserver.b, false, null);
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramToServiceMsg = paramFromServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("handleTroopFeeMemberListQuery|oidb_sso parseFrom byte ");
        paramObject.append(paramFromServiceMsg.toString());
        QLog.d("Q.troopdisband.", 2, paramObject.toString());
      }
      paramFromServiceMsg.printStackTrace();
    }
    int i = -1;
    if (paramToServiceMsg != null)
    {
      int j = paramToServiceMsg.uint32_result.get();
      i = j;
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleTroopFeeMemberListQuery|oidb_sso.OIDBSSOPkg.result ");
        paramFromServiceMsg.append(j);
        QLog.d("Q.troopdisband.", 2, paramFromServiceMsg.toString());
        i = j;
      }
    }
    if (i == 0) {
      paramFromServiceMsg = new cmd0x406.RspBody();
    }
    label394:
    try
    {
      paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      i = paramFromServiceMsg.uint32_ret.get();
      if (i == 0)
      {
        paramToServiceMsg = ((cmd0x406.GroupFeeMemberListResult)paramFromServiceMsg.msg_member_list.get()).msg_member_list.get();
        notifyUI(TroopFeeObserver.b, true, paramToServiceMsg);
      }
      else
      {
        notifyUI(TroopFeeObserver.b, false, null);
      }
      if (!QLog.isColorLevel()) {
        break label394;
      }
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("ret :");
      paramToServiceMsg.append(i);
      paramToServiceMsg.append(",msg:");
      paramToServiceMsg.append(paramFromServiceMsg.string_msg.get().toString());
      QLog.d("TroopFeeHandler.troop.troop_fee", 2, paramToServiceMsg.toString());
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      label361:
      break label361;
    }
    notifyUI(TroopFeeObserver.b, false, null);
    if (QLog.isColorLevel())
    {
      QLog.d("TroopFeeHandler.troop.troop_fee", 2, "handleGroupFeeMemberListQuery : InvalidProtocolBufferMicroException");
      return;
      notifyUI(TroopFeeObserver.b, false, null);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = createToServiceMsg("OidbSvc.0x406_3");
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1030);
    localOIDBSSOPkg.uint32_service_type.set(3);
    cmd0x406.ReqBody localReqBody = new cmd0x406.ReqBody();
    cmd0x406.GroupFeeMemberListQuery localGroupFeeMemberListQuery = new cmd0x406.GroupFeeMemberListQuery();
    localGroupFeeMemberListQuery.string_project_id.set(paramString2);
    localGroupFeeMemberListQuery.uint32_member_type.set(paramInt);
    localGroupFeeMemberListQuery.uint32_page_index.set(0);
    localGroupFeeMemberListQuery.uint32_page_size.set(-1);
    try
    {
      localReqBody.uint64_group_id.set(Long.valueOf(paramString1).longValue());
      localReqBody.msg_member_list.set(localGroupFeeMemberListQuery);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      sendPbReq((ToServiceMsg)localObject);
      if (!QLog.isColorLevel()) {
        break label261;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTroopFeeMembers, troopUin: ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" troopFeeId: ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("TroopFeeHandler.troop.troop_fee", 2, ((StringBuilder)localObject).toString());
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label205:
      break label205;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("NumberFormatException!getTroopFeeMembers, troopUin: ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" troopFeeId: ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("TroopFeeHandler.troop.troop_fee", 2, ((StringBuilder)localObject).toString());
    }
    label261:
  }
  
  protected String dv_()
  {
    return "TroopFeeHandler";
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x406_3");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopFeeObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopFeeHandler", 2, "onReceive,resp == null");
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
        QLog.d("TroopFeeHandler", 2, paramToServiceMsg.toString());
      }
      return;
    }
    if ("OidbSvc.0x406_3".equals(paramFromServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopfee.handler.TroopFeeHandler
 * JD-Core Version:    0.7.0.1
 */