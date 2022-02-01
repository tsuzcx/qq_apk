package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_msg_body$CommonElem
  extends MessageMicro<CommonElem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_pb_elem = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_business_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_service_type", "bytes_pb_elem", "uint32_business_type" }, new Object[] { localInteger, localByteStringMicro, localInteger }, CommonElem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.CommonElem
 * JD-Core Version:    0.7.0.1
 */