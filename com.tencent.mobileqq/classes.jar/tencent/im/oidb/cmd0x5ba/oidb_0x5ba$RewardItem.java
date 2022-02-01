package tencent.im.oidb.cmd0x5ba;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x5ba$RewardItem
  extends MessageMicro<RewardItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66, 72, 80, 88, 98, 106, 114, 122, 130, 138, 144, 152, 162, 168, 176 }, new String[] { "uint64_request_uin", "uint32_request_time", "uint64_pay_uin", "uint32_pay_time", "uint32_pay_count", "uint32_punish_left_time", "uint32_shootscreen_punish_time", "string_punish_warning_info", "uint32_reward_type", "uint32_reward_fee", "uint32_reward_status", "string_reward_text", "string_reward_id", "string_blur_pic_url", "string_clear_pic_url", "string_vid", "string_cookie", "uint32_reward_expire", "uint32_video_duration", "string_ckey", "uint32_close_time", "uint64_request_gc" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Long.valueOf(0L) }, RewardItem.class);
  public final PBStringField string_blur_pic_url = PBField.initString("");
  public final PBStringField string_ckey = PBField.initString("");
  public final PBStringField string_clear_pic_url = PBField.initString("");
  public final PBStringField string_cookie = PBField.initString("");
  public final PBStringField string_punish_warning_info = PBField.initString("");
  public final PBStringField string_reward_id = PBField.initString("");
  public final PBStringField string_reward_text = PBField.initString("");
  public final PBStringField string_vid = PBField.initString("");
  public final PBUInt32Field uint32_close_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pay_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pay_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_punish_left_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_request_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_reward_expire = PBField.initUInt32(0);
  public final PBUInt32Field uint32_reward_fee = PBField.initUInt32(0);
  public final PBUInt32Field uint32_reward_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_reward_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_shootscreen_punish_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_duration = PBField.initUInt32(0);
  public final PBUInt64Field uint64_pay_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_request_gc = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_request_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5ba.oidb_0x5ba.RewardItem
 * JD-Core Version:    0.7.0.1
 */