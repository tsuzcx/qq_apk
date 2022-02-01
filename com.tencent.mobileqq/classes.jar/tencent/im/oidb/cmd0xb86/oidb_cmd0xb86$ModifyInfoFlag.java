package tencent.im.oidb.cmd0xb86;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb86$ModifyInfoFlag
  extends MessageMicro<ModifyInfoFlag>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int32_flag = PBField.initInt32(0);
  public final PBStringField str_msg = PBField.initString("");
  public final PBUInt32Field uint32_count = PBField.initUInt32(0);
  public final PBUInt64Field uint64_remain_second = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "int32_flag", "str_msg", "uint32_count", "uint64_remain_second" }, new Object[] { localInteger, "", localInteger, Long.valueOf(0L) }, ModifyInfoFlag.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb86.oidb_cmd0xb86.ModifyInfoFlag
 * JD-Core Version:    0.7.0.1
 */