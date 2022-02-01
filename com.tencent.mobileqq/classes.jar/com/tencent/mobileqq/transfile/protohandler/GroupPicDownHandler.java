package com.tencent.mobileqq.transfile.protohandler;

import anza;
import bdkj;
import com.qq.taf.jce.HexUtil;
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
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388.GetImgUrlReq;
import tencent.im.cs.cmd0x388.cmd0x388.GetImgUrlRsp;
import tencent.im.cs.cmd0x388.cmd0x388.IPv6Info;
import tencent.im.cs.cmd0x388.cmd0x388.ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388.RspBody;

public class GroupPicDownHandler
  extends PicDownHandler
{
  private void handleResponse(RichProto.RichProtoReq.GroupPicDownReq paramGroupPicDownReq, cmd0x388.GetImgUrlRsp paramGetImgUrlRsp, RichProto.RichProtoResp.PicDownResp paramPicDownResp)
  {
    int j = 0;
    Object localObject = null;
    if (paramGroupPicDownReq.fileType == 65537) {
      if (bdkj.a()) {
        localObject = paramGetImgUrlRsp.bytes_big_thumb_down_para.get().toStringUtf8();
      }
    }
    int i;
    for (;;)
    {
      paramPicDownResp.urlPath = ((String)localObject);
      if ((!paramGetImgUrlRsp.rpt_uint32_down_ip.has()) || (paramGetImgUrlRsp.rpt_uint32_down_ip.size() <= 0) || (!paramGetImgUrlRsp.rpt_uint32_down_port.has()) || (paramGetImgUrlRsp.rpt_uint32_down_port.size() <= 0)) {
        break;
      }
      paramGroupPicDownReq = paramGetImgUrlRsp.rpt_uint32_down_ip.get();
      localObject = paramGetImgUrlRsp.rpt_uint32_down_port.get();
      i = 0;
      while (i < paramGroupPicDownReq.size())
      {
        ServerAddr localServerAddr = new ServerAddr();
        localServerAddr.mIp = PkgTools.int2IPNet(((Integer)paramGroupPicDownReq.get(i)).intValue() & 0xFFFFFFFF);
        localServerAddr.port = ((Integer)((List)localObject).get(i)).intValue();
        paramPicDownResp.mIpList.add(i, localServerAddr);
        i += 1;
      }
      localObject = paramGetImgUrlRsp.bytes_thumb_down_para.get().toStringUtf8();
      continue;
      if (paramGroupPicDownReq.fileType == 1) {
        localObject = paramGetImgUrlRsp.bytes_big_down_para.get().toStringUtf8();
      } else if (paramGroupPicDownReq.fileType == 131075) {
        localObject = paramGetImgUrlRsp.bytes_original_down_para.get().toStringUtf8();
      }
    }
    if ((paramGetImgUrlRsp.rpt_msg_down_ip6.has()) && (paramGetImgUrlRsp.rpt_msg_down_ip6.size() > 0))
    {
      paramGroupPicDownReq = paramGetImgUrlRsp.rpt_msg_down_ip6.get();
      i = j;
      while (i < paramGroupPicDownReq.size())
      {
        localObject = new ServerAddr();
        ((ServerAddr)localObject).mIp = Inet6Address.getByAddress(((cmd0x388.IPv6Info)paramGroupPicDownReq.get(i)).bytes_ip6.get().toByteArray()).getHostAddress();
        ((ServerAddr)localObject).port = ((cmd0x388.IPv6Info)paramGroupPicDownReq.get(i)).uint32_port.get();
        ((ServerAddr)localObject).isIpv6 = true;
        paramPicDownResp.mIpv6List.add(i, localObject);
        i += 1;
      }
    }
    if (paramGetImgUrlRsp.bytes_down_domain.has())
    {
      paramGroupPicDownReq = new ServerAddr();
      paramGroupPicDownReq.mIp = paramGetImgUrlRsp.bytes_down_domain.get().toStringUtf8();
      paramGroupPicDownReq.port = 80;
      paramPicDownResp.mIpList.add(paramGroupPicDownReq);
      paramPicDownResp.domain = paramGroupPicDownReq.mIp;
    }
    if (paramGetImgUrlRsp.uint32_https_url_flag.has()) {
      paramPicDownResp.protocolType = paramGetImgUrlRsp.uint32_https_url_flag.get();
    }
  }
  
  void addOne(int paramInt, RichProto.RichProtoReq.ReqCommon paramReqCommon, cmd0x388.ReqBody paramReqBody)
  {
    int i = 1;
    paramReqCommon = (RichProto.RichProtoReq.GroupPicDownReq)paramReqCommon;
    cmd0x388.GetImgUrlReq localGetImgUrlReq = new cmd0x388.GetImgUrlReq();
    localGetImgUrlReq.setHasFlag(true);
    localGetImgUrlReq.uint64_file_id.set(paramInt);
    localGetImgUrlReq.uint64_dst_uin.set(Long.valueOf(paramReqCommon.selfUin).longValue());
    localGetImgUrlReq.uint64_group_code.set(Long.parseLong(paramReqCommon.peerUin));
    localGetImgUrlReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramReqCommon.md5));
    localGetImgUrlReq.uint32_pic_up_timestamp.set(paramReqCommon.msgTime);
    if (paramReqCommon.groupFileID != 0L) {
      localGetImgUrlReq.uint64_fileid.set(paramReqCommon.groupFileID);
    }
    PBUInt32Field localPBUInt32Field;
    if (paramReqCommon.fileType == 65537) {
      if (bdkj.a())
      {
        localGetImgUrlReq.uint32_url_flag.set(16);
        localGetImgUrlReq.uint32_url_type.set(2);
        localGetImgUrlReq.uint32_req_platform_type.set(9);
        localGetImgUrlReq.uint32_req_term.set(5);
        localGetImgUrlReq.uint32_inner_ip.set(0);
        localPBUInt32Field = localGetImgUrlReq.uint32_bu_type;
        if (paramReqCommon.uinType != 1) {
          break label317;
        }
      }
    }
    label317:
    for (paramInt = i;; paramInt = 2)
    {
      localPBUInt32Field.set(paramInt);
      localGetImgUrlReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(RichMediaUtil.getVersionCode()));
      localGetImgUrlReq.uint32_req_transfer_type.set(paramReqCommon.protocolType);
      paramReqBody.rpt_msg_getimg_url_req.add(localGetImgUrlReq);
      return;
      localGetImgUrlReq.uint32_url_flag.set(1);
      localGetImgUrlReq.uint32_url_type.set(2);
      break;
      if (paramReqCommon.fileType == 1)
      {
        localGetImgUrlReq.uint32_url_flag.set(8);
        localGetImgUrlReq.uint32_url_type.set(3);
        break;
      }
      if (paramReqCommon.fileType != 131075) {
        break;
      }
      localGetImgUrlReq.uint32_url_flag.set(2);
      localGetImgUrlReq.uint32_url_type.set(4);
      break;
    }
  }
  
  byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> paramList)
  {
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(2);
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
  
  protected void handleSucResponse(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp, anza paramanza)
  {
    try
    {
      paramProtoResp = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(paramArrayOfByte)).rpt_msg_getimg_url_rsp.get();
      if ((paramProtoResp == null) || (paramProtoResp.size() == 0)) {
        throw new Exception("resps null");
      }
    }
    catch (Exception paramProtoResp)
    {
      setResult(-1, -9527, BaseTransProcessor.getServerReason("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(paramArrayOfByte), paramanza, paramRichProtoResp.resps);
    }
    for (;;)
    {
      return;
      Iterator localIterator = paramProtoResp.iterator();
      while (localIterator.hasNext())
      {
        paramProtoResp = (cmd0x388.GetImgUrlRsp)localIterator.next();
        try
        {
          localPicDownResp = (RichProto.RichProtoResp.PicDownResp)paramRichProtoResp.resps.get((int)paramProtoResp.uint64_file_id.get());
          try
          {
            RichProto.RichProtoReq.GroupPicDownReq localGroupPicDownReq = (RichProto.RichProtoReq.GroupPicDownReq)paramRichProtoReq.reqs.get(0);
            if (localPicDownResp == null) {
              continue;
            }
            if (paramFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
              localPicDownResp.isSendByQuickHttp = ((Boolean)paramFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
            }
            i = paramProtoResp.uint32_result.get();
            if (i != 0) {
              break label309;
            }
            handleResponse(localGroupPicDownReq, paramProtoResp, localPicDownResp);
            setResult(0, 0, "", "", paramanza, localPicDownResp);
          }
          catch (Exception paramProtoResp) {}
        }
        catch (Exception paramProtoResp)
        {
          for (;;)
          {
            int i;
            RichProto.RichProtoResp.PicDownResp localPicDownResp = null;
          }
        }
        setResult(-1, -9527, BaseTransProcessor.getServerReason("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(paramArrayOfByte), paramanza, localPicDownResp);
        continue;
        label309:
        if (GroupPicUpHandler.shouldRetryByRetCode(i))
        {
          this.mReqUrlCount += 1;
          if (this.mReqUrlCount < 2)
          {
            paramRichProtoReq.protoReqMgr.sendProtoReq(paramProtoReq);
            return;
          }
        }
        setResult(-1, -9527, BaseTransProcessor.getUrlReason(i), BaseTransProcessor.getUrlReason(i), paramanza, localPicDownResp);
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
      RichProto.RichProtoResp.PicDownResp localPicDownResp = new RichProto.RichProtoResp.PicDownResp();
      localRichProtoResp.resps.add(i, localPicDownResp);
      i += 1;
    }
  }
  
  public void sendRichProtoReq(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.reqs != null) && (paramRichProtoReq.protoReqMgr != null))
    {
      ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
      localProtoReq.ssoCmd = "ImgStore.GroupPicDown";
      localProtoReq.reqBody = constructReqBody(paramRichProtoReq.reqs);
      localProtoReq.busiData = paramRichProtoReq;
      localProtoReq.callback = this;
      inner_sendToProtoReq(paramRichProtoReq, localProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.GroupPicDownHandler
 * JD-Core Version:    0.7.0.1
 */