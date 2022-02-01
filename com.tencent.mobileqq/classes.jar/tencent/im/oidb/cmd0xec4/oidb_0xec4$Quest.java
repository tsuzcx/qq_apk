package tencent.im.oidb.cmd0xec4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xec4$Quest
  extends MessageMicro<Quest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48, 58, 66, 72, 82, 88, 96, 104, 112, 120, 128, 136 }, new String[] { "str_id", "str_quest", "uint64_quest_uin", "uint64_time", "str_ans", "uint64_ans_time", "rpt_comment", "rpt_praise", "uint64_praise_num", "str_like_key", "uint64_system_id", "uint64_comment_num", "uint64_show_type", "uint64_show_times", "uint64_been_praised", "bool_quest_read", "uint64_ans_show_type" }, new Object[] { "", "", Long.valueOf(0L), Long.valueOf(0L), "", Long.valueOf(0L), null, null, Long.valueOf(0L), "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false), Long.valueOf(0L) }, Quest.class);
  public final PBBoolField bool_quest_read = PBField.initBool(false);
  public final PBRepeatMessageField<oidb_0xec4.Comment> rpt_comment = PBField.initRepeatMessage(oidb_0xec4.Comment.class);
  public final PBRepeatMessageField<oidb_0xec4.Praise> rpt_praise = PBField.initRepeatMessage(oidb_0xec4.Praise.class);
  public final PBStringField str_ans = PBField.initString("");
  public final PBStringField str_id = PBField.initString("");
  public final PBStringField str_like_key = PBField.initString("");
  public final PBStringField str_quest = PBField.initString("");
  public final PBUInt64Field uint64_ans_show_type = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_ans_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_been_praised = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_comment_num = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_praise_num = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_quest_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_show_times = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_show_type = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_system_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xec4.oidb_0xec4.Quest
 * JD-Core Version:    0.7.0.1
 */