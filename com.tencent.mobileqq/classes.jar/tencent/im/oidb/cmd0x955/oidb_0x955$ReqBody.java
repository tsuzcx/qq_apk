package tencent.im.oidb.cmd0x955;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x955$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField rpt_pic_url = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatField rpt_uint32_type_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_anonymity = PBField.initUInt32(0);
  public final PBUInt32Field uint32_retry_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_school = PBField.initUInt32(0);
  public final PBUInt64Field uint64_publisher_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 98, 106, 112, 120 }, new String[] { "uint64_publisher_uin", "uint32_retry_count", "uint32_school", "bytes_content", "rpt_pic_url", "uint32_anonymity", "rpt_uint32_type_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x955.oidb_0x955.ReqBody
 * JD-Core Version:    0.7.0.1
 */