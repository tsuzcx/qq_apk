package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadInfo;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;

public class C2CPttDownHandler
  extends BaseHandler
{
  int a;
  
  public C2CPttDownHandler()
  {
    this.jdField_a_of_type_Int = 17;
  }
  
  public void a(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    Object localObject2 = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    Object localObject1 = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    RichProto.RichProtoReq localRichProtoReq = (RichProto.RichProtoReq)paramProtoReq.jdField_a_of_type_JavaLangObject;
    RichProto.RichProtoResp localRichProtoResp = localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoResp;
    MessageObserver.StatictisInfo localStatictisInfo = paramProtoResp.jdField_a_of_type_ComTencentMobileqqAppMessageObserver$StatictisInfo;
    int i;
    if (((FromServiceMsg)localObject2).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject2).getResultCode();
      if ((i == 1002) || (i == 1013))
      {
        localObject1 = MessageHandler.a((FromServiceMsg)localObject2);
        paramProtoReq = ((FromServiceMsg)localObject2).getBusinessFailMsg();
        paramProtoResp = paramProtoReq;
        if (paramProtoReq == null) {
          paramProtoResp = "";
        }
        a(-1, 9311, (String)localObject1, paramProtoResp, localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      }
    }
    for (;;)
    {
      RichProtoProc.a(localRichProtoReq, localRichProtoResp);
      return;
      localObject1 = MessageHandler.a((FromServiceMsg)localObject2);
      paramProtoReq = ((FromServiceMsg)localObject2).getBusinessFailMsg();
      paramProtoResp = paramProtoReq;
      if (paramProtoReq == null) {
        paramProtoResp = "";
      }
      a(-1, 9044, (String)localObject1, paramProtoResp, localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        paramProtoReq = new cmd0x346.RspBody();
        paramProtoReq.mergeFrom((byte[])localObject1);
        Object localObject3 = (cmd0x346.ApplyDownloadRsp)paramProtoReq.msg_apply_download_rsp.get();
        paramProtoResp = (RichProto.RichProtoResp.C2CPttDownResp)localRichProtoResp.jdField_a_of_type_JavaUtilList.get(0);
        if (paramProtoResp != null) {
          paramProtoResp.e = ((Boolean)((FromServiceMsg)localObject2).getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
        }
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "C2CPttDownHandler.onProtoResp:isSendByQuickHttp=" + paramProtoResp.e);
        }
        i = ((cmd0x346.ApplyDownloadRsp)localObject3).int32_ret_code.get();
        if (i != 0) {
          break label470;
        }
        paramProtoReq = (cmd0x346.DownloadInfo)((cmd0x346.ApplyDownloadRsp)localObject3).msg_download_info.get();
        if ((paramProtoReq != null) && (paramProtoReq.str_download_url.has()))
        {
          paramProtoResp.jdField_a_of_type_JavaLangString = paramProtoReq.str_download_url.get();
          paramProtoReq = paramProtoReq.rpt_str_downloadip_list.get();
          if ((paramProtoReq == null) || (paramProtoReq.size() <= 0)) {
            break label454;
          }
          paramProtoReq = paramProtoReq.iterator();
          while (paramProtoReq.hasNext())
          {
            localObject2 = (String)paramProtoReq.next();
            localObject3 = new ServerAddr();
            ((ServerAddr)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject2);
            paramProtoResp.jdField_a_of_type_JavaUtilArrayList.add(localObject3);
          }
        }
      }
      catch (Exception paramProtoResp)
      {
        a(-1, -9527, BaseTransProcessor.a("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr((byte[])localObject1), localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      }
      throw new Exception("no url");
      label454:
      a(0, 0, "", "", localStatictisInfo, paramProtoResp);
      continue;
      label470:
      paramProtoReq = (cmd0x346.ExtensionRsp)paramProtoReq.msg_extension_rsp.get();
      if ((paramProtoReq != null) && (paramProtoReq.uint32_allow_retry.get() == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.BaseHandler", 2, "onReceive :c2c ptt server not allow retry");
        }
        paramProtoResp.f = false;
      }
      a(-1, -9527, BaseTransProcessor.a(i), "", localStatictisInfo, paramProtoResp);
    }
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.jdField_a_of_type_JavaUtilList != null) && (paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
      localProtoReq.jdField_a_of_type_ArrayOfByte = a(paramRichProtoReq.jdField_a_of_type_JavaUtilList);
      localProtoReq.jdField_a_of_type_JavaLangObject = paramRichProtoReq;
      localProtoReq.jdField_a_of_type_JavaLangString = "PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_DOWNLOAD-1200";
      if (this.jdField_a_of_type_Int == 3) {
        localProtoReq.jdField_a_of_type_JavaLangString = "OfflineFilleHandleSvr.pb_ftnPtt_CMD_REQ_APPLY_DOWNLOAD-1200";
      }
      localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = this;
      a(paramRichProtoReq, localProtoReq);
    }
  }
  
  byte[] a(List paramList)
  {
    int i = 1;
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    if (paramList.size() == 1)
    {
      paramList = (RichProto.RichProtoReq.C2CPttDownReq)paramList.get(0);
      Object localObject;
      if ("ftn".equals(paramList.jdField_b_of_type_JavaLangString))
      {
        this.jdField_a_of_type_Int = 3;
        localObject = new cmd0x346.ApplyDownloadReq();
        ((cmd0x346.ApplyDownloadReq)localObject).uint64_uin.set(Long.parseLong(paramList.jdField_c_of_type_JavaLangString));
        ((cmd0x346.ApplyDownloadReq)localObject).bytes_uuid.set(ByteStringMicro.copyFromUtf8(paramList.jdField_a_of_type_JavaLangString));
        PBUInt32Field localPBUInt32Field = ((cmd0x346.ApplyDownloadReq)localObject).uint32_owner_type;
        if (!paramList.jdField_a_of_type_Boolean) {
          break label436;
        }
        label102:
        localPBUInt32Field.set(i);
        localReqBody.uint32_cmd.set(1200);
        localReqBody.uint32_seq.set(0);
        localReqBody.uint32_business_id.set(this.jdField_a_of_type_Int);
        localReqBody.uint32_client_type.set(104);
        localReqBody.msg_apply_download_req.set((MessageMicro)localObject);
        if (paramList.f == 0) {
          break label515;
        }
        localObject = new cmd0x346.ExtensionReq();
        ((cmd0x346.ExtensionReq)localObject).uint64_id.set(3L);
        switch (paramList.f)
        {
        default: 
          i = 0;
          label318:
          ((cmd0x346.ExtensionReq)localObject).uint64_type.set(i);
          ((cmd0x346.ExtensionReq)localObject).uint32_ptt_format.set(paramList.jdField_a_of_type_Int);
          ((cmd0x346.ExtensionReq)localObject).uint32_file_type.set(paramList.jdField_b_of_type_Int);
          ((cmd0x346.ExtensionReq)localObject).uint32_is_auto.set(paramList.jdField_c_of_type_Int);
          localReqBody.msg_extension_req.set((MessageMicro)localObject);
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.C2CPttDownHandler", 2, "constructReqBody C2CPttDownReq = " + paramList.toString());
        }
        return localReqBody.toByteArray();
        if (!"pttcenter".equals(paramList.jdField_b_of_type_JavaLangString)) {
          break;
        }
        this.jdField_a_of_type_Int = 17;
        break;
        label436:
        i = 2;
        break label102;
        i = 0;
        break label318;
        i = 102;
        break label318;
        i = 104;
        break label318;
        i = 104;
        break label318;
        i = 105;
        break label318;
        i = 0;
        break label318;
        i = 0;
        break label318;
        i = 0;
        break label318;
        i = 101;
        break label318;
        i = 103;
        break label318;
        i = 118;
        break label318;
        i = 100;
        break label318;
        i = 114;
        break label318;
        label515:
        localObject = new cmd0x346.ExtensionReq();
        ((cmd0x346.ExtensionReq)localObject).uint32_ptt_format.set(paramList.jdField_a_of_type_Int);
        ((cmd0x346.ExtensionReq)localObject).uint32_is_auto.set(paramList.jdField_c_of_type_Int);
        localReqBody.msg_extension_req.set((MessageMicro)localObject);
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
      RichProto.RichProtoResp.C2CPttDownResp localC2CPttDownResp = new RichProto.RichProtoResp.C2CPttDownResp();
      localRichProtoResp.jdField_a_of_type_JavaUtilList.add(i, localC2CPttDownResp);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.C2CPttDownHandler
 * JD-Core Version:    0.7.0.1
 */