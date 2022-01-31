package tencent.hiboom.hiboomauth;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.msg.im_msg_body.CommonElem;

public final class hiboom_auth$AuthReqBody
  extends MessageMicro<AuthReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field i32_implat = PBField.initInt32(0);
  public im_msg_body.CommonElem req_elem = new im_msg_body.CommonElem();
  public final PBBytesField str_version = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field u32_product_id = PBField.initUInt32(0);
  public final PBUInt64Field u64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "u64_uin", "i32_implat", "str_version", "req_elem", "u32_product_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, null, Integer.valueOf(0) }, AuthReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.hiboom.hiboomauth.hiboom_auth.AuthReqBody
 * JD-Core Version:    0.7.0.1
 */