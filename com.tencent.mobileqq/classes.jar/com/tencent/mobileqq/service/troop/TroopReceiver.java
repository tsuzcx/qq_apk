package com.tencent.mobileqq.service.troop;

import KQQ.RespBatchProcess;
import com.qq.jce.wup.UniPacket;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetMultiTroopInfoResp;
import friendlist.GetTroopAppointRemarkResp;
import friendlist.GetTroopListRespV2;
import friendlist.GetTroopMemberListResp;
import friendlist.GetTroopRemarkResp;
import friendlist.ModifyGroupCardResp;
import friendlist.ModifyGroupInfoResp;

public class TroopReceiver
{
  private final <T> T a(byte[] paramArrayOfByte, String paramString, T paramT)
  {
    UniPacket localUniPacket = new UniPacket(true);
    try
    {
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      return localUniPacket.getByClass(paramString, paramT);
    }
    catch (RuntimeException|Exception paramArrayOfByte) {}
    return null;
  }
  
  private Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (GetMultiTroopInfoResp)a(paramFromServiceMsg.getWupBuffer(), "GMTIRESP", new GetMultiTroopInfoResp());
  }
  
  private Object c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (GetTroopListRespV2)a(paramFromServiceMsg.getWupBuffer(), "GetTroopListRespV2", new GetTroopListRespV2());
    if ((paramToServiceMsg != null) && (paramToServiceMsg.result != 1) && ((paramToServiceMsg.vecTroopList != null) || (paramToServiceMsg.vecTroopListDel != null) || (paramToServiceMsg.vecTroopRank != null) || (paramToServiceMsg.vecFavGroup != null))) {
      return paramToServiceMsg;
    }
    return null;
  }
  
  private Object d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (GetTroopRemarkResp)a(paramFromServiceMsg.getWupBuffer(), "GTRRESP", new GetTroopRemarkResp());
    if (paramToServiceMsg == null) {
      return null;
    }
    if (paramToServiceMsg.result == 1) {
      return null;
    }
    return paramToServiceMsg;
  }
  
  private Object e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    try
    {
      paramToServiceMsg = (GetTroopMemberListResp)a(paramFromServiceMsg.getWupBuffer(), "GTMLRESP", new GetTroopMemberListResp());
      paramFromServiceMsg = paramToServiceMsg;
    }
    catch (OutOfMemoryError paramToServiceMsg)
    {
      StringBuilder localStringBuilder;
      label54:
      label72:
      label75:
      label77:
      label95:
      break label75;
    }
    try
    {
      if (!QLog.isColorLevel()) {
        break label95;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("FriendListService.decodeTroopGetMemberList");
      if (paramToServiceMsg != null) {
        break label105;
      }
      paramFromServiceMsg = "resp == null";
    }
    catch (OutOfMemoryError paramFromServiceMsg)
    {
      break label72;
      paramFromServiceMsg = "resp != null";
      break label54;
    }
    localStringBuilder.append(paramFromServiceMsg);
    QLog.d("TroopReceiver", 2, localStringBuilder.toString());
    return paramToServiceMsg;
    break label77;
    paramToServiceMsg = null;
    paramFromServiceMsg = paramToServiceMsg;
    if (QLog.isColorLevel())
    {
      QLog.e("TroopReceiver", 2, "decodeTroopGetMemberList OOM");
      paramFromServiceMsg = paramToServiceMsg;
    }
    return paramFromServiceMsg;
  }
  
  private Object f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (ModifyGroupCardResp)a(paramFromServiceMsg.getWupBuffer(), "MGCRESP", new ModifyGroupCardResp());
  }
  
  private Object g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (ModifyGroupInfoResp)a(paramFromServiceMsg.getWupBuffer(), "MGIRESP", new ModifyGroupInfoResp());
  }
  
  private Object h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (GetTroopAppointRemarkResp)a(paramFromServiceMsg.getWupBuffer(), "GTARESP", new GetTroopAppointRemarkResp());
  }
  
  private Object i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (RespBatchProcess)a(paramFromServiceMsg.getWupBuffer(), "RespBatchProcess", new RespBatchProcess());
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("~~~decode cmd: ");
      localStringBuilder.append(str);
      QLog.d("TroopReceiver", 2, localStringBuilder.toString());
    }
    if ("friendlist.GetMultiTroopInfoReq".equalsIgnoreCase(str)) {
      return b(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.GetTroopListReqV2".equalsIgnoreCase(str)) {
      return c(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.getTroopRemark".equalsIgnoreCase(str)) {
      return d(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.getTroopMemberList".equalsIgnoreCase(str)) {
      return e(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.ModifyGroupCardReq".equalsIgnoreCase(str)) {
      return f(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.ModifyGroupInfoReq".equalsIgnoreCase(str)) {
      return g(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.GetTroopAppointRemarkReq".equalsIgnoreCase(str)) {
      return h(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("ProfileService.ReqBatchProcess".equalsIgnoreCase(str)) {
      return i(paramToServiceMsg, paramFromServiceMsg);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.troop.TroopReceiver
 * JD-Core Version:    0.7.0.1
 */