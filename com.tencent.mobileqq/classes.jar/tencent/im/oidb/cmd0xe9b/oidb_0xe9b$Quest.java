package tencent.im.oidb.cmd0xe9b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe9b$Quest
  extends MessageMicro<Quest>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_ans = PBField.initString("");
  public final PBStringField str_id = PBField.initString("");
  public final PBStringField str_quest = PBField.initString("");
  public final PBUInt64Field uint64_quest_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "str_id", "str_quest", "uint64_quest_uin", "uint64_time", "str_ans" }, new Object[] { "", "", localLong, localLong, "" }, Quest.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe9b.oidb_0xe9b.Quest
 * JD-Core Version:    0.7.0.1
 */