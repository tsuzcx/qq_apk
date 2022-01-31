package tencent.im.mutualmark;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mutualmark$MutualMark
  extends MessageMicro<MutualMark>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_resource_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_special_word_attribute = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBFloatField float_count = PBField.initFloat(0.0F);
  public final PBFloatField float_last_week_count = PBField.initFloat(0.0F);
  public final PBRepeatMessageField<mutualmark.MutualActionDay> rpt_mutual_action_day = PBField.initRepeatMessage(mutualmark.MutualActionDay.class);
  public final PBUInt32Field uint32_close_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint64_add_friend_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_day = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_degrade_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_icon_status = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_icon_status_end_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_level = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_push_time_c2c_100 = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_push_time_c2c_50 = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_push_time_score_1000 = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_push_time_score_1200 = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_push_time_score_200 = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_push_time_score_400 = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_push_time_score_600 = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_push_time_score_800 = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_push_time_talk = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_type = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 45, 48, 56, 64, 72, 80, 90, 8002, 8013, 40000, 48000, 120000, 120008, 120016, 128000, 128008, 128016, 128024, 128032, 128040, 136002 }, new String[] { "uint64_type", "uint64_level", "uint64_src_uin", "uint64_dst_uin", "float_count", "uint64_day", "uint64_time", "uint64_icon_status", "uint64_icon_status_end_time", "uint32_close_flag", "bytes_resource_info", "rpt_mutual_action_day", "float_last_week_count", "uint64_add_friend_time", "uint64_degrade_time", "uint64_push_time_c2c_50", "uint64_push_time_c2c_100", "uint64_push_time_talk", "uint64_push_time_score_200", "uint64_push_time_score_400", "uint64_push_time_score_600", "uint64_push_time_score_800", "uint64_push_time_score_1000", "uint64_push_time_score_1200", "bytes_special_word_attribute" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Float.valueOf(0.0F), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, null, Float.valueOf(0.0F), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro2 }, MutualMark.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.mutualmark.mutualmark.MutualMark
 * JD-Core Version:    0.7.0.1
 */