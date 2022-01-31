package tencent.im.oidb.cmd0xde0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xde0$GestureEvent
  extends MessageMicro<GestureEvent>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 29, 32, 45, 50, 58, 66 }, new String[] { "ges_scroll_direction", "delta_ts_from_last_scroll_mills", "ges_scroll_distance", "ges_scroll_mills", "ges_scroll_speed", "ges_scroll_downNup", "ges_click_point", "get_scroll_feeds_info" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Float.valueOf(0.0F), Long.valueOf(0L), Float.valueOf(0.0F), "", "", null }, GestureEvent.class);
  public final PBUInt64Field delta_ts_from_last_scroll_mills = PBField.initUInt64(0L);
  public final PBStringField ges_click_point = PBField.initString("");
  public final PBUInt32Field ges_scroll_direction = PBField.initUInt32(0);
  public final PBFloatField ges_scroll_distance = PBField.initFloat(0.0F);
  public final PBStringField ges_scroll_downNup = PBField.initString("");
  public final PBUInt64Field ges_scroll_mills = PBField.initUInt64(0L);
  public final PBFloatField ges_scroll_speed = PBField.initFloat(0.0F);
  public final PBRepeatMessageField<oidb_cmd0xde0.FeedScrollStateInfo> get_scroll_feeds_info = PBField.initRepeatMessage(oidb_cmd0xde0.FeedScrollStateInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.GestureEvent
 * JD-Core Version:    0.7.0.1
 */