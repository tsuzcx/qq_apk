package tencent.im.cs.cmd0x3bb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x3bb$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField color = PBField.initString("");
  public final PBInt32Field int32_ret = PBField.initInt32(0);
  public cmd0x3bb.AnonyStatus msg_anony_status = new cmd0x3bb.AnonyStatus();
  public final PBBytesField str_anony_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_bubble_index = PBField.initUInt32(0);
  public final PBUInt32Field uint32_expired_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_portrait_index = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 82, 122 }, new String[] { "int32_ret", "uint64_group_code", "str_anony_name", "uint32_portrait_index", "uint32_bubble_index", "uint32_expired_time", "msg_anony_status", "color" }, new Object[] { localInteger, Long.valueOf(0L), localByteStringMicro, localInteger, localInteger, localInteger, null, "" }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.cmd0x3bb.cmd0x3bb.RspBody
 * JD-Core Version:    0.7.0.1
 */