package tencent.im.s2c.msgtype0x210.submsgtype0xc7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0xc7$ToDegradeItem
  extends MessageMicro<ToDegradeItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field continuity_days = PBField.initUInt32(0);
  public final PBUInt32Field new_level = PBField.initUInt32(0);
  public final PBUInt32Field old_level = PBField.initUInt32(0);
  public final PBEnumField type = PBField.initEnum(1);
  public final PBUInt64Field uint64_last_action_time = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 88, 96 }, new String[] { "type", "old_level", "new_level", "continuity_days", "uint64_last_action_time" }, new Object[] { Integer.valueOf(1), localInteger, localInteger, localInteger, Long.valueOf(0L) }, ToDegradeItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.ToDegradeItem
 * JD-Core Version:    0.7.0.1
 */