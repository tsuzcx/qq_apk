package tencent.im.oidb.cmd0x858;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x858$MessageRecallReminder
  extends MessageMicro<MessageRecallReminder>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_nickname = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_userdef = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_reminder_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_group_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
  public final PBRepeatMessageField<oidb_0x858.MessageRecallReminder.MessageMeta> uint32_recalled_msg_list = PBField.initRepeatMessage(oidb_0x858.MessageRecallReminder.MessageMeta.class);
  public final PBUInt64Field uint64_admin_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 56, 64 }, new String[] { "uint64_uin", "bytes_nickname", "uint32_recalled_msg_list", "str_reminder_content", "bytes_userdef", "uint32_group_type", "uint32_op_type", "uint64_admin_uin" }, new Object[] { localLong, localByteStringMicro1, null, localByteStringMicro2, localByteStringMicro3, localInteger, localInteger, localLong }, MessageRecallReminder.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x858.oidb_0x858.MessageRecallReminder
 * JD-Core Version:    0.7.0.1
 */