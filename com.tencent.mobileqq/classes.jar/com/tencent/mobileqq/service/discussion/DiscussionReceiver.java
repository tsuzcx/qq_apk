package com.tencent.mobileqq.service.discussion;

import QQService.DiscussRespHeader;
import QQService.RespAddDiscussMember;
import QQService.RespChangeDiscussName;
import QQService.RespCreateDiscuss;
import QQService.RespGetDiscussInfo;
import QQService.RespGetDiscussInteRemark;
import QQService.RespJoinDiscuss;
import QQService.RespQuitDiscuss;
import QQService.RespSetDiscussAttr;
import QQService.RespSetDiscussFlag;
import com.qq.jce.wup.UniPacket;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class DiscussionReceiver
{
  private Object a(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    DiscussionReceiver.RespPackage localRespPackage = new DiscussionReceiver.RespPackage(this);
    localRespPackage.jdField_a_of_type_Boolean = paramBoolean;
    localRespPackage.jdField_a_of_type_JavaLangObject = paramObject1;
    localRespPackage.b = paramObject2;
    return localRespPackage;
  }
  
  private <T> T a(byte[] paramArrayOfByte, String paramString, T paramT)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
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
    paramToServiceMsg = (RespSetDiscussFlag)a(paramFromServiceMsg.getWupBuffer(), "RespSetDiscussFlag", new RespSetDiscussFlag());
    DiscussRespHeader localDiscussRespHeader = (DiscussRespHeader)a(paramFromServiceMsg.getWupBuffer(), "DiscussRespHeader", new DiscussRespHeader());
    if ((paramToServiceMsg != null) && (localDiscussRespHeader != null))
    {
      boolean bool;
      if ((paramFromServiceMsg.getResultCode() == 1000) && (localDiscussRespHeader.Result == 0)) {
        bool = true;
      } else {
        bool = false;
      }
      return a(bool, localDiscussRespHeader, paramToServiceMsg);
    }
    QLog.w("DiscussionReceiver", 2, "<<---discussFlagResp or respheader is null");
    return null;
  }
  
  private Object c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (RespSetDiscussAttr)a(paramFromServiceMsg.getWupBuffer(), "RespSetDiscussAttr", new RespSetDiscussAttr());
    DiscussRespHeader localDiscussRespHeader = (DiscussRespHeader)a(paramFromServiceMsg.getWupBuffer(), "DiscussRespHeader", new DiscussRespHeader());
    if ((paramToServiceMsg != null) && (localDiscussRespHeader != null))
    {
      boolean bool;
      if ((paramFromServiceMsg.getResultCode() == 1000) && (localDiscussRespHeader.Result == 0)) {
        bool = true;
      } else {
        bool = false;
      }
      return a(bool, localDiscussRespHeader, paramToServiceMsg);
    }
    QLog.w("DiscussionReceiver", 2, "<<---discussAttr or respheader is null!");
    return null;
  }
  
  private Object d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (RespQuitDiscuss)a(paramFromServiceMsg.getWupBuffer(), "RespQuitDiscuss", new RespQuitDiscuss());
    DiscussRespHeader localDiscussRespHeader = (DiscussRespHeader)a(paramFromServiceMsg.getWupBuffer(), "DiscussRespHeader", new DiscussRespHeader());
    if ((paramToServiceMsg != null) && (localDiscussRespHeader != null))
    {
      boolean bool;
      if ((paramFromServiceMsg.getResultCode() == 1000) && (localDiscussRespHeader.Result == 0)) {
        bool = true;
      } else {
        bool = false;
      }
      return a(bool, localDiscussRespHeader, paramToServiceMsg);
    }
    QLog.w("DiscussionReceiver", 2, "<<---discussQuitResp or respheader is null");
    return null;
  }
  
  private Object e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (RespGetDiscussInfo)a(paramFromServiceMsg.getWupBuffer(), "RespGetDiscussInfo", new RespGetDiscussInfo());
    DiscussRespHeader localDiscussRespHeader = (DiscussRespHeader)a(paramFromServiceMsg.getWupBuffer(), "DiscussRespHeader", new DiscussRespHeader());
    if ((paramToServiceMsg != null) && (localDiscussRespHeader != null))
    {
      boolean bool;
      if ((paramFromServiceMsg.getResultCode() == 1000) && (localDiscussRespHeader.Result == 0)) {
        bool = true;
      } else {
        bool = false;
      }
      return a(bool, localDiscussRespHeader, paramToServiceMsg);
    }
    QLog.w("DiscussionReceiver", 2, "<<---discussInfo or respHeader is null!");
    return null;
  }
  
  private Object f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (RespGetDiscussInteRemark)a(paramFromServiceMsg.getWupBuffer(), "RespGetDiscussInteRemark", new RespGetDiscussInteRemark());
    DiscussRespHeader localDiscussRespHeader = (DiscussRespHeader)a(paramFromServiceMsg.getWupBuffer(), "DiscussRespHeader", new DiscussRespHeader());
    if ((paramToServiceMsg != null) && (localDiscussRespHeader != null))
    {
      boolean bool;
      if ((paramFromServiceMsg.getResultCode() == 1000) && (localDiscussRespHeader.Result == 0)) {
        bool = true;
      } else {
        bool = false;
      }
      return a(bool, localDiscussRespHeader, paramToServiceMsg);
    }
    QLog.w("DiscussionReceiver", 2, "<<---discussInfo or respHeader is null!");
    return null;
  }
  
  private Object g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (RespCreateDiscuss)a(paramFromServiceMsg.getWupBuffer(), "RespCreateDiscuss", new RespCreateDiscuss());
    DiscussRespHeader localDiscussRespHeader = (DiscussRespHeader)a(paramFromServiceMsg.getWupBuffer(), "DiscussRespHeader", new DiscussRespHeader());
    if ((paramToServiceMsg != null) && (localDiscussRespHeader != null))
    {
      boolean bool;
      if ((paramFromServiceMsg.getResultCode() == 1000) && (localDiscussRespHeader.Result == 0)) {
        bool = true;
      } else {
        bool = false;
      }
      return a(bool, localDiscussRespHeader, paramToServiceMsg);
    }
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionReceiver", 2, "<<---createDiscussResp or respheader is null!");
    }
    return null;
  }
  
  private Object h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (RespChangeDiscussName)a(paramFromServiceMsg.getWupBuffer(), "RespChangeDiscussName", new RespChangeDiscussName());
    DiscussRespHeader localDiscussRespHeader = (DiscussRespHeader)a(paramFromServiceMsg.getWupBuffer(), "DiscussRespHeader", new DiscussRespHeader());
    if ((paramToServiceMsg != null) && (localDiscussRespHeader != null))
    {
      boolean bool;
      if ((paramFromServiceMsg.getResultCode() == 1000) && (localDiscussRespHeader.Result == 0)) {
        bool = true;
      } else {
        bool = false;
      }
      return a(bool, localDiscussRespHeader, paramToServiceMsg);
    }
    return null;
  }
  
  private Object i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (RespAddDiscussMember)a(paramFromServiceMsg.getWupBuffer(), "RespAddDiscussMember", new RespAddDiscussMember());
    DiscussRespHeader localDiscussRespHeader = (DiscussRespHeader)a(paramFromServiceMsg.getWupBuffer(), "DiscussRespHeader", new DiscussRespHeader());
    if ((paramToServiceMsg != null) && (localDiscussRespHeader != null))
    {
      boolean bool;
      if ((paramFromServiceMsg.getResultCode() == 1000) && (localDiscussRespHeader.Result == 0)) {
        bool = true;
      } else {
        bool = false;
      }
      return a(bool, localDiscussRespHeader, paramToServiceMsg);
    }
    QLog.w("DiscussionReceiver", 2, "<<---addDisMember or respheader is null!");
    return null;
  }
  
  private Object j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (RespJoinDiscuss)a(paramFromServiceMsg.getWupBuffer(), "RespJoinDiscuss", new RespJoinDiscuss());
    DiscussRespHeader localDiscussRespHeader = (DiscussRespHeader)a(paramFromServiceMsg.getWupBuffer(), "DiscussRespHeader", new DiscussRespHeader());
    if ((paramToServiceMsg != null) && (localDiscussRespHeader != null))
    {
      boolean bool;
      if ((paramFromServiceMsg.getResultCode() == 1000) && (localDiscussRespHeader.Result == 0)) {
        bool = true;
      } else {
        bool = false;
      }
      return a(bool, localDiscussRespHeader, paramToServiceMsg);
    }
    QLog.w("DiscussionReceiver", 2, "<<---decodeRespJoinDiscuss or respheader is null!");
    return null;
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("~~~decode cmd: ");
      localStringBuilder.append(str);
      QLog.d("DiscussionReceiver", 2, localStringBuilder.toString());
    }
    if ("QQServiceDiscussSvc.ReqAddDiscussMember".equalsIgnoreCase(str)) {
      return i(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("QQServiceDiscussSvc.ReqChangeDiscussName".equalsIgnoreCase(str)) {
      return h(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("QQServiceDiscussSvc.ReqCreateDiscuss".equalsIgnoreCase(str)) {
      return g(paramToServiceMsg, paramFromServiceMsg);
    }
    if (!"OidbSvc.0x58a".equalsIgnoreCase(str))
    {
      if ("QQServiceDiscussSvc.ReqGetDiscussInfo".equalsIgnoreCase(str)) {
        return e(paramToServiceMsg, paramFromServiceMsg);
      }
      if ("QQServiceDiscussSvc.ReqQuitDiscuss".equalsIgnoreCase(str)) {
        return d(paramToServiceMsg, paramFromServiceMsg);
      }
      if ("QQServiceDiscussSvc.ReqSetDiscussAttr".equalsIgnoreCase(str)) {
        return c(paramToServiceMsg, paramFromServiceMsg);
      }
      if ("QQServiceDiscussSvc.ReqSetDiscussFlag".equalsIgnoreCase(str)) {
        return b(paramToServiceMsg, paramFromServiceMsg);
      }
      if ("QQServiceDiscussSvc.ReqGetDiscussInteRemark".equalsIgnoreCase(str)) {
        return f(paramToServiceMsg, paramFromServiceMsg);
      }
      if ("QQServiceDiscussSvc.ReqJoinDiscuss".equalsIgnoreCase(str)) {
        return j(paramToServiceMsg, paramFromServiceMsg);
      }
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("~~~unknow cmd: ");
      paramToServiceMsg.append(str);
      QLog.w("DiscussionReceiver", 2, paramToServiceMsg.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.discussion.DiscussionReceiver
 * JD-Core Version:    0.7.0.1
 */