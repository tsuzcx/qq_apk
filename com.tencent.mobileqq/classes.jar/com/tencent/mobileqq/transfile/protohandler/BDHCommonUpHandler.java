package com.tencent.mobileqq.transfile.protohandler;

import anza;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
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
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388.ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388.RspBody;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpImgReq;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpImgRsp;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpInfo4Busi;

public class BDHCommonUpHandler
  extends BaseHandler
{
  int mReqNetType;
  
  private void handleBusSuc(RichProto.RichProtoResp.BDHCommonUpResp paramBDHCommonUpResp, cmd0x388.TryUpImgRsp paramTryUpImgRsp)
  {
    boolean bool = false;
    if (paramTryUpImgRsp.msg_info4busi.has())
    {
      localObject1 = (cmd0x388.TryUpInfo4Busi)paramTryUpImgRsp.msg_info4busi.get();
      if (((cmd0x388.TryUpInfo4Busi)localObject1).bytes_down_domain.has()) {
        paramBDHCommonUpResp.downDomain = ((cmd0x388.TryUpInfo4Busi)localObject1).bytes_down_domain.get().toStringUtf8();
      }
      if (((cmd0x388.TryUpInfo4Busi)localObject1).bytes_big_down_url.has()) {
        paramBDHCommonUpResp.bigDownUrl = ((cmd0x388.TryUpInfo4Busi)localObject1).bytes_big_down_url.get().toStringUtf8();
      }
      if (((cmd0x388.TryUpInfo4Busi)localObject1).bytes_original_down_url.has()) {
        paramBDHCommonUpResp.orgiDownUrl = ((cmd0x388.TryUpInfo4Busi)localObject1).bytes_original_down_url.get().toStringUtf8();
      }
      if (((cmd0x388.TryUpInfo4Busi)localObject1).bytes_thumb_down_url.has()) {
        paramBDHCommonUpResp.thumbDownUrl = ((cmd0x388.TryUpInfo4Busi)localObject1).bytes_thumb_down_url.get().toStringUtf8();
      }
      if (((cmd0x388.TryUpInfo4Busi)localObject1).bytes_file_resid.has()) {
        paramBDHCommonUpResp.resid = ((cmd0x388.TryUpInfo4Busi)localObject1).bytes_file_resid.get().toStringUtf8();
      }
    }
    paramBDHCommonUpResp.groupFileID = paramTryUpImgRsp.uint64_fileid.get();
    Object localObject1 = paramTryUpImgRsp.rpt_uint32_up_ip.get();
    Object localObject2 = paramTryUpImgRsp.rpt_uint32_up_port.get();
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      int i = 0;
      while (i < ((List)localObject1).size())
      {
        long l1 = ((Integer)((List)localObject1).get(i)).intValue();
        long l2 = ((Integer)((List)localObject2).get(i)).intValue();
        ServerAddr localServerAddr = new ServerAddr();
        localServerAddr.mIp = PkgTools.int2IPNet(l1 & 0xFFFFFFFF);
        localServerAddr.port = ((int)l2);
        paramBDHCommonUpResp.mIpList.add(i, localServerAddr);
        i += 1;
      }
    }
    if ((paramTryUpImgRsp.bool_file_exit.has()) && (paramTryUpImgRsp.bool_file_exit.get())) {
      paramBDHCommonUpResp.isExist = true;
    }
    do
    {
      return;
      localObject2 = HexUtil.bytes2HexStr(paramTryUpImgRsp.bytes_up_ukey.get().toByteArray());
      if ((localObject2 == null) || (((String)localObject2).equals("")) || (localObject1 == null) || (((List)localObject1).size() == 0)) {
        throw new Exception("check ukey,iplist");
      }
      paramBDHCommonUpResp.mUkey = ((String)localObject2);
      paramBDHCommonUpResp.blockSize = ((int)paramTryUpImgRsp.uint64_block_size.get());
      paramBDHCommonUpResp.transferedSize = ((int)paramTryUpImgRsp.uint64_up_offset.get());
      if (NetworkCenter.getInstance().getNetType() != this.mReqNetType) {
        bool = true;
      }
      paramBDHCommonUpResp.networkChange = bool;
      paramBDHCommonUpResp.startOffset = paramTryUpImgRsp.uint64_up_offset.get();
      if (QLog.isColorLevel()) {
        QLog.d("BDH_LOG", 2, " Channel:" + paramTryUpImgRsp.bool_new_big_chan.get());
      }
    } while ((!paramTryUpImgRsp.bool_new_big_chan.has()) || (paramTryUpImgRsp.bool_new_big_chan.get() != true));
    paramBDHCommonUpResp.isUseBdh = true;
  }
  
  public static boolean shouldRetryByRetCode(int paramInt)
  {
    return (paramInt != 196) && (paramInt != 194) && (paramInt != 197) && (paramInt != 199) && (paramInt != 200) && (paramInt != 201) && (paramInt != 203) && (paramInt != 202) && (paramInt != 120509) && (paramInt != 400010) && (paramInt != 400011);
  }
  
  void addOne(int paramInt, RichProto.RichProtoReq.ReqCommon paramReqCommon, cmd0x388.ReqBody paramReqBody)
  {
    paramReqCommon = (RichProto.RichProtoReq.PicUpReq)paramReqCommon;
    cmd0x388.TryUpImgReq localTryUpImgReq = new cmd0x388.TryUpImgReq();
    localTryUpImgReq.setHasFlag(true);
    localTryUpImgReq.uint64_src_uin.set(Long.valueOf(paramReqCommon.selfUin).longValue());
    localTryUpImgReq.uint64_group_code.set(Long.valueOf(paramReqCommon.peerUin).longValue());
    localTryUpImgReq.uint64_file_id.set(paramInt);
    localTryUpImgReq.uint64_file_size.set(paramReqCommon.fileSize);
    localTryUpImgReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramReqCommon.md5));
    localTryUpImgReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(paramReqCommon.fileName));
    localTryUpImgReq.uint32_src_term.set(5);
    localTryUpImgReq.uint32_platform_type.set(9);
    localTryUpImgReq.uint32_pic_width.set(paramReqCommon.width);
    localTryUpImgReq.uint32_pic_height.set(paramReqCommon.height);
    localTryUpImgReq.uint32_pic_type.set(paramReqCommon.picType);
    PBUInt32Field localPBUInt32Field = localTryUpImgReq.uint32_bu_type;
    if (paramReqCommon.uinType == 1) {}
    for (paramInt = 1;; paramInt = 2)
    {
      localPBUInt32Field.set(paramInt);
      localTryUpImgReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(RichMediaUtil.getVersionCode()));
      if (paramReqCommon.isRaw) {
        localTryUpImgReq.uint32_original_pic.set(1);
      }
      paramReqBody.rpt_msg_tryup_img_req.add(localTryUpImgReq);
      return;
    }
  }
  
  byte[] constructReqBody(RichProto.RichProtoReq paramRichProtoReq)
  {
    if (paramRichProtoReq == null) {
      return null;
    }
    List localList = paramRichProtoReq.reqs;
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(1);
    localReqBody.uint32_command_id.set(paramRichProtoReq.commandId);
    if (paramRichProtoReq.extention != null) {
      localReqBody.bytes_extension.set(ByteStringMicro.copyFrom(paramRichProtoReq.extention));
    }
    int i = 0;
    while (i < localList.size())
    {
      addOne(i, (RichProto.RichProtoReq.ReqCommon)localList.get(i), localReqBody);
      i += 1;
    }
    i = NetworkCenter.getInstance().getNetType();
    this.mReqNetType = i;
    switch (i)
    {
    default: 
      i = 6;
    }
    for (;;)
    {
      paramRichProtoReq = NetworkCenter.getInstance().getApnType();
      int j = i;
      if (paramRichProtoReq != null)
      {
        j = i;
        if (paramRichProtoReq.contains("wap")) {
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
  
  protected void handleSucResp(FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp, anza paramanza, ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    try
    {
      paramProtoResp = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(paramArrayOfByte)).rpt_msg_tryup_img_rsp.get();
      if ((paramProtoResp == null) || (paramProtoResp.size() == 0)) {
        throw new Exception("resps null");
      }
    }
    catch (Exception paramFromServiceMsg)
    {
      setResult(-1, -9527, BaseTransProcessor.getServerReason("P", -9529L), paramFromServiceMsg.getMessage() + " hex:" + HexUtil.bytes2HexStr(paramArrayOfByte), paramanza, paramRichProtoResp.resps);
    }
    for (;;)
    {
      return;
      Iterator localIterator = paramProtoResp.iterator();
      while (localIterator.hasNext())
      {
        paramProtoResp = (cmd0x388.TryUpImgRsp)localIterator.next();
        try
        {
          localBDHCommonUpResp = (RichProto.RichProtoResp.BDHCommonUpResp)paramRichProtoResp.resps.get((int)paramProtoResp.uint64_file_id.get());
          if (localBDHCommonUpResp == null) {
            continue;
          }
          try
          {
            if (paramFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
              localBDHCommonUpResp.isSendByQuickHttp = ((Boolean)paramFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
            }
            i = paramProtoResp.uint32_result.get();
            if (i != 0) {
              break label296;
            }
            handleBusSuc(localBDHCommonUpResp, paramProtoResp);
            setResult(0, 0, "", "", paramanza, localBDHCommonUpResp);
          }
          catch (Exception paramProtoResp) {}
        }
        catch (Exception paramProtoResp)
        {
          for (;;)
          {
            int i;
            RichProto.RichProtoResp.BDHCommonUpResp localBDHCommonUpResp = null;
          }
        }
        setResult(-1, -9527, BaseTransProcessor.getServerReason("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(paramArrayOfByte), paramanza, localBDHCommonUpResp);
        continue;
        label296:
        if (shouldRetryByRetCode(i))
        {
          this.mReqUrlCount += 1;
          if (this.mReqUrlCount < 2)
          {
            paramRichProtoReq.protoReqMgr.sendProtoReq(paramProtoReq);
            return;
          }
        }
        setResult(-1, -9527, BaseTransProcessor.getUrlReason(i), "", paramanza, localBDHCommonUpResp);
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
      RichProto.RichProtoResp.BDHCommonUpResp localBDHCommonUpResp = new RichProto.RichProtoResp.BDHCommonUpResp();
      localRichProtoResp.resps.add(i, localBDHCommonUpResp);
      i += 1;
    }
  }
  
  public void onProtoResp(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    if (QLog.isColorLevel()) {
      QLog.e("BDHCommonUpHandler", 1, "onProtoResp: " + paramProtoResp.resp.getResultCode());
    }
    super.onProtoResp(paramProtoResp, paramProtoReq);
  }
  
  public void sendRichProtoReq(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.reqs != null) && (paramRichProtoReq.protoReqMgr != null))
    {
      ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
      localProtoReq.ssoCmd = "ImgStore.BDHCommonUp";
      localProtoReq.reqBody = constructReqBody(paramRichProtoReq);
      localProtoReq.busiData = paramRichProtoReq;
      localProtoReq.callback = this;
      inner_sendToProtoReq(paramRichProtoReq, localProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.BDHCommonUpHandler
 * JD-Core Version:    0.7.0.1
 */