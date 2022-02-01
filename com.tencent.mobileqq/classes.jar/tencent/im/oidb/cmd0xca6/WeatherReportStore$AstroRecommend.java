package tencent.im.oidb.cmd0xca6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class WeatherReportStore$AstroRecommend
  extends MessageMicro<AstroRecommend>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "signId", "daily", "commentary", "image", "path" }, new Object[] { "", "", "", "", "" }, AstroRecommend.class);
  public final PBStringField commentary = PBField.initString("");
  public final PBStringField daily = PBField.initString("");
  public final PBStringField image = PBField.initString("");
  public final PBStringField path = PBField.initString("");
  public final PBStringField signId = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xca6.WeatherReportStore.AstroRecommend
 * JD-Core Version:    0.7.0.1
 */