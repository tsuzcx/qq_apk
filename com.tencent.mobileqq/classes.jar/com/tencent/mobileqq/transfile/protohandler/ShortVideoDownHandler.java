package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import pttcenterservice.PttShortVideo.ExtensionReq;
import pttcenterservice.PttShortVideo.PttShortVideoAddr;
import pttcenterservice.PttShortVideo.PttShortVideoDownloadReq;
import pttcenterservice.PttShortVideo.PttShortVideoDownloadResp;
import pttcenterservice.PttShortVideo.PttShortVideoIpList;
import pttcenterservice.PttShortVideo.ReqBody;
import pttcenterservice.PttShortVideo.RspBody;

public class ShortVideoDownHandler
  extends BaseHandler
{
  public void a(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    Object localObject = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    RichProto.RichProtoReq localRichProtoReq = (RichProto.RichProtoReq)paramProtoReq.jdField_a_of_type_JavaLangObject;
    RichProto.RichProtoResp localRichProtoResp = localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoResp;
    MessageObserver.StatictisInfo localStatictisInfo = paramProtoResp.jdField_a_of_type_ComTencentMobileqqAppMessageObserver$StatictisInfo;
    int i;
    if (((FromServiceMsg)localObject).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject).getResultCode();
      if ((i == 1002) || (i == 1013)) {
        a(-1, 9311, MessageHandler.a((FromServiceMsg)localObject), "", localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      }
    }
    label289:
    label871:
    for (;;)
    {
      RichProtoProc.a(localRichProtoReq, localRichProtoResp);
      return;
      a(-1, 9044, MessageHandler.a((FromServiceMsg)localObject), "", localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      continue;
      PttShortVideo.PttShortVideoDownloadResp localPttShortVideoDownloadResp;
      try
      {
        paramProtoResp = new PttShortVideo.RspBody();
        paramProtoResp.mergeFrom(arrayOfByte);
        localPttShortVideoDownloadResp = (PttShortVideo.PttShortVideoDownloadResp)paramProtoResp.msg_PttShortVideoDownload_Resp.get();
        localObject = (RichProto.RichProtoResp.ShortVideoDownResp)localRichProtoResp.jdField_a_of_type_JavaUtilList.get(0);
        i = localPttShortVideoDownloadResp.int32_ret_code.get();
        if (i != 0) {
          break label789;
        }
        paramProtoResp = localPttShortVideoDownloadResp.bytes_downloadkey.get().toByteArray();
        if (((localPttShortVideoDownloadResp.rpt_same_area_out_addr.size() > 0) || (localPttShortVideoDownloadResp.rpt_diff_area_out_addr.size() > 0)) && (paramProtoResp != null) && (paramProtoResp.length != 0)) {
          break label289;
        }
        throw new Exception("check ip, port, ukey");
      }
      catch (Exception paramProtoResp)
      {
        a(-1, -9527, BaseTransProcessor.a("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      }
      continue;
      ((RichProto.RichProtoResp.ShortVideoDownResp)localObject).jdField_a_of_type_JavaLangString = HexUtil.bytes2HexStr(paramProtoResp);
      ((RichProto.RichProtoResp.ShortVideoDownResp)localObject).jdField_a_of_type_ArrayOfByte = localPttShortVideoDownloadResp.bytes_file_md5.get().toByteArray();
      if (localPttShortVideoDownloadResp.bytes_encrypt_key.has()) {
        ((RichProto.RichProtoResp.ShortVideoDownResp)localObject).jdField_b_of_type_ArrayOfByte = localPttShortVideoDownloadResp.bytes_encrypt_key.get().toByteArray();
      }
      PttShortVideo.PttShortVideoAddr localPttShortVideoAddr = (PttShortVideo.PttShortVideoAddr)localPttShortVideoDownloadResp.msg_download_addr.get();
      if (localPttShortVideoAddr != null)
      {
        ((RichProto.RichProtoResp.ShortVideoDownResp)localObject).jdField_a_of_type_Int = localPttShortVideoAddr.uint32_host_type.get();
        List localList = localPttShortVideoAddr.rpt_str_host.get();
        if (localList != null)
        {
          if (((RichProto.RichProtoResp.ShortVideoDownResp)localObject).jdField_a_of_type_Int == 0)
          {
            i = 0;
            while (i < localList.size())
            {
              ServerAddr localServerAddr = new ServerAddr();
              paramProtoReq = (String)localList.get(i);
              paramProtoResp = paramProtoReq;
              if (paramProtoReq.startsWith("http://")) {
                paramProtoResp = paramProtoReq.substring("http://".length());
              }
              paramProtoReq = paramProtoResp;
              if (paramProtoResp.endsWith("/")) {
                paramProtoReq = paramProtoResp.substring(0, paramProtoResp.length() - 1);
              }
              paramProtoResp = paramProtoReq.split(":");
              localServerAddr.jdField_a_of_type_JavaLangString = paramProtoResp[0];
              if (paramProtoResp.length == 2) {
                localServerAddr.jdField_a_of_type_Int = Integer.valueOf(paramProtoResp[1]).intValue();
              }
              ((RichProto.RichProtoResp.ShortVideoDownResp)localObject).jdField_a_of_type_JavaUtilArrayList.add(i, localServerAddr);
              i += 1;
            }
          }
          paramProtoReq = (String)localList.get(0);
          paramProtoResp = paramProtoReq;
          if (paramProtoReq.startsWith("http://")) {
            paramProtoResp = paramProtoReq.substring("http://".length());
          }
          paramProtoReq = paramProtoResp;
          if (paramProtoResp.endsWith("/")) {
            paramProtoReq = paramProtoResp.substring(0, paramProtoResp.length() - 1);
          }
          ((RichProto.RichProtoResp.ShortVideoDownResp)localObject).jdField_b_of_type_JavaLangString = paramProtoReq;
          ((RichProto.RichProtoResp.ShortVideoDownResp)localObject).jdField_c_of_type_JavaLangString = localPttShortVideoAddr.str_url_args.get();
        }
      }
      if ((((RichProto.RichProtoResp.ShortVideoDownResp)localObject).jdField_a_of_type_JavaUtilArrayList.size() == 0) && (((RichProto.RichProtoResp.ShortVideoDownResp)localObject).jdField_b_of_type_JavaLangString == null))
      {
        paramProtoResp = localPttShortVideoDownloadResp.rpt_same_area_out_addr.get();
        paramProtoResp.addAll(localPttShortVideoDownloadResp.rpt_diff_area_out_addr.get());
        i = 0;
        while (i < paramProtoResp.size())
        {
          paramProtoReq = (PttShortVideo.PttShortVideoIpList)paramProtoResp.get(i);
          paramProtoReq.uint32_ip.get();
          long l = paramProtoReq.uint32_ip.get() & 0xFFFFFFFF;
          if (QLog.isColorLevel()) {
            QLog.d("Q.richmedia.ShortVideoDownHandler", 2, "onProtoResp---------- ip = " + l);
          }
          int j = paramProtoReq.uint32_port.get();
          paramProtoReq = new ServerAddr();
          paramProtoReq.jdField_a_of_type_JavaLangString = PkgTools.a(l);
          paramProtoReq.jdField_a_of_type_Int = j;
          ((RichProto.RichProtoResp.ShortVideoDownResp)localObject).jdField_a_of_type_JavaUtilArrayList.add(i, paramProtoReq);
          i += 1;
        }
      }
      a(0, 0, "", "", localStatictisInfo, (RichProto.RichProtoResp.RespCommon)localObject);
      continue;
      if (i == -5100026) {
        a(-1, -5100026, BaseTransProcessor.a(i), "", localStatictisInfo, (RichProto.RichProtoResp.RespCommon)localObject);
      }
      for (;;)
      {
        if (paramProtoResp.uint32_allow_retry.get() != 1) {
          break label871;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.BaseHandler", 2, "onProtoResp : shortVideo server not allow retry");
        }
        ((RichProto.RichProtoResp.ShortVideoDownResp)localObject).f = false;
        break;
        a(-1, -9527, BaseTransProcessor.a(i), "", localStatictisInfo, (RichProto.RichProtoResp.RespCommon)localObject);
      }
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
      localProtoReq.jdField_a_of_type_JavaLangString = "PttCenterSvr.ShortVideoDownReq";
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
        localProtoReq.jdField_a_of_type_JavaLangString = "PttCenterSvr.GroupShortVideoDownReq";
      } else {
        localProtoReq.jdField_a_of_type_JavaLangString = "PttCenterSvr.ShortVideoDownReq";
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
      paramList = (RichProto.RichProtoReq.ShortVideoDownReq)paramList.get(0);
      PttShortVideo.PttShortVideoDownloadReq localPttShortVideoDownloadReq = new PttShortVideo.PttShortVideoDownloadReq();
      localPttShortVideoDownloadReq.uint64_touin.set(Long.parseLong(paramList.jdField_c_of_type_JavaLangString));
      localPttShortVideoDownloadReq.uint32_chat_type.set(paramList.jdField_a_of_type_Int);
      if (paramList.jdField_a_of_type_Int == 0)
      {
        localPttShortVideoDownloadReq.uint64_fromuin.set(Long.parseLong(paramList.jdField_d_of_type_JavaLangString));
        localPttShortVideoDownloadReq.uint32_client_type.set(paramList.jdField_b_of_type_Int);
        localPttShortVideoDownloadReq.str_fileid.set(paramList.jdField_a_of_type_JavaLangString);
        if (paramList.jdField_b_of_type_JavaLangString == null) {
          break label361;
        }
        localPttShortVideoDownloadReq.uint64_group_code.set(Long.parseLong(paramList.jdField_b_of_type_JavaLangString));
      }
      for (;;)
      {
        localPttShortVideoDownloadReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramList.jdField_a_of_type_ArrayOfByte));
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ShortVideoDownHandler", 2, "download md5 = " + paramList.jdField_a_of_type_ArrayOfByte);
        }
        localPttShortVideoDownloadReq.uint32_agent_type.set(paramList.jdField_d_of_type_Int);
        localPttShortVideoDownloadReq.uint32_business_type.set(paramList.jdField_e_of_type_Int);
        localPttShortVideoDownloadReq.uint32_file_type.set(paramList.g);
        localPttShortVideoDownloadReq.uint32_down_type.set(paramList.h);
        localPttShortVideoDownloadReq.uint32_scene_type.set(paramList.i);
        localPttShortVideoDownloadReq.uint32_need_inner_addr.set(0);
        PttShortVideo.ExtensionReq localExtensionReq = new PttShortVideo.ExtensionReq();
        localExtensionReq.uint32_sub_busi_type.set(paramList.j);
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ShortVideoDownHandler", 2, "constructReqBody ShortVideoDownReq = " + paramList.toString());
        }
        localReqBody.uint32_cmd.set(400);
        localReqBody.uint32_seq.set(paramList.jdField_c_of_type_Int);
        localReqBody.msg_PttShortVideoDownload_Req.set(localPttShortVideoDownloadReq);
        localReqBody.rpt_msg_extension_req.add(localExtensionReq);
        return localReqBody.toByteArray();
        localPttShortVideoDownloadReq.uint64_fromuin.set(Long.parseLong(paramList.jdField_e_of_type_JavaLangString));
        break;
        label361:
        localPttShortVideoDownloadReq.uint64_group_code.set(0L);
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
      RichProto.RichProtoResp.ShortVideoDownResp localShortVideoDownResp = new RichProto.RichProtoResp.ShortVideoDownResp();
      localRichProtoResp.jdField_a_of_type_JavaUtilList.add(i, localShortVideoDownResp);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.ShortVideoDownHandler
 * JD-Core Version:    0.7.0.1
 */