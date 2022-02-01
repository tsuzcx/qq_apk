package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
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
    if ((paramReqCommon.multiMsgType == 0) && (MultiMsgUtil.b)) {
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
    int i;
    if (((FromServiceMsg)localObject1).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject1).getResultCode();
      if ((i != 1002) && (i != 1013)) {
        setResult(-1, 9044, BaseMessageHandler.a((FromServiceMsg)localObject1), "", localStatictisInfo, localRichProtoResp.resps);
      } else {
        setResult(-1, 9311, BaseMessageHandler.a((FromServiceMsg)localObject1), "", localStatictisInfo, localRichProtoResp.resps);
      }
    }
    for (;;)
    {
      label813:
      label829:
      StringBuilder localStringBuilder;
      try
      {
        paramProtoResp = ((MultiMsg.RspBody)new MultiMsg.RspBody().mergeFrom(arrayOfByte1)).rpt_multimsg_applyup_rsp.get();
        if ((paramProtoResp != null) && (paramProtoResp.size() != 0))
        {
          i = 0;
          if (i >= paramProtoResp.size()) {
            break label984;
          }
          MultiMsg.MultiMsgApplyUpRsp localMultiMsgApplyUpRsp = (MultiMsg.MultiMsgApplyUpRsp)paramProtoResp.get(i);
          try
          {
            localObject5 = (RichProto.RichProtoResp.MultiMsgUpResp)localRichProtoResp.resps.get(i);
            int j;
            Object localObject3;
            byte[] arrayOfByte2;
            byte[] arrayOfByte3;
            try
            {
              j = localMultiMsgApplyUpRsp.uint32_result.get();
              if (j == 0) {
                if (localMultiMsgApplyUpRsp.bytes_msg_resid.has())
                {
                  localObject3 = localMultiMsgApplyUpRsp.bytes_msg_resid.get().toByteArray();
                  if ((localObject3 != null) && (localObject3.length > 0)) {
                    if (localMultiMsgApplyUpRsp.bytes_msg_ukey.has())
                    {
                      localObject6 = localMultiMsgApplyUpRsp.bytes_msg_ukey.get().toByteArray();
                      if ((localObject6 != null) && (localObject6.length > 0)) {
                        if (localMultiMsgApplyUpRsp.bytes_msg_key.has())
                        {
                          arrayOfByte2 = localMultiMsgApplyUpRsp.bytes_msg_key.get().toByteArray();
                          if ((arrayOfByte2 != null) && (arrayOfByte2.length > 0)) {
                            if (localMultiMsgApplyUpRsp.bytes_msg_sig.has())
                            {
                              arrayOfByte3 = localMultiMsgApplyUpRsp.bytes_msg_sig.get().toByteArray();
                              if (arrayOfByte3 == null) {
                                break label1011;
                              }
                              localObject1 = paramProtoResp;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
            catch (Exception localException5) {}
          }
          catch (Exception localException3)
          {
            Object localObject2;
            localObject4 = null;
          }
        }
      }
      catch (Exception paramProtoResp)
      {
        Object localObject5;
        Object localObject6;
        Object localObject4;
        paramProtoReq = ProcessorReport.getServerReason("P", -9529L);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramProtoResp.getMessage());
        localStringBuilder.append(" hex:");
        localStringBuilder.append(HexUtil.bytes2HexStr(arrayOfByte1));
        setResult(-1, -9527, paramProtoReq, localStringBuilder.toString(), localStatictisInfo, localRichProtoResp.resps);
      }
      for (;;)
      {
        try
        {
          if (arrayOfByte3.length <= 0) {
            continue;
          }
          localObject1 = paramProtoResp;
          ((RichProto.RichProtoResp.MultiMsgUpResp)localObject5).resId = ((byte[])localObject3);
          localObject1 = paramProtoResp;
          ((RichProto.RichProtoResp.MultiMsgUpResp)localObject5).ukey = ((byte[])localObject6);
          localObject1 = paramProtoResp;
          ((RichProto.RichProtoResp.MultiMsgUpResp)localObject5).msgKey = arrayOfByte2;
          localObject1 = paramProtoResp;
          ((RichProto.RichProtoResp.MultiMsgUpResp)localObject5).msgSig = arrayOfByte3;
          localObject1 = paramProtoResp;
          localObject3 = localMultiMsgApplyUpRsp.rpt_uint32_up_ip.get();
          localObject1 = paramProtoResp;
          localObject6 = localMultiMsgApplyUpRsp.rpt_uint32_up_port.get();
          if (localObject3 != null)
          {
            localObject1 = paramProtoResp;
            if (((List)localObject3).size() != 0)
            {
              j = 0;
              for (;;)
              {
                localObject1 = paramProtoResp;
                int k = ((List)localObject3).size();
                if (j < k) {
                  try
                  {
                    long l1 = ((Integer)((List)localObject3).get(j)).intValue();
                    k = ((Integer)((List)localObject6).get(j)).intValue();
                    long l2 = k;
                    try
                    {
                      localObject1 = new ServerAddr();
                      ((ServerAddr)localObject1).mIp = PkgTools.int2IPNet(l1 & 0xFFFFFFFF);
                      ((ServerAddr)localObject1).port = ((int)l2);
                      ((RichProto.RichProtoResp.MultiMsgUpResp)localObject5).ipList.add(j, localObject1);
                      j += 1;
                    }
                    catch (Exception localException1)
                    {
                      localObject3 = localObject5;
                      break label829;
                    }
                    localObject2 = paramProtoResp;
                  }
                  catch (Exception localException2)
                  {
                    localObject3 = localObject5;
                  }
                }
              }
            }
          }
        }
        catch (Exception localException7)
        {
          paramProtoResp = localStringBuilder;
          break label813;
        }
        try
        {
          ((RichProto.RichProtoResp.MultiMsgUpResp)localObject5).blockSize = ((int)localMultiMsgApplyUpRsp.uint64_block_size.get());
          ((RichProto.RichProtoResp.MultiMsgUpResp)localObject5).transferedSize = ((int)localMultiMsgApplyUpRsp.uint64_up_offset.get());
          paramProtoResp = (ProtoReqManagerImpl.ProtoResp)localObject2;
          try
          {
            setResult(0, 0, "", "", localStatictisInfo, (RichProto.RichProtoResp.RespCommon)localObject5);
            paramProtoResp = (ProtoReqManagerImpl.ProtoResp)localObject2;
          }
          catch (Exception localException4)
          {
            break label813;
          }
          throw new Exception("check iplist");
        }
        catch (Exception localException6)
        {
          paramProtoResp = localStringBuilder;
          break label813;
        }
      }
      throw new Exception("msgsig_bs == null || empty");
      throw new Exception("bytes_msg_sig NOT exists");
      throw new Exception("msgkey_bs == null || empty");
      throw new Exception("bytes_msg_key NOT exists");
      throw new Exception("ukey_bs == null || empty");
      throw new Exception("bytes_msg_ukey NOT exists");
      throw new Exception("resid_bs == null || empty");
      throw new Exception("bytes_msg_resid NOT exists");
      localObject2 = paramProtoResp;
      paramProtoResp = (ProtoReqManagerImpl.ProtoResp)localObject2;
      if (shouldRetryByRetCodeForGroup(j))
      {
        paramProtoResp = (ProtoReqManagerImpl.ProtoResp)localObject2;
        this.mReqUrlCount += 1;
        paramProtoResp = (ProtoReqManagerImpl.ProtoResp)localObject2;
        if (this.mReqUrlCount < 2)
        {
          paramProtoResp = (ProtoReqManagerImpl.ProtoResp)localObject2;
          localRichProtoReq.protoReqMgr.sendProtoReq(paramProtoReq);
          return;
        }
      }
      paramProtoResp = (ProtoReqManagerImpl.ProtoResp)localObject2;
      setResult(-1, -9527, ProcessorReport.getUrlReason(j), "", localStatictisInfo, (RichProto.RichProtoResp.RespCommon)localObject5);
      paramProtoResp = (ProtoReqManagerImpl.ProtoResp)localObject2;
      break label1014;
      localObject2 = localException5;
      localObject4 = localObject5;
      localObject5 = ProcessorReport.getServerReason("P", -9529L);
      localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append(localException3.getMessage());
      ((StringBuilder)localObject6).append(" hex:");
      ((StringBuilder)localObject6).append(HexUtil.bytes2HexStr(arrayOfByte1));
      setResult(-1, -9527, (String)localObject5, ((StringBuilder)localObject6).toString(), localStatictisInfo, localObject4);
      break label1014;
      throw new Exception("resps null");
      label984:
      RichProtoProc.onBusiProtoResp(localRichProtoReq, localRichProtoResp);
      return;
      continue;
      label1011:
      continue;
      label1014:
      i += 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.MultiMsgUpHandler
 * JD-Core Version:    0.7.0.1
 */