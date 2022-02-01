package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.ArrayList;
import java.util.List;
import tencent.im.longconn.multimsg.MultiMsg.MultiMsgApplyUpReq;
import tencent.im.longconn.multimsg.MultiMsg.MultiMsgApplyUpRsp;
import tencent.im.longconn.multimsg.MultiMsg.ReqBody;
import tencent.im.longconn.multimsg.MultiMsg.RspBody;

public class MultiMsgUpHandler
  extends BaseHandler
{
  int mReqNetType;
  
  private void addOne(int paramInt, RichProto.RichProtoReq.ReqCommon paramReqCommon, MultiMsg.ReqBody paramReqBody)
  {
    paramReqCommon = (RichProto.RichProtoReq.MultiMsgUpReq)paramReqCommon;
    MultiMsg.MultiMsgApplyUpReq localMultiMsgApplyUpReq = new MultiMsg.MultiMsgApplyUpReq();
    localMultiMsgApplyUpReq.setHasFlag(true);
    localMultiMsgApplyUpReq.uint64_dst_uin.set(Long.valueOf(paramReqCommon.peerUin).longValue());
    localMultiMsgApplyUpReq.uint64_msg_size.set(paramReqCommon.size);
    localMultiMsgApplyUpReq.bytes_msg_md5.set(ByteStringMicro.copyFrom(paramReqCommon.md5));
    localMultiMsgApplyUpReq.uint32_msg_type.set(convertMsgType(paramReqCommon.uinType));
    localMultiMsgApplyUpReq.uint32_apply_id.set(0);
    paramReqBody.rpt_multimsg_applyup_req.add(localMultiMsgApplyUpReq);
    if (paramReqCommon.multiMsgType == 1) {
      paramReqBody.uint32_bu_type.set(1);
    }
    if (paramReqCommon.multiMsgType == 0) {
      paramReqBody.uint32_bu_type.set(2);
    }
  }
  
  private byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> paramList)
  {
    int j = NetworkCenter.getInstance().getNetType();
    this.mReqNetType = j;
    int i = 3;
    if (j != 1) {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 4) {
            i = 255;
          } else {
            i = 8;
          }
        }
        else {
          i = 7;
        }
      }
      else {
        i = 6;
      }
    }
    Object localObject = NetworkCenter.getInstance().getApnType();
    j = i;
    if (localObject != null)
    {
      j = i;
      if (((String)localObject).contains("wap")) {
        j = 5;
      }
    }
    localObject = new MultiMsg.ReqBody();
    ((MultiMsg.ReqBody)localObject).setHasFlag(true);
    ((MultiMsg.ReqBody)localObject).uint32_subcmd.set(1);
    ((MultiMsg.ReqBody)localObject).uint32_term_type.set(5);
    ((MultiMsg.ReqBody)localObject).uint32_platform_type.set(9);
    ((MultiMsg.ReqBody)localObject).uint32_net_type.set(j);
    ((MultiMsg.ReqBody)localObject).bytes_build_ver.set(ByteStringMicro.copyFromUtf8(TransFileUtil.getVersionCode()));
    PBUInt32Field localPBUInt32Field = ((MultiMsg.ReqBody)localObject).uint32_bu_type;
    i = 0;
    localPBUInt32Field.set(0);
    while (i < paramList.size())
    {
      addOne(i, (RichProto.RichProtoReq.ReqCommon)paramList.get(i), (MultiMsg.ReqBody)localObject);
      i += 1;
    }
    return ((MultiMsg.ReqBody)localObject).toByteArray();
  }
  
  public static int convertMsgType(int paramInt)
  {
    int j = 3;
    int i = j;
    if (paramInt != 1)
    {
      i = j;
      if (paramInt != 3000)
      {
        if (paramInt != 1039)
        {
          if (paramInt != 1040) {
            return 1;
          }
          return 15;
        }
        i = 255;
      }
    }
    return i;
  }
  
  void handleSSORespError(FromServiceMsg paramFromServiceMsg, RichProto.RichProtoResp paramRichProtoResp, StatictisInfo paramStatictisInfo, int paramInt)
  {
    if ((paramInt != 1002) && (paramInt != 1013))
    {
      setResult(-1, 9044, BaseMessageHandler.a(paramFromServiceMsg), "", paramStatictisInfo, paramRichProtoResp.resps);
      return;
    }
    setResult(-1, 9311, BaseMessageHandler.a(paramFromServiceMsg), "", paramStatictisInfo, paramRichProtoResp.resps);
  }
  
  void initResps(RichProto.RichProtoReq paramRichProtoReq)
  {
    RichProto.RichProtoResp localRichProtoResp = paramRichProtoReq.resp;
    localRichProtoResp.resps.clear();
    int i = 0;
    while (i < paramRichProtoReq.reqs.size())
    {
      RichProto.RichProtoResp.MultiMsgUpResp localMultiMsgUpResp = new RichProto.RichProtoResp.MultiMsgUpResp();
      localRichProtoResp.resps.add(i, localMultiMsgUpResp);
      i += 1;
    }
  }
  
  public void onProtoResp(ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    Object localObject1 = paramProtoResp.resp;
    byte[] arrayOfByte1 = paramProtoResp.resp.getWupBuffer();
    RichProto.RichProtoReq localRichProtoReq = (RichProto.RichProtoReq)paramProtoReq.busiData;
    RichProto.RichProtoResp localRichProtoResp = localRichProtoReq.resp;
    StatictisInfo localStatictisInfo = paramProtoResp.statisInfo;
    if (((FromServiceMsg)localObject1).getResultCode() != 1000) {
      handleSSORespError((FromServiceMsg)localObject1, localRichProtoResp, localStatictisInfo, ((FromServiceMsg)localObject1).getResultCode());
    } else {
      try
      {
        List localList = ((MultiMsg.RspBody)new MultiMsg.RspBody().mergeFrom(arrayOfByte1)).rpt_multimsg_applyup_rsp.get();
        int i = 0;
        while (i < localList.size())
        {
          MultiMsg.MultiMsgApplyUpRsp localMultiMsgApplyUpRsp = (MultiMsg.MultiMsgApplyUpRsp)localList.get(i);
          RichProto.RichProtoResp.MultiMsgUpResp localMultiMsgUpResp = (RichProto.RichProtoResp.MultiMsgUpResp)localRichProtoResp.resps.get(i);
          int j = localMultiMsgApplyUpRsp.uint32_result.get();
          if (j == 0)
          {
            paramProtoResp = localMultiMsgApplyUpRsp.bytes_msg_resid.get().toByteArray();
            localObject1 = localMultiMsgApplyUpRsp.bytes_msg_ukey.get().toByteArray();
            Object localObject2 = localMultiMsgApplyUpRsp.bytes_msg_key.get().toByteArray();
            byte[] arrayOfByte2 = localMultiMsgApplyUpRsp.bytes_msg_sig.get().toByteArray();
            localMultiMsgUpResp.resId = paramProtoResp;
            localMultiMsgUpResp.ukey = ((byte[])localObject1);
            localMultiMsgUpResp.msgKey = ((byte[])localObject2);
            localMultiMsgUpResp.msgSig = arrayOfByte2;
            localObject1 = localMultiMsgApplyUpRsp.rpt_uint32_up_ip.get();
            paramProtoResp = localMultiMsgApplyUpRsp.rpt_uint32_up_port.get();
            j = 0;
            while (j < ((List)localObject1).size())
            {
              long l1 = ((Integer)((List)localObject1).get(j)).intValue();
              long l2 = ((Integer)paramProtoResp.get(j)).intValue();
              localObject2 = new ServerAddr();
              ((ServerAddr)localObject2).mIp = PkgTools.int2IPNet(l1 & 0xFFFFFFFF);
              ((ServerAddr)localObject2).port = ((int)l2);
              localMultiMsgUpResp.ipList.add(j, localObject2);
              j += 1;
            }
            localMultiMsgUpResp.blockSize = ((int)localMultiMsgApplyUpRsp.uint64_block_size.get());
            localMultiMsgUpResp.transferedSize = ((int)localMultiMsgApplyUpRsp.uint64_up_offset.get());
            setResult(0, 0, "", "", localStatictisInfo, localMultiMsgUpResp);
          }
          else
          {
            if (shouldRetryByRetCodeForGroup(j))
            {
              this.mReqUrlCount += 1;
              if (this.mReqUrlCount < 2)
              {
                localRichProtoReq.protoReqMgr.sendProtoReq(paramProtoReq);
                return;
              }
            }
            setResult(-1, -9527, ProcessorReport.getUrlReason(j), "", localStatictisInfo, localMultiMsgUpResp);
          }
          i += 1;
        }
        RichProtoProc.onBusiProtoResp(localRichProtoReq, localRichProtoResp);
      }
      catch (Exception paramProtoResp)
      {
        paramProtoReq = ProcessorReport.getServerReason("P", -9529L);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramProtoResp.getMessage());
        ((StringBuilder)localObject1).append(" hex:");
        ((StringBuilder)localObject1).append(HexUtil.bytes2HexStr(arrayOfByte1));
        setResult(-1, -9527, paramProtoReq, ((StringBuilder)localObject1).toString(), localStatictisInfo, localRichProtoResp.resps);
      }
    }
  }
  
  public void sendRichProtoReq(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.reqs != null) && (paramRichProtoReq.protoReqMgr != null))
    {
      ProtoReqManagerImpl.ProtoReq localProtoReq = new ProtoReqManagerImpl.ProtoReq();
      localProtoReq.ssoCmd = "MultiMsg.ApplyUp";
      localProtoReq.reqBody = constructReqBody(paramRichProtoReq.reqs);
      localProtoReq.busiData = paramRichProtoReq;
      localProtoReq.callback = this;
      inner_sendToProtoReq(paramRichProtoReq, localProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.MultiMsgUpHandler
 * JD-Core Version:    0.7.0.1
 */