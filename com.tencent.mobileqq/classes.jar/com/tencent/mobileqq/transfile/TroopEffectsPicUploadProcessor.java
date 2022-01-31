package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import java.util.ArrayList;
import tencent.im.msg.im_msg_body.CustomFace;

public class TroopEffectsPicUploadProcessor
  extends GroupPicUploadProcessor
{
  public im_msg_body.CustomFace a;
  
  public TroopEffectsPicUploadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
  }
  
  void s()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.a != null)
    {
      w();
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Long = this.q;
      localSendResult.d = this.c;
      localSendResult.c = this.d;
      localSendResult.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i;
      localSendResult.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      localSendResult.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_TencentImMsgIm_msg_body$CustomFace;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.a.b(localSendResult);
      a(true);
    }
  }
  
  protected void w()
  {
    im_msg_body.CustomFace localCustomFace = new im_msg_body.CustomFace();
    localCustomFace.uint32_file_id.set((int)this.jdField_a_of_type_Long);
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      localObject = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      localCustomFace.uint32_server_ip.set(a(((ServerAddr)localObject).jdField_a_of_type_JavaLangString));
      localCustomFace.uint32_server_port.set(((ServerAddr)localObject).jdField_a_of_type_Int);
    }
    localCustomFace.uint32_file_type.set(Integer.valueOf(66).intValue());
    localCustomFace.uint32_useful.set(1);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      localCustomFace.bytes_signature.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    }
    localCustomFace.bytes_md5.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ArrayOfByte));
    localCustomFace.str_file_path.set(this.d);
    Object localObject = localCustomFace.uint32_origin;
    if (this.l) {}
    for (int i = 1;; i = 0)
    {
      ((PBUInt32Field)localObject).set(i);
      localCustomFace.uint32_width.set(this.o);
      localCustomFace.uint32_height.set(this.p);
      localCustomFace.uint32_size.set((int)this.q);
      localCustomFace.uint32_source.set(200);
      this.jdField_a_of_type_TencentImMsgIm_msg_body$CustomFace = localCustomFace;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.TroopEffectsPicUploadProcessor
 * JD-Core Version:    0.7.0.1
 */