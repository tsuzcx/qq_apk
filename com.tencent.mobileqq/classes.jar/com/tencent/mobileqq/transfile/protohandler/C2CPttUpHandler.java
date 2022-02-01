package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.ReqCommon;>;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;

public class C2CPttUpHandler
  extends BaseHandler
{
  private static int s0x346Seq;
  
  byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> paramList)
  {
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    Object localObject = localReqBody.uint32_cmd;
    int i = 500;
    ((PBUInt32Field)localObject).set(500);
    localObject = localReqBody.uint32_seq;
    int j = s0x346Seq;
    s0x346Seq = j + 1;
    ((PBUInt32Field)localObject).set(j);
    localReqBody.uint32_business_id.set(17);
    localReqBody.uint32_client_type.set(104);
    if (paramList.size() == 1)
    {
      RichProto.RichProtoReq.PttUpReq localPttUpReq = (RichProto.RichProtoReq.PttUpReq)paramList.get(0);
      cmd0x346.ApplyUploadReq localApplyUploadReq = new cmd0x346.ApplyUploadReq();
      localApplyUploadReq.uint64_sender_uin.set(Long.parseLong(localPttUpReq.selfUin));
      try
      {
        localObject = localPttUpReq.peerUin;
        paramList = (List<RichProto.RichProtoReq.ReqCommon>)localObject;
        if (((String)localObject).startsWith("+")) {
          paramList = ((String)localObject).substring(1);
        }
        long l = Long.valueOf(paramList).longValue();
        localApplyUploadReq.uint64_recver_uin.set(l);
      }
      catch (Exception paramList)
      {
        paramList.printStackTrace();
      }
      localApplyUploadReq.uint32_file_type.set(2);
      localApplyUploadReq.str_file_name.set(localPttUpReq.fileName);
      localApplyUploadReq.uint64_file_size.set(localPttUpReq.fileSize);
      localApplyUploadReq.bytes_10m_md5.set(ByteStringMicro.copyFrom(localPttUpReq.md5));
      localReqBody.msg_apply_upload_req.set(localApplyUploadReq);
      paramList = new cmd0x346.ExtensionReq();
      paramList.uint64_id.set(3L);
      paramList.uint32_ptt_format.set(localPttUpReq.voiceType);
      paramList.uint32_ptt_time.set(localPttUpReq.voiceLength);
      j = getHandlerNetType();
      paramList.uint32_net_type.set(j);
      paramList.uint32_voice_type.set(localPttUpReq.audioPanelType);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("C2CPttUp: panel[");
        ((StringBuilder)localObject).append(localPttUpReq.audioPanelType);
        ((StringBuilder)localObject).append("] type[");
        ((StringBuilder)localObject).append(localPttUpReq.voiceType);
        ((StringBuilder)localObject).append("] length[");
        ((StringBuilder)localObject).append(localPttUpReq.voiceLength);
        ((StringBuilder)localObject).append("] size[");
        ((StringBuilder)localObject).append(localPttUpReq.fileSize);
        ((StringBuilder)localObject).append("]");
        QLog.d("RecordParams", 2, ((StringBuilder)localObject).toString());
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("C2CPttUp: net[");
          ((StringBuilder)localObject).append(j);
          ((StringBuilder)localObject).append("]");
          QLog.d("RecordParams", 2, ((StringBuilder)localObject).toString());
        }
      }
      j = localPttUpReq.uinType;
      if (j != 0) {
        if (j != 1020)
        {
          if (j == 9999) {
            break label630;
          }
          if ((j == 10002) || (j == 10004)) {
            break label624;
          }
          if (j == 10009) {
            break label617;
          }
          if (j != 1000)
          {
            if (j == 1001) {
              break label624;
            }
            if (j != 1008) {
              if (j != 1009) {
                if ((j == 1023) || (j == 1024)) {
                  break label647;
                }
              }
            }
          }
        }
      }
      switch (j)
      {
      default: 
        break;
      case 1006: 
        paramList.str_dst_phonenum.set(localPttUpReq.peerUin);
        i = 102;
        break;
      case 1004: 
        i = 105;
        break label649;
        i = 103;
        break label649;
        i = 101;
        break label649;
        i = 104;
        break label649;
        label617:
        i = 130;
        break label649;
        label624:
        i = 100;
        break label649;
        label630:
        i = 114;
        break label649;
        if (localPttUpReq.forceViaOffline) {
          break label649;
        }
      }
      label647:
      i = 0;
      label649:
      paramList.uint64_type.set(i);
      if (localPttUpReq.uinType == 1008) {
        paramList.uint32_file_type.set(3);
      } else if (localPttUpReq.uinType == 9999) {
        paramList.uint32_file_type.set(102);
      }
      localReqBody.msg_extension_req.set(paramList);
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
      RichProto.RichProtoResp.C2CPttUpResp localC2CPttUpResp = new RichProto.RichProtoResp.C2CPttUpResp();
      localRichProtoResp.resps.add(i, localC2CPttUpResp);
      i += 1;
    }
  }
  
  public void onProtoResp(ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    Object localObject2 = paramProtoResp.resp;
    if (localObject2 == null) {
      return;
    }
    byte[] arrayOfByte = paramProtoResp.resp.getWupBuffer();
    RichProto.RichProtoReq localRichProtoReq = (RichProto.RichProtoReq)paramProtoReq.busiData;
    RichProto.RichProtoResp localRichProtoResp = localRichProtoReq.resp;
    StatictisInfo localStatictisInfo = paramProtoResp.statisInfo;
    int i;
    if (((FromServiceMsg)localObject2).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject2).getResultCode();
      if ((i != 1002) && (i != 1013))
      {
        paramProtoReq = BaseMessageHandler.a((FromServiceMsg)localObject2);
        paramProtoResp = ((FromServiceMsg)localObject2).getBusinessFailMsg();
        if (paramProtoResp == null) {
          paramProtoResp = "";
        }
        setResult(-1, 9044, paramProtoReq, paramProtoResp, localStatictisInfo, localRichProtoResp.resps);
      }
      else
      {
        paramProtoReq = BaseMessageHandler.a((FromServiceMsg)localObject2);
        paramProtoResp = ((FromServiceMsg)localObject2).getBusinessFailMsg();
        if (paramProtoResp == null) {
          paramProtoResp = "";
        }
        setResult(-1, 9311, paramProtoReq, paramProtoResp, localStatictisInfo, localRichProtoResp.resps);
      }
    }
    else
    {
      try
      {
        paramProtoResp = new cmd0x346.RspBody();
        paramProtoResp.mergeFrom(arrayOfByte);
        cmd0x346.ApplyUploadRsp localApplyUploadRsp = (cmd0x346.ApplyUploadRsp)paramProtoResp.msg_apply_upload_rsp.get();
        localObject1 = (RichProto.RichProtoResp.C2CPttUpResp)localRichProtoResp.resps.get(0);
        if (localObject1 != null)
        {
          if (((FromServiceMsg)localObject2).getAttributes().containsKey("_attr_send_by_quickHttp")) {
            ((RichProto.RichProtoResp.C2CPttUpResp)localObject1).isSendByQuickHttp = ((Boolean)((FromServiceMsg)localObject2).getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
          }
          if (QLog.isColorLevel())
          {
            paramProtoResp = new StringBuilder();
            paramProtoResp.append("C2CPttUpHandler.onProtoResp:isSendByQuickHttp=");
            paramProtoResp.append(((RichProto.RichProtoResp.C2CPttUpResp)localObject1).isSendByQuickHttp);
            QLog.e("http_sideway", 2, paramProtoResp.toString());
          }
          i = localApplyUploadRsp.int32_ret_code.get();
          if (i == 0)
          {
            ((RichProto.RichProtoResp.C2CPttUpResp)localObject1).uuid = localApplyUploadRsp.bytes_uuid.get().toStringUtf8();
            if ((localApplyUploadRsp.bool_file_exist.has()) && (localApplyUploadRsp.bool_file_exist.get()))
            {
              ((RichProto.RichProtoResp.C2CPttUpResp)localObject1).isExist = true;
            }
            else
            {
              if (localApplyUploadRsp.uint32_pack_size.has()) {
                ((RichProto.RichProtoResp.C2CPttUpResp)localObject1).blockSize = localApplyUploadRsp.uint32_pack_size.get();
              }
              localObject2 = HexUtil.bytes2HexStr(localApplyUploadRsp.bytes_upload_key.get().toByteArray());
              ((RichProto.RichProtoResp.C2CPttUpResp)localObject1).mUkey = ((String)localObject2);
              paramProtoReq = localApplyUploadRsp.str_upload_ip.get();
              paramProtoResp = paramProtoReq;
              if (paramProtoReq == null) {
                paramProtoResp = localApplyUploadRsp.str_upload_domain.get();
              }
              if ((localObject2 != null) && (paramProtoResp != null))
              {
                paramProtoResp = localApplyUploadRsp.rpt_str_uploadip_list.get();
                if ((paramProtoResp != null) && (paramProtoResp.size() > 0))
                {
                  paramProtoResp = paramProtoResp.iterator();
                  while (paramProtoResp.hasNext())
                  {
                    paramProtoReq = (String)paramProtoResp.next();
                    localObject2 = new ServerAddr();
                    ((ServerAddr)localObject2).mIp = paramProtoReq;
                    ((RichProto.RichProtoResp.C2CPttUpResp)localObject1).ipList.add(localObject2);
                  }
                }
                setResult(0, 0, "", "", localStatictisInfo, (RichProto.RichProtoResp.RespCommon)localObject1);
              }
              else
              {
                throw new Exception("ukey or ip missing");
              }
            }
          }
          else
          {
            setResult(-1, -9527, ProcessorReport.getUrlReason(i), "", localStatictisInfo, (RichProto.RichProtoResp.RespCommon)localObject1);
          }
        }
      }
      catch (Exception paramProtoResp)
      {
        paramProtoReq = ProcessorReport.getServerReason("P", -9529L);
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramProtoResp.getMessage());
        ((StringBuilder)localObject1).append(" hex:");
        ((StringBuilder)localObject1).append(HexUtil.bytes2HexStr(arrayOfByte));
        setResult(-1, -9527, paramProtoReq, ((StringBuilder)localObject1).toString(), localStatictisInfo, localRichProtoResp.resps);
      }
    }
    RichProtoProc.onBusiProtoResp(localRichProtoReq, localRichProtoResp);
  }
  
  public void sendRichProtoReq(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.reqs != null) && (paramRichProtoReq.protoReqMgr != null))
    {
      ProtoReqManagerImpl.ProtoReq localProtoReq = new ProtoReqManagerImpl.ProtoReq();
      localProtoReq.ssoCmd = "PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500";
      localProtoReq.reqBody = constructReqBody(paramRichProtoReq.reqs);
      localProtoReq.busiData = paramRichProtoReq;
      localProtoReq.callback = this;
      inner_sendToProtoReq(paramRichProtoReq, localProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.C2CPttUpHandler
 * JD-Core Version:    0.7.0.1
 */