package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
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
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    int j = paramList.size();
    int i = 1;
    if (j == 1)
    {
      j = 0;
      paramList = (RichProto.RichProtoReq.C2CPttDownReq)paramList.get(0);
      if ("ftn".equals(paramList.storageSource)) {
        this.busiType = 3;
      } else if ("pttcenter".equals(paramList.storageSource)) {
        this.busiType = 17;
      }
      Object localObject = new cmd0x346.ApplyDownloadReq();
      ((cmd0x346.ApplyDownloadReq)localObject).uint64_uin.set(Long.parseLong(paramList.selfUin));
      ((cmd0x346.ApplyDownloadReq)localObject).bytes_uuid.set(ByteStringMicro.copyFromUtf8(paramList.uuid));
      PBUInt32Field localPBUInt32Field = ((cmd0x346.ApplyDownloadReq)localObject).uint32_owner_type;
      if (!paramList.isSelfSend) {
        i = 2;
      }
      localPBUInt32Field.set(i);
      localReqBody.uint32_cmd.set(1200);
      localReqBody.uint32_seq.set(0);
      localReqBody.uint32_business_id.set(this.busiType);
      localReqBody.uint32_client_type.set(104);
      localReqBody.msg_apply_download_req.set((MessageMicro)localObject);
      if (paramList.uinType != 0)
      {
        localObject = new cmd0x346.ExtensionReq();
        ((cmd0x346.ExtensionReq)localObject).uint64_id.set(3L);
        int k = paramList.uinType;
        i = j;
        if (k != 0)
        {
          if (k != 1020)
          {
            if (k == 9999) {
              break label400;
            }
            if ((k == 10002) || (k == 10004)) {
              break label394;
            }
            if (k == 10009) {
              break label387;
            }
            if (k != 1000)
            {
              if (k == 1001) {
                break label394;
              }
              if (k != 1008) {
                if (k != 1009)
                {
                  i = j;
                  if (k == 1023) {
                    break label403;
                  }
                  i = j;
                  if (k == 1024) {
                    break label403;
                  }
                  i = j;
                }
              }
            }
          }
          switch (k)
          {
          default: 
            i = j;
            break;
          case 1006: 
            i = 102;
            break;
          case 1004: 
            i = 105;
            break;
            i = 103;
            break;
            i = 101;
            break;
            i = 104;
            break;
            label387:
            i = 130;
            break;
            label394:
            i = 100;
            break;
            label400:
            i = 114;
          }
        }
        label403:
        ((cmd0x346.ExtensionReq)localObject).uint64_type.set(i);
        ((cmd0x346.ExtensionReq)localObject).uint32_ptt_format.set(paramList.voiceType);
        ((cmd0x346.ExtensionReq)localObject).uint32_file_type.set(paramList.busiType);
        ((cmd0x346.ExtensionReq)localObject).uint32_is_auto.set(paramList.downType);
        ((cmd0x346.ExtensionReq)localObject).uint32_req_transfer_type.set(2);
        localReqBody.msg_extension_req.set((MessageMicro)localObject);
      }
      else
      {
        localObject = new cmd0x346.ExtensionReq();
        ((cmd0x346.ExtensionReq)localObject).uint32_ptt_format.set(paramList.voiceType);
        ((cmd0x346.ExtensionReq)localObject).uint32_is_auto.set(paramList.downType);
        ((cmd0x346.ExtensionReq)localObject).uint32_req_transfer_type.set(2);
        localReqBody.msg_extension_req.set((MessageMicro)localObject);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("constructReqBody C2CPttDownReq = ");
        ((StringBuilder)localObject).append(paramList.toString());
        QLog.d("Q.richmedia.C2CPttDownHandler", 2, ((StringBuilder)localObject).toString());
      }
      return localReqBody.toByteArray();
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
  
  public void onProtoResp(ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    Object localObject2 = paramProtoResp.resp;
    Object localObject1 = paramProtoResp.resp.getWupBuffer();
    paramProtoReq = (RichProto.RichProtoReq)paramProtoReq.busiData;
    RichProto.RichProtoResp localRichProtoResp = paramProtoReq.resp;
    StatictisInfo localStatictisInfo = paramProtoResp.statisInfo;
    int i;
    if (((FromServiceMsg)localObject2).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject2).getResultCode();
      if ((i != 1002) && (i != 1013))
      {
        localObject1 = BaseMessageHandler.a((FromServiceMsg)localObject2);
        paramProtoResp = ((FromServiceMsg)localObject2).getBusinessFailMsg();
        if (paramProtoResp == null) {
          paramProtoResp = "";
        }
        setResult(-1, 9044, (String)localObject1, paramProtoResp, localStatictisInfo, localRichProtoResp.resps);
      }
      else
      {
        localObject1 = BaseMessageHandler.a((FromServiceMsg)localObject2);
        paramProtoResp = ((FromServiceMsg)localObject2).getBusinessFailMsg();
        if (paramProtoResp == null) {
          paramProtoResp = "";
        }
        setResult(-1, 9311, (String)localObject1, paramProtoResp, localStatictisInfo, localRichProtoResp.resps);
      }
    }
    else
    {
      try
      {
        Object localObject4 = new cmd0x346.RspBody();
        ((cmd0x346.RspBody)localObject4).mergeFrom((byte[])localObject1);
        localObject3 = (cmd0x346.ApplyDownloadRsp)((cmd0x346.RspBody)localObject4).msg_apply_download_rsp.get();
        paramProtoResp = (RichProto.RichProtoResp.C2CPttDownResp)localRichProtoResp.resps.get(0);
        if (paramProtoResp != null)
        {
          paramProtoResp.isSendByQuickHttp = ((Boolean)((FromServiceMsg)localObject2).getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("C2CPttDownHandler.onProtoResp:isSendByQuickHttp=");
            ((StringBuilder)localObject2).append(paramProtoResp.isSendByQuickHttp);
            QLog.e("http_sideway", 2, ((StringBuilder)localObject2).toString());
          }
          i = ((cmd0x346.ApplyDownloadRsp)localObject3).int32_ret_code.get();
          localObject2 = (cmd0x346.ExtensionRsp)((cmd0x346.RspBody)localObject4).msg_extension_rsp.get();
          if (i == 0)
          {
            localObject3 = (cmd0x346.DownloadInfo)((cmd0x346.ApplyDownloadRsp)localObject3).msg_download_info.get();
            if ((localObject3 != null) && (((cmd0x346.DownloadInfo)localObject3).str_download_url.has()))
            {
              paramProtoResp.downloadUrl = ((cmd0x346.DownloadInfo)localObject3).str_download_url.get();
              localObject3 = ((cmd0x346.DownloadInfo)localObject3).rpt_str_downloadip_list.get();
              ServerAddr localServerAddr;
              if ((localObject3 != null) && (((List)localObject3).size() > 0))
              {
                localObject3 = ((List)localObject3).iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  localObject4 = (String)((Iterator)localObject3).next();
                  localServerAddr = new ServerAddr();
                  localServerAddr.mIp = ((String)localObject4);
                  paramProtoResp.mIpList.add(localServerAddr);
                }
              }
              if ((localObject2 != null) && (((cmd0x346.ExtensionRsp)localObject2).server_addr_ipv6_list.has()))
              {
                localObject2 = (cmd0x346.AddrList)((cmd0x346.ExtensionRsp)localObject2).server_addr_ipv6_list.get();
                if (localObject2 != null)
                {
                  localObject3 = ((cmd0x346.AddrList)localObject2).rpt_str_ip.get();
                  i = ((cmd0x346.AddrList)localObject2).uint32_port.get();
                  if ((localObject3 != null) && (((List)localObject3).size() > 0))
                  {
                    localObject3 = ((List)localObject3).iterator();
                    while (((Iterator)localObject3).hasNext())
                    {
                      localObject4 = (String)((Iterator)localObject3).next();
                      localServerAddr = new ServerAddr();
                      localServerAddr.mIp = ((String)localObject4);
                      localServerAddr.port = i;
                      localServerAddr.isIpv6 = true;
                      paramProtoResp.mIpv6List.add(localServerAddr);
                    }
                  }
                  paramProtoResp.domainV4V6 = ((cmd0x346.AddrList)localObject2).rpt_str_domain.get();
                }
              }
              setResult(0, 0, "", "", localStatictisInfo, paramProtoResp);
            }
            else
            {
              throw new Exception("no url");
            }
          }
          else
          {
            if ((localObject2 != null) && (((cmd0x346.ExtensionRsp)localObject2).uint32_allow_retry.get() == 1))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.richmedia.C2CPttDownHandler", 2, "onReceive :c2c ptt server not allow retry");
              }
              paramProtoResp.isAllowRetry = false;
            }
            setResult(-1, -9527, ProcessorReport.getUrlReason(i), "", localStatictisInfo, paramProtoResp);
          }
        }
      }
      catch (Exception paramProtoResp)
      {
        localObject2 = ProcessorReport.getServerReason("P", -9529L);
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramProtoResp.getMessage());
        ((StringBuilder)localObject3).append(" hex:");
        ((StringBuilder)localObject3).append(HexUtil.bytes2HexStr((byte[])localObject1));
        setResult(-1, -9527, (String)localObject2, ((StringBuilder)localObject3).toString(), localStatictisInfo, localRichProtoResp.resps);
      }
    }
    RichProtoProc.onBusiProtoResp(paramProtoReq, localRichProtoResp);
  }
  
  public void sendRichProtoReq(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.reqs != null) && (paramRichProtoReq.protoReqMgr != null))
    {
      ProtoReqManagerImpl.ProtoReq localProtoReq = new ProtoReqManagerImpl.ProtoReq();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.C2CPttDownHandler
 * JD-Core Version:    0.7.0.1
 */