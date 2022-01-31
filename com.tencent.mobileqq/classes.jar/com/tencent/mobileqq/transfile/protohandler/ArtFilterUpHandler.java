package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import tencent.im.cs.cmd0x352.cmd0x352.ReqBody;
import tencent.im.cs.cmd0x352.cmd0x352.TryUpImgReq;

public class ArtFilterUpHandler
  extends C2CPicUpHandler
{
  void a(int paramInt, RichProto.RichProtoReq.ReqCommon paramReqCommon, cmd0x352.ReqBody paramReqBody)
  {
    paramReqCommon = (RichProto.RichProtoReq.PicUpReq)paramReqCommon;
    cmd0x352.TryUpImgReq localTryUpImgReq = new cmd0x352.TryUpImgReq();
    localTryUpImgReq.uint64_file_id.set(paramInt);
    localTryUpImgReq.setHasFlag(true);
    localTryUpImgReq.uint64_src_uin.set(Long.valueOf(paramReqCommon.jdField_c_of_type_JavaLangString).longValue());
    localTryUpImgReq.uint64_file_size.set(paramReqCommon.jdField_a_of_type_Long);
    localTryUpImgReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramReqCommon.jdField_a_of_type_ArrayOfByte));
    localTryUpImgReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(paramReqCommon.jdField_a_of_type_JavaLangString));
    localTryUpImgReq.uint32_src_term.set(5);
    localTryUpImgReq.bool_address_book.set(paramReqCommon.jdField_c_of_type_Boolean);
    localTryUpImgReq.uint32_platform_type.set(9);
    localTryUpImgReq.uint32_bu_type.set(1);
    localTryUpImgReq.bool_pic_original.set(paramReqCommon.b);
    localTryUpImgReq.uint32_pic_width.set(paramReqCommon.jdField_c_of_type_Int);
    localTryUpImgReq.uint32_pic_height.set(paramReqCommon.d);
    localTryUpImgReq.uint32_pic_type.set(paramReqCommon.jdField_a_of_type_Int);
    localTryUpImgReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(RichMediaUtil.a()));
    localTryUpImgReq.bool_reject_tryfast.set(true);
    paramReqBody.rpt_msg_tryup_img_req.add(localTryUpImgReq);
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.jdField_a_of_type_JavaUtilList != null) && (paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
      localProtoReq.jdField_a_of_type_JavaLangString = "LongConn.ArtisticFilter";
      localProtoReq.jdField_a_of_type_ArrayOfByte = a(paramRichProtoReq.jdField_a_of_type_JavaUtilList);
      localProtoReq.jdField_a_of_type_JavaLangObject = paramRichProtoReq;
      localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = this;
      a(paramRichProtoReq, localProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.ArtFilterUpHandler
 * JD-Core Version:    0.7.0.1
 */