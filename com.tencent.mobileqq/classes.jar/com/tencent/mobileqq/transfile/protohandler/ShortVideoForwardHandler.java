package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
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
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import pttcenterservice.PttShortVideo.DataHole;
import pttcenterservice.PttShortVideo.PttShortVideoFileInfo;
import pttcenterservice.PttShortVideo.PttShortVideoIpList;
import pttcenterservice.PttShortVideo.PttShortVideoRetweetReq;
import pttcenterservice.PttShortVideo.PttShortVideoRetweetResp;
import pttcenterservice.PttShortVideo.ReqBody;
import pttcenterservice.PttShortVideo.RspBody;

public class ShortVideoForwardHandler
  extends BaseHandler
{
  public static boolean a(int paramInt)
  {
    return (paramInt != 196) && (paramInt != 197) && (paramInt != 199) && (paramInt != 201) && (paramInt != 202) && (paramInt != 206) && (paramInt != 207) && (paramInt != 208);
  }
  
  public void a(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    Object localObject1 = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    RichProto.RichProtoReq localRichProtoReq = (RichProto.RichProtoReq)paramProtoReq.jdField_a_of_type_JavaLangObject;
    RichProto.RichProtoResp localRichProtoResp = localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoResp;
    MessageObserver.StatictisInfo localStatictisInfo = paramProtoResp.jdField_a_of_type_ComTencentMobileqqAppMessageObserver$StatictisInfo;
    int i;
    if (((FromServiceMsg)localObject1).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject1).getResultCode();
      if ((i == 1002) || (i == 1013)) {
        a(-1, 9311, MessageHandler.a((FromServiceMsg)localObject1), "", localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      }
    }
    for (;;)
    {
      RichProtoProc.a(localRichProtoReq, localRichProtoResp);
      return;
      a(-1, 9044, MessageHandler.a((FromServiceMsg)localObject1), "", localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      continue;
      Object localObject2;
      try
      {
        localObject2 = (PttShortVideo.RspBody)new PttShortVideo.RspBody().mergeFrom(arrayOfByte);
        localObject1 = (PttShortVideo.PttShortVideoRetweetResp)((PttShortVideo.RspBody)localObject2).rpt_msg_short_video_retweet_resp.get(0);
        if (localObject1 != null) {
          break label226;
        }
        throw new Exception("forwardResp null");
      }
      catch (Exception paramProtoResp)
      {
        a(-1, -9527, BaseTransProcessor.a("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      }
      continue;
      for (;;)
      {
        try
        {
          for (;;)
          {
            label226:
            paramProtoResp = (RichProto.RichProtoResp.ShortVideoForwardResp)localRichProtoResp.jdField_a_of_type_JavaUtilList.get(0);
            try
            {
              i = ((PttShortVideo.PttShortVideoRetweetResp)localObject1).int32_ret_code.get();
              if (i != 0) {
                break label683;
              }
              if ((((PttShortVideo.RspBody)localObject2).uint32_change_channel.has()) && (((PttShortVideo.RspBody)localObject2).uint32_change_channel.get() == 1)) {
                paramProtoResp.jdField_b_of_type_Boolean = true;
              }
              if (1 != ((PttShortVideo.PttShortVideoRetweetResp)localObject1).uint32_file_exist.get()) {
                break label398;
              }
              paramProtoResp.jdField_a_of_type_Boolean = true;
              paramProtoResp.jdField_b_of_type_JavaLangString = ((PttShortVideo.PttShortVideoRetweetResp)localObject1).str_fileid.get();
              paramProtoResp.jdField_a_of_type_Int = ((PttShortVideo.PttShortVideoRetweetResp)localObject1).uint32_is_hot_file.get();
              a(0, 0, "", "", localStatictisInfo, paramProtoResp);
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
          label398:
          long l;
          int j;
          paramProtoReq = null;
          continue;
        }
        a(-1, -9527, BaseTransProcessor.a("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localStatictisInfo, paramProtoReq);
        break;
        paramProtoReq = localException.bytes_ukey.get().toByteArray();
        if (((localException.rpt_same_area_out_addr.size() <= 0) && (localException.rpt_diff_area_out_addr.size() <= 0)) || (paramProtoReq == null) || (paramProtoReq.length == 0)) {
          throw new Exception("check ip, port, ukey");
        }
        paramProtoResp.jdField_a_of_type_JavaLangString = HexUtil.bytes2HexStr(paramProtoReq);
        paramProtoResp.jdField_b_of_type_JavaLangString = localException.str_fileid.get();
        paramProtoReq = localException.rpt_same_area_out_addr.get();
        paramProtoReq.addAll(localException.rpt_diff_area_out_addr.get());
        i = 0;
        if (i < paramProtoReq.size())
        {
          localObject2 = (PttShortVideo.PttShortVideoIpList)paramProtoReq.get(i);
          ((PttShortVideo.PttShortVideoIpList)localObject2).uint32_ip.get();
          l = ((PttShortVideo.PttShortVideoIpList)localObject2).uint32_ip.get() & 0xFFFFFFFF;
          if (QLog.isColorLevel()) {
            QLog.d("Q.richmedia.ShortVideoForwardHandler", 2, "onProtoResp---------- ip = " + l);
          }
          if (i == 0) {
            paramProtoResp.jdField_a_of_type_Long = l;
          }
          j = ((PttShortVideo.PttShortVideoIpList)localObject2).uint32_port.get();
          localObject2 = new ServerAddr();
          ((ServerAddr)localObject2).jdField_a_of_type_JavaLangString = PkgTools.a(l);
          ((ServerAddr)localObject2).jdField_a_of_type_Int = j;
          paramProtoResp.jdField_a_of_type_JavaUtilArrayList.add(i, localObject2);
          i += 1;
        }
        else
        {
          paramProtoReq = localException.rpt_data_hole.get();
          if ((paramProtoReq != null) && (paramProtoReq.size() > 0)) {
            paramProtoResp.jdField_b_of_type_Long = ((PttShortVideo.DataHole)paramProtoReq.get(0)).uint64_begin.get();
          }
        }
      }
      label683:
      if (i == -5100026)
      {
        a(-1, -5100026, BaseTransProcessor.a(i), "", localStatictisInfo, paramProtoResp);
      }
      else
      {
        if (a(i))
        {
          this.jdField_b_of_type_Int += 1;
          if (this.jdField_b_of_type_Int < 2)
          {
            localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(paramProtoReq);
            return;
          }
        }
        a(-1, -9527, BaseTransProcessor.a(i), "", localStatictisInfo, paramProtoResp);
      }
    }
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.jdField_a_of_type_JavaUtilList != null) && (paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
      if (paramRichProtoReq.jdField_a_of_type_JavaUtilList.size() == 1)
      {
        localProtoReq.jdField_a_of_type_JavaLangString = "PttCenterSvr.ShortVideoRetweetReq";
        localProtoReq.jdField_a_of_type_ArrayOfByte = a(paramRichProtoReq.jdField_a_of_type_JavaUtilList);
        localProtoReq.jdField_a_of_type_JavaLangObject = paramRichProtoReq;
        localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = this;
        a(paramRichProtoReq, localProtoReq);
      }
    }
    else
    {
      return;
    }
    throw new RuntimeException("only support one request");
  }
  
  byte[] a(List paramList)
  {
    PttShortVideo.ReqBody localReqBody = new PttShortVideo.ReqBody();
    localReqBody.setHasFlag(true);
    if (paramList.size() == 1)
    {
      RichProto.RichProtoReq.ShortVideoForwardReq localShortVideoForwardReq = (RichProto.RichProtoReq.ShortVideoForwardReq)paramList.get(0);
      PttShortVideo.PttShortVideoRetweetReq localPttShortVideoRetweetReq = new PttShortVideo.PttShortVideoRetweetReq();
      localPttShortVideoRetweetReq.setHasFlag(true);
      localPttShortVideoRetweetReq.uint64_from_uin.set(Long.parseLong(localShortVideoForwardReq.jdField_g_of_type_JavaLangString));
      localPttShortVideoRetweetReq.uint64_to_uin.set(Long.parseLong(localShortVideoForwardReq.jdField_d_of_type_JavaLangString));
      localPttShortVideoRetweetReq.uint32_from_chat_type.set(localShortVideoForwardReq.jdField_a_of_type_Int);
      localPttShortVideoRetweetReq.uint32_to_chat_type.set(localShortVideoForwardReq.jdField_b_of_type_Int);
      localPttShortVideoRetweetReq.uint32_from_busi_type.set(localShortVideoForwardReq.c);
      localPttShortVideoRetweetReq.uint32_to_busi_type.set(localShortVideoForwardReq.jdField_d_of_type_Int);
      localPttShortVideoRetweetReq.uint32_client_type.set(localShortVideoForwardReq.e);
      localPttShortVideoRetweetReq.uint32_agent_type.set(localShortVideoForwardReq.l);
      Object localObject = localPttShortVideoRetweetReq.str_fileid;
      if (localShortVideoForwardReq.f == null)
      {
        paramList = "";
        ((PBStringField)localObject).set(paramList);
        if (localShortVideoForwardReq.jdField_b_of_type_JavaLangString == null) {
          break label428;
        }
      }
      for (;;)
      {
        try
        {
          localPttShortVideoRetweetReq.uint64_group_code.set(Long.parseLong(localShortVideoForwardReq.jdField_b_of_type_JavaLangString));
          localObject = new PttShortVideo.PttShortVideoFileInfo();
          PBStringField localPBStringField = ((PttShortVideo.PttShortVideoFileInfo)localObject).str_file_name;
          if (localShortVideoForwardReq.jdField_a_of_type_JavaLangString != null) {
            break label440;
          }
          paramList = "";
          localPBStringField.set(paramList);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).bytes_file_md5.set(ByteStringMicro.copyFrom(localShortVideoForwardReq.jdField_a_of_type_ArrayOfByte));
          ((PttShortVideo.PttShortVideoFileInfo)localObject).bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(localShortVideoForwardReq.jdField_b_of_type_ArrayOfByte));
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint64_file_size.set(localShortVideoForwardReq.jdField_a_of_type_Long);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_res_length.set(localShortVideoForwardReq.h);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_res_width.set(localShortVideoForwardReq.i);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_format.set(localShortVideoForwardReq.j);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_time.set(localShortVideoForwardReq.k);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint64_thumb_file_size.set(localShortVideoForwardReq.jdField_b_of_type_Long);
          localPttShortVideoRetweetReq.msg_PttShortVideoFileInfo.set((MessageMicro)localObject);
          localReqBody.uint32_cmd.set(500);
          localReqBody.uint32_seq.set(localShortVideoForwardReq.jdField_g_of_type_Int);
          localReqBody.rpt_msg_short_video_retweet_req.add(localPttShortVideoRetweetReq);
          return localReqBody.toByteArray();
          paramList = localShortVideoForwardReq.f;
        }
        catch (NumberFormatException paramList)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.richmedia.ShortVideoForwardHandler", 2, "NumberFormatException e = " + paramList);
          }
          localPttShortVideoRetweetReq.uint64_group_code.set(0L);
          continue;
        }
        label428:
        localPttShortVideoRetweetReq.uint64_group_code.set(0L);
        continue;
        label440:
        paramList = localShortVideoForwardReq.jdField_a_of_type_JavaLangString;
      }
    }
    throw new RuntimeException("only support one request");
  }
  
  void b(RichProto.RichProtoReq paramRichProtoReq)
  {
    RichProto.RichProtoResp localRichProtoResp = paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoResp;
    localRichProtoResp.jdField_a_of_type_JavaUtilList.clear();
    int j = paramRichProtoReq.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      paramRichProtoReq = new RichProto.RichProtoResp.ShortVideoForwardResp();
      localRichProtoResp.jdField_a_of_type_JavaUtilList.add(i, paramRichProtoReq);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.ShortVideoForwardHandler
 * JD-Core Version:    0.7.0.1
 */