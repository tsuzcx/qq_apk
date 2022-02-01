package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
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
          if (str.startsWith("https://")) {
            paramShortVideoDownResp.mIsHttps = true;
          } else {
            paramShortVideoDownResp.mIsHttps = false;
          }
        }
        catch (Exception localException)
        {
          QLog.e("Q.richmedia.ShortVideoDownHandler", 1, "parseSrvAddlist err.", localException);
        }
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
      if (paramList.chatType == 0) {
        localPttShortVideoDownloadReq.uint64_fromuin.set(Long.parseLong(paramList.peerUin));
      } else {
        localPttShortVideoDownloadReq.uint64_fromuin.set(Long.parseLong(paramList.secondUin));
      }
      localPttShortVideoDownloadReq.uint32_client_type.set(paramList.clientType);
      localPttShortVideoDownloadReq.str_fileid.set(paramList.fileId);
      if (paramList.troopUin != null) {
        localPttShortVideoDownloadReq.uint64_group_code.set(Long.parseLong(paramList.troopUin));
      } else {
        localPttShortVideoDownloadReq.uint64_group_code.set(0L);
      }
      localPttShortVideoDownloadReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramList.md5));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("download md5 = ");
        ((StringBuilder)localObject).append(paramList.md5);
        QLog.d("Q.richmedia.ShortVideoDownHandler", 2, ((StringBuilder)localObject).toString());
      }
      localPttShortVideoDownloadReq.uint32_agent_type.set(paramList.agentType);
      localPttShortVideoDownloadReq.uint32_business_type.set(paramList.busiType);
      localPttShortVideoDownloadReq.uint32_flag_support_large_size.set(1);
      localPttShortVideoDownloadReq.uint32_flag_client_quic_proto_enable.set(1);
      localPttShortVideoDownloadReq.uint32_file_type.set(paramList.fileType);
      localPttShortVideoDownloadReq.uint32_down_type.set(paramList.downType);
      localPttShortVideoDownloadReq.uint32_scene_type.set(paramList.sceneType);
      localPttShortVideoDownloadReq.uint32_need_inner_addr.set(0);
      if (paramList.busiType == 0) {
        localPttShortVideoDownloadReq.uint32_req_transfer_type.set(1);
      } else {
        localPttShortVideoDownloadReq.uint32_req_transfer_type.set(2);
      }
      localPttShortVideoDownloadReq.uint32_req_host_type.set(11);
      Object localObject = new PttShortVideo.ExtensionReq();
      ((PttShortVideo.ExtensionReq)localObject).uint32_sub_busi_type.set(paramList.subBusiType);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("constructReqBody ShortVideoDownReq = ");
        localStringBuilder.append(paramList.toString());
        QLog.d("Q.richmedia.ShortVideoDownHandler", 2, localStringBuilder.toString());
      }
      localReqBody.uint32_cmd.set(400);
      localReqBody.uint32_seq.set(paramList.seq);
      localReqBody.msg_PttShortVideoDownload_Req.set(localPttShortVideoDownloadReq);
      localReqBody.rpt_msg_extension_req.add((MessageMicro)localObject);
      return localReqBody.toByteArray();
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
        if ((localPttShortVideoAddr.rpt_str_domain.has()) && (localPttShortVideoAddr.rpt_str_domain.size() > 0)) {
          paramPttShortVideoDownloadResp = (String)localPttShortVideoAddr.rpt_str_domain.get(0);
        } else {
          paramPttShortVideoDownloadResp = "";
        }
        Object localObject = paramPttShortVideoDownloadResp;
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
    try
    {
      PttShortVideo.RspBody localRspBody = new PttShortVideo.RspBody();
      localRspBody.mergeFrom(paramArrayOfByte);
      localObject1 = (PttShortVideo.PttShortVideoDownloadResp)localRspBody.msg_PttShortVideoDownload_Resp.get();
      localObject2 = (RichProto.RichProtoResp.ShortVideoDownResp)paramRichProtoResp.resps.get(0);
      int i = ((PttShortVideo.PttShortVideoDownloadResp)localObject1).int32_ret_code.get();
      if (i == 0)
      {
        ((RichProto.RichProtoResp.ShortVideoDownResp)localObject2).mUkey = HexUtil.bytes2HexStr(((PttShortVideo.PttShortVideoDownloadResp)localObject1).bytes_downloadkey.get().toByteArray());
        ((RichProto.RichProtoResp.ShortVideoDownResp)localObject2).md5 = ((PttShortVideo.PttShortVideoDownloadResp)localObject1).bytes_file_md5.get().toByteArray();
        handleAddr((RichProto.RichProtoResp.ShortVideoDownResp)localObject2, (PttShortVideo.PttShortVideoDownloadResp)localObject1);
        handleSupportQuic((RichProto.RichProtoResp.ShortVideoDownResp)localObject2, (PttShortVideo.PttShortVideoDownloadResp)localObject1);
        setResult(0, 0, "", "", paramStatictisInfo, (RichProto.RichProtoResp.RespCommon)localObject2);
        return;
      }
      if (i == -5100026) {
        setResult(-1, -5100026, ProcessorReport.getUrlReason(i), "", paramStatictisInfo, (RichProto.RichProtoResp.RespCommon)localObject2);
      } else if (i == -5100528) {
        setResult(-1, -5100528, ProcessorReport.getUrlReason(i), "", paramStatictisInfo, (RichProto.RichProtoResp.RespCommon)localObject2);
      } else {
        setResult(-1, -9527, ProcessorReport.getUrlReason(i), "", paramStatictisInfo, (RichProto.RichProtoResp.RespCommon)localObject2);
      }
      if (localRspBody.uint32_allow_retry.get() == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ShortVideoDownHandler", 2, "onProtoResp : shortVideo server not allow retry");
        }
        ((RichProto.RichProtoResp.ShortVideoDownResp)localObject2).isAllowRetry = false;
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject1 = ProcessorReport.getServerReason("P", -9529L);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localException.getMessage());
      ((StringBuilder)localObject2).append(" hex:");
      ((StringBuilder)localObject2).append(HexUtil.bytes2HexStr(paramArrayOfByte));
      setResult(-1, -9527, (String)localObject1, ((StringBuilder)localObject2).toString(), paramStatictisInfo, paramRichProtoResp.resps);
    }
  }
  
  public void handleSupportQuic(RichProto.RichProtoResp.ShortVideoDownResp paramShortVideoDownResp, PttShortVideo.PttShortVideoDownloadResp paramPttShortVideoDownloadResp)
  {
    boolean bool1 = paramPttShortVideoDownloadResp.uint32_flag_server_quic_proto_enable.has();
    boolean bool4 = true;
    boolean bool2;
    Object localObject;
    if (bool1)
    {
      if (paramPttShortVideoDownloadResp.uint32_flag_server_quic_proto_enable.get() == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("quic_proto_enable : ");
        ((StringBuilder)localObject).append(paramPttShortVideoDownloadResp.uint32_flag_server_quic_proto_enable.get());
        QLog.d("Q.richmedia.ShortVideoDownHandler", 2, ((StringBuilder)localObject).toString());
        bool1 = bool2;
      }
    }
    else
    {
      bool1 = false;
    }
    boolean bool3 = bool1;
    if (paramPttShortVideoDownloadResp.bytes_server_quic_para.has())
    {
      localObject = paramPttShortVideoDownloadResp.bytes_server_quic_para.get();
      paramPttShortVideoDownloadResp = new PttShortVideo.QuicParameter();
      bool2 = bool1;
    }
    for (;;)
    {
      try
      {
        paramPttShortVideoDownloadResp.mergeFrom(((ByteStringMicro)localObject).toByteArray());
        if (!bool1) {
          break label447;
        }
        bool2 = bool1;
        if (paramPttShortVideoDownloadResp.uint32_enable_quic.get() != 1) {
          break label447;
        }
        bool1 = true;
        bool2 = bool1;
        if (paramPttShortVideoDownloadResp.uint32_encryption_ver.has())
        {
          bool2 = bool1;
          int i = paramPttShortVideoDownloadResp.uint32_encryption_ver.get();
          if (i != 1) {
            break label453;
          }
          bool3 = bool4;
          bool2 = bool1;
          paramShortVideoDownResp.mIsQuicEncryption = bool3;
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            bool2 = bool1;
            localObject = new StringBuilder();
            bool2 = bool1;
            ((StringBuilder)localObject).append("encryption_ver : ");
            bool2 = bool1;
            ((StringBuilder)localObject).append(i);
            bool2 = bool1;
            QLog.d("Q.richmedia.ShortVideoDownHandler", 2, ((StringBuilder)localObject).toString());
          }
        }
        bool2 = bool1;
        bool3 = bool1;
        if (paramPttShortVideoDownloadResp.uint32_fec_ver.has())
        {
          bool2 = bool1;
          paramShortVideoDownResp.mQuicFec = paramPttShortVideoDownloadResp.uint32_fec_ver.get();
          bool2 = bool1;
          bool3 = bool1;
          if (QLog.isColorLevel())
          {
            bool2 = bool1;
            paramPttShortVideoDownloadResp = new StringBuilder();
            bool2 = bool1;
            paramPttShortVideoDownloadResp.append("fec_ver : ");
            bool2 = bool1;
            paramPttShortVideoDownloadResp.append(paramShortVideoDownResp.mQuicFec);
            bool2 = bool1;
            QLog.d("Q.richmedia.ShortVideoDownHandler", 2, paramPttShortVideoDownloadResp.toString());
            bool3 = bool1;
          }
        }
      }
      catch (Exception paramPttShortVideoDownloadResp)
      {
        QLog.e("Q.richmedia.ShortVideoDownHandler", 4, paramPttShortVideoDownloadResp, new Object[0]);
        bool3 = bool2;
      }
      paramShortVideoDownResp.mIsSupportQuic = bool3;
      if (QLog.isColorLevel())
      {
        paramShortVideoDownResp = new StringBuilder();
        paramShortVideoDownResp.append("supportQuic: ");
        paramShortVideoDownResp.append(bool3);
        QLog.d("Q.richmedia.ShortVideoDownHandler", 2, paramShortVideoDownResp.toString());
      }
      return;
      label447:
      bool1 = false;
      continue;
      label453:
      bool3 = false;
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
      if ((i != 1002) && (i != 1013)) {
        setResult(-1, 9044, BaseMessageHandler.a(localFromServiceMsg), "", paramProtoResp, localRichProtoResp.resps);
      } else {
        setResult(-1, 9311, BaseMessageHandler.a(localFromServiceMsg), "", paramProtoResp, localRichProtoResp.resps);
      }
    }
    else
    {
      handleRespBody(arrayOfByte, localRichProtoResp, paramProtoResp);
    }
    RichProtoProc.onBusiProtoResp(paramProtoReq, localRichProtoResp);
  }
  
  public void sendRichProtoReq(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.reqs != null) && (paramRichProtoReq.protoReqMgr != null))
    {
      ProtoReqManagerImpl.ProtoReq localProtoReq = new ProtoReqManagerImpl.ProtoReq();
      if (paramRichProtoReq.reqs.size() == 1)
      {
        RichProto.RichProtoReq.ReqCommon localReqCommon = (RichProto.RichProtoReq.ReqCommon)paramRichProtoReq.reqs.get(0);
        if (localReqCommon.uinType == 0) {
          localProtoReq.ssoCmd = "PttCenterSvr.ShortVideoDownReq";
        } else if ((1 != localReqCommon.uinType) && (3000 != localReqCommon.uinType) && (10014 != localReqCommon.uinType)) {
          localProtoReq.ssoCmd = "PttCenterSvr.ShortVideoDownReq";
        } else {
          localProtoReq.ssoCmd = "PttCenterSvr.GroupShortVideoDownReq";
        }
        localProtoReq.reqBody = constructReqBody(paramRichProtoReq.reqs);
        localProtoReq.busiData = paramRichProtoReq;
        localProtoReq.callback = this;
        inner_sendToProtoReq(paramRichProtoReq, localProtoReq);
        return;
      }
      throw new RuntimeException("only support one request");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.ShortVideoDownHandler
 * JD-Core Version:    0.7.0.1
 */