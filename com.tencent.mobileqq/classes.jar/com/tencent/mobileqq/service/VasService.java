package com.tencent.mobileqq.service;

import ColorNick.QC.readItemInfoReq;
import ColorNick.QC.readItemInfoRsp;
import GROUP.MessageRemindReq;
import GROUP.MessageRemindRsp;
import MQQ.GetRoamToastReq;
import MQQ.GetRoamToastRsp;
import ProfileLogic.QC.readUserInfoReq;
import ProfileLogic.QC.readUserInfoRsp;
import ProfileLogic.QC.setUserFlagReq;
import ProfileLogic.QC.setUserFlagRsp;
import ProfileLogic.QC.setUserProfileReq;
import ProfileLogic.QC.setUserProfileRsp;
import QC.BubbleRecommendReq;
import QC.BubbleRecommendRsp;
import QC.FaceReq;
import QC.FaceRsp;
import QC.FontRecommendReq;
import QC.FontRecommendRsp;
import QC.SetFontBubbleReq;
import QC.SetFontBubbleRsp;
import QC.UniGetRsp;
import QC.UniLoginCheckReq;
import QC.UniLoginCheckRsp;
import QC.UniSetRsp;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.vas.api.IJce;
import com.tencent.mobileqq.vas.api.IJce.Util;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class VasService
  extends BaseProtocolCoder
{
  private static int a;
  private static ConcurrentHashMap<String, IJce> b = new ConcurrentHashMap();
  
  private <T> T a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, T paramT)
  {
    if (paramFromServiceMsg == null) {
      return null;
    }
    paramToServiceMsg = new UniPacket(true);
    try
    {
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = paramToServiceMsg.getByClass("rsp", paramT);
      return paramToServiceMsg;
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.e("VasService", 1, "decodeWUP: ", paramToServiceMsg);
    }
    return null;
  }
  
  public static void a(IJce paramIJce, String paramString)
  {
    b.put(paramString, paramIJce);
  }
  
  public static void a(String paramString)
  {
    b.remove(paramString);
  }
  
  public String[] cmdHeaderPrefix()
  {
    return VasCmdPrefix.a;
  }
  
  public Object decode(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("decode: cmd=");
      ((StringBuilder)localObject).append(paramToServiceMsg.getServiceCmd());
      QLog.d("VasService", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new UniPacket(true);
    try
    {
      ((UniPacket)localObject).setEncodeName("utf-8");
      ((UniPacket)localObject).decode(paramFromServiceMsg.getWupBuffer());
      boolean bool;
      if (paramToServiceMsg.getServiceCmd().equals("FriendClone.CloneAuthStatus"))
      {
        int i = ((Integer)((UniPacket)localObject).getByClass("", Integer.valueOf(-1))).intValue();
        paramFromServiceMsg = new ArrayList();
        int j = paramToServiceMsg.extraData.getInt("operation", -1);
        paramFromServiceMsg.add(Integer.valueOf(i));
        paramFromServiceMsg.add(Integer.valueOf(j));
        if (j == 257)
        {
          bool = ((Boolean)((UniPacket)localObject).getByClass("bOpenAuth", new Boolean(false))).booleanValue();
          paramFromServiceMsg.add(Boolean.valueOf(bool));
          if (QLog.isColorLevel())
          {
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append("decode: ret=");
            paramToServiceMsg.append(i);
            paramToServiceMsg.append(" openAuth=");
            paramToServiceMsg.append(bool);
            paramToServiceMsg.append(" funName=");
            paramToServiceMsg.append(((UniPacket)localObject).getFuncName());
            QLog.d("VasService", 2, paramToServiceMsg.toString());
            return paramFromServiceMsg;
          }
        }
        else if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("decode: ret=");
          paramToServiceMsg.append(i);
          paramToServiceMsg.append(" funName=");
          paramToServiceMsg.append(((UniPacket)localObject).getFuncName());
          QLog.d("VasService", 2, paramToServiceMsg.toString());
          return paramFromServiceMsg;
        }
      }
      else
      {
        bool = paramToServiceMsg.getServiceCmd().equals("groupnick.readitem");
        if (bool)
        {
          paramToServiceMsg = (readItemInfoRsp)((UniPacket)localObject).getByClass("stRsp", new readItemInfoRsp());
          if (!QLog.isColorLevel()) {
            return paramToServiceMsg;
          }
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("decode: ret =  funName = ");
          paramFromServiceMsg.append(((UniPacket)localObject).getFuncName());
          paramFromServiceMsg.append(" infoRsp = ");
          paramFromServiceMsg.append(paramToServiceMsg.toString());
          QLog.d("VasService", 2, paramFromServiceMsg.toString());
          return paramToServiceMsg;
        }
        if (paramToServiceMsg.getServiceCmd().equals("profilelogic.readUserInfo")) {
          return (readUserInfoRsp)((UniPacket)localObject).getByClass("stRsp", new readUserInfoRsp());
        }
        if (paramToServiceMsg.getServiceCmd().equals("profilelogic.setUserProfile")) {
          return (setUserProfileRsp)((UniPacket)localObject).getByClass("stRsp", new setUserProfileRsp());
        }
        if (paramToServiceMsg.getServiceCmd().equals("profilelogic.setUserFlag")) {
          return (setUserFlagRsp)((UniPacket)localObject).getByClass("stRsp", new setUserFlagRsp());
        }
        if (paramToServiceMsg.getServiceCmd().equals("GroupCare.getMessageRemindInfo")) {
          return (MessageRemindRsp)((UniPacket)localObject).getByClass("stRsp", new MessageRemindRsp());
        }
        bool = paramToServiceMsg.getServiceCmd().equals("FontBubbleRecommend.getFontRecommend");
        if (bool) {
          return (FontRecommendRsp)((UniPacket)localObject).getByClass("rsp", new FontRecommendRsp());
        }
        if (paramToServiceMsg.getServiceCmd().equals("FontBubbleRecommend.getBubbleRecommend")) {
          return (BubbleRecommendRsp)((UniPacket)localObject).getByClass("rsp", new BubbleRecommendRsp());
        }
        if (paramToServiceMsg.getServiceCmd().equals("FontBubbleRecommend.setFontBubble")) {
          return (SetFontBubbleRsp)((UniPacket)localObject).getByClass("rsp", new SetFontBubbleRsp());
        }
        if (paramToServiceMsg.getServiceCmd().equals("RoamWrap.GetRoamToast")) {
          return (GetRoamToastRsp)((UniPacket)localObject).getByClass("stRsp", new GetRoamToastRsp());
        }
        if (paramToServiceMsg.getServiceCmd().equals("Face.setFace")) {
          return (FaceRsp)((UniPacket)localObject).getByClass("rsp", new FaceRsp());
        }
        if (paramToServiceMsg.getServiceCmd().equals("QCUniBusinessLogin.check")) {
          return (UniLoginCheckRsp)((UniPacket)localObject).getByClass("rsp", new UniLoginCheckRsp());
        }
        if ("QCUniBusinessLogic.uniSet".equals(paramToServiceMsg.getServiceCmd())) {
          return a(paramToServiceMsg, paramFromServiceMsg, new UniSetRsp());
        }
        if ("QCUniBusinessLogic.uniGet".equals(paramToServiceMsg.getServiceCmd())) {
          return a(paramToServiceMsg, paramFromServiceMsg, new UniGetRsp());
        }
        if (b.containsKey(IJce.Util.a(paramToServiceMsg)))
        {
          paramToServiceMsg = ((IJce)b.get(IJce.Util.a(paramToServiceMsg))).decode(paramToServiceMsg, paramFromServiceMsg, (UniPacket)localObject);
          return paramToServiceMsg;
        }
        return null;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.e("VasService", 1, "decode error: ", paramToServiceMsg);
      return null;
    }
    return paramFromServiceMsg;
    return paramToServiceMsg;
  }
  
  public boolean encodeReqMsg(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("encodeReqMsg: cmd=");
      ((StringBuilder)localObject).append(paramToServiceMsg.getServiceCmd());
      QLog.d("VasService", 2, ((StringBuilder)localObject).toString());
    }
    int i;
    if (paramToServiceMsg.getServiceCmd().equals("FriendClone.CloneAuthStatus"))
    {
      i = paramToServiceMsg.extraData.getInt("operation", -1);
      if (i == 257)
      {
        paramUniPacket.setFuncName("getCloneAuthStatus");
      }
      else
      {
        if (i != 258) {
          break label303;
        }
        paramUniPacket.setFuncName("setCloneAuthStatus");
      }
      paramUniPacket.setServantName("MQQ.FriendCloneServer.FriendCloneObj");
      i = a;
      a = i + 1;
      paramUniPacket.setRequestId(i);
      localObject = paramToServiceMsg.extraData.getString("uUin");
      boolean bool = paramToServiceMsg.extraData.getBoolean("bOpenAuth", false);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        QLog.e("VasService", 2, "encodeReqMsg: uin is empty");
        return false;
      }
      paramUniPacket.put("uUin", Long.valueOf(Long.parseLong((String)localObject)));
      paramUniPacket.put("bOpenAuth", Boolean.valueOf(bool));
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("encodeReqMsg: svName=");
        paramToServiceMsg.append(paramUniPacket.getServantName());
        paramToServiceMsg.append(" funName=");
        paramToServiceMsg.append(paramUniPacket.getFuncName());
        paramToServiceMsg.append(" uin=");
        paramToServiceMsg.append(paramUniPacket.getByClass("uUin", new Long(1L)));
        paramToServiceMsg.append(" openAuth=");
        paramToServiceMsg.append(paramUniPacket.getByClass("bOpenAuth", new Boolean(false)));
        QLog.d("VasService", 2, paramToServiceMsg.toString());
      }
      return true;
      label303:
      return false;
    }
    if (paramToServiceMsg.getServiceCmd().equals("groupnick.readitem"))
    {
      paramUniPacket.setFuncName("readItemInfo");
      paramUniPacket.put("stReq", (readItemInfoReq)paramToServiceMsg.extraData.getSerializable("req"));
      paramUniPacket.setServantName("QC.readGroupNickServer.readGroupNickObj");
      i = a;
      a = i + 1;
      paramUniPacket.setRequestId(i);
      return true;
    }
    if (paramToServiceMsg.getServiceCmd().equals("profilelogic.readUserInfo"))
    {
      paramUniPacket.setServantName("QC.ProfileLogicServer.ProfileLogicObj");
      paramUniPacket.setFuncName("ReadUserProfile");
      i = a;
      a = i + 1;
      paramUniPacket.setRequestId(i);
      paramUniPacket.put("stReq", (readUserInfoReq)paramToServiceMsg.extraData.getSerializable("req"));
      return true;
    }
    if (paramToServiceMsg.getServiceCmd().equals("profilelogic.setUserProfile"))
    {
      paramUniPacket.setServantName("QC.ProfileLogicServer.ProfileLogicObj");
      paramUniPacket.setFuncName("SetUserProfile");
      i = a;
      a = i + 1;
      paramUniPacket.setRequestId(i);
      paramUniPacket.put("stReq", (setUserProfileReq)paramToServiceMsg.extraData.get("req"));
      return true;
    }
    if (paramToServiceMsg.getServiceCmd().equals("profilelogic.setUserFlag"))
    {
      paramUniPacket.setServantName("QC.ProfileLogicServer.ProfileLogicObj");
      paramUniPacket.setFuncName("SetUserFlag");
      i = a;
      a = i + 1;
      paramUniPacket.setRequestId(i);
      paramUniPacket.put("stReq", (setUserFlagReq)paramToServiceMsg.extraData.get("req"));
      return true;
    }
    if (paramToServiceMsg.getServiceCmd().equals("GroupCare.getMessageRemindInfo"))
    {
      paramUniPacket.setServantName("GROUP.GroupCareServer.GroupCareObj");
      paramUniPacket.setFuncName("getMessageRemindInfo");
      i = a;
      a = i + 1;
      paramUniPacket.setRequestId(i);
      paramUniPacket.put("stReq", (MessageRemindReq)paramToServiceMsg.extraData.get("req"));
      return true;
    }
    if (paramToServiceMsg.getServiceCmd().equals("FontBubbleRecommend.getFontRecommend"))
    {
      paramUniPacket.setServantName("QC.FontBubbleRecommendServer.FontBubbleRecommendObj");
      paramUniPacket.setFuncName("getFontRecommend");
      i = a;
      a = i + 1;
      paramUniPacket.setRequestId(i);
      paramUniPacket.put("req", (FontRecommendReq)paramToServiceMsg.extraData.get("req"));
      return true;
    }
    if (paramToServiceMsg.getServiceCmd().equals("FontBubbleRecommend.getBubbleRecommend"))
    {
      paramUniPacket.setServantName("QC.FontBubbleRecommendServer.FontBubbleRecommendObj");
      paramUniPacket.setFuncName("getBubbleRecommend");
      i = a;
      a = i + 1;
      paramUniPacket.setRequestId(i);
      paramUniPacket.put("req", (BubbleRecommendReq)paramToServiceMsg.extraData.get("req"));
      return true;
    }
    if (paramToServiceMsg.getServiceCmd().equals("QCUniBusinessLogin.check"))
    {
      paramUniPacket.setServantName("QC.UniBusinessLoginServer.UniBusinessLoginObj");
      paramUniPacket.setFuncName("UniLoginCheck");
      i = a;
      a = i + 1;
      paramUniPacket.setRequestId(i);
      paramUniPacket.put("stReq", (UniLoginCheckReq)paramToServiceMsg.extraData.get("req"));
      return true;
    }
    if (paramToServiceMsg.getServiceCmd().equals("FontBubbleRecommend.setFontBubble"))
    {
      paramUniPacket.setServantName("QC.FontBubbleRecommendServer.FontBubbleRecommendObj");
      paramUniPacket.setFuncName("setFontBubble");
      i = a;
      a = i + 1;
      paramUniPacket.setRequestId(i);
      paramUniPacket.put("req", (SetFontBubbleReq)paramToServiceMsg.extraData.get("req"));
      return true;
    }
    if (paramToServiceMsg.getServiceCmd().equals("RoamWrap.GetRoamToast"))
    {
      paramUniPacket.setServantName("MQQ.RoamWrapServer.RoamWrapObj");
      paramUniPacket.setFuncName("GetRoamToast");
      i = a;
      a = i + 1;
      paramUniPacket.setRequestId(i);
      paramUniPacket.put("stReq", (GetRoamToastReq)paramToServiceMsg.extraData.get("req"));
      return true;
    }
    if (paramToServiceMsg.getServiceCmd().equals("Face.setFace"))
    {
      paramUniPacket.setServantName("QC.FaceServer.FaceObj");
      paramUniPacket.setFuncName("setFace");
      i = a;
      a = i + 1;
      paramUniPacket.setRequestId(i);
      paramUniPacket.put("req", (FaceReq)paramToServiceMsg.extraData.get("req"));
      return true;
    }
    if ("QCUniBusinessLogic.uniSet".equals(paramToServiceMsg.getServiceCmd()))
    {
      paramUniPacket.setServantName("QC.UniBusinessLogicServer.UniBusinessLogicObj");
      paramUniPacket.setFuncName("uniSet");
      paramUniPacket.put("stReq", paramToServiceMsg.extraData.getSerializable("req"));
      return true;
    }
    if ("QCUniBusinessLogic.uniGet".equals(paramToServiceMsg.getServiceCmd()))
    {
      paramUniPacket.setServantName("QC.UniBusinessLogicServer.UniBusinessLogicObj");
      paramUniPacket.setFuncName("uniGet");
      paramUniPacket.put("stReq", paramToServiceMsg.extraData.getSerializable("req"));
      return true;
    }
    if (b.containsKey(IJce.Util.a(paramToServiceMsg)))
    {
      localObject = (IJce)b.get(IJce.Util.a(paramToServiceMsg));
      i = a;
      a = i + 1;
      ((IJce)localObject).encode(paramToServiceMsg, paramUniPacket, i);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.VasService
 * JD-Core Version:    0.7.0.1
 */