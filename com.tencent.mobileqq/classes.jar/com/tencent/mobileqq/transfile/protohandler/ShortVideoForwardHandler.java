package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
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
      paramList = localShortVideoForwardReq.uuid;
      String str = "";
      if (paramList == null) {
        paramList = "";
      } else {
        paramList = localShortVideoForwardReq.uuid;
      }
      ((PBStringField)localObject).set(paramList);
      if (localShortVideoForwardReq.troopUin != null) {
        try
        {
          localPttShortVideoRetweetReq.uint64_group_code.set(Long.parseLong(localShortVideoForwardReq.troopUin));
        }
        catch (NumberFormatException paramList)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("NumberFormatException e = ");
            ((StringBuilder)localObject).append(paramList);
            QLog.d("Q.richmedia.ShortVideoForwardHandler", 2, ((StringBuilder)localObject).toString());
          }
          localPttShortVideoRetweetReq.uint64_group_code.set(0L);
        }
      } else {
        localPttShortVideoRetweetReq.uint64_group_code.set(0L);
      }
      localPttShortVideoRetweetReq.uint32_flag_support_large_size.set(1);
      localObject = new PttShortVideo.PttShortVideoFileInfo();
      PBStringField localPBStringField = ((PttShortVideo.PttShortVideoFileInfo)localObject).str_file_name;
      if (localShortVideoForwardReq.fileName == null) {
        paramList = str;
      } else {
        paramList = localShortVideoForwardReq.fileName;
      }
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
  
  public void onProtoResp(ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    Object localObject1 = paramProtoResp.resp;
    byte[] arrayOfByte = paramProtoResp.resp.getWupBuffer();
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
    else
    {
      try
      {
        localObject1 = (PttShortVideo.PttShortVideoRetweetResp)((PttShortVideo.RspBody)new PttShortVideo.RspBody().mergeFrom(arrayOfByte)).rpt_msg_short_video_retweet_resp.get(0);
        if (localObject1 != null)
        {
          try
          {
            paramProtoResp = (RichProto.RichProtoResp.ShortVideoForwardResp)localRichProtoResp.resps.get(0);
            try
            {
              i = ((PttShortVideo.PttShortVideoRetweetResp)localObject1).int32_ret_code.get();
              if (i == 0)
              {
                if (1 == ((PttShortVideo.PttShortVideoRetweetResp)localObject1).uint32_file_exist.get())
                {
                  paramProtoResp.isExist = true;
                  paramProtoResp.fileId = ((PttShortVideo.PttShortVideoRetweetResp)localObject1).str_fileid.get();
                }
                else
                {
                  paramProtoReq = ((PttShortVideo.PttShortVideoRetweetResp)localObject1).bytes_ukey.get().toByteArray();
                  if (((((PttShortVideo.PttShortVideoRetweetResp)localObject1).rpt_same_area_out_addr.size() <= 0) && (((PttShortVideo.PttShortVideoRetweetResp)localObject1).rpt_diff_area_out_addr.size() <= 0)) || (paramProtoReq == null) || (paramProtoReq.length == 0)) {
                    break label350;
                  }
                  paramProtoResp.fileId = ((PttShortVideo.PttShortVideoRetweetResp)localObject1).str_fileid.get();
                  paramProtoReq = ((PttShortVideo.PttShortVideoRetweetResp)localObject1).rpt_data_hole.get();
                  if ((paramProtoReq != null) && (paramProtoReq.size() > 0)) {
                    paramProtoResp.startOffset = ((PttShortVideo.DataHole)paramProtoReq.get(0)).uint64_begin.get();
                  }
                }
                paramProtoResp.videoAttr = ((PttShortVideo.PttShortVideoRetweetResp)localObject1).uint32_is_hot_file.get();
                paramProtoResp.videoKandianType = ((PttShortVideo.PttShortVideoRetweetResp)localObject1).uint32_long_video_carry_watch_point_type.get();
                setResult(0, 0, "", "", localStatictisInfo, paramProtoResp);
                break label613;
                label350:
                throw new Exception("check ip, port, ukey");
              }
              else if (i == -5100026)
              {
                setResult(-1, -5100026, ProcessorReport.getUrlReason(i), "", localStatictisInfo, paramProtoResp);
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
                setResult(-1, -9527, ProcessorReport.getUrlReason(i), "", localStatictisInfo, paramProtoResp);
              }
            }
            catch (Exception localException)
            {
              paramProtoReq = paramProtoResp;
              paramProtoResp = localException;
            }
            localObject2 = ProcessorReport.getServerReason("P", -9529L);
          }
          catch (Exception paramProtoResp)
          {
            paramProtoReq = null;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramProtoResp.getMessage());
          localStringBuilder.append(" hex:");
          localStringBuilder.append(HexUtil.bytes2HexStr(arrayOfByte));
          setResult(-1, -9527, (String)localObject2, localStringBuilder.toString(), localStatictisInfo, paramProtoReq);
        }
        else
        {
          throw new Exception("forwardResp null");
        }
      }
      catch (Exception paramProtoResp)
      {
        paramProtoReq = ProcessorReport.getServerReason("P", -9529L);
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramProtoResp.getMessage());
        ((StringBuilder)localObject2).append(" hex:");
        ((StringBuilder)localObject2).append(HexUtil.bytes2HexStr(arrayOfByte));
        setResult(-1, -9527, paramProtoReq, ((StringBuilder)localObject2).toString(), localStatictisInfo, localRichProtoResp.resps);
      }
    }
    label613:
    RichProtoProc.onBusiProtoResp(localRichProtoReq, localRichProtoResp);
  }
  
  public void sendRichProtoReq(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.reqs != null) && (paramRichProtoReq.protoReqMgr != null))
    {
      ProtoReqManagerImpl.ProtoReq localProtoReq = new ProtoReqManagerImpl.ProtoReq();
      if (paramRichProtoReq.reqs.size() == 1)
      {
        localProtoReq.ssoCmd = "PttCenterSvr.ShortVideoRetweetReq";
        localProtoReq.reqBody = constructReqBody(paramRichProtoReq.reqs);
        localProtoReq.busiData = paramRichProtoReq;
        localProtoReq.callback = this;
        inner_sendToProtoReq(paramRichProtoReq, localProtoReq);
        return;
      }
      throw new RuntimeException("only support one request");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.ShortVideoForwardHandler
 * JD-Core Version:    0.7.0.1
 */