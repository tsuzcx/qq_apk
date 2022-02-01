package com.tencent.mobileqq.transfile.protohandler;

import amwm;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x352.cmd0x352.ReqBody;
import tencent.im.cs.cmd0x352.cmd0x352.RspBody;
import tencent.im.cs.cmd0x352.cmd0x352.TryUpImgReq;
import tencent.im.cs.cmd0x352.cmd0x352.TryUpImgRsp;

public class C2CPicUpHandler
  extends PicUpHandler
{
  int mReqNetType;
  
  public static boolean shouldRetryByRetCode(int paramInt)
  {
    return (paramInt != 196) && (paramInt != 197) && (paramInt != 199) && (paramInt != 201) && (paramInt != 202) && (paramInt != 206) && (paramInt != 207) && (paramInt != 208);
  }
  
  void addOne(int paramInt, RichProto.RichProtoReq.ReqCommon paramReqCommon, cmd0x352.ReqBody paramReqBody)
  {
    RichProto.RichProtoReq.PicUpReq localPicUpReq = (RichProto.RichProtoReq.PicUpReq)paramReqCommon;
    cmd0x352.TryUpImgReq localTryUpImgReq = new cmd0x352.TryUpImgReq();
    localTryUpImgReq.uint64_file_id.set(paramInt);
    localTryUpImgReq.setHasFlag(true);
    localTryUpImgReq.uint64_src_uin.set(Long.valueOf(localPicUpReq.selfUin).longValue());
    try
    {
      String str = localPicUpReq.peerUin;
      paramReqCommon = str;
      if (str.startsWith("+")) {
        paramReqCommon = str.substring(1);
      }
      long l = Long.valueOf(paramReqCommon).longValue();
      localTryUpImgReq.uint64_dst_uin.set(l);
    }
    catch (Exception paramReqCommon)
    {
      for (;;)
      {
        paramReqCommon.printStackTrace();
      }
    }
    localTryUpImgReq.uint64_file_size.set(localPicUpReq.fileSize);
    localTryUpImgReq.bytes_file_md5.set(ByteStringMicro.copyFrom(localPicUpReq.md5));
    localTryUpImgReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(localPicUpReq.fileName));
    localTryUpImgReq.uint32_src_term.set(5);
    localTryUpImgReq.bool_address_book.set(localPicUpReq.isContact);
    localTryUpImgReq.uint32_platform_type.set(9);
    setBuType(localTryUpImgReq);
    localTryUpImgReq.bool_pic_original.set(localPicUpReq.isRaw);
    localTryUpImgReq.uint32_pic_width.set(localPicUpReq.width);
    localTryUpImgReq.uint32_pic_height.set(localPicUpReq.height);
    localTryUpImgReq.uint32_pic_type.set(localPicUpReq.picType);
    localTryUpImgReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(RichMediaUtil.getVersionCode()));
    localTryUpImgReq.bool_reject_tryfast.set(false);
    localTryUpImgReq.uint32_srv_upload.set(localPicUpReq.typeHotPic);
    if (!TextUtils.isEmpty(localPicUpReq.transferUrl)) {
      localTryUpImgReq.bytes_transfer_url.set(ByteStringMicro.copyFromUtf8(localPicUpReq.transferUrl));
    }
    paramReqBody.rpt_msg_tryup_img_req.add(localTryUpImgReq);
  }
  
  byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> paramList)
  {
    cmd0x352.ReqBody localReqBody = new cmd0x352.ReqBody();
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
      paramProtoResp = ((cmd0x352.RspBody)new cmd0x352.RspBody().mergeFrom(paramArrayOfByte)).rpt_msg_tryup_img_rsp.get();
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
        paramProtoResp = (cmd0x352.TryUpImgRsp)localIterator.next();
        try
        {
          localC2CPicUpResp = (RichProto.RichProtoResp.C2CPicUpResp)paramRichProtoResp.resps.get((int)paramProtoResp.uint64_file_id.get());
          if (localC2CPicUpResp == null) {
            continue;
          }
          try
          {
            if (paramFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
              localC2CPicUpResp.isSendByQuickHttp = ((Boolean)paramFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
            }
            i = paramProtoResp.uint32_result.get();
            if (i != 0) {
              break label298;
            }
            parseResp(paramProtoResp, localC2CPicUpResp);
            setResult(0, 0, "", "", paramamwm, localC2CPicUpResp);
          }
          catch (Exception paramProtoResp) {}
        }
        catch (Exception paramProtoResp)
        {
          for (;;)
          {
            int i;
            RichProto.RichProtoResp.C2CPicUpResp localC2CPicUpResp = null;
          }
        }
        setResult(-1, -9527, BaseTransProcessor.getServerReason("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(paramArrayOfByte), paramamwm, localC2CPicUpResp);
        continue;
        label298:
        if (shouldRetryByRetCode(i))
        {
          this.mReqUrlCount += 1;
          if (this.mReqUrlCount < 2)
          {
            paramRichProtoReq.protoReqMgr.sendProtoReq(paramProtoReq);
            return;
          }
        }
        setResult(-1, -9527, BaseTransProcessor.getUrlReason(i), "", paramamwm, localC2CPicUpResp);
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
      RichProto.RichProtoResp.C2CPicUpResp localC2CPicUpResp = new RichProto.RichProtoResp.C2CPicUpResp();
      localRichProtoResp.resps.add(i, localC2CPicUpResp);
      i += 1;
    }
  }
  
  void parseResp(cmd0x352.TryUpImgRsp paramTryUpImgRsp, RichProto.RichProtoResp.C2CPicUpResp paramC2CPicUpResp)
  {
    boolean bool = true;
    if (paramTryUpImgRsp.bytes_up_resid.has()) {
      paramC2CPicUpResp.mResid = paramTryUpImgRsp.bytes_up_resid.get().toStringUtf8();
    }
    if (paramTryUpImgRsp.bytes_up_uuid.has()) {
      paramC2CPicUpResp.mUuid = paramTryUpImgRsp.bytes_up_uuid.get().toStringUtf8();
    }
    paramC2CPicUpResp.startOffset = paramTryUpImgRsp.uint64_up_offset.get();
    if (QLog.isColorLevel()) {
      QLog.d("BDH_LOG", 2, " TryUpLoad : Offset:" + paramC2CPicUpResp.startOffset + " Value:" + paramTryUpImgRsp.uint64_up_offset.get());
    }
    if ((paramTryUpImgRsp.bool_file_exit.has()) && (paramTryUpImgRsp.bool_file_exit.get()))
    {
      paramC2CPicUpResp.isExist = true;
      if (paramTryUpImgRsp.bytes_original_down_para.has()) {
        paramC2CPicUpResp.mOriginalDownPara = paramTryUpImgRsp.bytes_original_down_para.get().toStringUtf8();
      }
      return;
    }
    paramC2CPicUpResp.mUkey = HexUtil.bytes2HexStr(paramTryUpImgRsp.bytes_up_ukey.get().toByteArray());
    paramC2CPicUpResp.blockSize = ((int)paramTryUpImgRsp.uint64_block_size.get());
    if (NetworkCenter.getInstance().getNetType() != this.mReqNetType) {}
    for (;;)
    {
      paramC2CPicUpResp.networkChange = bool;
      break;
      bool = false;
    }
  }
  
  public void sendRichProtoReq(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.reqs != null) && (paramRichProtoReq.protoReqMgr != null))
    {
      ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
      setSsoCmd(localProtoReq);
      localProtoReq.reqBody = constructReqBody(paramRichProtoReq.reqs);
      localProtoReq.busiData = paramRichProtoReq;
      localProtoReq.callback = this;
      inner_sendToProtoReq(paramRichProtoReq, localProtoReq);
    }
  }
  
  protected void setBuType(cmd0x352.TryUpImgReq paramTryUpImgReq)
  {
    paramTryUpImgReq.uint32_bu_type.set(1);
  }
  
  protected void setSsoCmd(ProtoReqManager.ProtoReq paramProtoReq)
  {
    paramProtoReq.ssoCmd = "LongConn.OffPicUp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.C2CPicUpHandler
 * JD-Core Version:    0.7.0.1
 */