package tencent.im.oidb.cmd0x7b4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x7b4$TaskCommonInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_animation = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_config = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_screen_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_logo_url = PBField.initString("");
  public final PBUInt32Field uint32_begtime = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cooldown = PBField.initUInt32(0);
  public final PBUInt32Field uint32_endtime = PBField.initUInt32(0);
  public final PBUInt32Field uint32_priority = PBField.initUInt32(0);
  public final PBUInt32Field uint32_treasure_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_task_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 88, 98, 106, 114, 122, 128, 136 }, new String[] { "uint64_task_id", "uint32_priority", "uint32_treasure_type", "str_logo_url", "uint32_cooldown", "bytes_animation", "bytes_jump_url", "bytes_screen_info", "bytes_config", "uint32_begtime", "uint32_endtime" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0) }, TaskCommonInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7b4.cmd0x7b4.TaskCommonInfo
 * JD-Core Version:    0.7.0.1
 */