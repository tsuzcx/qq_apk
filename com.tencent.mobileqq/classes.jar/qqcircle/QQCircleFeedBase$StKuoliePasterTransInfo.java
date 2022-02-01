package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQCircleFeedBase$StKuoliePasterTransInfo
  extends MessageMicro<StKuoliePasterTransInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42 }, new String[] { "feed_id", "feed_author_id", "request_uid", "time", "trace_id" }, new Object[] { "", "", "", Long.valueOf(0L), "" }, StKuoliePasterTransInfo.class);
  public final PBStringField feed_author_id = PBField.initString("");
  public final PBStringField feed_id = PBField.initString("");
  public final PBStringField request_uid = PBField.initString("");
  public final PBUInt64Field time = PBField.initUInt64(0L);
  public final PBStringField trace_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StKuoliePasterTransInfo
 * JD-Core Version:    0.7.0.1
 */