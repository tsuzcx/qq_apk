package com.tencent.mobileqq.transfile.protohandler;

import anza;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x346.cmd0x346.AddrList;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadInfo;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;

public class C2CPttDownHandler
  extends BaseHandler
{
  public static final String TAG = "Q.richmedia.C2CPttDownHandler";
  int busiType = 17;
  
  byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> paramList)
  {
    int i = 1;
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    if (paramList.size() == 1)
    {
      paramList = (RichProto.RichProtoReq.C2CPttDownReq)paramList.get(0);
      Object localObject;
      if ("ftn".equals(paramList.storageSource))
      {
        this.busiType = 3;
        localObject = new cmd0x346.ApplyDownloadReq();
        ((cmd0x346.ApplyDownloadReq)localObject).uint64_uin.set(Long.parseLong(paramList.selfUin));
        ((cmd0x346.ApplyDownloadReq)localObject).bytes_uuid.set(ByteStringMicro.copyFromUtf8(paramList.uuid));
        PBUInt32Field localPBUInt32Field = ((cmd0x346.ApplyDownloadReq)localObject).uint32_owner_type;
        if (!paramList.isSelfSend) {
          break label442;
        }
        label101:
        localPBUInt32Field.set(i);
        localReqBody.uint32_cmd.set(1200);
        localReqBody.uint32_seq.set(0);
        localReqBody.uint32_business_id.set(this.busiType);
        localReqBody.uint32_client_type.set(104);
        localReqBody.msg_apply_download_req.set((MessageMicro)localObject);
        if (paramList.uinType == 0) {
          break label522;
        }
        localObject = new cmd0x346.ExtensionReq();
        ((cmd0x346.ExtensionReq)localObject).uint64_id.set(3L);
        switch (paramList.uinType)
        {
        default: 
          i = 0;
          label318:
          ((cmd0x346.ExtensionReq)localObject).uint64_type.set(i);
          ((cmd0x346.ExtensionReq)localObject).uint32_ptt_format.set(paramList.voiceType);
          ((cmd0x346.ExtensionReq)localObject).uint32_file_type.set(paramList.busiType);
          ((cmd0x346.ExtensionReq)localObject).uint32_is_auto.set(paramList.downType);
          ((cmd0x346.ExtensionReq)localObject).uint32_req_transfer_type.set(2);
          localReqBody.msg_extension_req.set((MessageMicro)localObject);
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.C2CPttDownHandler", 2, "constructReqBody C2CPttDownReq = " + paramList.toString());
        }
        return localReqBody.toByteArray();
        if (!"pttcenter".equals(paramList.storageSource)) {
          break;
        }
        this.busiType = 17;
        break;
        label442:
        i = 2;
        break label101;
        i = 0;
        break label318;
        i = 102;
        break label318;
        i = 104;
        break label318;
        i = 104;
        break label318;
        i = 105;
        break label318;
        i = 0;
        break label318;
        i = 0;
        break label318;
        i = 0;
        break label318;
        i = 101;
        break label318;
        i = 103;
        break label318;
        i = 100;
        break label318;
        i = 114;
        break label318;
        i = 130;
        break label318;
        label522:
        localObject = new cmd0x346.ExtensionReq();
        ((cmd0x346.ExtensionReq)localObject).uint32_ptt_format.set(paramList.voiceType);
        ((cmd0x346.ExtensionReq)localObject).uint32_is_auto.set(paramList.downType);
        ((cmd0x346.ExtensionReq)localObject).uint32_req_transfer_type.set(2);
        localReqBody.msg_extension_req.set((MessageMicro)localObject);
      }
    }
    throw new RuntimeException("only support one request");
  }
  
  void initResps(RichProto.RichProtoReq paramRichProtoReq)
  {
    RichProto.RichProtoResp localRichProtoResp = paramRichProtoReq.resp;
    localRichProtoResp.resps.clear();
    int i = 0;
    while (i < paramRichProtoReq.reqs.size())
    {
      RichProto.RichProtoResp.C2CPttDownResp localC2CPttDownResp = new RichProto.RichProtoResp.C2CPttDownResp();
      localRichProtoResp.resps.add(i, localC2CPttDownResp);
      i += 1;
    }
  }
  
  public void onProtoResp(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    Object localObject2 = paramProtoResp.resp;
    Object localObject1 = paramProtoResp.resp.getWupBuffer();
    RichProto.RichProtoReq localRichProtoReq = (RichProto.RichProtoReq)paramProtoReq.busiData;
    RichProto.RichProtoResp localRichProtoResp = localRichProtoReq.resp;
    anza localanza = paramProtoResp.statisInfo;
    int i;
    if (((FromServiceMsg)localObject2).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject2).getResultCode();
      if ((i == 1002) || (i == 1013))
      {
        localObject1 = MessageHandler.a((FromServiceMsg)localObject2);
        paramProtoReq = ((FromServiceMsg)localObject2).getBusinessFailMsg();
        paramProtoResp = paramProtoReq;
        if (paramProtoReq == null) {
          paramProtoResp = "";
        }
        setResult(-1, 9311, (String)localObject1, paramProtoResp, localanza, localRichProtoResp.resps);
      }
    }
    for (;;)
    {
      RichProtoProc.onBusiProtoResp(localRichProtoReq, localRichProtoResp);
      return;
      localObject1 = MessageHandler.a((FromServiceMsg)localObject2);
      paramProtoReq = ((FromServiceMsg)localObject2).getBusinessFailMsg();
      paramProtoResp = paramProtoReq;
      if (paramProtoReq == null) {
        paramProtoResp = "";
      }
      setResult(-1, 9044, (String)localObject1, paramProtoResp, localanza, localRichProtoResp.resps);
      continue;
      Object localObject3;
      ServerAddr localServerAddr;
      try
      {
        paramProtoReq = new cmd0x346.RspBody();
        paramProtoReq.mergeFrom((byte[])localObject1);
        localObject3 = (cmd0x346.ApplyDownloadRsp)paramProtoReq.msg_apply_download_rsp.get();
        paramProtoResp = (RichProto.RichProtoResp.C2CPttDownResp)localRichProtoResp.resps.get(0);
        if (paramProtoResp == null) {
          continue;
        }
        paramProtoResp.isSendByQuickHttp = ((Boolean)((FromServiceMsg)localObject2).getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "C2CPttDownHandler.onProtoResp:isSendByQuickHttp=" + paramProtoResp.isSendByQuickHttp);
        }
        i = ((cmd0x346.ApplyDownloadRsp)localObject3).int32_ret_code.get();
        paramProtoReq = (cmd0x346.ExtensionRsp)paramProtoReq.msg_extension_rsp.get();
        if (i != 0) {
          break label647;
        }
        localObject2 = (cmd0x346.DownloadInfo)((cmd0x346.ApplyDownloadRsp)localObject3).msg_download_info.get();
        if ((localObject2 != null) && (((cmd0x346.DownloadInfo)localObject2).str_download_url.has()))
        {
          paramProtoResp.downloadUrl = ((cmd0x346.DownloadInfo)localObject2).str_download_url.get();
          localObject2 = ((cmd0x346.DownloadInfo)localObject2).rpt_str_downloadip_list.get();
          if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
            break label485;
          }
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            localServerAddr = new ServerAddr();
            localServerAddr.mIp = ((String)localObject3);
            paramProtoResp.mIpList.add(localServerAddr);
          }
        }
      }
      catch (Exception paramProtoResp)
      {
        setResult(-1, -9527, BaseTransProcessor.getServerReason("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr((byte[])localObject1), localanza, localRichProtoResp.resps);
      }
      throw new Exception("no url");
      label485:
      if ((paramProtoReq != null) && (paramProtoReq.server_addr_ipv6_list.has()))
      {
        paramProtoReq = (cmd0x346.AddrList)paramProtoReq.server_addr_ipv6_list.get();
        if (paramProtoReq != null)
        {
          localObject2 = paramProtoReq.rpt_str_ip.get();
          i = paramProtoReq.uint32_port.get();
          if ((localObject2 != null) && (((List)localObject2).size() > 0))
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (String)((Iterator)localObject2).next();
              localServerAddr = new ServerAddr();
              localServerAddr.mIp = ((String)localObject3);
              localServerAddr.port = i;
              localServerAddr.isIpv6 = true;
              paramProtoResp.mIpv6List.add(localServerAddr);
            }
          }
          paramProtoResp.domainV4V6 = paramProtoReq.rpt_str_domain.get();
        }
      }
      setResult(0, 0, "", "", localanza, paramProtoResp);
      continue;
      label647:
      if ((paramProtoReq != null) && (paramProtoReq.uint32_allow_retry.get() == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.C2CPttDownHandler", 2, "onReceive :c2c ptt server not allow retry");
        }
        paramProtoResp.isAllowRetry = false;
      }
      setResult(-1, -9527, BaseTransProcessor.getUrlReason(i), "", localanza, paramProtoResp);
    }
  }
  
  public void sendRichProtoReq(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.reqs != null) && (paramRichProtoReq.protoReqMgr != null))
    {
      ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
      localProtoReq.reqBody = constructReqBody(paramRichProtoReq.reqs);
      localProtoReq.busiData = paramRichProtoReq;
      localProtoReq.ssoCmd = "PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_DOWNLOAD-1200";
      if (this.busiType == 3) {
        localProtoReq.ssoCmd = "OfflineFilleHandleSvr.pb_ftnPtt_CMD_REQ_APPLY_DOWNLOAD-1200";
      }
      localProtoReq.callback = this;
      inner_sendToProtoReq(paramRichProtoReq, localProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.C2CPttDownHandler
 * JD-Core Version:    0.7.0.1
 */