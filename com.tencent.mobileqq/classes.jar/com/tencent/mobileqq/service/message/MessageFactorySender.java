package com.tencent.mobileqq.service.message;

import AccostSvc.ClientMsg;
import AccostSvc.Msg;
import AccostSvc.MsgItem;
import AccostSvc.ReqDeleteBlackList;
import AccostSvc.ReqGetBlackList;
import AccostSvc.ReqInsertBlackList;
import AccostSvc.RespHeader;
import AccostSvc.RespSvrMsg;
import AccostSvc.RichMsg;
import AccostSvc.SvrMsg;
import AccostSvc.UserInfo;
import MessageSvcPack.AccostMsg;
import MessageSvcPack.SvcDelMsgInfo;
import MessageSvcPack.SvcRequestDelMsgV2;
import MessageSvcPack.SvcRequestDelRoamMsg;
import MessageSvcPack.SvcRequestGetMsgV2;
import MessageSvcPack.SvcRequestSendVideoMsg;
import MessageSvcPack.SvcRequestSetRoamMsgAllUser;
import OnlinePushPack.DelMsgInfo;
import OnlinePushPack.DeviceInfo;
import OnlinePushPack.SvcRespPushMsg;
import QQService.CSRespPushStreamMsg;
import QQService.CSUploadStreamMsg;
import QQService.ReqGetSign;
import QQService.ReqOffFilePack;
import QQService.ReqTmpChatPicDownload;
import QQService.StreamData;
import QQService.StreamInfo;
import SharpSvrPack.MultiVideoMsg;
import VideoSvrPack.VideoCallMsg;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.InitMsgModule;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.transfile.api.IBaseHandlerService;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.msg.im_msg_body.GeneralFlags;

public class MessageFactorySender
{
  private static MessageFactorySender.Callback c;
  AppRuntime a;
  AtomicInteger b = new AtomicInteger();
  
  static {}
  
  public static long a(long paramLong)
  {
    return paramLong | 0L;
  }
  
  private long a(String paramString)
  {
    long l = 0L;
    if (paramString != null) {
      if (paramString.length() <= 0) {
        return 0L;
      }
    }
    try
    {
      l = Long.parseLong(paramString);
      if (l < 10000L) {
        return 0L;
      }
      return l;
    }
    catch (NumberFormatException paramString) {}
    return 0L;
  }
  
  public static void a(MessageFactorySender.Callback paramCallback)
  {
    c = paramCallback;
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("OnlinePush");
    paramUniPacket.setFuncName("SvcRespPushMsg");
    paramUniPacket.setRequestId(paramToServiceMsg.extraData.getInt("seq"));
    SvcRespPushMsg localSvcRespPushMsg = new SvcRespPushMsg();
    localSvcRespPushMsg.lUin = paramToServiceMsg.extraData.getLong("lUin");
    localSvcRespPushMsg.svrip = paramToServiceMsg.extraData.getInt("svrip");
    if (localSvcRespPushMsg.lUin < 10000L) {
      return false;
    }
    if (paramToServiceMsg.extraData.getSerializable("delMsgInfos") != null)
    {
      Object localObject = (ArrayList)paramToServiceMsg.extraData.getSerializable("delMsgInfos");
      localSvcRespPushMsg.vDelInfos = ((ArrayList)localObject);
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        DelMsgInfo localDelMsgInfo = (DelMsgInfo)((Iterator)localObject).next();
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("createC2COnlinePushBuff uin: ");
          localStringBuilder.append(localDelMsgInfo.lFromUin);
          localStringBuilder.append(" seq: ");
          localStringBuilder.append(localDelMsgInfo.shMsgSeq);
          QLog.d("MessageHandler", 2, localStringBuilder.toString());
        }
        if ((localDelMsgInfo.vMsgCookies != null) && (QLog.isColorLevel()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("createC2COnlinePushBuff Cookies: ");
          localStringBuilder.append(HexUtil.bytes2HexStr(localDelMsgInfo.vMsgCookies));
          QLog.d("MessageHandler", 2, localStringBuilder.toString());
        }
      }
    }
    if (paramToServiceMsg.extraData.getByteArray("bytes_push_token") != null) {
      localSvcRespPushMsg.bytes_push_token = ((byte[])paramToServiceMsg.extraData.getByteArray("bytes_push_token").clone());
    }
    int i = paramToServiceMsg.extraData.getInt("service_type");
    if (i != -1) {
      localSvcRespPushMsg.service_type = i;
    }
    paramToServiceMsg = paramToServiceMsg.extraData.getSerializable("deviceInfo");
    if ((paramToServiceMsg != null) && ((paramToServiceMsg instanceof DeviceInfo)))
    {
      localSvcRespPushMsg.deviceInfo = ((DeviceInfo)paramToServiceMsg);
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("createC2COnlinePushBuff serviceType=");
        paramToServiceMsg.append(i);
        paramToServiceMsg.append(" device=");
        paramToServiceMsg.append(localSvcRespPushMsg.deviceInfo.strOSVer);
        QLog.d("MessageFactorySender", 2, paramToServiceMsg.toString());
      }
    }
    paramUniPacket.put("resp", localSvcRespPushMsg);
    return true;
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("MessageSvc");
    paramUniPacket.setFuncName("DelMsgV2");
    SvcRequestDelMsgV2 localSvcRequestDelMsgV2 = new SvcRequestDelMsgV2();
    localSvcRequestDelMsgV2.lUin = Long.parseLong(paramToServiceMsg.getUin());
    localSvcRequestDelMsgV2.vDelInfos = new ArrayList();
    localSvcRequestDelMsgV2.vAccostMsg = new ArrayList();
    long[] arrayOfLong = paramToServiceMsg.extraData.getLongArray("fromUin");
    Object localObject1 = paramToServiceMsg.extraData.getIntArray("msgTime");
    Object localObject2 = paramToServiceMsg.extraData.getShortArray("msgSeq");
    int j = 0;
    int i;
    Object localObject3;
    if ((arrayOfLong != null) && (arrayOfLong.length > 0))
    {
      i = 0;
      while (i < arrayOfLong.length)
      {
        localObject3 = new SvcDelMsgInfo();
        ((SvcDelMsgInfo)localObject3).lFromUin = arrayOfLong[i];
        ((SvcDelMsgInfo)localObject3).uMsgTime = localObject1[i];
        ((SvcDelMsgInfo)localObject3).shMsgSeq = localObject2[i];
        localSvcRequestDelMsgV2.vDelInfos.add(localObject3);
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("createDelMessageBuff i: ");
          ((StringBuilder)localObject3).append(i);
          ((StringBuilder)localObject3).append(" fromUin:");
          ((StringBuilder)localObject3).append(arrayOfLong[i]);
          ((StringBuilder)localObject3).append(" msgTime: ");
          ((StringBuilder)localObject3).append(localObject1[i]);
          ((StringBuilder)localObject3).append(" msgSeq:");
          ((StringBuilder)localObject3).append(localObject2[i]);
          QLog.d("MessageFactorySender", 2, ((StringBuilder)localObject3).toString());
        }
        i += 1;
      }
    }
    arrayOfLong = paramToServiceMsg.extraData.getLongArray("accostFromUin");
    localObject1 = paramToServiceMsg.extraData.getLongArray("accostToUin");
    localObject2 = paramToServiceMsg.extraData.getLongArray("accostMsgId");
    paramToServiceMsg = paramToServiceMsg.extraData.getShortArray("accostMsgType");
    if ((arrayOfLong != null) && (arrayOfLong.length > 0))
    {
      i = j;
      while (i < arrayOfLong.length)
      {
        localObject3 = new AccostMsg();
        ((AccostMsg)localObject3).lFromMID = arrayOfLong[i];
        ((AccostMsg)localObject3).lToMID = localObject1[i];
        ((AccostMsg)localObject3).uMsgID = localObject2[i];
        ((AccostMsg)localObject3).shMsgType = paramToServiceMsg[i];
        ((AccostMsg)localObject3).strMsg = new byte[1];
        localSvcRequestDelMsgV2.vAccostMsg.add(localObject3);
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("createDelMessageBuff i: ");
          ((StringBuilder)localObject3).append(i);
          ((StringBuilder)localObject3).append(" accostFromUin:");
          ((StringBuilder)localObject3).append(arrayOfLong[i]);
          ((StringBuilder)localObject3).append(" accostMsgId: ");
          ((StringBuilder)localObject3).append(localObject2[i]);
          ((StringBuilder)localObject3).append(" accostMsgType:");
          ((StringBuilder)localObject3).append(paramToServiceMsg[i]);
          QLog.d("MessageFactorySender", 2, ((StringBuilder)localObject3).toString());
        }
        i += 1;
      }
    }
    paramUniPacket.put("req_DelMsgV2", localSvcRequestDelMsgV2);
    return true;
  }
  
  private boolean d(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    try
    {
      paramUniPacket.setServantName("MessageSvc");
      paramUniPacket.setFuncName("GetMsgV4");
      SvcRequestGetMsgV2 localSvcRequestGetMsgV2 = new SvcRequestGetMsgV2();
      localSvcRequestGetMsgV2.lUin = a(paramToServiceMsg.getUin());
      long l = localSvcRequestGetMsgV2.lUin;
      if (l == 0L) {
        return false;
      }
      int i = paramToServiceMsg.extraData.getInt("lastSeq");
      byte b1 = paramToServiceMsg.extraData.getByte("cChannel");
      byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("vCookies");
      int j = paramToServiceMsg.extraData.getInt("cSyncFlag");
      byte b2 = paramToServiceMsg.extraData.getByte("onlineSyncFlag");
      paramToServiceMsg = paramToServiceMsg.extraData.getByteArray("vSyncCookie");
      localSvcRequestGetMsgV2.uDateTime = i;
      localSvcRequestGetMsgV2.cMsgStoreType = 1;
      localSvcRequestGetMsgV2.cRecivePic = 1;
      localSvcRequestGetMsgV2.shAbility = 15;
      localSvcRequestGetMsgV2.cChannel = b1;
      localSvcRequestGetMsgV2.vCookies = arrayOfByte;
      localSvcRequestGetMsgV2.cUnFilter = 0;
      localSvcRequestGetMsgV2.cSyncFlag = j;
      localSvcRequestGetMsgV2.shLatestRambleNumber = 20;
      localSvcRequestGetMsgV2.shOtherRambleNumber = 3;
      localSvcRequestGetMsgV2.cChannelEx = 1;
      localSvcRequestGetMsgV2.vSyncCookie = paramToServiceMsg;
      localSvcRequestGetMsgV2.cRambleFlag = 0;
      localSvcRequestGetMsgV2.cUnFilter = 0;
      localSvcRequestGetMsgV2.cInst = 0;
      localSvcRequestGetMsgV2.cOnlineSyncFlag = b2;
      localSvcRequestGetMsgV2.cContextFlag = 1;
      localSvcRequestGetMsgV2.lGeneralAbi = 1L;
      paramUniPacket.put("req_GetMsgV2", localSvcRequestGetMsgV2);
      return true;
    }
    finally {}
  }
  
  private boolean e(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = (SvrMsg)paramToServiceMsg.extraData.getSerializable("SvrMsg");
    paramToServiceMsg = new RespSvrMsg(new RespHeader(paramToServiceMsg.stHeader.shVersion, paramToServiceMsg.stHeader.lMID, 0, ""), paramToServiceMsg.stMsg);
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("AccostObj");
    paramUniPacket.setFuncName("CMD_SVR_Msg");
    paramUniPacket.put("RespSvrMsg", paramToServiceMsg);
    return true;
  }
  
  private boolean f(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = new AccostSvc.ReqHeader();
    ((AccostSvc.ReqHeader)localObject).shVersion = 0;
    ((AccostSvc.ReqHeader)localObject).lMID = a(Long.parseLong(paramToServiceMsg.getUin()));
    ((AccostSvc.ReqHeader)localObject).iAppID = AppSetting.d();
    long l = paramToServiceMsg.extraData.getLong("lNextMid");
    if (l < 0L) {
      return false;
    }
    localObject = new ReqGetBlackList((AccostSvc.ReqHeader)localObject, l, 1, 0);
    paramUniPacket.setServantName("AccostObj");
    paramUniPacket.setFuncName("CMD_GET_BlackList");
    paramUniPacket.put("ReqGetBlackList", localObject);
    paramToServiceMsg.setTimeout(10000L);
    return true;
  }
  
  private boolean g(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = new AccostSvc.ReqHeader();
    ((AccostSvc.ReqHeader)localObject).shVersion = 0;
    ((AccostSvc.ReqHeader)localObject).lMID = a(Long.parseLong(paramToServiceMsg.getUin()));
    ((AccostSvc.ReqHeader)localObject).iAppID = AppSetting.d();
    String str = paramToServiceMsg.extraData.getString("deleteUin");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(str));
    localObject = new ReqDeleteBlackList((AccostSvc.ReqHeader)localObject, localArrayList, 0);
    paramUniPacket.setServantName("AccostObj");
    paramUniPacket.setFuncName("CMD_DELETE_BlackList");
    paramUniPacket.put("ReqDeleteBlackList", localObject);
    paramToServiceMsg.setTimeout(10000L);
    return true;
  }
  
  private boolean h(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = new AccostSvc.ReqHeader();
    ((AccostSvc.ReqHeader)localObject).shVersion = 0;
    ((AccostSvc.ReqHeader)localObject).lMID = a(Long.parseLong(paramToServiceMsg.getUin()));
    ((AccostSvc.ReqHeader)localObject).iAppID = AppSetting.d();
    String str = paramToServiceMsg.extraData.getString("insertUin");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(str));
    localObject = new ReqInsertBlackList((AccostSvc.ReqHeader)localObject, localArrayList, 0);
    paramUniPacket.setServantName("AccostObj");
    paramUniPacket.setFuncName("CMD_INSERT_BlackList");
    paramUniPacket.put("ReqInsertBlackList", localObject);
    paramToServiceMsg.setTimeout(10000L);
    return true;
  }
  
  private boolean i(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    AccostSvc.ReqHeader localReqHeader = new AccostSvc.ReqHeader();
    localReqHeader.shVersion = 0;
    localReqHeader.lMID = a(Long.parseLong(paramToServiceMsg.getUin()));
    localReqHeader.iAppID = AppSetting.d();
    long l1 = paramToServiceMsg.extraData.getLong("to");
    Object localObject3 = paramToServiceMsg.extraData.getString("msg");
    boolean bool = paramToServiceMsg.extraData.getBoolean("hello");
    byte b1 = paramToServiceMsg.extraData.getByte("cType");
    Object localObject2 = paramToServiceMsg.extraData.getString("pyNickname");
    long l2 = paramToServiceMsg.extraData.getLong("msgSeq");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    if (b1 == 18) {
      localObject2 = ((String)localObject3).getBytes();
    } else {
      localObject2 = c.f((String)localObject3);
    }
    long l3 = paramToServiceMsg.extraData.getLong("timeOut");
    localObject3 = new MsgItem(b1, (byte[])localObject2);
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(localObject3);
    localObject3 = new UserInfo();
    ((UserInfo)localObject3).nickname = ((String)localObject1);
    localObject1 = new RichMsg((ArrayList)localObject2, "", (UserInfo)localObject3, 0);
    long l4 = Long.valueOf(paramToServiceMsg.getUin()).longValue();
    int j = (int)(System.currentTimeMillis() / 1000L);
    int i;
    if (bool) {
      i = 1;
    } else {
      i = 2;
    }
    localObject1 = new ClientMsg(localReqHeader, new Msg((short)5, l2, l4, l1, j, i, ((RichMsg)localObject1).toByteArray(), 0L, 0L));
    paramUniPacket.setServantName("AccostObj");
    paramUniPacket.setFuncName("CMD_CLT_Msg");
    paramUniPacket.put("ClientMsg", localObject1);
    paramToServiceMsg.setTimeout(l3);
    return true;
  }
  
  private boolean j(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("VideoSvc");
    paramUniPacket.setFuncName("SendVideoMsg");
    Bundle localBundle = paramToServiceMsg.extraData;
    VideoCallMsg localVideoCallMsg = new VideoCallMsg();
    localVideoCallMsg.ver = 1;
    localVideoCallMsg.type = 1;
    localVideoCallMsg.lUin = a(paramToServiceMsg.getUin());
    localVideoCallMsg.lPeerUin = localBundle.getLong("toUin");
    localVideoCallMsg.uDateTime = ((int)System.currentTimeMillis() / 1000);
    localVideoCallMsg.cVerifyType = 0;
    localVideoCallMsg.uSeqId = 0;
    localVideoCallMsg.uSessionId = 0;
    localVideoCallMsg.vMsg = localBundle.getByteArray("vMsg");
    paramUniPacket.put("VideoCallMsg", localVideoCallMsg);
    return true;
  }
  
  private boolean k(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MultiVideo");
    paramUniPacket.setFuncName("MultiVideos2cack");
    paramToServiceMsg = paramToServiceMsg.extraData;
    MultiVideoMsg localMultiVideoMsg = new MultiVideoMsg();
    localMultiVideoMsg.ver = paramToServiceMsg.getByte("ver");
    localMultiVideoMsg.type = paramToServiceMsg.getByte("type");
    localMultiVideoMsg.csCmd = paramToServiceMsg.getShort("cscmd");
    localMultiVideoMsg.subCmd = paramToServiceMsg.getShort("subcmd");
    localMultiVideoMsg.from_uin = a(String.valueOf(paramToServiceMsg.getLong("from_uin")));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramToServiceMsg.getLong("to_uin")));
    localMultiVideoMsg.to_uin = localArrayList;
    localMultiVideoMsg.msg_time = paramToServiceMsg.getLong("msg_time");
    localMultiVideoMsg.msg_type = paramToServiceMsg.getLong("msg_type");
    localMultiVideoMsg.msg_seq = paramToServiceMsg.getLong("msg_seq");
    localMultiVideoMsg.msg_uid = paramToServiceMsg.getLong("msg_uid");
    localMultiVideoMsg.video_buff = paramToServiceMsg.getByteArray("video_buff");
    paramUniPacket.put("MultiVideoMsg", localMultiVideoMsg);
    return true;
  }
  
  private boolean l(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MessageSvc");
    paramUniPacket.setFuncName("SendVideoMsg");
    Bundle localBundle = paramToServiceMsg.extraData;
    SvcRequestSendVideoMsg localSvcRequestSendVideoMsg = new SvcRequestSendVideoMsg();
    localSvcRequestSendVideoMsg.lUin = a(paramToServiceMsg.getUin());
    localSvcRequestSendVideoMsg.lPeerUin = a(localBundle.getString("uin"));
    localSvcRequestSendVideoMsg.uDateTime = ((int)System.currentTimeMillis() / 1000);
    localSvcRequestSendVideoMsg.cVerifyType = localBundle.getByte("cVerifyType");
    localSvcRequestSendVideoMsg.vMsg = localBundle.getByteArray("vMsg");
    paramUniPacket.put("req_SendVideoMsg", localSvcRequestSendVideoMsg);
    if (localSvcRequestSendVideoMsg.vMsg != null) {
      paramToServiceMsg = String.valueOf(localSvcRequestSendVideoMsg.vMsg[2]);
    } else {
      paramToServiceMsg = "null";
    }
    c.a(localSvcRequestSendVideoMsg, paramToServiceMsg);
    return true;
  }
  
  private boolean m(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("TransService");
    paramUniPacket.setFuncName("ReqOffFilePack");
    Bundle localBundle = paramToServiceMsg.extraData;
    int k = localBundle.getInt("offfile_type");
    ReqOffFilePack localReqOffFilePack = new ReqOffFilePack();
    localReqOffFilePack.lUIN = a(paramToServiceMsg.getUin());
    paramToServiceMsg = localBundle.getByteArray("filepath");
    int j;
    if (paramToServiceMsg == null) {
      j = 0;
    } else {
      j = paramToServiceMsg.length;
    }
    long l = a(localBundle.getString("uin"));
    if (k != 0)
    {
      if (k != 1)
      {
        if (k != 2)
        {
          if ((k != 3) && (k != 4))
          {
            if ((k == 5) && (paramToServiceMsg != null))
            {
              localReqOffFilePack.vBody = new byte[j + 10];
              localReqOffFilePack.vBody[0] = 3;
              localReqOffFilePack.vBody[1] = 6;
              PkgTools.word2Byte(localReqOffFilePack.vBody, 2, (short)0);
              PkgTools.word2Byte(localReqOffFilePack.vBody, 4, (short)0);
              PkgTools.word2Byte(localReqOffFilePack.vBody, 6, (short)1);
              PkgTools.word2Byte(localReqOffFilePack.vBody, 8, (short)j);
              PkgTools.copyData(localReqOffFilePack.vBody, 10, paramToServiceMsg, j);
            }
          }
          else
          {
            localBundle.getInt("vip_level");
            byte[] arrayOfByte1 = localBundle.getByteArray("sig");
            l = localBundle.getLong("filesize");
            byte[] arrayOfByte2 = localBundle.getByteArray("filemd5");
            localReqOffFilePack.vBody = a(arrayOfByte1, paramToServiceMsg, localBundle.getByteArray("filename"), arrayOfByte2, l);
          }
        }
        else
        {
          int i = localBundle.getByte("result");
          if (paramToServiceMsg != null) {
            k = j + 8;
          } else {
            k = 8;
          }
          localReqOffFilePack.vBody = new byte[k];
          localReqOffFilePack.vBody[0] = 2;
          localReqOffFilePack.vBody[1] = i;
          PkgTools.dWord2Byte(localReqOffFilePack.vBody, 2, l);
          PkgTools.word2Byte(localReqOffFilePack.vBody, 6, (short)j);
          PkgTools.copyData(localReqOffFilePack.vBody, 8, paramToServiceMsg, j);
        }
      }
      else
      {
        localReqOffFilePack.vBody = new byte[13];
        localReqOffFilePack.vBody[0] = 6;
        PkgTools.dWord2Byte(localReqOffFilePack.vBody, 1, l);
        PkgTools.dWord2Byte(localReqOffFilePack.vBody, 5, 0L);
        PkgTools.dWord2Byte(localReqOffFilePack.vBody, 9, 0L);
      }
    }
    else if (paramToServiceMsg != null)
    {
      localReqOffFilePack.vBody = new byte[j + 10];
      localReqOffFilePack.vBody[0] = 3;
      localReqOffFilePack.vBody[1] = 6;
      PkgTools.word2Byte(localReqOffFilePack.vBody, 2, (short)0);
      PkgTools.word2Byte(localReqOffFilePack.vBody, 4, (short)0);
      PkgTools.word2Byte(localReqOffFilePack.vBody, 6, (short)1);
      PkgTools.word2Byte(localReqOffFilePack.vBody, 8, (short)j);
      PkgTools.copyData(localReqOffFilePack.vBody, 10, paramToServiceMsg, j);
    }
    paramUniPacket.put("ReqOffFilePack", localReqOffFilePack);
    return true;
  }
  
  private boolean n(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("TransService");
    paramUniPacket.setFuncName("ReqGetSign");
    Bundle localBundle = paramToServiceMsg.extraData;
    ReqGetSign localReqGetSign = new ReqGetSign();
    localReqGetSign.lUIN = a(paramToServiceMsg.getUin());
    localReqGetSign.uSSOVer = localBundle.getInt("ssover");
    localReqGetSign.uAppID = localBundle.getInt("app_id");
    localReqGetSign.cA2Type = localBundle.getByte("a2type");
    localReqGetSign.vA2 = new byte[0];
    localReqGetSign.vCiphertext = localBundle.getByteArray("enkey");
    paramUniPacket.put("ReqGetSign", localReqGetSign);
    return true;
  }
  
  private boolean o(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("TransService");
    paramUniPacket.setFuncName("ReqTmpChatPicDownload");
    Bundle localBundle = paramToServiceMsg.extraData;
    ReqTmpChatPicDownload localReqTmpChatPicDownload = new ReqTmpChatPicDownload();
    localReqTmpChatPicDownload.lUIN = a(paramToServiceMsg.getUin());
    int i = MobileQQService.seq;
    MobileQQService.seq = i + 1;
    localReqTmpChatPicDownload.lSeq = i;
    localReqTmpChatPicDownload.strFlieKey = localBundle.getString("filekey");
    localReqTmpChatPicDownload.getPicSize = localBundle.getByte("picscale");
    paramUniPacket.put("ReqTmpChatPicDownload", localReqTmpChatPicDownload);
    return true;
  }
  
  private boolean p(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MessageSvc.SetRoamMsgAllUser");
    paramUniPacket.setFuncName("SetRoamMsgAllUser");
    Bundle localBundle = paramToServiceMsg.extraData;
    SvcRequestSetRoamMsgAllUser localSvcRequestSetRoamMsgAllUser = new SvcRequestSetRoamMsgAllUser();
    localSvcRequestSetRoamMsgAllUser.lUin = a(paramToServiceMsg.getUin());
    localSvcRequestSetRoamMsgAllUser.shType = localBundle.getShort("shType");
    localSvcRequestSetRoamMsgAllUser.cValue = localBundle.getByte("cValue");
    localSvcRequestSetRoamMsgAllUser.cVerifyType = 0;
    paramUniPacket.put("req_SetRoamMsgAllUser", localSvcRequestSetRoamMsgAllUser);
    return true;
  }
  
  private boolean q(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MessageSvc.DelRoamMsg");
    paramUniPacket.setFuncName("DelRoamMsg");
    Bundle localBundle = paramToServiceMsg.extraData;
    SvcRequestDelRoamMsg localSvcRequestDelRoamMsg = new SvcRequestDelRoamMsg();
    localSvcRequestDelRoamMsg.lUin = a(paramToServiceMsg.getUin());
    localSvcRequestDelRoamMsg.lPeerUin = a(localBundle.getString("uin"));
    localSvcRequestDelRoamMsg.cVerifyType = 0;
    paramUniPacket.put("req_DelRoamMsg", localSvcRequestDelRoamMsg);
    return true;
  }
  
  private boolean r(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("StreamSvr");
    paramUniPacket.setFuncName("GetCSUploadStreamMsgBuf");
    long l1 = b(Long.valueOf(paramToServiceMsg.extraData.getString("uin")).longValue());
    Object localObject1 = paramToServiceMsg.extraData.getString("filepath");
    Object localObject2 = paramToServiceMsg.extraData.getString("selfuin");
    Object localObject3 = paramToServiceMsg.extraData.getString("uin");
    Short localShort = Short.valueOf(paramToServiceMsg.extraData.getShort("PackSeq"));
    int i = paramToServiceMsg.extraData.getInt("msgseq");
    long l2 = paramToServiceMsg.extraData.getLong("random");
    long l3 = paramToServiceMsg.extraData.getLong("VoiceType");
    long l4 = paramToServiceMsg.extraData.getLong("VoiceLength");
    long l5 = paramToServiceMsg.extraData.getLong("SubBubbleId");
    int j = paramToServiceMsg.extraData.getInt("DiyTextId");
    paramToServiceMsg = new StreamInfo();
    paramToServiceMsg.lFromUIN = a((String)localObject2);
    paramToServiceMsg.lToUIN = a((String)localObject3);
    paramToServiceMsg.iMsgId = c.a((String)localObject1);
    paramToServiceMsg.type = 1;
    paramToServiceMsg.iSendTime = 0;
    paramToServiceMsg.shPackNum = c.c((String)localObject1);
    paramToServiceMsg.shFlowLayer = c.b((String)localObject1);
    paramToServiceMsg.pttTime = l4;
    paramToServiceMsg.pttFormat = l3;
    paramToServiceMsg.subBubbleId = l5;
    int k = a();
    paramToServiceMsg.netType = k;
    if (localShort.shortValue() == 1)
    {
      localObject2 = new ptt_reserve.ReserveStruct();
      ((ptt_reserve.ReserveStruct)localObject2).uint32_change_voice.set(0);
      ((ptt_reserve.ReserveStruct)localObject2).uint32_autototext_voice.set(0);
      localObject3 = new im_msg_body.GeneralFlags();
      ((im_msg_body.GeneralFlags)localObject3).uint32_bubble_sub_id.set((int)l5);
      ((im_msg_body.GeneralFlags)localObject3).uint32_bubble_diy_text_id.set(j);
      ((ptt_reserve.ReserveStruct)localObject2).bytes_general_flags.set(ByteStringMicro.copyFrom(((im_msg_body.GeneralFlags)localObject3).toByteArray()));
      paramToServiceMsg.vPbData = ((ptt_reserve.ReserveStruct)localObject2).toByteArray();
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("C2CStreamUp: type[");
      ((StringBuilder)localObject2).append(l3);
      ((StringBuilder)localObject2).append("] length[");
      ((StringBuilder)localObject2).append(l4);
      ((StringBuilder)localObject2).append("]");
      QLog.d("RecordParams", 2, ((StringBuilder)localObject2).toString());
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("C2CStreamUp: net[");
        ((StringBuilder)localObject2).append(k);
        ((StringBuilder)localObject2).append("]");
        QLog.d("RecordParams", 2, ((StringBuilder)localObject2).toString());
      }
    }
    localObject2 = new StreamData();
    ((StreamData)localObject2).shPackSeq = localShort.shortValue();
    if (((StreamData)localObject2).shPackSeq < paramToServiceMsg.shPackNum) {
      paramToServiceMsg.shPackNum = 0;
    }
    ((StreamData)localObject2).vData = c.a((String)localObject1, localShort.shortValue());
    boolean bool = c.d((String)localObject1);
    if (bool)
    {
      paramToServiceMsg.shPackNum = 0;
      paramToServiceMsg.oprType = 1;
      c.e((String)localObject1);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("shPackSeq:");
      ((StringBuilder)localObject1).append(localShort);
      ((StringBuilder)localObject1).append(" shPackNum:");
      ((StringBuilder)localObject1).append(paramToServiceMsg.shPackNum);
      ((StringBuilder)localObject1).append(",layer:");
      ((StringBuilder)localObject1).append(paramToServiceMsg.shFlowLayer);
      ((StringBuilder)localObject1).append(",msgId:");
      ((StringBuilder)localObject1).append(paramToServiceMsg.iMsgId);
      ((StringBuilder)localObject1).append(" cancelled:");
      ((StringBuilder)localObject1).append(bool);
      QLog.d("StreamPtt", 2, ((StringBuilder)localObject1).toString());
    }
    new QQService.ReqHeader((short)0, paramUniPacket.getRequestId(), l1);
    if ((i == 0) && (l2 == 0L))
    {
      paramUniPacket.put("CSUploadStreamMsg", a(paramUniPacket, paramToServiceMsg, (StreamData)localObject2, (short)1));
      return true;
    }
    paramToServiceMsg.msgSeq = i;
    paramToServiceMsg.random = l2;
    paramUniPacket.put("CSUploadStreamMsg", a(paramUniPacket, paramToServiceMsg, (StreamData)localObject2, (short)10));
    return true;
  }
  
  private boolean s(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("StreamSvr");
    paramUniPacket.setFuncName("GetCSRespPushStreamMsgBuf");
    Object localObject = paramToServiceMsg.extraData.getString("filepath");
    String str1 = paramToServiceMsg.extraData.getString("selfuin");
    String str2 = paramToServiceMsg.extraData.getString("uin");
    Short localShort = Short.valueOf(paramToServiceMsg.extraData.getShort("PackSeq"));
    long l = paramToServiceMsg.extraData.getLong("lkey");
    paramToServiceMsg = new StreamInfo();
    paramToServiceMsg.lFromUIN = a(str2);
    paramToServiceMsg.lToUIN = a(str1);
    paramToServiceMsg.iMsgId = c.a((String)localObject);
    paramToServiceMsg.type = 1;
    paramToServiceMsg.iSendTime = 0;
    paramToServiceMsg.shPackNum = 0;
    paramToServiceMsg.shFlowLayer = c.b((String)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createReqpushStreamMsg ---streaminfo.lFromUIN= ");
      ((StringBuilder)localObject).append(paramToServiceMsg.lFromUIN);
      ((StringBuilder)localObject).append("---streaminfo.shFlowLayer = ");
      ((StringBuilder)localObject).append(paramToServiceMsg.shFlowLayer);
      ((StringBuilder)localObject).append("---streaminfo.lToUIN = ");
      ((StringBuilder)localObject).append(paramToServiceMsg.lToUIN);
      ((StringBuilder)localObject).append("---streaminfo.iMsgId = ");
      ((StringBuilder)localObject).append(paramToServiceMsg.iMsgId);
      ((StringBuilder)localObject).append("---PackSeq = ");
      ((StringBuilder)localObject).append(localShort);
      ((StringBuilder)localObject).append("---lKey = ");
      ((StringBuilder)localObject).append(l);
      QLog.d("streamptt.recv", 2, ((StringBuilder)localObject).toString());
    }
    paramUniPacket.put("CSRespPushStreamMsg", new CSRespPushStreamMsg((short)1, paramUniPacket.getRequestId(), paramToServiceMsg, localShort.shortValue(), l));
    return true;
  }
  
  public int a()
  {
    return ((IBaseHandlerService)QRoute.api(IBaseHandlerService.class)).getHandlerNetType();
  }
  
  @NotNull
  public CSUploadStreamMsg a(UniPacket paramUniPacket, StreamInfo paramStreamInfo, StreamData paramStreamData, short paramShort)
  {
    return new CSUploadStreamMsg(paramShort, paramUniPacket.getRequestId(), paramStreamInfo, paramStreamData, this.b.incrementAndGet());
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.a = paramAppRuntime;
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if ("MessageSvc.DelMsgV2".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return c(paramToServiceMsg, paramUniPacket);
    }
    if ("MessageSvc.GetMsgV4".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return d(paramToServiceMsg, paramUniPacket);
    }
    if ("TransService.ReqGetSign".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return n(paramToServiceMsg, paramUniPacket);
    }
    if ("TransService.ReqTmpChatPicDownload".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return o(paramToServiceMsg, paramUniPacket);
    }
    if ("TransService.ReqOffFilePack".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return m(paramToServiceMsg, paramUniPacket);
    }
    if ("MessageSvc.SetRoamMsgAllUser".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return p(paramToServiceMsg, paramUniPacket);
    }
    if ("MessageSvc.DelRoamMsg".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return q(paramToServiceMsg, paramUniPacket);
    }
    if ("MessageSvc.SendVideoMsg".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return l(paramToServiceMsg, paramUniPacket);
    }
    if ("StreamSvr.UploadStreamMsg".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return r(paramToServiceMsg, paramUniPacket);
    }
    if ("StreamSvr.RespPushStreamMsg".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return s(paramToServiceMsg, paramUniPacket);
    }
    if ("VideoCCSvc.Adaptation".equals(paramToServiceMsg.getServiceCmd())) {
      return j(paramToServiceMsg, paramUniPacket);
    }
    if ("MultiVideo.s2cack".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return k(paramToServiceMsg, paramUniPacket);
    }
    if ("OnlinePush.RespPush".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return b(paramToServiceMsg, paramUniPacket);
    }
    if ("AccostSvc.ClientMsg".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return i(paramToServiceMsg, paramUniPacket);
    }
    if ("AccostSvc.ReqInsertBlackList".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return h(paramToServiceMsg, paramUniPacket);
    }
    if ("AccostSvc.ReqDeleteBlackList".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return g(paramToServiceMsg, paramUniPacket);
    }
    if ("AccostSvc.ReqGetBlackList".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return f(paramToServiceMsg, paramUniPacket);
    }
    if ("AccostSvc.SvrMsg".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return e(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, long paramLong)
  {
    if (paramArrayOfByte1 == null) {
      i = 2;
    } else {
      i = paramArrayOfByte1.length + 2;
    }
    int j;
    if (paramArrayOfByte1 == null) {
      j = 2;
    } else {
      j = paramArrayOfByte1.length + 2;
    }
    int k;
    if (paramArrayOfByte3 == null) {
      k = 2;
    } else {
      k = paramArrayOfByte3.length + 2;
    }
    int m;
    if (paramArrayOfByte4 == null) {
      m = 1;
    } else {
      m = paramArrayOfByte4.length + 1;
    }
    int n;
    if (paramArrayOfByte4 == null) {
      n = 1;
    } else {
      n = paramArrayOfByte4.length + 1;
    }
    int i1;
    if (paramArrayOfByte2 == null) {
      i1 = 2;
    } else {
      i1 = paramArrayOfByte2.length + 2;
    }
    byte[] arrayOfByte = new byte[i + 5 + j + 6 + k + m + n + i1];
    arrayOfByte[0] = 1;
    PkgTools.dWord2Byte(arrayOfByte, 1, 0L);
    int i = 7;
    if (paramArrayOfByte1 != null)
    {
      PkgTools.word2Byte(arrayOfByte, 5, (short)paramArrayOfByte1.length);
      PkgTools.copyData(arrayOfByte, 7, paramArrayOfByte1, paramArrayOfByte1.length);
      i = 7 + paramArrayOfByte1.length;
    }
    else
    {
      PkgTools.word2Byte(arrayOfByte, 5, (short)0);
    }
    if (paramArrayOfByte1 != null)
    {
      PkgTools.word2Byte(arrayOfByte, i, (short)paramArrayOfByte1.length);
      i += 2;
      PkgTools.copyData(arrayOfByte, i, paramArrayOfByte1, paramArrayOfByte1.length);
      i += paramArrayOfByte1.length;
    }
    else
    {
      PkgTools.word2Byte(arrayOfByte, i, (short)0);
      i += 2;
    }
    PkgTools.word2Byte(arrayOfByte, i, (short)0);
    i += 2;
    PkgTools.dWord2Byte(arrayOfByte, i, paramLong);
    i += 4;
    if (paramArrayOfByte3 != null)
    {
      PkgTools.word2Byte(arrayOfByte, i, (short)paramArrayOfByte3.length);
      i += 2;
      PkgTools.copyData(arrayOfByte, i, paramArrayOfByte3, paramArrayOfByte3.length);
      i += paramArrayOfByte3.length;
    }
    else
    {
      PkgTools.word2Byte(arrayOfByte, i, (short)0);
      i += 2;
    }
    if (paramArrayOfByte4 != null)
    {
      arrayOfByte[i] = ((byte)paramArrayOfByte4.length);
      i += 1;
      PkgTools.copyData(arrayOfByte, i, paramArrayOfByte4, paramArrayOfByte4.length);
      i += paramArrayOfByte4.length;
    }
    else
    {
      arrayOfByte[i] = 0;
      i += 1;
    }
    if (paramArrayOfByte4 != null)
    {
      arrayOfByte[i] = ((byte)paramArrayOfByte4.length);
      i += 1;
      PkgTools.copyData(arrayOfByte, i, paramArrayOfByte4, paramArrayOfByte4.length);
      i += paramArrayOfByte4.length;
    }
    else
    {
      arrayOfByte[i] = 0;
      i += 1;
    }
    if (paramArrayOfByte2 != null)
    {
      PkgTools.word2Byte(arrayOfByte, i, (short)paramArrayOfByte2.length);
      PkgTools.copyData(arrayOfByte, i + 2, paramArrayOfByte2, paramArrayOfByte2.length);
      i = paramArrayOfByte2.length;
      return arrayOfByte;
    }
    PkgTools.word2Byte(arrayOfByte, i, (short)0);
    return arrayOfByte;
  }
  
  long b(long paramLong)
  {
    return paramLong & 0xFFFFFFFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageFactorySender
 * JD-Core Version:    0.7.0.1
 */