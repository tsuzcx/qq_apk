package com.tencent.mobileqq.service.message;

import AccostSvc.RespClientMsg;
import AccostSvc.RespDeleteBlackList;
import AccostSvc.RespGetBlackList;
import AccostSvc.RespHeader;
import AccostSvc.RespInsertBlackList;
import AccostSvc.SvrMsg;
import MessageSvcPack.RequestPushStatus;
import MessageSvcPack.SvcResponseDelMsgV2;
import MessageSvcPack.SvcResponseDelRoamMsg;
import MessageSvcPack.SvcResponseGetMsgV2;
import MessageSvcPack.SvcResponsePullGroupMsgSeq;
import MessageSvcPack.SvcResponseSetRoamMsg;
import OnlinePushPack.SvcReqPushMsg;
import PushAdMsg.AdMsgInfo;
import PushNotifyPack.RequestPushNotify;
import PushNotifyPack.SvcRequestPushReadedNotify;
import QQService.RespGetSign;
import QQService.RespOffFilePack;
import QQService.RespTmpChatPicDownload;
import QQService.SCPushStreamMsg;
import QQService.SCRespUploadStreamMsg;
import QQService.StreamData;
import QQService.StreamInfo;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.tencent.imcore.message.InitMsgModule;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class MessageFactoryReceiver
{
  private static MessageFactoryReceiver.Callback a;
  
  static {}
  
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
  
  public static void a(MessageFactoryReceiver.Callback paramCallback)
  {
    a = paramCallback;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, int paramInt, String paramString, long paramLong) {}
  
  private void a(ToServiceMsg paramToServiceMsg, long paramLong)
  {
    a(paramToServiceMsg, 1001, "", paramLong);
  }
  
  private Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("push", 2, "decodeVideoChatStatus");
    }
    return null;
  }
  
  private Object c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    RespGetSign localRespGetSign = (RespGetSign)a(paramFromServiceMsg.getWupBuffer(), "RespGetSign", new RespGetSign());
    if ((localRespGetSign != null) && (localRespGetSign.iReplyCode == 0)) {
      return new MessageFactoryReceiver.SigStruct(this, localRespGetSign.vKey, localRespGetSign.vSign);
    }
    long l;
    if (localRespGetSign == null) {
      l = 2139062143L;
    } else {
      l = localRespGetSign.iReplyCode;
    }
    a(paramToServiceMsg, l);
    paramFromServiceMsg.extraData.putLong("ServerReplyCode", l);
    return null;
  }
  
  private Object d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (SCRespUploadStreamMsg)a(paramFromServiceMsg.getWupBuffer(), "SCRespUploadStreamMsg", new SCRespUploadStreamMsg());
    if (paramToServiceMsg == null) {
      return null;
    }
    paramFromServiceMsg = paramToServiceMsg.stStreamInfo;
    return new MessageFactoryReceiver.UploadStreamStruct(a.a(paramFromServiceMsg.iMsgId), paramToServiceMsg.shResetSeq, paramFromServiceMsg.shFlowLayer, paramFromServiceMsg, paramToServiceMsg.result);
  }
  
  private Object e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (SCPushStreamMsg)a(paramFromServiceMsg.getWupBuffer(), "SCPushStreamMsg", new SCPushStreamMsg());
    if (paramToServiceMsg == null) {
      return null;
    }
    Object localObject = paramToServiceMsg.stStreamInfo;
    StreamData localStreamData = paramToServiceMsg.stStreamData;
    long l = paramToServiceMsg.lKey;
    paramFromServiceMsg = new Object[6];
    paramFromServiceMsg[0] = Long.valueOf(l);
    paramFromServiceMsg[1] = localObject;
    paramFromServiceMsg[2] = localStreamData;
    paramFromServiceMsg[3] = Long.valueOf(paramToServiceMsg.bubbleID);
    paramFromServiceMsg[4] = Long.valueOf(paramToServiceMsg.subBubbleId);
    paramFromServiceMsg[5] = Long.valueOf(paramToServiceMsg.diyAddonId);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("decodeServerPushStream: iSeq:");
      ((StringBuilder)localObject).append(paramToServiceMsg.iSeq);
      ((StringBuilder)localObject).append(", lKey: ");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append(", vipBubbleID:");
      ((StringBuilder)localObject).append(paramFromServiceMsg[3]);
      ((StringBuilder)localObject).append(", subBubbleId:");
      ((StringBuilder)localObject).append(paramFromServiceMsg[4]);
      ((StringBuilder)localObject).append(", diyAddonId:");
      ((StringBuilder)localObject).append(paramFromServiceMsg[5]);
      QLog.d("MessageHandler", 2, ((StringBuilder)localObject).toString());
    }
    return paramFromServiceMsg;
  }
  
  private Object f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramFromServiceMsg.getWupBuffer();
    paramFromServiceMsg = new byte[paramToServiceMsg.length - 4];
    System.arraycopy(paramToServiceMsg, 4, paramFromServiceMsg, 0, paramToServiceMsg.length - 4);
    return (RequestPushNotify)a(paramFromServiceMsg, "req_PushNotify", new RequestPushNotify());
  }
  
  private Object g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvrMsg)a(paramFromServiceMsg.getWupBuffer(), "SvrMsg", new SvrMsg());
  }
  
  private Object h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (RespGetBlackList)a(paramFromServiceMsg.getWupBuffer(), "RespGetBlackList", new RespGetBlackList());
  }
  
  private Object i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    RespInsertBlackList localRespInsertBlackList = (RespInsertBlackList)a(paramFromServiceMsg.getWupBuffer(), "RespInsertBlackList", new RespInsertBlackList());
    paramFromServiceMsg.extraData.putString("insertUin", paramToServiceMsg.extraData.getString("insertUin"));
    if (localRespInsertBlackList.stHeader.eReplyCode != 0) {
      return null;
    }
    return localRespInsertBlackList;
  }
  
  private Object j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    RespDeleteBlackList localRespDeleteBlackList = (RespDeleteBlackList)a(paramFromServiceMsg.getWupBuffer(), "RespDeleteBlackList", new RespDeleteBlackList());
    paramFromServiceMsg.extraData.putString("deleteUin", paramToServiceMsg.extraData.getString("deleteUin"));
    if (localRespDeleteBlackList.stHeader.eReplyCode != 0) {
      return null;
    }
    return localRespDeleteBlackList;
  }
  
  private Object k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (RespClientMsg)a(paramFromServiceMsg.getWupBuffer(), "RespClientMsg", new RespClientMsg());
  }
  
  private Object l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcReqPushMsg)a(paramFromServiceMsg.getWupBuffer(), "req", new SvcReqPushMsg());
  }
  
  private Object m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcRequestPushReadedNotify)a(paramFromServiceMsg.getWupBuffer(), "req", new SvcRequestPushReadedNotify());
  }
  
  private Object n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = (RespTmpChatPicDownload)a(paramFromServiceMsg.getWupBuffer(), "RespTmpChatPicDownload", new RespTmpChatPicDownload());
    paramToServiceMsg = paramFromServiceMsg;
    if (paramFromServiceMsg == null) {
      paramToServiceMsg = null;
    }
    return paramToServiceMsg;
  }
  
  private Object o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (SvcResponseGetMsgV2)a(paramFromServiceMsg.getWupBuffer(), "resp_GetMsgV2", new SvcResponseGetMsgV2());
    if (paramToServiceMsg != null)
    {
      a.a(paramFromServiceMsg, paramToServiceMsg);
      return paramToServiceMsg;
    }
    return null;
  }
  
  private Object p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (SvcResponseDelMsgV2)a(paramFromServiceMsg.getWupBuffer(), "resp_DelMsgV2", new SvcResponseDelMsgV2());
    if (paramToServiceMsg != null) {
      return paramToServiceMsg;
    }
    return null;
  }
  
  private Object q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject1 = (RespOffFilePack)a(paramFromServiceMsg.getWupBuffer(), "RespOffFilePack", new RespOffFilePack());
    paramToServiceMsg.extraData.getLong("msgTime");
    byte b1 = paramToServiceMsg.extraData.getByte("type");
    paramToServiceMsg.extraData.getString("friendUin");
    long l1;
    if ((localObject1 != null) && (((RespOffFilePack)localObject1).iReplyCode == 0))
    {
      byte b2 = localObject1.vBody[0];
      l1 = PkgTools.getLongData(((RespOffFilePack)localObject1).vBody, 1);
      int i = PkgTools.getShortData(((RespOffFilePack)localObject1).vBody, 5);
      paramFromServiceMsg = new byte[i];
      PkgTools.copyData(paramFromServiceMsg, 0, ((RespOffFilePack)localObject1).vBody, 7, i);
      paramFromServiceMsg = PkgTools.getUTFString(paramFromServiceMsg, 0, i);
      i = 7 + i;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("<<<<decodeGetOffLineFileResp cSubCmd:");
        ((StringBuilder)localObject2).append(b2);
        QLog.d("MessageHandler", 2, ((StringBuilder)localObject2).toString());
      }
      if (b2 != 1)
      {
        if (b2 != 2)
        {
          if (b2 != 3)
          {
            if (b2 != 6) {
              return null;
            }
            j = PkgTools.getShortData(((RespOffFilePack)localObject1).vBody, i);
            paramToServiceMsg = new byte[j];
            PkgTools.copyData(paramToServiceMsg, 0, ((RespOffFilePack)localObject1).vBody, i + 2, j);
            return new MessageFactoryReceiver.OffLineFileInfo(this, l1, paramFromServiceMsg, b2, b1, paramToServiceMsg);
          }
          j = localObject1.vBody[i];
          i += 1;
          PkgTools.getShortData(((RespOffFilePack)localObject1).vBody, i);
          i += 2;
          PkgTools.getShortData(((RespOffFilePack)localObject1).vBody, i);
          i += 2;
          PkgTools.getShortData(((RespOffFilePack)localObject1).vBody, i);
          i += 2;
          PkgTools.getShortData(((RespOffFilePack)localObject1).vBody, i);
          i += 2;
          j = localObject1.vBody[i];
          i += 1;
          l2 = PkgTools.getLongData(((RespOffFilePack)localObject1).vBody, i);
          j = i + 4;
          i = PkgTools.getShortData(((RespOffFilePack)localObject1).vBody, j);
          j += 2;
          PkgTools.copyData(new byte[i], 0, ((RespOffFilePack)localObject1).vBody, j, i);
          j += i;
          i = PkgTools.getShortData(((RespOffFilePack)localObject1).vBody, j);
          j += 2;
          localObject2 = new byte[i];
          PkgTools.copyData((byte[])localObject2, 0, ((RespOffFilePack)localObject1).vBody, j, i);
          j += i;
          i = localObject1.vBody[j];
          j += 1;
          PkgTools.copyData(new byte[i], 0, ((RespOffFilePack)localObject1).vBody, j, i);
          j += i;
          i = localObject1.vBody[j];
          j += 1;
          PkgTools.copyData(new byte[i], 0, ((RespOffFilePack)localObject1).vBody, j, i);
          j += i;
          i = PkgTools.getShortData(((RespOffFilePack)localObject1).vBody, j);
          j += 2;
          Object localObject3 = new byte[i];
          PkgTools.copyData((byte[])localObject3, 0, ((RespOffFilePack)localObject1).vBody, j, i);
          localObject3 = PkgTools.getUTFString((byte[])localObject3, 0, i);
          i = j + i;
          j = localObject1.vBody[i];
          i += 1;
          l3 = PkgTools.getLongData(((RespOffFilePack)localObject1).vBody, i);
          i += 4;
          l4 = PkgTools.getLongData(((RespOffFilePack)localObject1).vBody, i);
          i += 4;
          PkgTools.getShortData(((RespOffFilePack)localObject1).vBody, i);
          i += 2;
          PkgTools.getLongData(((RespOffFilePack)localObject1).vBody, i);
          l5 = PkgTools.getLongData(((RespOffFilePack)localObject1).vBody, i + 4);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("<<<<decodeGetOffLineFileResp dwUploadTime = ");
            ((StringBuilder)localObject1).append(l5);
            QLog.i("MessageHandler", 2, ((StringBuilder)localObject1).toString());
          }
          return new MessageFactoryReceiver.OffLineFileInfo(this, l1, paramFromServiceMsg, b2, b1, l2, HexUtil.bytes2HexStr((byte[])localObject2), l4, paramToServiceMsg.extraData.getLong("msgTime"), paramToServiceMsg.extraData.getShort("msgSeq"), l3, (String)localObject3, paramToServiceMsg.extraData.getLong("delUin"));
        }
        return new MessageFactoryReceiver.OffLineFileInfo(this, l1, paramFromServiceMsg, b2, b1);
      }
      long l2 = PkgTools.getLongLongData(((RespOffFilePack)localObject1).vBody, i);
      i += 8;
      long l3 = PkgTools.getLongLongData(((RespOffFilePack)localObject1).vBody, i);
      i += 8;
      long l4 = PkgTools.getLongData(((RespOffFilePack)localObject1).vBody, i);
      i += 4;
      long l5 = PkgTools.getLongData(((RespOffFilePack)localObject1).vBody, i);
      i += 4;
      short s = PkgTools.getShortData(((RespOffFilePack)localObject1).vBody, i);
      int j = i + 2;
      i = PkgTools.getShortData(((RespOffFilePack)localObject1).vBody, j);
      j += 2;
      paramToServiceMsg = new byte[i];
      PkgTools.copyData(paramToServiceMsg, 0, ((RespOffFilePack)localObject1).vBody, j, paramToServiceMsg.length);
      j += paramToServiceMsg.length;
      i = PkgTools.getShortData(((RespOffFilePack)localObject1).vBody, j);
      j += 2;
      Object localObject2 = new byte[i];
      PkgTools.copyData((byte[])localObject2, 0, ((RespOffFilePack)localObject1).vBody, j, localObject2.length);
      i = j + localObject2.length;
      byte b3 = localObject1.vBody[i];
      long l6 = PkgTools.getLongData(((RespOffFilePack)localObject1).vBody, i + 1);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(l1);
        ((StringBuilder)localObject1).append("|");
        ((StringBuilder)localObject1).append(l5);
        ((StringBuilder)localObject1).append("|");
        ((StringBuilder)localObject1).append(s);
        ((StringBuilder)localObject1).append("|");
        ((StringBuilder)localObject1).append(paramToServiceMsg);
        ((StringBuilder)localObject1).append("|");
        ((StringBuilder)localObject1).append(localObject2);
        ((StringBuilder)localObject1).append("|");
        ((StringBuilder)localObject1).append(b3);
        QLog.d("wk", 2, ((StringBuilder)localObject1).toString());
      }
      return new MessageFactoryReceiver.OffLineFileInfo(this, l1, paramFromServiceMsg, b2, b1, l2, l3, l4, l5, s, paramToServiceMsg, (byte[])localObject2, b3, l6);
    }
    paramToServiceMsg = paramFromServiceMsg.extraData;
    if (localObject1 == null) {
      l1 = 2139062143L;
    } else {
      l1 = ((RespOffFilePack)localObject1).iReplyCode;
    }
    paramToServiceMsg.putLong("ServerReplyCode", l1);
    return null;
  }
  
  private Object r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcResponseSetRoamMsg)a(paramFromServiceMsg.getWupBuffer(), "resp_SetRoamMsg", new SvcResponseSetRoamMsg());
  }
  
  private Object s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcResponseDelRoamMsg)a(paramFromServiceMsg.getWupBuffer(), "resp_DelRoamMsg", new SvcResponseDelRoamMsg());
  }
  
  private Object t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (AdMsgInfo)a(paramFromServiceMsg.getWupBuffer(), "PushADMsg", new AdMsgInfo());
  }
  
  private Object u(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (SvcResponsePullGroupMsgSeq)a(paramFromServiceMsg.getWupBuffer(), "resp_PullGroupMsgSeq", new SvcResponsePullGroupMsgSeq());
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("decodePullGroupMsgNumResp res");
      paramFromServiceMsg.append(paramToServiceMsg);
      QLog.d("MessageHandler", 2, paramFromServiceMsg.toString());
    }
    return paramToServiceMsg;
  }
  
  private Object v(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (RequestPushStatus)a(paramFromServiceMsg.getWupBuffer(), "req_PushStatus", new RequestPushStatus());
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("decodeRespMsg cmd: ");
      localStringBuilder.append(str);
      QLog.d("MessageHandler", 2, localStringBuilder.toString());
    }
    if ("MessageSvc.PushNotify".equalsIgnoreCase(str)) {
      return f(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("MessageSvc.GetMsgV4".equalsIgnoreCase(str)) {
      return o(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("MessageSvc.DelMsgV2".equalsIgnoreCase(str)) {
      return p(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("TransService.ReqOffFilePack".equalsIgnoreCase(str)) {
      return q(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("TransService.ReqTmpChatPicDownload".equalsIgnoreCase(str)) {
      return n(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("MessageSvc.SetRoamMsgAllUser".equalsIgnoreCase(str)) {
      return r(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("MessageSvc.DelRoamMsg".equalsIgnoreCase(str)) {
      return s(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("ADMsgSvc.PushMsg".equalsIgnoreCase(str)) {
      return t(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("OnlinePush.ReqPush".equalsIgnoreCase(str)) {
      return l(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("MessageSvc.PushReaded".equalsIgnoreCase(str)) {
      return m(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("TransService.ReqGetSign".equalsIgnoreCase(str)) {
      return c(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("StreamSvr.RespUploadStreamMsg".equalsIgnoreCase(str)) {
      return d(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("MessageSvc.SendVideoMsg".equalsIgnoreCase(str)) {
      return b(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("StreamSvr.PushStreamMsg".equalsIgnoreCase(str)) {
      return e(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("AccostSvc.ClientMsg".equals(str)) {
      return k(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("AccostSvc.ReqInsertBlackList".equals(str)) {
      return i(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("AccostSvc.ReqDeleteBlackList".equals(str)) {
      return j(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("AccostSvc.ReqGetBlackList".equals(str)) {
      return h(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("AccostSvc.SvrMsg".equals(str)) {
      return g(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("MessageSvc.PullGroupMsgSeq".equalsIgnoreCase(str)) {
      return u(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("MessageSvc.RequestPushStatus".equalsIgnoreCase(str)) {
      return v(paramToServiceMsg, paramFromServiceMsg);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageFactoryReceiver
 * JD-Core Version:    0.7.0.1
 */