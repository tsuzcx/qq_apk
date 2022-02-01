package tencent.im.oidb.cmd0xca6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class WeatherReportStore$DailyAstroFortune
  extends MessageMicro<DailyAstroFortune>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 50, 58 }, new String[] { "astro", "date", "fortunes", "astro_id", "astro_pic", "astro_title", "recommend" }, new Object[] { "", "", null, Integer.valueOf(0), "", "", null }, DailyAstroFortune.class);
  public final PBStringField astro = PBField.initString("");
  public final PBUInt32Field astro_id = PBField.initUInt32(0);
  public final PBStringField astro_pic = PBField.initString("");
  public final PBStringField astro_title = PBField.initString("");
  public final PBStringField date = PBField.initString("");
  public final PBRepeatMessageField<WeatherReportStore.Fortune> fortunes = PBField.initRepeatMessage(WeatherReportStore.Fortune.class);
  public WeatherReportStore.AstroRecommend recommend = new WeatherReportStore.AstroRecommend();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xca6.WeatherReportStore.DailyAstroFortune
 * JD-Core Version:    0.7.0.1
 */