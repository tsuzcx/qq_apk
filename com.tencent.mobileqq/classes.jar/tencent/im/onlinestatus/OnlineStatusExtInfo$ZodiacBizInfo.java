package tencent.im.onlinestatus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class OnlineStatusExtInfo$ZodiacBizInfo
  extends MessageMicro<ZodiacBizInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "string_today_trend", "string_tomorrow_trend", "string_miniapp", "string_today_date" }, new Object[] { "", "", "", "" }, ZodiacBizInfo.class);
  public final PBStringField string_miniapp = PBField.initString("");
  public final PBStringField string_today_date = PBField.initString("");
  public final PBStringField string_today_trend = PBField.initString("");
  public final PBStringField string_tomorrow_trend = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.onlinestatus.OnlineStatusExtInfo.ZodiacBizInfo
 * JD-Core Version:    0.7.0.1
 */