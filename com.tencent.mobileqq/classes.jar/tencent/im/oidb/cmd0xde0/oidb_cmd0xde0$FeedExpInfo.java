package tencent.im.oidb.cmd0xde0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xde0$FeedExpInfo
  extends MessageMicro<FeedExpInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 106 }, new String[] { "feeds_id", "rec_reason", "style", "word_cnt_for_display", "feed_card_height", "is_first_scrn", "is_last_scrn", "exp_pos_in_list", "is_clicked", "read_duratiion", "exp_duration", "exp_duration_in_active_zone", "exp_orientation" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(false), Integer.valueOf(0), Boolean.valueOf(false), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "" }, FeedExpInfo.class);
  public final PBUInt64Field exp_duration = PBField.initUInt64(0L);
  public final PBUInt64Field exp_duration_in_active_zone = PBField.initUInt64(0L);
  public final PBStringField exp_orientation = PBField.initString("");
  public final PBUInt32Field exp_pos_in_list = PBField.initUInt32(0);
  public final PBUInt32Field feed_card_height = PBField.initUInt32(0);
  public final PBStringField feeds_id = PBField.initString("");
  public final PBBoolField is_clicked = PBField.initBool(false);
  public final PBBoolField is_first_scrn = PBField.initBool(false);
  public final PBBoolField is_last_scrn = PBField.initBool(false);
  public final PBUInt64Field read_duratiion = PBField.initUInt64(0L);
  public final PBStringField rec_reason = PBField.initString("");
  public final PBUInt32Field style = PBField.initUInt32(0);
  public final PBUInt32Field word_cnt_for_display = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.FeedExpInfo
 * JD-Core Version:    0.7.0.1
 */