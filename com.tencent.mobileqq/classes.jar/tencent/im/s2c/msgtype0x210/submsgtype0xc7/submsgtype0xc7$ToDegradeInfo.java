package tencent.im.s2c.msgtype0x210.submsgtype0xc7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0xc7$ToDegradeInfo
  extends MessageMicro<ToDegradeInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_duplicate_removal = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_wildcard_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field notify_time = PBField.initUInt64(0L);
  public final PBRepeatMessageField<submsgtype0xc7.ToDegradeItem> rpt_to_degrade_item = PBField.initRepeatMessage(submsgtype0xc7.ToDegradeItem.class);
  public final PBUInt32Field uint32_graytip_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 42, 88, 8002 }, new String[] { "rpt_to_degrade_item", "bytes_nick", "notify_time", "bytes_wildcard_wording", "uint32_graytip_type", "bytes_duplicate_removal" }, new Object[] { null, localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3 }, ToDegradeInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.ToDegradeInfo
 * JD-Core Version:    0.7.0.1
 */