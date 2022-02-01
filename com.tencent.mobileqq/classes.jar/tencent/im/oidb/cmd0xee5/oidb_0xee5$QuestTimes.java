package tencent.im.oidb.cmd0xee5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xee5$QuestTimes
  extends MessageMicro<QuestTimes>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_quest_id = PBField.initString("");
  public final PBUInt64Field uint64_quest_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_show_times = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "str_quest_id", "uint64_quest_time", "uint64_uin", "uint64_show_times" }, new Object[] { "", localLong, localLong, localLong }, QuestTimes.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xee5.oidb_0xee5.QuestTimes
 * JD-Core Version:    0.7.0.1
 */