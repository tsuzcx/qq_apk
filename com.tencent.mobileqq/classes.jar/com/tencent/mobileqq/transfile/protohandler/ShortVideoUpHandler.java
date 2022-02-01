package com.tencent.mobileqq.transfile.protohandler;

import amwm;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.List;
import pttcenterservice.PttShortVideo.DataHole;
import pttcenterservice.PttShortVideo.ExtensionReq;
import pttcenterservice.PttShortVideo.PttShortVideoFileInfo;
import pttcenterservice.PttShortVideo.PttShortVideoUploadReq;
import pttcenterservice.PttShortVideo.PttShortVideoUploadResp;
import pttcenterservice.PttShortVideo.ReqBody;
import pttcenterservice.PttShortVideo.RspBody;

public class ShortVideoUpHandler
  extends BaseHandler
{
  public static final String TAG = "Q.richmedia.ShortVideoUpHandler";
  
  public static boolean shouldRetryByRetCode(int paramInt)
  {
    return (paramInt != 196) && (paramInt != 197) && (paramInt != 199) && (paramInt != 201) && (paramInt != 202) && (paramInt != 206) && (paramInt != 207) && (paramInt != 208);
  }
  
  byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> paramList)
  {
    PttShortVideo.ReqBody localReqBody = new PttShortVideo.ReqBody();
    localReqBody.setHasFlag(true);
    if (paramList.size() == 1)
    {
      paramList = (RichProto.RichProtoReq.ShortVideoUpReq)paramList.get(0);
      PttShortVideo.PttShortVideoUploadReq localPttShortVideoUploadReq = new PttShortVideo.PttShortVideoUploadReq();
      localPttShortVideoUploadReq.setHasFlag(true);
      localPttShortVideoUploadReq.uint64_fromuin.set(Long.parseLong(paramList.selfUin));
      localPttShortVideoUploadReq.uint64_touin.set(Long.parseLong(paramList.peerUin));
      localPttShortVideoUploadReq.uint32_chat_type.set(paramList.chatType);
      localPttShortVideoUploadReq.uint32_client_type.set(paramList.clientType);
      if (paramList.troopUin != null) {
        localPttShortVideoUploadReq.uint64_group_code.set(Long.parseLong(paramList.troopUin));
      }
      for (;;)
      {
        localPttShortVideoUploadReq.uint32_agent_type.set(paramList.agentType);
        localPttShortVideoUploadReq.uint32_business_type.set(paramList.busiType);
        localPttShortVideoUploadReq.uint32_flag_support_large_size.set(1);
        Object localObject = new PttShortVideo.PttShortVideoFileInfo();
        ((PttShortVideo.PttShortVideoFileInfo)localObject).str_file_name.set(paramList.fileName);
        ((PttShortVideo.PttShortVideoFileInfo)localObject).bytes_file_md5.set(ByteStringMicro.copyFrom(paramList.md5));
        ((PttShortVideo.PttShortVideoFileInfo)localObject).bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(paramList.thumbFileMd5));
        ((PttShortVideo.PttShortVideoFileInfo)localObject).uint64_file_size.set(paramList.fileSize);
        ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_res_length.set(paramList.fileResLength);
        ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_res_width.set(paramList.fileResWidth);
        ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_format.set(paramList.format);
        ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_time.set(paramList.fileTime);
        ((PttShortVideo.PttShortVideoFileInfo)localObject).uint64_thumb_file_size.set(paramList.thumbFileSize);
        localPttShortVideoUploadReq.msg_PttShortVideoFileInfo.set((MessageMicro)localObject);
        localObject = new PttShortVideo.ExtensionReq();
        ((PttShortVideo.ExtensionReq)localObject).uint32_sub_busi_type.set(paramList.subBusiType);
        ((PttShortVideo.ExtensionReq)localObject).uint32_user_cnt.set(paramList.userCnt);
        localReqBody.uint32_cmd.set(300);
        localReqBody.uint32_seq.set(paramList.seq);
        localReqBody.msg_PttShortVideoUpload_Req.set(localPttShortVideoUploadReq);
        localReqBody.rpt_msg_extension_req.add((MessageMicro)localObject);
        return localReqBody.toByteArray();
        localPttShortVideoUploadReq.uint64_group_code.set(0L);
      }
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
      RichProto.RichProtoResp.ShortVideoUpResp localShortVideoUpResp = new RichProto.RichProtoResp.ShortVideoUpResp();
      localRichProtoResp.resps.add(i, localShortVideoUpResp);
      i += 1;
    }
  }
  
  public void onProtoResp(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    Object localObject = paramProtoResp.resp;
    byte[] arrayOfByte = paramProtoResp.resp.getWupBuffer();
    RichProto.RichProtoReq localRichProtoReq = (RichProto.RichProtoReq)paramProtoReq.busiData;
    RichProto.RichProtoResp localRichProtoResp = localRichProtoReq.resp;
    amwm localamwm = paramProtoResp.statisInfo;
    int i;
    if (((FromServiceMsg)localObject).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject).getResultCode();
      if ((i == 1002) || (i == 1013)) {
        setResult(-1, 9311, MessageHandler.a((FromServiceMsg)localObject), "", localamwm, localRichProtoResp.resps);
      }
    }
    for (;;)
    {
      RichProtoProc.onBusiProtoResp(localRichProtoReq, localRichProtoResp);
      return;
      setResult(-1, 9044, MessageHandler.a((FromServiceMsg)localObject), "", localamwm, localRichProtoResp.resps);
      continue;
      try
      {
        localObject = (PttShortVideo.PttShortVideoUploadResp)((PttShortVideo.RspBody)new PttShortVideo.RspBody().mergeFrom(arrayOfByte)).msg_PttShortVideoUpload_Resp.get();
        if (localObject != null) {
          break label226;
        }
        throw new Exception("svUpResp null");
      }
      catch (Exception paramProtoResp)
      {
        setResult(-1, -9527, BaseTransProcessor.getServerReason("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localamwm, localRichProtoResp.resps);
      }
      continue;
      for (;;)
      {
        try
        {
          for (;;)
          {
            label226:
            paramProtoResp = (RichProto.RichProtoResp.ShortVideoUpResp)localRichProtoResp.resps.get(0);
            try
            {
              i = ((PttShortVideo.PttShortVideoUploadResp)localObject).int32_ret_code.get();
              if (i != 0) {
                break label497;
              }
              if (1 != ((PttShortVideo.PttShortVideoUploadResp)localObject).uint32_file_exist.get()) {
                break label386;
              }
              paramProtoResp.isExist = true;
              paramProtoResp.fileId = ((PttShortVideo.PttShortVideoUploadResp)localObject).str_fileid.get();
              paramProtoResp.videoAttr = ((PttShortVideo.PttShortVideoUploadResp)localObject).uint32_is_hot_file.get();
              paramProtoResp.videoKandianType = ((PttShortVideo.PttShortVideoUploadResp)localObject).uint32_long_video_carry_watch_point_type.get();
              setResult(0, 0, "", "", localamwm, paramProtoResp);
            }
            catch (Exception localException)
            {
              paramProtoReq = paramProtoResp;
              paramProtoResp = localException;
            }
          }
        }
        catch (Exception paramProtoResp)
        {
          label386:
          paramProtoReq = null;
          continue;
        }
        setResult(-1, -9527, BaseTransProcessor.getServerReason("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localamwm, paramProtoReq);
        break;
        paramProtoReq = localException.bytes_ukey.get().toByteArray();
        if (((localException.rpt_same_area_out_addr.size() <= 0) && (localException.rpt_diff_area_out_addr.size() <= 0)) || (paramProtoReq == null) || (paramProtoReq.length == 0)) {
          throw new Exception("check ip, port, ukey");
        }
        paramProtoResp.fileId = localException.str_fileid.get();
        paramProtoReq = localException.rpt_data_hole.get();
        if ((paramProtoReq != null) && (paramProtoReq.size() > 0)) {
          paramProtoResp.startOffset = ((PttShortVideo.DataHole)paramProtoReq.get(0)).uint64_begin.get();
        }
      }
      label497:
      if (shouldRetryByRetCode(i))
      {
        this.mReqUrlCount += 1;
        if (this.mReqUrlCount < 2)
        {
          localRichProtoReq.protoReqMgr.sendProtoReq(paramProtoReq);
          return;
        }
      }
      setResult(-1, -9527, BaseTransProcessor.getUrlReason(i), "", localamwm, paramProtoResp);
    }
  }
  
  public void sendRichProtoReq(RichProto.RichProtoReq paramRichProtoReq)
  {
    ProtoReqManager.ProtoReq localProtoReq;
    RichProto.RichProtoReq.ReqCommon localReqCommon;
    if ((paramRichProtoReq != null) && (paramRichProtoReq.reqs != null) && (paramRichProtoReq.protoReqMgr != null))
    {
      localProtoReq = new ProtoReqManager.ProtoReq();
      if (paramRichProtoReq.reqs.size() != 1) {
        break label134;
      }
      localReqCommon = (RichProto.RichProtoReq.ReqCommon)paramRichProtoReq.reqs.get(0);
      if (localReqCommon.uinType != 0) {
        break label96;
      }
      localProtoReq.ssoCmd = "PttCenterSvr.ShortVideoUpReq";
    }
    for (;;)
    {
      localProtoReq.reqBody = constructReqBody(paramRichProtoReq.reqs);
      localProtoReq.busiData = paramRichProtoReq;
      localProtoReq.callback = this;
      inner_sendToProtoReq(paramRichProtoReq, localProtoReq);
      return;
      label96:
      if ((1 == localReqCommon.uinType) || (3000 == localReqCommon.uinType)) {
        localProtoReq.ssoCmd = "PttCenterSvr.GroupShortVideoUpReq";
      } else {
        localProtoReq.ssoCmd = "PttCenterSvr.ShortVideoUpReq";
      }
    }
    label134:
    throw new RuntimeException("only support one request");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.ShortVideoUpHandler
 * JD-Core Version:    0.7.0.1
 */