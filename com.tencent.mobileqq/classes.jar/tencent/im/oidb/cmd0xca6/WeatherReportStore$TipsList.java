package tencent.im.oidb.cmd0xca6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WeatherReportStore$TipsList
  extends MessageMicro<TipsList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "tips", "updatetime" }, new Object[] { null, Long.valueOf(0L) }, TipsList.class);
  public final PBRepeatMessageField<WeatherReportStore.TipsItem> tips = PBField.initRepeatMessage(WeatherReportStore.TipsItem.class);
  public final PBUInt64Field updatetime = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xca6.WeatherReportStore.TipsList
 * JD-Core Version:    0.7.0.1
 */