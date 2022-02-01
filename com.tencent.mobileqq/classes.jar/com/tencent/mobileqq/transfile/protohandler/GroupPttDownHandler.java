package com.tencent.mobileqq.transfile.protohandler;

import amwm;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
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
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388.GetPttUrlReq;
import tencent.im.cs.cmd0x388.cmd0x388.GetPttUrlRsp;
import tencent.im.cs.cmd0x388.cmd0x388.IPv6Info;
import tencent.im.cs.cmd0x388.cmd0x388.ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388.RspBody;

public class GroupPttDownHandler
  extends BaseHandler
{
  public static final String TAG = "Q.richmedia.GroupPttDownHandler";
  
  void addOne(int paramInt, RichProto.RichProtoReq.ReqCommon paramReqCommon, cmd0x388.ReqBody paramReqBody)
  {
    paramReqCommon = (RichProto.RichProtoReq.GroupPttDownReq)paramReqCommon;
    cmd0x388.GetPttUrlReq localGetPttUrlReq = new cmd0x388.GetPttUrlReq();
    localGetPttUrlReq.setHasFlag(true);
    localGetPttUrlReq.uint64_file_id.set(paramInt);
    localGetPttUrlReq.uint64_dst_uin.set(Long.valueOf(paramReqCommon.selfUin).longValue());
    localGetPttUrlReq.uint64_group_code.set(Long.parseLong(paramReqCommon.peerUin));
    localGetPttUrlReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramReqCommon.md5));
    if (paramReqCommon.groupFileID != 0L) {
      localGetPttUrlReq.uint64_fileid.set(paramReqCommon.groupFileID);
    }
    localGetPttUrlReq.uint32_req_platform_type.set(9);
    localGetPttUrlReq.uint32_req_term.set(5);
    localGetPttUrlReq.uint32_inner_ip.set(0);
    Object localObject = localGetPttUrlReq.uint32_bu_type;
    if (paramReqCommon.uinType == 1) {
      paramInt = 3;
    }
    for (;;)
    {
      ((PBUInt32Field)localObject).set(paramInt);
      localGetPttUrlReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(RichMediaUtil.getVersionCode()));
      localGetPttUrlReq.uint32_codec.set(paramReqCommon.voiceType);
      if (paramReqCommon.groupFileKey != null) {}
      try
      {
        localObject = paramReqCommon.groupFileKey.getBytes("utf-8");
        localGetPttUrlReq.bytes_file_key.set(ByteStringMicro.copyFrom((byte[])localObject));
        label207:
        localGetPttUrlReq.uint32_is_auto.set(paramReqCommon.downType);
        localGetPttUrlReq.uint32_req_transfer_type.set(2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.GroupPttDownHandler", 2, "constructReqBody GroupPttDownReq = " + paramReqCommon.toString());
        }
        paramReqBody.rpt_msg_getptt_url_req.add(localGetPttUrlReq);
        return;
        paramInt = 4;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        break label207;
      }
    }
  }
  
  byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> paramList)
  {
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(4);
    int i = 0;
    while (i < paramList.size())
    {
      addOne(i, (RichProto.RichProtoReq.ReqCommon)paramList.get(i), localReqBody);
      i += 1;
    }
    switch (NetworkCenter.getInstance().getNetType())
    {
    default: 
      i = 6;
    }
    for (;;)
    {
      paramList = NetworkCenter.getInstance().getApnType();
      int j = i;
      if (paramList != null)
      {
        j = i;
        if (paramList.contains("wap")) {
          j = 5;
        }
      }
      localReqBody.uint32_net_type.set(j);
      return localReqBody.toByteArray();
      i = 3;
      continue;
      i = 6;
      continue;
      i = 7;
      continue;
      i = 8;
    }
  }
  
  void initResps(RichProto.RichProtoReq paramRichProtoReq)
  {
    RichProto.RichProtoResp localRichProtoResp = paramRichProtoReq.resp;
    localRichProtoResp.resps.clear();
    int i = 0;
    while (i < paramRichProtoReq.reqs.size())
    {
      RichProto.RichProtoResp.GroupPttDownResp localGroupPttDownResp = new RichProto.RichProtoResp.GroupPttDownResp();
      localRichProtoResp.resps.add(i, localGroupPttDownResp);
      i += 1;
    }
  }
  
  public void onProtoResp(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    FromServiceMsg localFromServiceMsg = paramProtoResp.resp;
    if (localFromServiceMsg == null) {
      return;
    }
    byte[] arrayOfByte = paramProtoResp.resp.getWupBuffer();
    RichProto.RichProtoReq localRichProtoReq = (RichProto.RichProtoReq)paramProtoReq.busiData;
    RichProto.RichProtoResp localRichProtoResp = localRichProtoReq.resp;
    amwm localamwm = paramProtoResp.statisInfo;
    int i;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      i = localFromServiceMsg.getResultCode();
      if ((i == 1002) || (i == 1013))
      {
        localObject1 = MessageHandler.a(localFromServiceMsg);
        paramProtoReq = localFromServiceMsg.getBusinessFailMsg();
        paramProtoResp = paramProtoReq;
        if (paramProtoReq == null) {
          paramProtoResp = "";
        }
        setResult(-1, 9311, (String)localObject1, paramProtoResp, localamwm, localRichProtoResp.resps);
      }
    }
    for (;;)
    {
      RichProtoProc.onBusiProtoResp(localRichProtoReq, localRichProtoResp);
      return;
      localObject1 = MessageHandler.a(localFromServiceMsg);
      paramProtoReq = localFromServiceMsg.getBusinessFailMsg();
      paramProtoResp = paramProtoReq;
      if (paramProtoReq == null) {
        paramProtoResp = "";
      }
      setResult(-1, 9044, (String)localObject1, paramProtoResp, localamwm, localRichProtoResp.resps);
      continue;
      try
      {
        paramProtoResp = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(arrayOfByte)).rpt_msg_getptt_url_rsp.get();
        if ((paramProtoResp != null) && (paramProtoResp.size() != 0)) {
          break label272;
        }
        throw new Exception("resps size is 0");
      }
      catch (Exception paramProtoResp)
      {
        setResult(-1, -9527, BaseTransProcessor.getServerReason("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localamwm, localRichProtoResp.resps);
      }
      continue;
      label272:
      Iterator localIterator = paramProtoResp.iterator();
      while (localIterator.hasNext())
      {
        paramProtoResp = (cmd0x388.GetPttUrlRsp)localIterator.next();
        try
        {
          localObject1 = (RichProto.RichProtoResp.GroupPttDownResp)localRichProtoResp.resps.get((int)paramProtoResp.uint64_file_id.get());
          if (localObject1 == null) {
            continue;
          }
        }
        catch (Exception paramProtoResp)
        {
          for (;;)
          {
            List localList;
            Object localObject2;
            label462:
            localObject1 = null;
            label776:
            continue;
            boolean bool = false;
          }
        }
        try
        {
          ((RichProto.RichProtoResp.GroupPttDownResp)localObject1).isSendByQuickHttp = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
          if (QLog.isColorLevel()) {
            QLog.e("http_sideway", 2, "GroupPttDownHandler.onProtoResp:isSendByQuickHttp=" + ((RichProto.RichProtoResp.GroupPttDownResp)localObject1).isSendByQuickHttp);
          }
          if (localObject1 != null)
          {
            if (paramProtoResp.uint32_transfer_type.get() != 1) {
              break label873;
            }
            bool = true;
            ((RichProto.RichProtoResp.GroupPttDownResp)localObject1).mIsHttps = bool;
          }
          i = paramProtoResp.uint32_result.get();
          if (i != 0) {
            break label776;
          }
          ((RichProto.RichProtoResp.GroupPttDownResp)localObject1).urlPath = paramProtoResp.bytes_down_para.get().toStringUtf8();
          localList = paramProtoResp.rpt_uint32_down_ip.get();
          localObject2 = paramProtoResp.rpt_uint32_down_port.get();
          i = 0;
          if (i < localList.size())
          {
            ServerAddr localServerAddr = new ServerAddr();
            localServerAddr.mIp = PkgTools.int2IPNet(((Integer)localList.get(i)).intValue() & 0xFFFFFFFF);
            localServerAddr.port = ((Integer)((List)localObject2).get(i)).intValue();
            ((RichProto.RichProtoResp.GroupPttDownResp)localObject1).mIpList.add(i, localServerAddr);
            i += 1;
            break label462;
          }
          if ((paramProtoResp.rpt_msg_down_ip6.has()) && (paramProtoResp.rpt_msg_down_ip6.size() > 0))
          {
            localList = paramProtoResp.rpt_msg_down_ip6.get();
            i = 0;
            while (i < localList.size())
            {
              localObject2 = new ServerAddr();
              ((ServerAddr)localObject2).mIp = Inet6Address.getByAddress(((cmd0x388.IPv6Info)localList.get(i)).bytes_ip6.get().toByteArray()).getHostAddress();
              ((ServerAddr)localObject2).port = ((cmd0x388.IPv6Info)localList.get(i)).uint32_port.get();
              ((ServerAddr)localObject2).isIpv6 = true;
              ((RichProto.RichProtoResp.GroupPttDownResp)localObject1).mIpv6List.add(i, localObject2);
              i += 1;
            }
          }
          if (paramProtoResp.rpt_str_domain.has()) {
            ((RichProto.RichProtoResp.GroupPttDownResp)localObject1).domainV4V6 = paramProtoResp.rpt_str_domain.get();
          }
          setResult(0, 0, "", "", localamwm, (RichProto.RichProtoResp.RespCommon)localObject1);
        }
        catch (Exception paramProtoResp) {}
        if (localObject1 != null)
        {
          setResult(-1, -9527, BaseTransProcessor.getServerReason("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localamwm, (RichProto.RichProtoResp.RespCommon)localObject1);
          continue;
          if (paramProtoResp.uint32_allow_retry.get() == 1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.richmedia.GroupPttDownHandler", 2, "onProtoResp :group ptt server not allow retry");
            }
            ((RichProto.RichProtoResp.GroupPttDownResp)localObject1).isAllowRetry = false;
          }
          if (GroupPicUpHandler.shouldRetryByRetCode(i))
          {
            this.mReqUrlCount += 1;
            if (this.mReqUrlCount < 2)
            {
              localRichProtoReq.protoReqMgr.sendProtoReq(paramProtoReq);
              return;
            }
          }
          setResult(-1, -9527, BaseTransProcessor.getUrlReason(i), "", localamwm, (RichProto.RichProtoResp.RespCommon)localObject1);
        }
      }
    }
  }
  
  public void sendRichProtoReq(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.reqs != null) && (paramRichProtoReq.protoReqMgr != null))
    {
      ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
      localProtoReq.ssoCmd = "PttStore.GroupPttDown";
      localProtoReq.reqBody = constructReqBody(paramRichProtoReq.reqs);
      localProtoReq.busiData = paramRichProtoReq;
      localProtoReq.callback = this;
      inner_sendToProtoReq(paramRichProtoReq, localProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.GroupPttDownHandler
 * JD-Core Version:    0.7.0.1
 */