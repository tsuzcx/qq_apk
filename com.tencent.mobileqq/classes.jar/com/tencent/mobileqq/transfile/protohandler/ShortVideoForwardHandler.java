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
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import pttcenterservice.PttShortVideo.DataHole;
import pttcenterservice.PttShortVideo.PttShortVideoFileInfo;
import pttcenterservice.PttShortVideo.PttShortVideoRetweetReq;
import pttcenterservice.PttShortVideo.PttShortVideoRetweetResp;
import pttcenterservice.PttShortVideo.ReqBody;
import pttcenterservice.PttShortVideo.RspBody;

public class ShortVideoForwardHandler
  extends BaseHandler
{
  public static final String TAG = "Q.richmedia.ShortVideoForwardHandler";
  
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
      RichProto.RichProtoReq.ShortVideoForwardReq localShortVideoForwardReq = (RichProto.RichProtoReq.ShortVideoForwardReq)paramList.get(0);
      PttShortVideo.PttShortVideoRetweetReq localPttShortVideoRetweetReq = new PttShortVideo.PttShortVideoRetweetReq();
      localPttShortVideoRetweetReq.setHasFlag(true);
      localPttShortVideoRetweetReq.uint64_from_uin.set(Long.parseLong(localShortVideoForwardReq.fromUin));
      localPttShortVideoRetweetReq.uint64_to_uin.set(Long.parseLong(localShortVideoForwardReq.peerUin));
      localPttShortVideoRetweetReq.uint32_from_chat_type.set(localShortVideoForwardReq.fromChatType);
      localPttShortVideoRetweetReq.uint32_to_chat_type.set(localShortVideoForwardReq.toChatType);
      localPttShortVideoRetweetReq.uint32_from_busi_type.set(localShortVideoForwardReq.fromBusiType);
      localPttShortVideoRetweetReq.uint32_to_busi_type.set(localShortVideoForwardReq.toBusiType);
      localPttShortVideoRetweetReq.uint32_client_type.set(localShortVideoForwardReq.clientType);
      localPttShortVideoRetweetReq.uint32_agent_type.set(localShortVideoForwardReq.agentType);
      Object localObject = localPttShortVideoRetweetReq.str_fileid;
      if (localShortVideoForwardReq.uuid == null)
      {
        paramList = "";
        ((PBStringField)localObject).set(paramList);
        if (localShortVideoForwardReq.troopUin == null) {
          break label436;
        }
      }
      for (;;)
      {
        try
        {
          localPttShortVideoRetweetReq.uint64_group_code.set(Long.parseLong(localShortVideoForwardReq.troopUin));
          localPttShortVideoRetweetReq.uint32_flag_support_large_size.set(1);
          localObject = new PttShortVideo.PttShortVideoFileInfo();
          PBStringField localPBStringField = ((PttShortVideo.PttShortVideoFileInfo)localObject).str_file_name;
          if (localShortVideoForwardReq.fileName != null) {
            break label448;
          }
          paramList = "";
          localPBStringField.set(paramList);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).bytes_file_md5.set(ByteStringMicro.copyFrom(localShortVideoForwardReq.md5));
          ((PttShortVideo.PttShortVideoFileInfo)localObject).bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(localShortVideoForwardReq.thumbFileMd5));
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint64_file_size.set(localShortVideoForwardReq.fileSize);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_res_length.set(localShortVideoForwardReq.fileResLength);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_res_width.set(localShortVideoForwardReq.fileResWidth);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_format.set(localShortVideoForwardReq.format);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_time.set(localShortVideoForwardReq.fileTime);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint64_thumb_file_size.set(localShortVideoForwardReq.thumbFileSize);
          localPttShortVideoRetweetReq.msg_PttShortVideoFileInfo.set((MessageMicro)localObject);
          localReqBody.uint32_cmd.set(500);
          localReqBody.uint32_seq.set(localShortVideoForwardReq.seq);
          localReqBody.rpt_msg_short_video_retweet_req.add(localPttShortVideoRetweetReq);
          return localReqBody.toByteArray();
          paramList = localShortVideoForwardReq.uuid;
        }
        catch (NumberFormatException paramList)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.richmedia.ShortVideoForwardHandler", 2, "NumberFormatException e = " + paramList);
          }
          localPttShortVideoRetweetReq.uint64_group_code.set(0L);
          continue;
        }
        label436:
        localPttShortVideoRetweetReq.uint64_group_code.set(0L);
        continue;
        label448:
        paramList = localShortVideoForwardReq.fileName;
      }
    }
    throw new RuntimeException("only support one request");
  }
  
  void initResps(RichProto.RichProtoReq paramRichProtoReq)
  {
    RichProto.RichProtoResp localRichProtoResp = paramRichProtoReq.resp;
    localRichProtoResp.resps.clear();
    int j = paramRichProtoReq.reqs.size();
    int i = 0;
    while (i < j)
    {
      paramRichProtoReq = new RichProto.RichProtoResp.ShortVideoForwardResp();
      localRichProtoResp.resps.add(i, paramRichProtoReq);
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
        localObject = (PttShortVideo.PttShortVideoRetweetResp)((PttShortVideo.RspBody)new PttShortVideo.RspBody().mergeFrom(arrayOfByte)).rpt_msg_short_video_retweet_resp.get(0);
        if (localObject != null) {
          break label225;
        }
        throw new Exception("forwardResp null");
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
            label225:
            paramProtoResp = (RichProto.RichProtoResp.ShortVideoForwardResp)localRichProtoResp.resps.get(0);
            try
            {
              i = ((PttShortVideo.PttShortVideoRetweetResp)localObject).int32_ret_code.get();
              if (i != 0) {
                break label494;
              }
              if (1 != ((PttShortVideo.PttShortVideoRetweetResp)localObject).uint32_file_exist.get()) {
                break label383;
              }
              paramProtoResp.isExist = true;
              paramProtoResp.fileId = ((PttShortVideo.PttShortVideoRetweetResp)localObject).str_fileid.get();
              paramProtoResp.videoAttr = ((PttShortVideo.PttShortVideoRetweetResp)localObject).uint32_is_hot_file.get();
              paramProtoResp.videoKandianType = ((PttShortVideo.PttShortVideoRetweetResp)localObject).uint32_long_video_carry_watch_point_type.get();
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
          label383:
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
      label494:
      if (i == -5100026)
      {
        setResult(-1, -5100026, BaseTransProcessor.getUrlReason(i), "", localamwm, paramProtoResp);
      }
      else
      {
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
  }
  
  public void sendRichProtoReq(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.reqs != null) && (paramRichProtoReq.protoReqMgr != null))
    {
      ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
      if (paramRichProtoReq.reqs.size() == 1)
      {
        localProtoReq.ssoCmd = "PttCenterSvr.ShortVideoRetweetReq";
        localProtoReq.reqBody = constructReqBody(paramRichProtoReq.reqs);
        localProtoReq.busiData = paramRichProtoReq;
        localProtoReq.callback = this;
        inner_sendToProtoReq(paramRichProtoReq, localProtoReq);
      }
    }
    else
    {
      return;
    }
    throw new RuntimeException("only support one request");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.ShortVideoForwardHandler
 * JD-Core Version:    0.7.0.1
 */