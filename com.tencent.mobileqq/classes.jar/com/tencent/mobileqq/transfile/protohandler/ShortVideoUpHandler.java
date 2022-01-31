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
import pttcenterservice.PttShortVideo.ExtensionReq;
import pttcenterservice.PttShortVideo.PttShortVideoFileInfo;
import pttcenterservice.PttShortVideo.PttShortVideoIpList;
import pttcenterservice.PttShortVideo.PttShortVideoUploadReq;
import pttcenterservice.PttShortVideo.PttShortVideoUploadResp;
import pttcenterservice.PttShortVideo.ReqBody;
import pttcenterservice.PttShortVideo.RspBody;

public class ShortVideoUpHandler
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
        localObject1 = (PttShortVideo.PttShortVideoUploadResp)((PttShortVideo.RspBody)localObject2).msg_PttShortVideoUpload_Resp.get();
        if (localObject1 != null) {
          break label225;
        }
        throw new Exception("svUpResp null");
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
            label225:
            paramProtoResp = (RichProto.RichProtoResp.ShortVideoUpResp)localRichProtoResp.jdField_a_of_type_JavaUtilList.get(0);
            try
            {
              i = ((PttShortVideo.PttShortVideoUploadResp)localObject1).int32_ret_code.get();
              if (i != 0) {
                break label682;
              }
              if ((((PttShortVideo.RspBody)localObject2).uint32_change_channel.has()) && (((PttShortVideo.RspBody)localObject2).uint32_change_channel.get() == 1)) {
                paramProtoResp.jdField_b_of_type_Boolean = true;
              }
              if (1 != ((PttShortVideo.PttShortVideoUploadResp)localObject1).uint32_file_exist.get()) {
                break label397;
              }
              paramProtoResp.jdField_a_of_type_Boolean = true;
              paramProtoResp.jdField_b_of_type_JavaLangString = ((PttShortVideo.PttShortVideoUploadResp)localObject1).str_fileid.get();
              paramProtoResp.jdField_a_of_type_Int = ((PttShortVideo.PttShortVideoUploadResp)localObject1).uint32_is_hot_file.get();
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
          label397:
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
            QLog.d("Q.richmedia.ShortVideoUpHandler", 2, "onProtoResp---------- ip = " + l);
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
      label682:
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
  
  public void a(RichProto.RichProtoReq paramRichProtoReq)
  {
    ProtoReqManager.ProtoReq localProtoReq;
    RichProto.RichProtoReq.ReqCommon localReqCommon;
    if ((paramRichProtoReq != null) && (paramRichProtoReq.jdField_a_of_type_JavaUtilList != null) && (paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      localProtoReq = new ProtoReqManager.ProtoReq();
      if (paramRichProtoReq.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label134;
      }
      localReqCommon = (RichProto.RichProtoReq.ReqCommon)paramRichProtoReq.jdField_a_of_type_JavaUtilList.get(0);
      if (localReqCommon.f != 0) {
        break label96;
      }
      localProtoReq.jdField_a_of_type_JavaLangString = "PttCenterSvr.ShortVideoUpReq";
    }
    for (;;)
    {
      localProtoReq.jdField_a_of_type_ArrayOfByte = a(paramRichProtoReq.jdField_a_of_type_JavaUtilList);
      localProtoReq.jdField_a_of_type_JavaLangObject = paramRichProtoReq;
      localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = this;
      a(paramRichProtoReq, localProtoReq);
      return;
      label96:
      if ((1 == localReqCommon.f) || (3000 == localReqCommon.f)) {
        localProtoReq.jdField_a_of_type_JavaLangString = "PttCenterSvr.GroupShortVideoUpReq";
      } else {
        localProtoReq.jdField_a_of_type_JavaLangString = "PttCenterSvr.ShortVideoUpReq";
      }
    }
    label134:
    throw new RuntimeException("only support one request");
  }
  
  byte[] a(List paramList)
  {
    PttShortVideo.ReqBody localReqBody = new PttShortVideo.ReqBody();
    localReqBody.setHasFlag(true);
    if (paramList.size() == 1)
    {
      paramList = (RichProto.RichProtoReq.ShortVideoUpReq)paramList.get(0);
      PttShortVideo.PttShortVideoUploadReq localPttShortVideoUploadReq = new PttShortVideo.PttShortVideoUploadReq();
      localPttShortVideoUploadReq.setHasFlag(true);
      localPttShortVideoUploadReq.uint64_fromuin.set(Long.parseLong(paramList.jdField_c_of_type_JavaLangString));
      localPttShortVideoUploadReq.uint64_touin.set(Long.parseLong(paramList.jdField_d_of_type_JavaLangString));
      localPttShortVideoUploadReq.uint32_chat_type.set(paramList.jdField_a_of_type_Int);
      localPttShortVideoUploadReq.uint32_client_type.set(paramList.jdField_b_of_type_Int);
      if (paramList.jdField_b_of_type_JavaLangString != null) {
        localPttShortVideoUploadReq.uint64_group_code.set(Long.parseLong(paramList.jdField_b_of_type_JavaLangString));
      }
      for (;;)
      {
        localPttShortVideoUploadReq.uint32_agent_type.set(paramList.i);
        localPttShortVideoUploadReq.uint32_business_type.set(paramList.j);
        Object localObject = new PttShortVideo.PttShortVideoFileInfo();
        ((PttShortVideo.PttShortVideoFileInfo)localObject).str_file_name.set(paramList.jdField_a_of_type_JavaLangString);
        ((PttShortVideo.PttShortVideoFileInfo)localObject).bytes_file_md5.set(ByteStringMicro.copyFrom(paramList.jdField_a_of_type_ArrayOfByte));
        ((PttShortVideo.PttShortVideoFileInfo)localObject).bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(paramList.jdField_b_of_type_ArrayOfByte));
        ((PttShortVideo.PttShortVideoFileInfo)localObject).uint64_file_size.set(paramList.jdField_a_of_type_Long);
        ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_res_length.set(paramList.jdField_d_of_type_Int);
        ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_res_width.set(paramList.e);
        ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_format.set(paramList.g);
        ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_time.set(paramList.h);
        ((PttShortVideo.PttShortVideoFileInfo)localObject).uint64_thumb_file_size.set(paramList.jdField_b_of_type_Long);
        localPttShortVideoUploadReq.msg_PttShortVideoFileInfo.set((MessageMicro)localObject);
        localObject = new PttShortVideo.ExtensionReq();
        ((PttShortVideo.ExtensionReq)localObject).uint32_sub_busi_type.set(paramList.k);
        ((PttShortVideo.ExtensionReq)localObject).uint32_user_cnt.set(paramList.l);
        localReqBody.uint32_cmd.set(300);
        localReqBody.uint32_seq.set(paramList.jdField_c_of_type_Int);
        localReqBody.msg_PttShortVideoUpload_Req.set(localPttShortVideoUploadReq);
        localReqBody.rpt_msg_extension_req.add((MessageMicro)localObject);
        return localReqBody.toByteArray();
        localPttShortVideoUploadReq.uint64_group_code.set(0L);
      }
    }
    throw new RuntimeException("only support one request");
  }
  
  void b(RichProto.RichProtoReq paramRichProtoReq)
  {
    RichProto.RichProtoResp localRichProtoResp = paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoResp;
    localRichProtoResp.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < paramRichProtoReq.jdField_a_of_type_JavaUtilList.size())
    {
      RichProto.RichProtoResp.ShortVideoUpResp localShortVideoUpResp = new RichProto.RichProtoResp.ShortVideoUpResp();
      localRichProtoResp.jdField_a_of_type_JavaUtilList.add(i, localShortVideoUpResp);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.ShortVideoUpHandler
 * JD-Core Version:    0.7.0.1
 */