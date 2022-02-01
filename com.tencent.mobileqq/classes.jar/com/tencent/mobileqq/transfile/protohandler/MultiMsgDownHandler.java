package com.tencent.mobileqq.transfile.protohandler;

import anza;
import axcw;
import axiv;
import bdla;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.longconn.multimsg.MultiMsg.ExternMsg;
import tencent.im.longconn.multimsg.MultiMsg.Ipv4Info;
import tencent.im.longconn.multimsg.MultiMsg.Ipv6Info;
import tencent.im.longconn.multimsg.MultiMsg.MultiMsgApplyDownReq;
import tencent.im.longconn.multimsg.MultiMsg.MultiMsgApplyDownRsp;
import tencent.im.longconn.multimsg.MultiMsg.ReqBody;
import tencent.im.longconn.multimsg.MultiMsg.RspBody;

public class MultiMsgDownHandler
  extends BaseHandler
{
  int mReqNetType;
  
  private void addOne(int paramInt, RichProto.RichProtoReq.ReqCommon paramReqCommon, MultiMsg.ReqBody paramReqBody)
  {
    paramReqCommon = (RichProto.RichProtoReq.MultiMsgDownReq)paramReqCommon;
    MultiMsg.MultiMsgApplyDownReq localMultiMsgApplyDownReq = new MultiMsg.MultiMsgApplyDownReq();
    localMultiMsgApplyDownReq.setHasFlag(true);
    localMultiMsgApplyDownReq.bytes_msg_resid.set(ByteStringMicro.copyFrom(paramReqCommon.msgResId));
    localMultiMsgApplyDownReq.uint32_msg_type.set(MultiMsgUpHandler.convertMsgType(paramReqCommon.uinType));
    localMultiMsgApplyDownReq.uint64_src_uin.set(Long.valueOf(paramReqCommon.selfUin).longValue());
    try
    {
      localMultiMsgApplyDownReq.bytes_msg_key.set(ByteStringMicro.copyFrom(BDHCommonUploadProcessor.getHttpConnKey()));
      localMultiMsgApplyDownReq.bytes_msg_sig.set(ByteStringMicro.copyFrom(BDHCommonUploadProcessor.getHttpConnSig()));
      List localList = BDHCommonUploadProcessor.getBDHServerIp(false);
      if (QLog.isDevelopLevel()) {
        QLog.i("MultiMsg_TAG_opt", 2, "Multimsg download handler addone bdh serverIP4.size  " + localList.size());
      }
      if (localList.size() > 0)
      {
        localObject1 = localList.iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label312;
          }
          localObject2 = (ExcitingTransferHostInfo)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            MultiMsg.Ipv4Info localIpv4Info = new MultiMsg.Ipv4Info();
            localIpv4Info.uint32_ip_v4_addr.set(axcw.a(((ExcitingTransferHostInfo)localObject2).mstrIp));
            if (QLog.isDevelopLevel()) {
              QLog.i("MultiMsg_TAG_opt", 2, "Multimsg download handler ipv4:  " + ((ExcitingTransferHostInfo)localObject2).mstrIp);
            }
            localIpv4Info.uint32_ip_v4_port.set(((ExcitingTransferHostInfo)localObject2).mport);
            if (!((ExcitingTransferHostInfo)localObject2).mIsHttps) {
              break;
            }
            paramInt = 1;
            localIpv4Info.uint32_is_https_addr.set(paramInt);
            localMultiMsgApplyDownReq.rpt_ip_v4_info.add(localIpv4Info);
          }
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      for (;;)
      {
        QLog.e("MultiMsg_TAG", 1, localException, new Object[0]);
        continue;
        paramInt = 0;
      }
      label312:
      Object localObject1 = BDHCommonUploadProcessor.getBDHServerIp(true);
      if (QLog.isDevelopLevel()) {
        QLog.i("MultiMsg_TAG_opt", 2, "Multimsg download handler addone bdh serverIP6.size  " + localException.size());
      }
      if (((List)localObject1).size() > 0)
      {
        Iterator localIterator = ((List)localObject1).iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject1 = (ExcitingTransferHostInfo)localIterator.next();
            if (localObject1 == null) {
              continue;
            }
            localObject2 = new MultiMsg.Ipv6Info();
            try
            {
              ((MultiMsg.Ipv6Info)localObject2).bytes_ip_v6_addr.set(ByteStringMicro.copyFrom(Inet6Address.getByName(((ExcitingTransferHostInfo)localObject1).mstrIp).getAddress()));
              if (QLog.isDevelopLevel()) {
                QLog.i("MultiMsg_TAG_opt", 2, "Multimsg download handler ipv6:  " + ((ExcitingTransferHostInfo)localObject1).mstrIp);
              }
              ((MultiMsg.Ipv6Info)localObject2).uint32_ip_v6_port.set(((ExcitingTransferHostInfo)localObject1).mport);
              if (((ExcitingTransferHostInfo)localObject1).mIsHttps)
              {
                paramInt = 1;
                ((MultiMsg.Ipv6Info)localObject2).uint32_is_https_addr.set(paramInt);
                localMultiMsgApplyDownReq.rpt_ip_v6_info.add((MessageMicro)localObject2);
              }
            }
            catch (UnknownHostException localUnknownHostException)
            {
              for (;;)
              {
                localUnknownHostException.printStackTrace();
                continue;
                paramInt = 0;
              }
            }
          }
        }
      }
      paramReqBody.rpt_multimsg_applydown_req.add(localMultiMsgApplyDownReq);
      if ((paramReqCommon.multiMsgType == 0) && (axiv.b)) {
        paramReqBody.uint32_bu_type.set(2);
      }
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
      ((MultiMsg.ReqBody)localObject).uint32_subcmd.set(2);
      ((MultiMsg.ReqBody)localObject).uint32_term_type.set(5);
      ((MultiMsg.ReqBody)localObject).uint32_platform_type.set(9);
      ((MultiMsg.ReqBody)localObject).uint32_net_type.set(j);
      ((MultiMsg.ReqBody)localObject).bytes_build_ver.set(ByteStringMicro.copyFromUtf8(RichMediaUtil.getVersionCode()));
      ((MultiMsg.ReqBody)localObject).uint32_req_channel_type.set(2);
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
  
  void initResps(RichProto.RichProtoReq paramRichProtoReq)
  {
    RichProto.RichProtoResp localRichProtoResp = paramRichProtoReq.resp;
    localRichProtoResp.resps.clear();
    int i = 0;
    while (i < paramRichProtoReq.reqs.size())
    {
      RichProto.RichProtoResp.MultiMsgDownResp localMultiMsgDownResp = new RichProto.RichProtoResp.MultiMsgDownResp();
      localRichProtoResp.resps.add(i, localMultiMsgDownResp);
      i += 1;
    }
  }
  
  public void onProtoResp(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    localObject1 = paramProtoResp.resp;
    byte[] arrayOfByte = paramProtoResp.resp.getWupBuffer();
    RichProto.RichProtoReq localRichProtoReq = (RichProto.RichProtoReq)paramProtoReq.busiData;
    RichProto.RichProtoResp localRichProtoResp = localRichProtoReq.resp;
    anza localanza = paramProtoResp.statisInfo;
    if (((FromServiceMsg)localObject1).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject1).getResultCode();
      if ((i == 1002) || (i == 1013)) {
        setResult(-1, 9311, MessageHandler.a((FromServiceMsg)localObject1), "", localanza, localRichProtoResp.resps);
      }
    }
    List localList;
    for (;;)
    {
      RichProtoProc.onBusiProtoResp(localRichProtoReq, localRichProtoResp);
      return;
      setResult(-1, 9044, MessageHandler.a((FromServiceMsg)localObject1), "", localanza, localRichProtoResp.resps);
      continue;
      try
      {
        localList = ((MultiMsg.RspBody)new MultiMsg.RspBody().mergeFrom(arrayOfByte)).rpt_multimsg_applydown_rsp.get();
        if ((localList != null) && (localList.size() != 0)) {
          break;
        }
        throw new Exception("resps null");
      }
      catch (Exception paramProtoResp)
      {
        setResult(-1, -9527, BaseTransProcessor.getServerReason("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localanza, localRichProtoResp.resps);
      }
    }
    int i = 0;
    label235:
    Object localObject2;
    if (i < localList.size()) {
      localObject2 = (MultiMsg.MultiMsgApplyDownRsp)localList.get(i);
    }
    try
    {
      localObject1 = (RichProto.RichProtoResp.MultiMsgDownResp)localRichProtoResp.resps.get(i);
      try
      {
        j = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).uint32_result.get();
        if (j != 0) {
          break label899;
        }
        if (((MultiMsg.MultiMsgApplyDownRsp)localObject2).bytes_thumb_down_para.has()) {
          break label372;
        }
        throw new Exception("bytes_thumb_down_para NOT exists");
      }
      catch (Exception paramProtoResp) {}
    }
    catch (Exception paramProtoResp)
    {
      for (;;)
      {
        int j;
        localObject1 = null;
      }
    }
    setResult(-1, -9527, BaseTransProcessor.getServerReason("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localanza, (RichProto.RichProtoResp.RespCommon)localObject1);
    for (;;)
    {
      i += 1;
      break label235;
      break;
      label372:
      paramProtoResp = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).bytes_thumb_down_para.get();
      if (paramProtoResp == null) {}
      for (paramProtoResp = null; (paramProtoResp == null) || (paramProtoResp.equals("")); paramProtoResp = paramProtoResp.toStringUtf8()) {
        throw new Exception("urlParam == null || empty");
      }
      if (!((MultiMsg.MultiMsgApplyDownRsp)localObject2).bytes_msg_resid.has()) {
        throw new Exception("bytes_msg_resid NOT exists");
      }
      Object localObject3 = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).bytes_msg_resid.get().toByteArray();
      if ((localObject3 == null) || (localObject3.length <= 0)) {
        throw new Exception("resid_bs == null || empty");
      }
      if (!((MultiMsg.MultiMsgApplyDownRsp)localObject2).bytes_msg_key.has()) {
        throw new Exception("bytes_msg_key NOT exists");
      }
      Object localObject4 = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).bytes_msg_key.get().toByteArray();
      if ((localObject4 == null) || (localObject4.length <= 0)) {
        throw new Exception("ukey_bs == null || empty");
      }
      j = 0;
      if (((MultiMsg.MultiMsgApplyDownRsp)localObject2).msg_extern_info.has()) {
        j = ((MultiMsg.ExternMsg)((MultiMsg.MultiMsgApplyDownRsp)localObject2).msg_extern_info.get()).uint32_channel_type.get();
      }
      ((RichProto.RichProtoResp.MultiMsgDownResp)localObject1).mChannelType = j;
      ((RichProto.RichProtoResp.MultiMsgDownResp)localObject1).urlParam = paramProtoResp;
      ((RichProto.RichProtoResp.MultiMsgDownResp)localObject1).resId = ((byte[])localObject3);
      ((RichProto.RichProtoResp.MultiMsgDownResp)localObject1).msgkey = ((byte[])localObject4);
      paramProtoResp = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).rpt_uint32_down_ip.get();
      localObject3 = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).rpt_uint32_down_port.get();
      if ((paramProtoResp == null) || (paramProtoResp.size() == 0)) {
        throw new Exception("check iplist");
      }
      if ((paramProtoResp != null) && (paramProtoResp.size() > 0))
      {
        j = 0;
        while (j < paramProtoResp.size())
        {
          long l1 = ((Integer)paramProtoResp.get(j)).intValue();
          long l2 = ((Integer)((List)localObject3).get(j)).intValue();
          localObject4 = new ServerAddr();
          ((ServerAddr)localObject4).mIp = PkgTools.int2IPNet(l1 & 0xFFFFFFFF);
          ((ServerAddr)localObject4).port = ((int)l2);
          ((RichProto.RichProtoResp.MultiMsgDownResp)localObject1).ipList.add(j, localObject4);
          j += 1;
        }
      }
      paramProtoResp = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).rpt_bytes_down_ip_v6.get();
      localObject2 = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).rpt_uint32_down_v6_port.get();
      if ((paramProtoResp != null) && (paramProtoResp.size() > 0))
      {
        j = 0;
        while (j < paramProtoResp.size())
        {
          localObject3 = new ServerAddr();
          ((ServerAddr)localObject3).mIp = Inet6Address.getByAddress(((ByteStringMicro)paramProtoResp.get(j)).toByteArray()).getHostAddress();
          ((ServerAddr)localObject3).port = ((int)((Integer)((List)localObject2).get(j)).intValue());
          ((ServerAddr)localObject3).isIpv6 = true;
          ((RichProto.RichProtoResp.MultiMsgDownResp)localObject1).mIpv6List.add(j, localObject3);
          j += 1;
        }
      }
      setResult(0, 0, "", "", localanza, (RichProto.RichProtoResp.RespCommon)localObject1);
      continue;
      label899:
      if (j == 196) {
        bdla.b(null, "CliOper", "", "", "0X8006627", "0X8006627", 0, 1, 0, "", "", "", "");
      }
      if (GroupPicUpHandler.shouldRetryByRetCode(j))
      {
        this.mReqUrlCount += 1;
        if (this.mReqUrlCount < 2)
        {
          localRichProtoReq.protoReqMgr.sendProtoReq(paramProtoReq);
          return;
        }
      }
      setResult(-1, -9527, BaseTransProcessor.getUrlReason(j), "", localanza, (RichProto.RichProtoResp.RespCommon)localObject1);
    }
  }
  
  public void sendRichProtoReq(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.reqs != null) && (paramRichProtoReq.protoReqMgr != null))
    {
      ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
      localProtoReq.ssoCmd = "MultiMsg.ApplyDown";
      localProtoReq.reqBody = constructReqBody(paramRichProtoReq.reqs);
      localProtoReq.busiData = paramRichProtoReq;
      localProtoReq.callback = this;
      inner_sendToProtoReq(paramRichProtoReq, localProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.MultiMsgDownHandler
 * JD-Core Version:    0.7.0.1
 */