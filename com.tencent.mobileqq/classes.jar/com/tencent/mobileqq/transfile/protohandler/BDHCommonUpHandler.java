package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
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
  int a;
  
  public static boolean a(int paramInt)
  {
    return (paramInt != 196) && (paramInt != 194) && (paramInt != 197) && (paramInt != 199) && (paramInt != 200) && (paramInt != 201) && (paramInt != 203) && (paramInt != 202) && (paramInt != 120509) && (paramInt != 400010) && (paramInt != 400011);
  }
  
  void a(int paramInt, RichProto.RichProtoReq.ReqCommon paramReqCommon, cmd0x388.ReqBody paramReqBody)
  {
    paramReqCommon = (RichProto.RichProtoReq.PicUpReq)paramReqCommon;
    cmd0x388.TryUpImgReq localTryUpImgReq = new cmd0x388.TryUpImgReq();
    localTryUpImgReq.setHasFlag(true);
    localTryUpImgReq.uint64_src_uin.set(Long.valueOf(paramReqCommon.jdField_c_of_type_JavaLangString).longValue());
    localTryUpImgReq.uint64_group_code.set(Long.valueOf(paramReqCommon.jdField_d_of_type_JavaLangString).longValue());
    localTryUpImgReq.uint64_file_id.set(paramInt);
    localTryUpImgReq.uint64_file_size.set(paramReqCommon.jdField_a_of_type_Long);
    localTryUpImgReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramReqCommon.jdField_a_of_type_ArrayOfByte));
    localTryUpImgReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(paramReqCommon.jdField_a_of_type_JavaLangString));
    localTryUpImgReq.uint32_src_term.set(5);
    localTryUpImgReq.uint32_platform_type.set(9);
    localTryUpImgReq.uint32_pic_width.set(paramReqCommon.jdField_c_of_type_Int);
    localTryUpImgReq.uint32_pic_height.set(paramReqCommon.jdField_d_of_type_Int);
    localTryUpImgReq.uint32_pic_type.set(paramReqCommon.jdField_a_of_type_Int);
    PBUInt32Field localPBUInt32Field = localTryUpImgReq.uint32_bu_type;
    if (paramReqCommon.f == 1) {}
    for (paramInt = 1;; paramInt = 2)
    {
      localPBUInt32Field.set(paramInt);
      localTryUpImgReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(RichMediaUtil.a()));
      if (paramReqCommon.jdField_b_of_type_Boolean) {
        localTryUpImgReq.uint32_original_pic.set(1);
      }
      paramReqBody.rpt_msg_tryup_img_req.add(localTryUpImgReq);
      return;
    }
  }
  
  public void a(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    FromServiceMsg localFromServiceMsg = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    RichProto.RichProtoReq localRichProtoReq = (RichProto.RichProtoReq)paramProtoReq.jdField_a_of_type_JavaLangObject;
    RichProto.RichProtoResp localRichProtoResp = localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoResp;
    MessageObserver.StatictisInfo localStatictisInfo = paramProtoResp.jdField_a_of_type_ComTencentMobileqqAppMessageObserver$StatictisInfo;
    if (QLog.isColorLevel()) {
      QLog.e("BDHCommonUpHandler", 1, "onProtoResp: " + localFromServiceMsg.getResultCode());
    }
    int i;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      paramProtoResp = (String)localFromServiceMsg.getAttribute("_tag_socket_connerror", "");
      if ((paramProtoResp.equals("conSucc")) || (paramProtoResp.equals("")))
      {
        i = localFromServiceMsg.getResultCode();
        if ((i == 1002) || (i == 1013))
        {
          localObject1 = MessageHandler.b(localFromServiceMsg);
          paramProtoReq = localFromServiceMsg.getBusinessFailMsg();
          paramProtoResp = paramProtoReq;
          if (paramProtoReq == null) {
            paramProtoResp = "";
          }
          a(-1, 9311, (String)localObject1, paramProtoResp, localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
        }
      }
    }
    for (;;)
    {
      RichProtoProc.a(localRichProtoReq, localRichProtoResp);
      return;
      paramProtoReq = localFromServiceMsg.getBusinessFailMsg();
      paramProtoResp = paramProtoReq;
      if (paramProtoReq == null) {
        paramProtoResp = "";
      }
      a(-1, 9044, String.valueOf(i), paramProtoResp, localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      continue;
      a(-1, 9313, paramProtoResp, localFromServiceMsg.getBusinessFailMsg(), localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        paramProtoResp = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(arrayOfByte)).rpt_msg_tryup_img_rsp.get();
        if ((paramProtoResp != null) && (paramProtoResp.size() != 0)) {
          break label349;
        }
        throw new Exception("resps null");
      }
      catch (Exception paramProtoResp)
      {
        a(-1, -9527, BaseTransProcessor.a("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      }
      continue;
      label349:
      Iterator localIterator = paramProtoResp.iterator();
      while (localIterator.hasNext())
      {
        paramProtoResp = (cmd0x388.TryUpImgRsp)localIterator.next();
        for (;;)
        {
          try
          {
            for (;;)
            {
              localObject1 = (RichProto.RichProtoResp.BDHCommonUpResp)localRichProtoResp.jdField_a_of_type_JavaUtilList.get((int)paramProtoResp.uint64_file_id.get());
              if (localObject1 == null) {
                break;
              }
              try
              {
                if (localFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
                  ((RichProto.RichProtoResp.BDHCommonUpResp)localObject1).jdField_e_of_type_Boolean = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
                }
                if (paramProtoResp.msg_info4busi.has())
                {
                  localObject2 = (cmd0x388.TryUpInfo4Busi)paramProtoResp.msg_info4busi.get();
                  if (((cmd0x388.TryUpInfo4Busi)localObject2).bytes_down_domain.has()) {
                    ((RichProto.RichProtoResp.BDHCommonUpResp)localObject1).jdField_b_of_type_JavaLangString = ((cmd0x388.TryUpInfo4Busi)localObject2).bytes_down_domain.get().toStringUtf8();
                  }
                  if (((cmd0x388.TryUpInfo4Busi)localObject2).bytes_big_down_url.has()) {
                    ((RichProto.RichProtoResp.BDHCommonUpResp)localObject1).jdField_d_of_type_JavaLangString = ((cmd0x388.TryUpInfo4Busi)localObject2).bytes_big_down_url.get().toStringUtf8();
                  }
                  if (((cmd0x388.TryUpInfo4Busi)localObject2).bytes_original_down_url.has()) {
                    ((RichProto.RichProtoResp.BDHCommonUpResp)localObject1).jdField_e_of_type_JavaLangString = ((cmd0x388.TryUpInfo4Busi)localObject2).bytes_original_down_url.get().toStringUtf8();
                  }
                  if (((cmd0x388.TryUpInfo4Busi)localObject2).bytes_thumb_down_url.has()) {
                    ((RichProto.RichProtoResp.BDHCommonUpResp)localObject1).jdField_c_of_type_JavaLangString = ((cmd0x388.TryUpInfo4Busi)localObject2).bytes_thumb_down_url.get().toStringUtf8();
                  }
                  if (((cmd0x388.TryUpInfo4Busi)localObject2).bytes_file_resid.has()) {
                    ((RichProto.RichProtoResp.BDHCommonUpResp)localObject1).f = ((cmd0x388.TryUpInfo4Busi)localObject2).bytes_file_resid.get().toStringUtf8();
                  }
                }
                i = paramProtoResp.uint32_result.get();
                if (i != 0) {
                  break label1045;
                }
                ((RichProto.RichProtoResp.BDHCommonUpResp)localObject1).jdField_a_of_type_Long = paramProtoResp.uint64_fileid.get();
                localObject2 = paramProtoResp.rpt_uint32_up_ip.get();
                localObject3 = paramProtoResp.rpt_uint32_up_port.get();
                if ((localObject2 != null) && (((List)localObject2).size() > 0))
                {
                  i = 0;
                  while (i < ((List)localObject2).size())
                  {
                    long l1 = ((Integer)((List)localObject2).get(i)).intValue();
                    long l2 = ((Integer)((List)localObject3).get(i)).intValue();
                    ServerAddr localServerAddr = new ServerAddr();
                    localServerAddr.jdField_a_of_type_JavaLangString = PkgTools.a(l1 & 0xFFFFFFFF);
                    localServerAddr.jdField_a_of_type_Int = ((int)l2);
                    ((RichProto.RichProtoResp.BDHCommonUpResp)localObject1).jdField_a_of_type_JavaUtilArrayList.add(i, localServerAddr);
                    i += 1;
                  }
                }
                if ((!paramProtoResp.bool_file_exit.has()) || (!paramProtoResp.bool_file_exit.get())) {
                  break label852;
                }
                ((RichProto.RichProtoResp.BDHCommonUpResp)localObject1).jdField_a_of_type_Boolean = true;
                a(0, 0, "", "", localStatictisInfo, (RichProto.RichProtoResp.RespCommon)localObject1);
              }
              catch (Exception paramProtoResp) {}
            }
          }
          catch (Exception paramProtoResp)
          {
            Object localObject2;
            Object localObject3;
            label852:
            localObject1 = null;
            continue;
            boolean bool = false;
            continue;
          }
          a(-1, -9527, BaseTransProcessor.a("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localStatictisInfo, (RichProto.RichProtoResp.RespCommon)localObject1);
          break;
          localObject3 = HexUtil.bytes2HexStr(paramProtoResp.bytes_up_ukey.get().toByteArray());
          if ((localObject3 == null) || (((String)localObject3).equals("")) || (localObject2 == null) || (((List)localObject2).size() == 0)) {
            throw new Exception("check ukey,iplist");
          }
          ((RichProto.RichProtoResp.BDHCommonUpResp)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject3);
          ((RichProto.RichProtoResp.BDHCommonUpResp)localObject1).jdField_a_of_type_Int = ((int)paramProtoResp.uint64_block_size.get());
          ((RichProto.RichProtoResp.BDHCommonUpResp)localObject1).jdField_b_of_type_Int = ((int)paramProtoResp.uint64_up_offset.get());
          if (NetworkCenter.a().a() == this.jdField_a_of_type_Int) {
            continue;
          }
          bool = true;
          ((RichProto.RichProtoResp.BDHCommonUpResp)localObject1).jdField_b_of_type_Boolean = bool;
          ((RichProto.RichProtoResp.BDHCommonUpResp)localObject1).jdField_b_of_type_Long = paramProtoResp.uint64_up_offset.get();
          if (QLog.isColorLevel()) {
            QLog.d("BDH_LOG", 2, " Channel:" + paramProtoResp.bool_new_big_chan.get());
          }
          if ((paramProtoResp.bool_new_big_chan.has()) && (paramProtoResp.bool_new_big_chan.get() == true)) {
            ((RichProto.RichProtoResp.BDHCommonUpResp)localObject1).jdField_c_of_type_Boolean = true;
          }
        }
        label1045:
        if (a(i))
        {
          this.jdField_b_of_type_Int += 1;
          if (this.jdField_b_of_type_Int < 2)
          {
            localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(paramProtoReq);
            return;
          }
        }
        a(-1, -9527, BaseTransProcessor.a(i), "", localStatictisInfo, (RichProto.RichProtoResp.RespCommon)localObject1);
      }
    }
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.jdField_a_of_type_JavaUtilList != null) && (paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
      localProtoReq.jdField_a_of_type_JavaLangString = "ImgStore.BDHCommonUp";
      localProtoReq.jdField_a_of_type_ArrayOfByte = a(paramRichProtoReq);
      localProtoReq.jdField_a_of_type_JavaLangObject = paramRichProtoReq;
      localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = this;
      a(paramRichProtoReq, localProtoReq);
    }
  }
  
  byte[] a(RichProto.RichProtoReq paramRichProtoReq)
  {
    if (paramRichProtoReq == null) {
      return null;
    }
    List localList = paramRichProtoReq.jdField_a_of_type_JavaUtilList;
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(1);
    localReqBody.uint32_command_id.set(paramRichProtoReq.jdField_a_of_type_Int);
    if (paramRichProtoReq.jdField_a_of_type_ArrayOfByte != null) {
      localReqBody.bytes_extension.set(ByteStringMicro.copyFrom(paramRichProtoReq.jdField_a_of_type_ArrayOfByte));
    }
    int i = 0;
    while (i < localList.size())
    {
      a(i, (RichProto.RichProtoReq.ReqCommon)localList.get(i), localReqBody);
      i += 1;
    }
    i = NetworkCenter.a().a();
    this.jdField_a_of_type_Int = i;
    switch (i)
    {
    default: 
      i = 6;
    }
    for (;;)
    {
      paramRichProtoReq = NetworkCenter.a().a();
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
  
  void b(RichProto.RichProtoReq paramRichProtoReq)
  {
    RichProto.RichProtoResp localRichProtoResp = paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoResp;
    localRichProtoResp.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < paramRichProtoReq.jdField_a_of_type_JavaUtilList.size())
    {
      RichProto.RichProtoResp.BDHCommonUpResp localBDHCommonUpResp = new RichProto.RichProtoResp.BDHCommonUpResp();
      localRichProtoResp.jdField_a_of_type_JavaUtilList.add(i, localBDHCommonUpResp);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.BDHCommonUpHandler
 * JD-Core Version:    0.7.0.1
 */