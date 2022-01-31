package tencent.im.oidb.cmd0x8b2;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8b2$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_clear_all_administrator = PBField.initBool(false);
  public final PBBytesField string_hot_group_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<Long> uint64_administrator_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "string_hot_group_id", "uint64_administrator_uin", "bool_clear_all_administrator", "uint64_group_code" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Boolean.valueOf(false), Long.valueOf(0L) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8b2.oidb_0x8b2.ReqBody
 * JD-Core Version:    0.7.0.1
 */