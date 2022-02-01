package tencent.im.oidb.cmd0xdb1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xdb1$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_birthday = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_school_verify_status = PBField.initEnum(0);
  public final PBRepeatMessageField<oidb_0xdb1.SearchKeyWord> msg_campus_search_keywords = PBField.initRepeatMessage(oidb_0xdb1.SearchKeyWord.class);
  public oidb_0xdb1.SchoolInfo msg_kuolie_school_info = new oidb_0xdb1.SchoolInfo();
  public oidb_0xdb1.SchoolInfo msg_new_school_info = new oidb_0xdb1.SchoolInfo();
  public oidb_0xdb1.matchTaskInfo msg_task_info = new oidb_0xdb1.matchTaskInfo();
  public final PBRepeatMessageField<oidb_0xdb1.SearchKeyWord> msg_voice_search_keywords = PBField.initRepeatMessage(oidb_0xdb1.SearchKeyWord.class);
  public final PBStringField str_be_black_tips = PBField.initString("");
  public final PBStringField str_black_times_tips = PBField.initString("");
  public final PBStringField str_black_times_used_up_tips = PBField.initString("");
  public final PBStringField str_black_times_used_up_title = PBField.initString("");
  public final PBStringField str_func_name = PBField.initString("");
  public final PBStringField str_punish_tips = PBField.initString("");
  public final PBStringField str_school_verify_tips = PBField.initString("");
  public final PBStringField str_suggest_school_name = PBField.initString("");
  public final PBUInt64Field uint32_forbid_end_time = PBField.initUInt64(0L);
  public final PBUInt32Field uint32_forbid_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_left_chat_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_match_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_display_school_info = PBField.initUInt32(0);
  public final PBUInt32Field uint32_online_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_show_gray_tips = PBField.initUInt32(0);
  public final PBUInt32Field uint32_user_identity = PBField.initUInt32(0);
  public final PBUInt64Field uint64_allow_kuolie = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_be_blacked_times = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_black_times = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_expire_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_left_punish_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_matched_times = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_max_match_times = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_voice_match_flag = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 56, 66, 74, 82, 90, 98, 106, 112, 120, 128, 136, 144, 154, 162, 168, 176, 184, 192, 216, 226, 234, 242, 250, 258, 264 }, new String[] { "uint64_allow_kuolie", "uint32_match_count", "str_func_name", "uint64_expire_time", "uint32_left_chat_time", "uint64_voice_match_flag", "enum_school_verify_status", "str_school_verify_tips", "str_suggest_school_name", "msg_kuolie_school_info", "msg_new_school_info", "msg_voice_search_keywords", "msg_campus_search_keywords", "uint32_online_num", "uint32_need_display_school_info", "uint32_user_identity", "uint32_forbid_flag", "uint32_forbid_end_time", "bytes_birthday", "msg_task_info", "uint64_max_match_times", "uint64_matched_times", "uint64_black_times", "uint64_be_blacked_times", "uint64_left_punish_time", "str_black_times_tips", "str_black_times_used_up_tips", "str_black_times_used_up_title", "str_be_black_tips", "str_punish_tips", "uint32_show_gray_tips" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "", "", null, null, null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro, null, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", "", "", "", "", Integer.valueOf(0) }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdb1.oidb_0xdb1.RspBody
 * JD-Core Version:    0.7.0.1
 */