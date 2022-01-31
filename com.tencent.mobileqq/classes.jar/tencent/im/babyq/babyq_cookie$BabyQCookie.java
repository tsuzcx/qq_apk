package tencent.im.babyq;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class babyq_cookie$BabyQCookie
  extends MessageMicro<BabyQCookie>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 88, 96, 104, 112 }, new String[] { "uint32_type", "rpt_uint64_maybe_uin", "uint64_group_uin", "uint64_buluo_id", "uint32_game_appid", "uint32_no_reward", "uint32_need_not_report", "uint32_video_type", "uint32_user_click", "uint64_client_ability" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, BabyQCookie.class);
  public final PBRepeatField<Long> rpt_uint64_maybe_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_game_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_not_report = PBField.initUInt32(0);
  public final PBUInt32Field uint32_no_reward = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_user_click = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_buluo_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_client_ability = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.babyq.babyq_cookie.BabyQCookie
 * JD-Core Version:    0.7.0.1
 */