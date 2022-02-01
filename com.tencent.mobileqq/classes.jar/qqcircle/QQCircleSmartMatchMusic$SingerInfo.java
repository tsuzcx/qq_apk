package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleSmartMatchMusic$SingerInfo
  extends MessageMicro<SingerInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "iD", "mID", "name", "picURL" }, new Object[] { Long.valueOf(0L), "", "", "" }, SingerInfo.class);
  public final PBInt64Field iD = PBField.initInt64(0L);
  public final PBStringField mID = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBStringField picURL = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleSmartMatchMusic.SingerInfo
 * JD-Core Version:    0.7.0.1
 */