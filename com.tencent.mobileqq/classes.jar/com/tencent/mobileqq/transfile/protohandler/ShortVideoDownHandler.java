package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pttcenterservice.PttShortVideo.ExtensionReq;
import pttcenterservice.PttShortVideo.PttShortVideoAddr;
import pttcenterservice.PttShortVideo.PttShortVideoDownloadReq;
import pttcenterservice.PttShortVideo.PttShortVideoDownloadResp;
import pttcenterservice.PttShortVideo.QuicParameter;
import pttcenterservice.PttShortVideo.ReqBody;
import pttcenterservice.PttShortVideo.RspBody;

public class ShortVideoDownHandler
  extends BaseHandler
{
  public static final String TAG = "Q.richmedia.ShortVideoDownHandler";
  
  private ArrayList<ServerAddr> parseSrvAddlist(RichProto.RichProtoResp.ShortVideoDownResp paramShortVideoDownResp, List<String> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        try
        {
          ServerAddr localServerAddr = new ServerAddr();
          URL localURL = new URL(str);
          localServerAddr.mIp = localURL.getHost();
          localServerAddr.port = localURL.getPort();
          localServerAddr.isIpv6 = paramBoolean;
          localArrayList.add(localServerAddr);
          if (!str.startsWith("https://")) {
            break label127;
          }
          paramShortVideoDownResp.mIsHttps = true;
        }
        catch (Exception localException)
        {
          QLog.e("Q.richmedia.ShortVideoDownHandler", 1, "parseSrvAddlist err.", localException);
        }
        continue;
        label127:
        paramShortVideoDownResp.mIsHttps = false;
      }
    }
    return localArrayList;
  }
  
  byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> paramList)
  {
    PttShortVideo.ReqBody localReqBody = new PttShortVideo.ReqBody();
    localReqBody.setHasFlag(true);
    if (paramList.size() == 1)
    {
      paramList = (RichProto.RichProtoReq.ShortVideoDownReq)paramList.get(0);
      PttShortVideo.PttShortVideoDownloadReq localPttShortVideoDownloadReq = new PttShortVideo.PttShortVideoDownloadReq();
      localPttShortVideoDownloadReq.uint64_touin.set(Long.parseLong(paramList.selfUin));
      localPttShortVideoDownloadReq.uint32_chat_type.set(paramList.chatType);
      if (paramList.chatType == 0)
      {
        localPttShortVideoDownloadReq.uint64_fromuin.set(Long.parseLong(paramList.peerUin));
        localPttShortVideoDownloadReq.uint32_client_type.set(paramList.clientType);
        localPttShortVideoDownloadReq.str_fileid.set(paramList.fileId);
        if (paramList.troopUin == null) {
          break label398;
        }
        localPttShortVideoDownloadReq.uint64_group_code.set(Long.parseLong(paramList.troopUin));
        label131:
        localPttShortVideoDownloadReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramList.md5));
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ShortVideoDownHandler", 2, "download md5 = " + paramList.md5);
        }
        localPttShortVideoDownloadReq.uint32_agent_type.set(paramList.agentType);
        localPttShortVideoDownloadReq.uint32_business_type.set(paramList.busiType);
        localPttShortVideoDownloadReq.uint32_flag_support_large_size.set(1);
        localPttShortVideoDownloadReq.uint32_flag_client_quic_proto_enable.set(1);
        localPttShortVideoDownloadReq.uint32_file_type.set(paramList.fileType);
        localPttShortVideoDownloadReq.uint32_down_type.set(paramList.downType);
        localPttShortVideoDownloadReq.uint32_scene_type.set(paramList.sceneType);
        localPttShortVideoDownloadReq.uint32_need_inner_addr.set(0);
        if (paramList.busiType != 0) {
          break label409;
        }
        localPttShortVideoDownloadReq.uint32_req_transfer_type.set(1);
      }
      for (;;)
      {
        localPttShortVideoDownloadReq.uint32_req_host_type.set(11);
        PttShortVideo.ExtensionReq localExtensionReq = new PttShortVideo.ExtensionReq();
        localExtensionReq.uint32_sub_busi_type.set(paramList.subBusiType);
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ShortVideoDownHandler", 2, "constructReqBody ShortVideoDownReq = " + paramList.toString());
        }
        localReqBody.uint32_cmd.set(400);
        localReqBody.uint32_seq.set(paramList.seq);
        localReqBody.msg_PttShortVideoDownload_Req.set(localPttShortVideoDownloadReq);
        localReqBody.rpt_msg_extension_req.add(localExtensionReq);
        return localReqBody.toByteArray();
        localPttShortVideoDownloadReq.uint64_fromuin.set(Long.parseLong(paramList.secondUin));
        break;
        label398:
        localPttShortVideoDownloadReq.uint64_group_code.set(0L);
        break label131;
        label409:
        localPttShortVideoDownloadReq.uint32_req_transfer_type.set(2);
      }
    }
    throw new RuntimeException("only support one request");
  }
  
  public void handleAddr(RichProto.RichProtoResp.ShortVideoDownResp paramShortVideoDownResp, PttShortVideo.PttShortVideoDownloadResp paramPttShortVideoDownloadResp)
  {
    PttShortVideo.PttShortVideoAddr localPttShortVideoAddr = (PttShortVideo.PttShortVideoAddr)paramPttShortVideoDownloadResp.msg_download_addr.get();
    if (localPttShortVideoAddr != null)
    {
      paramShortVideoDownResp.mHostType = localPttShortVideoAddr.uint32_host_type.get();
      if (paramShortVideoDownResp.mHostType == 0)
      {
        paramShortVideoDownResp.mIpList = parseSrvAddlist(paramShortVideoDownResp, localPttShortVideoAddr.rpt_str_host.get(), false);
        paramShortVideoDownResp.mIpv6List = parseSrvAddlist(paramShortVideoDownResp, localPttShortVideoAddr.rpt_str_host_ipv6.get(), true);
        Object localObject = "";
        paramPttShortVideoDownloadResp = (PttShortVideo.PttShortVideoDownloadResp)localObject;
        if (localPttShortVideoAddr.rpt_str_domain.has())
        {
          paramPttShortVideoDownloadResp = (PttShortVideo.PttShortVideoDownloadResp)localObject;
          if (localPttShortVideoAddr.rpt_str_domain.size() > 0) {
            paramPttShortVideoDownloadResp = (String)localPttShortVideoAddr.rpt_str_domain.get(0);
          }
        }
        localObject = paramPttShortVideoDownloadResp;
        if (paramPttShortVideoDownloadResp != null)
        {
          localObject = paramPttShortVideoDownloadResp;
          if (paramPttShortVideoDownloadResp.length() > 0) {
            localObject = InnerDns.getHostFromUrl(paramPttShortVideoDownloadResp);
          }
        }
        paramShortVideoDownResp.mDomain = ((String)localObject);
      }
      paramShortVideoDownResp.mUrl = localPttShortVideoAddr.str_url_args.get();
    }
  }
  
  public void handleRespBody(byte[] paramArrayOfByte, RichProto.RichProtoResp paramRichProtoResp, StatictisInfo paramStatictisInfo)
  {
    for (;;)
    {
      RichProto.RichProtoResp.ShortVideoDownResp localShortVideoDownResp;
      int i;
      try
      {
        PttShortVideo.RspBody localRspBody = new PttShortVideo.RspBody();
        localRspBody.mergeFrom(paramArrayOfByte);
        PttShortVideo.PttShortVideoDownloadResp localPttShortVideoDownloadResp = (PttShortVideo.PttShortVideoDownloadResp)localRspBody.msg_PttShortVideoDownload_Resp.get();
        localShortVideoDownResp = (RichProto.RichProtoResp.ShortVideoDownResp)paramRichProtoResp.resps.get(0);
        i = localPttShortVideoDownloadResp.int32_ret_code.get();
        if (i == 0)
        {
          localShortVideoDownResp.mUkey = HexUtil.bytes2HexStr(localPttShortVideoDownloadResp.bytes_downloadkey.get().toByteArray());
          localShortVideoDownResp.md5 = localPttShortVideoDownloadResp.bytes_file_md5.get().toByteArray();
          handleAddr(localShortVideoDownResp, localPttShortVideoDownloadResp);
          handleSupportQuic(localShortVideoDownResp, localPttShortVideoDownloadResp);
          setResult(0, 0, "", "", paramStatictisInfo, localShortVideoDownResp);
          return;
        }
        if (i == -5100026)
        {
          setResult(-1, -5100026, BaseTransProcessor.getUrlReason(i), "", paramStatictisInfo, localShortVideoDownResp);
          if (localRspBody.uint32_allow_retry.get() != 1) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.richmedia.ShortVideoDownHandler", 2, "onProtoResp : shortVideo server not allow retry");
          }
          localShortVideoDownResp.isAllowRetry = false;
          return;
        }
      }
      catch (Exception localException)
      {
        setResult(-1, -9527, BaseTransProcessor.getServerReason("P", -9529L), localException.getMessage() + " hex:" + HexUtil.bytes2HexStr(paramArrayOfByte), paramStatictisInfo, paramRichProtoResp.resps);
        return;
      }
      if (i == -5100528)
      {
        long l = i;
        setResult(-1, -5100528, BaseTransProcessor.getUrlReason(l), "", paramStatictisInfo, localShortVideoDownResp);
      }
      else
      {
        setResult(-1, -9527, BaseTransProcessor.getUrlReason(i), "", paramStatictisInfo, localShortVideoDownResp);
      }
    }
  }
  
  public void handleSupportQuic(RichProto.RichProtoResp.ShortVideoDownResp paramShortVideoDownResp, PttShortVideo.PttShortVideoDownloadResp paramPttShortVideoDownloadResp)
  {
    boolean bool4 = true;
    boolean bool2;
    if (paramPttShortVideoDownloadResp.uint32_flag_server_quic_proto_enable.has()) {
      if (paramPttShortVideoDownloadResp.uint32_flag_server_quic_proto_enable.get() == 1)
      {
        bool2 = true;
        bool1 = bool2;
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ShortVideoDownHandler", 2, "quic_proto_enable : " + paramPttShortVideoDownloadResp.uint32_flag_server_quic_proto_enable.get());
        }
      }
    }
    boolean bool3;
    for (boolean bool1 = bool2;; bool1 = false)
    {
      bool3 = bool1;
      PttShortVideo.QuicParameter localQuicParameter;
      if (paramPttShortVideoDownloadResp.bytes_server_quic_para.has())
      {
        paramPttShortVideoDownloadResp = paramPttShortVideoDownloadResp.bytes_server_quic_para.get();
        localQuicParameter = new PttShortVideo.QuicParameter();
        bool2 = bool1;
      }
      for (;;)
      {
        try
        {
          localQuicParameter.mergeFrom(paramPttShortVideoDownloadResp.toByteArray());
          if (!bool1) {
            continue;
          }
          bool2 = bool1;
          if (localQuicParameter.uint32_enable_quic.get() != 1) {
            continue;
          }
          bool1 = true;
          bool2 = bool1;
          if (localQuicParameter.uint32_encryption_ver.has())
          {
            bool2 = bool1;
            int i = localQuicParameter.uint32_encryption_ver.get();
            if (i != 1) {
              continue;
            }
            bool3 = bool4;
            bool2 = bool1;
            paramShortVideoDownResp.mIsQuicEncryption = bool3;
            bool2 = bool1;
            if (QLog.isColorLevel())
            {
              bool2 = bool1;
              QLog.d("Q.richmedia.ShortVideoDownHandler", 2, "encryption_ver : " + i);
            }
          }
          bool3 = bool1;
          bool2 = bool1;
          if (localQuicParameter.uint32_fec_ver.has())
          {
            bool2 = bool1;
            paramShortVideoDownResp.mQuicFec = localQuicParameter.uint32_fec_ver.get();
            bool3 = bool1;
            bool2 = bool1;
            if (QLog.isColorLevel())
            {
              bool2 = bool1;
              QLog.d("Q.richmedia.ShortVideoDownHandler", 2, "fec_ver : " + paramShortVideoDownResp.mQuicFec);
              bool3 = bool1;
            }
          }
        }
        catch (Exception paramPttShortVideoDownloadResp)
        {
          QLog.e("Q.richmedia.ShortVideoDownHandler", 4, paramPttShortVideoDownloadResp, new Object[0]);
          bool3 = bool2;
          continue;
        }
        paramShortVideoDownResp.mIsSupportQuic = bool3;
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ShortVideoDownHandler", 2, "supportQuic: " + bool3);
        }
        return;
        bool2 = false;
        break;
        bool1 = false;
        continue;
        bool3 = false;
      }
    }
  }
  
  void initResps(RichProto.RichProtoReq paramRichProtoReq)
  {
    RichProto.RichProtoResp localRichProtoResp = paramRichProtoReq.resp;
    localRichProtoResp.resps.clear();
    int i = 0;
    while (i < paramRichProtoReq.reqs.size())
    {
      RichProto.RichProtoResp.ShortVideoDownResp localShortVideoDownResp = new RichProto.RichProtoResp.ShortVideoDownResp();
      localRichProtoResp.resps.add(i, localShortVideoDownResp);
      i += 1;
    }
  }
  
  public void onProtoResp(ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    FromServiceMsg localFromServiceMsg = paramProtoResp.resp;
    byte[] arrayOfByte = paramProtoResp.resp.getWupBuffer();
    paramProtoReq = (RichProto.RichProtoReq)paramProtoReq.busiData;
    RichProto.RichProtoResp localRichProtoResp = paramProtoReq.resp;
    paramProtoResp = paramProtoResp.statisInfo;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      int i = localFromServiceMsg.getResultCode();
      if ((i == 1002) || (i == 1013)) {
        setResult(-1, 9311, MessageHandler.a(localFromServiceMsg), "", paramProtoResp, localRichProtoResp.resps);
      }
    }
    for (;;)
    {
      RichProtoProc.onBusiProtoResp(paramProtoReq, localRichProtoResp);
      return;
      setResult(-1, 9044, MessageHandler.a(localFromServiceMsg), "", paramProtoResp, localRichProtoResp.resps);
      continue;
      handleRespBody(arrayOfByte, localRichProtoResp, paramProtoResp);
    }
  }
  
  public void sendRichProtoReq(RichProto.RichProtoReq paramRichProtoReq)
  {
    ProtoReqManagerImpl.ProtoReq localProtoReq;
    RichProto.RichProtoReq.ReqCommon localReqCommon;
    if ((paramRichProtoReq != null) && (paramRichProtoReq.reqs != null) && (paramRichProtoReq.protoReqMgr != null))
    {
      localProtoReq = new ProtoReqManagerImpl.ProtoReq();
      if (paramRichProtoReq.reqs.size() != 1) {
        break label134;
      }
      localReqCommon = (RichProto.RichProtoReq.ReqCommon)paramRichProtoReq.reqs.get(0);
      if (localReqCommon.uinType != 0) {
        break label96;
      }
      localProtoReq.ssoCmd = "PttCenterSvr.ShortVideoDownReq";
    }
    for (;;)
    {
      localProtoReq.reqBody = constructReqBody(paramRichProtoReq.reqs);
      localProtoReq.busiData = paramRichProtoReq;
      localProtoReq.callback = this;
      inner_sendToProtoReq(paramRichProtoReq, localProtoReq);
      return;
      label96:
      if ((1 == localReqCommon.uinType) || (3000 == localReqCommon.uinType)) {
        localProtoReq.ssoCmd = "PttCenterSvr.GroupShortVideoDownReq";
      } else {
        localProtoReq.ssoCmd = "PttCenterSvr.ShortVideoDownReq";
      }
    }
    label134:
    throw new RuntimeException("only support one request");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.ShortVideoDownHandler
 * JD-Core Version:    0.7.0.1
 */