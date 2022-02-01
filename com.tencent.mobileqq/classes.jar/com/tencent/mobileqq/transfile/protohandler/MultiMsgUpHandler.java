package com.tencent.mobileqq.transfile.protohandler;

import amwm;
import awct;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.ServerAddr;
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
    if ((paramReqCommon.multiMsgType == 0) && (awct.b)) {
      paramReqBody.uint32_bu_type.set(2);
    }
  }
  
  private byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> paramList)
  {
    int i = NetworkCenter.getInstance().getNetType();
    this.mReqNetType = i;
    switch (i)
    {
    default: 
      i = 255;
    }
    Object localObject;
    for (;;)
    {
      localObject = NetworkCenter.getInstance().getApnType();
      int j = i;
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
      ((MultiMsg.ReqBody)localObject).bytes_build_ver.set(ByteStringMicro.copyFromUtf8(RichMediaUtil.getVersionCode()));
      ((MultiMsg.ReqBody)localObject).uint32_bu_type.set(0);
      i = 0;
      while (i < paramList.size())
      {
        addOne(i, (RichProto.RichProtoReq.ReqCommon)paramList.get(i), (MultiMsg.ReqBody)localObject);
        i += 1;
      }
      i = 3;
      continue;
      i = 6;
      continue;
      i = 7;
      continue;
      i = 8;
    }
    return ((MultiMsg.ReqBody)localObject).toByteArray();
  }
  
  public static int convertMsgType(int paramInt)
  {
    int i = 3;
    switch (paramInt)
    {
    default: 
      i = 1;
    case 1: 
    case 3000: 
      return i;
    case 1040: 
      return 15;
    }
    return 255;
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
  
  public void onProtoResp(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    localObject1 = paramProtoResp.resp;
    byte[] arrayOfByte1 = paramProtoResp.resp.getWupBuffer();
    RichProto.RichProtoReq localRichProtoReq = (RichProto.RichProtoReq)paramProtoReq.busiData;
    RichProto.RichProtoResp localRichProtoResp = localRichProtoReq.resp;
    amwm localamwm = paramProtoResp.statisInfo;
    if (((FromServiceMsg)localObject1).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject1).getResultCode();
      if ((i == 1002) || (i == 1013)) {
        setResult(-1, 9311, MessageHandler.a((FromServiceMsg)localObject1), "", localamwm, localRichProtoResp.resps);
      }
    }
    List localList;
    for (;;)
    {
      RichProtoProc.onBusiProtoResp(localRichProtoReq, localRichProtoResp);
      return;
      setResult(-1, 9044, MessageHandler.a((FromServiceMsg)localObject1), "", localamwm, localRichProtoResp.resps);
      continue;
      try
      {
        localList = ((MultiMsg.RspBody)new MultiMsg.RspBody().mergeFrom(arrayOfByte1)).rpt_multimsg_applyup_rsp.get();
        if ((localList != null) && (localList.size() != 0)) {
          break;
        }
        throw new Exception("resps null");
      }
      catch (Exception paramProtoResp)
      {
        setResult(-1, -9527, BaseTransProcessor.getServerReason("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte1), localamwm, localRichProtoResp.resps);
      }
    }
    int i = 0;
    label233:
    if (i < localList.size()) {
      paramProtoResp = (MultiMsg.MultiMsgApplyUpRsp)localList.get(i);
    }
    try
    {
      localObject1 = (RichProto.RichProtoResp.MultiMsgUpResp)localRichProtoResp.resps.get(i);
      try
      {
        j = paramProtoResp.uint32_result.get();
        if (j != 0) {
          break label781;
        }
        if (paramProtoResp.bytes_msg_resid.has()) {
          break label367;
        }
        throw new Exception("bytes_msg_resid NOT exists");
      }
      catch (Exception paramProtoResp) {}
    }
    catch (Exception paramProtoResp)
    {
      for (;;)
      {
        localObject1 = null;
        continue;
        int j = 0;
      }
    }
    setResult(-1, -9527, BaseTransProcessor.getServerReason("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte1), localamwm, (RichProto.RichProtoResp.RespCommon)localObject1);
    for (;;)
    {
      i += 1;
      break label233;
      break;
      label367:
      Object localObject2 = paramProtoResp.bytes_msg_resid.get().toByteArray();
      if ((localObject2 == null) || (localObject2.length <= 0)) {
        throw new Exception("resid_bs == null || empty");
      }
      if (!paramProtoResp.bytes_msg_ukey.has()) {
        throw new Exception("bytes_msg_ukey NOT exists");
      }
      Object localObject3 = paramProtoResp.bytes_msg_ukey.get().toByteArray();
      if ((localObject3 == null) || (localObject3.length <= 0)) {
        throw new Exception("ukey_bs == null || empty");
      }
      if (!paramProtoResp.bytes_msg_key.has()) {
        throw new Exception("bytes_msg_key NOT exists");
      }
      Object localObject4 = paramProtoResp.bytes_msg_key.get().toByteArray();
      if ((localObject4 == null) || (localObject4.length <= 0)) {
        throw new Exception("msgkey_bs == null || empty");
      }
      if (!paramProtoResp.bytes_msg_sig.has()) {
        throw new Exception("bytes_msg_sig NOT exists");
      }
      byte[] arrayOfByte2 = paramProtoResp.bytes_msg_sig.get().toByteArray();
      if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
        throw new Exception("msgsig_bs == null || empty");
      }
      ((RichProto.RichProtoResp.MultiMsgUpResp)localObject1).resId = ((byte[])localObject2);
      ((RichProto.RichProtoResp.MultiMsgUpResp)localObject1).ukey = ((byte[])localObject3);
      ((RichProto.RichProtoResp.MultiMsgUpResp)localObject1).msgKey = ((byte[])localObject4);
      ((RichProto.RichProtoResp.MultiMsgUpResp)localObject1).msgSig = arrayOfByte2;
      localObject2 = paramProtoResp.rpt_uint32_up_ip.get();
      localObject3 = paramProtoResp.rpt_uint32_up_port.get();
      if ((localObject2 != null) && (((List)localObject2).size() != 0)) {
        break label847;
      }
      throw new Exception("check iplist");
      while (j < ((List)localObject2).size())
      {
        long l1 = ((Integer)((List)localObject2).get(j)).intValue();
        long l2 = ((Integer)((List)localObject3).get(j)).intValue();
        localObject4 = new ServerAddr();
        ((ServerAddr)localObject4).mIp = PkgTools.int2IPNet(l1 & 0xFFFFFFFF);
        ((ServerAddr)localObject4).port = ((int)l2);
        ((RichProto.RichProtoResp.MultiMsgUpResp)localObject1).ipList.add(j, localObject4);
        j += 1;
      }
      ((RichProto.RichProtoResp.MultiMsgUpResp)localObject1).blockSize = ((int)paramProtoResp.uint64_block_size.get());
      ((RichProto.RichProtoResp.MultiMsgUpResp)localObject1).transferedSize = ((int)paramProtoResp.uint64_up_offset.get());
      setResult(0, 0, "", "", localamwm, (RichProto.RichProtoResp.RespCommon)localObject1);
      continue;
      label781:
      if (GroupPicUpHandler.shouldRetryByRetCode(j))
      {
        this.mReqUrlCount += 1;
        if (this.mReqUrlCount < 2)
        {
          localRichProtoReq.protoReqMgr.sendProtoReq(paramProtoReq);
          return;
        }
      }
      setResult(-1, -9527, BaseTransProcessor.getUrlReason(j), "", localamwm, (RichProto.RichProtoResp.RespCommon)localObject1);
    }
  }
  
  public void sendRichProtoReq(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.reqs != null) && (paramRichProtoReq.protoReqMgr != null))
    {
      ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
      localProtoReq.ssoCmd = "MultiMsg.ApplyUp";
      localProtoReq.reqBody = constructReqBody(paramRichProtoReq.reqs);
      localProtoReq.busiData = paramRichProtoReq;
      localProtoReq.callback = this;
      inner_sendToProtoReq(paramRichProtoReq, localProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.MultiMsgUpHandler
 * JD-Core Version:    0.7.0.1
 */