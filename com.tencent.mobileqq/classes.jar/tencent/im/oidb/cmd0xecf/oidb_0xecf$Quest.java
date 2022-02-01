package tencent.im.oidb.cmd0xecf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xecf$Quest
  extends MessageMicro<Quest>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_quest_read = PBField.initBool(false);
  public final PBStringField bytes_quest_uin = PBField.initString("");
  public final PBRepeatMessageField<oidb_0xecf.Comment> rpt_comment = PBField.initRepeatMessage(oidb_0xecf.Comment.class);
  public final PBRepeatMessageField<oidb_0xecf.Praise> rpt_praise = PBField.initRepeatMessage(oidb_0xecf.Praise.class);
  public final PBRepeatField<Long> rpt_quest_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBStringField str_ans = PBField.initString("");
  public final PBStringField str_id = PBField.initString("");
  public final PBStringField str_like_key = PBField.initString("");
  public final PBStringField str_quest = PBField.initString("");
  public final PBUInt64Field uint64_ans_show_type = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_ans_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_been_praised = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_comment_num = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_praise_num = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_quest_num = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_quest_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_show_times = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_show_type = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_system_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48, 58, 66, 72, 82, 88, 96, 104, 112, 120, 128, 136, 146, 152, 160 }, new String[] { "str_id", "str_quest", "uint64_quest_uin", "uint64_time", "str_ans", "uint64_ans_time", "rpt_comment", "rpt_praise", "uint64_praise_num", "str_like_key", "uint64_system_id", "uint64_comment_num", "uint64_show_type", "uint64_show_times", "uint64_been_praised", "bool_quest_read", "uint64_ans_show_type", "bytes_quest_uin", "rpt_quest_uin", "uint64_quest_num" }, new Object[] { "", "", localLong, localLong, "", localLong, null, null, localLong, "", localLong, localLong, localLong, localLong, localLong, Boolean.valueOf(false), localLong, "", localLong, localLong }, Quest.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xecf.oidb_0xecf.Quest
 * JD-Core Version:    0.7.0.1
 */