package com.tencent.mobileqq.transfile.protohandler;

import amwm;
import android.text.TextUtils;
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

public class GroupPicUpHandler
  extends PicUpHandler
{
  int mReqNetType;
  
  private void handleSucResult(amwm paramamwm, cmd0x388.TryUpImgRsp paramTryUpImgRsp, RichProto.RichProtoResp.GroupPicUpResp paramGroupPicUpResp)
  {
    paramGroupPicUpResp.groupFileID = paramTryUpImgRsp.uint64_fileid.get();
    List localList;
    int i;
    if ((paramTryUpImgRsp.bool_file_exit.has()) && (paramTryUpImgRsp.bool_file_exit.get()))
    {
      paramGroupPicUpResp.isExist = true;
      localList = paramTryUpImgRsp.rpt_uint32_up_ip.get();
      paramTryUpImgRsp = paramTryUpImgRsp.rpt_uint32_up_port.get();
      if ((localList != null) && (localList.size() > 0)) {
        i = 0;
      }
    }
    else
    {
      while (i < localList.size())
      {
        long l1 = ((Integer)localList.get(i)).intValue();
        long l2 = ((Integer)paramTryUpImgRsp.get(i)).intValue();
        Object localObject = new ServerAddr();
        ((ServerAddr)localObject).mIp = PkgTools.int2IPNet(l1 & 0xFFFFFFFF);
        ((ServerAddr)localObject).port = ((int)l2);
        paramGroupPicUpResp.mIpList.add(i, localObject);
        i += 1;
        continue;
        localList = paramTryUpImgRsp.rpt_uint32_up_ip.get();
        localObject = paramTryUpImgRsp.rpt_uint32_up_port.get();
        if ((localList != null) && (localList.size() > 0))
        {
          i = 0;
          while (i < localList.size())
          {
            l1 = ((Integer)localList.get(i)).intValue();
            l2 = ((Integer)((List)localObject).get(i)).intValue();
            ServerAddr localServerAddr = new ServerAddr();
            localServerAddr.mIp = PkgTools.int2IPNet(l1 & 0xFFFFFFFF);
            localServerAddr.port = ((int)l2);
            paramGroupPicUpResp.mIpList.add(i, localServerAddr);
            i += 1;
          }
        }
        localObject = HexUtil.bytes2HexStr(paramTryUpImgRsp.bytes_up_ukey.get().toByteArray());
        if ((localObject == null) || (((String)localObject).equals("")) || (localList == null) || (localList.size() == 0)) {
          throw new Exception("check ukey,iplist");
        }
        paramGroupPicUpResp.mUkey = ((String)localObject);
        paramGroupPicUpResp.blockSize = ((int)paramTryUpImgRsp.uint64_block_size.get());
        paramGroupPicUpResp.transferedSize = ((int)paramTryUpImgRsp.uint64_up_offset.get());
        if (NetworkCenter.getInstance().getNetType() == this.mReqNetType) {
          break label498;
        }
      }
    }
    label498:
    for (boolean bool = true;; bool = false)
    {
      paramGroupPicUpResp.networkChange = bool;
      paramGroupPicUpResp.startOffset = paramTryUpImgRsp.uint64_up_offset.get();
      if (QLog.isColorLevel()) {
        QLog.d("BDH_LOG", 2, " Channel:" + paramTryUpImgRsp.bool_new_big_chan.get());
      }
      if ((paramTryUpImgRsp.bool_new_big_chan.has()) && (paramTryUpImgRsp.bool_new_big_chan.get() == true)) {
        paramGroupPicUpResp.isUseBdh = true;
      }
      setResult(0, 0, "", "", paramamwm, paramGroupPicUpResp);
      return;
    }
  }
  
  public static boolean shouldRetryByRetCode(int paramInt)
  {
    return (paramInt != 196) && (paramInt != 194) && (paramInt != 197) && (paramInt != 199) && (paramInt != 200) && (paramInt != 201) && (paramInt != 203) && (paramInt != 202);
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
    localTryUpImgReq.uint32_app_pic_type.set(paramReqCommon.busiType);
    PBUInt32Field localPBUInt32Field = localTryUpImgReq.uint32_bu_type;
    if (paramReqCommon.uinType == 1) {}
    for (paramInt = 1;; paramInt = 2)
    {
      localPBUInt32Field.set(paramInt);
      localTryUpImgReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(RichMediaUtil.getVersionCode()));
      localTryUpImgReq.uint32_srv_upload.set(paramReqCommon.typeHotPic);
      if (paramReqCommon.isRaw) {
        localTryUpImgReq.uint32_original_pic.set(1);
      }
      if (!TextUtils.isEmpty(paramReqCommon.transferUrl)) {
        localTryUpImgReq.bytes_transfer_url.set(ByteStringMicro.copyFromUtf8(paramReqCommon.transferUrl));
      }
      paramReqBody.rpt_msg_tryup_img_req.add(localTryUpImgReq);
      return;
    }
  }
  
  byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> paramList)
  {
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(1);
    int i = 0;
    while (i < paramList.size())
    {
      addOne(i, (RichProto.RichProtoReq.ReqCommon)paramList.get(i), localReqBody);
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
  
  protected void handleSucResp(FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp, amwm paramamwm, ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
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
      setResult(-1, -9527, BaseTransProcessor.getServerReason("P", -9529L), paramFromServiceMsg.getMessage() + " hex:" + HexUtil.bytes2HexStr(paramArrayOfByte), paramamwm, paramRichProtoResp.resps);
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
          localGroupPicUpResp = (RichProto.RichProtoResp.GroupPicUpResp)paramRichProtoResp.resps.get((int)paramProtoResp.uint64_file_id.get());
          if (localGroupPicUpResp == null) {
            continue;
          }
          try
          {
            if (paramFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
              localGroupPicUpResp.isSendByQuickHttp = ((Boolean)paramFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
            }
            i = paramProtoResp.uint32_result.get();
            if (i != 0) {
              break label284;
            }
            handleSucResult(paramamwm, paramProtoResp, localGroupPicUpResp);
          }
          catch (Exception paramProtoResp) {}
        }
        catch (Exception paramProtoResp)
        {
          for (;;)
          {
            int i;
            RichProto.RichProtoResp.GroupPicUpResp localGroupPicUpResp = null;
          }
        }
        setResult(-1, -9527, BaseTransProcessor.getServerReason("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(paramArrayOfByte), paramamwm, localGroupPicUpResp);
        continue;
        label284:
        if (shouldRetryByRetCode(i))
        {
          this.mReqUrlCount += 1;
          if (this.mReqUrlCount < 2)
          {
            paramRichProtoReq.protoReqMgr.sendProtoReq(paramProtoReq);
            return;
          }
        }
        setResult(-1, -9527, BaseTransProcessor.getUrlReason(i), "", paramamwm, localGroupPicUpResp);
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
      RichProto.RichProtoResp.GroupPicUpResp localGroupPicUpResp = new RichProto.RichProtoResp.GroupPicUpResp();
      localRichProtoResp.resps.add(i, localGroupPicUpResp);
      i += 1;
    }
  }
  
  public void sendRichProtoReq(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.reqs != null) && (paramRichProtoReq.protoReqMgr != null))
    {
      ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
      localProtoReq.ssoCmd = "ImgStore.GroupPicUp";
      localProtoReq.reqBody = constructReqBody(paramRichProtoReq.reqs);
      localProtoReq.busiData = paramRichProtoReq;
      localProtoReq.callback = this;
      inner_sendToProtoReq(paramRichProtoReq, localProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.GroupPicUpHandler
 * JD-Core Version:    0.7.0.1
 */