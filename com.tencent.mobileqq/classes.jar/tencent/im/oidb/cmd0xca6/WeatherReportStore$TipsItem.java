package tencent.im.oidb.cmd0xca6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class WeatherReportStore$TipsItem
  extends MessageMicro<TipsItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "content", "date" }, new Object[] { "", "" }, TipsItem.class);
  public final PBStringField content = PBField.initString("");
  public final PBStringField date = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xca6.WeatherReportStore.TipsItem
 * JD-Core Version:    0.7.0.1
 */