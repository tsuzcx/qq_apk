package tencent.im.oidb.cmd0xdb1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xdb1$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 56, 66, 74, 82, 90, 98, 106, 112, 120, 128 }, new String[] { "uint64_allow_kuolie", "uint32_match_count", "str_func_name", "uint64_expire_time", "uint32_left_chat_time", "uint64_voice_match_flag", "enum_school_verify_status", "str_school_verify_tips", "str_suggest_school_name", "msg_kuolie_school_info", "msg_new_school_info", "msg_voice_search_keywords", "msg_campus_search_keywords", "uint32_online_num", "uint32_need_display_school_info", "uint32_user_identity" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "", "", null, null, null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
  public final PBEnumField enum_school_verify_status = PBField.initEnum(0);
  public final PBRepeatMessageField<oidb_0xdb1.SearchKeyWord> msg_campus_search_keywords = PBField.initRepeatMessage(oidb_0xdb1.SearchKeyWord.class);
  public oidb_0xdb1.SchoolInfo msg_kuolie_school_info = new oidb_0xdb1.SchoolInfo();
  public oidb_0xdb1.SchoolInfo msg_new_school_info = new oidb_0xdb1.SchoolInfo();
  public final PBRepeatMessageField<oidb_0xdb1.SearchKeyWord> msg_voice_search_keywords = PBField.initRepeatMessage(oidb_0xdb1.SearchKeyWord.class);
  public final PBStringField str_func_name = PBField.initString("");
  public final PBStringField str_school_verify_tips = PBField.initString("");
  public final PBStringField str_suggest_school_name = PBField.initString("");
  public final PBUInt32Field uint32_left_chat_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_match_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_display_school_info = PBField.initUInt32(0);
  public final PBUInt32Field uint32_online_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_user_identity = PBField.initUInt32(0);
  public final PBUInt64Field uint64_allow_kuolie = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_expire_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_voice_match_flag = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdb1.oidb_0xdb1.RspBody
 * JD-Core Version:    0.7.0.1
 */