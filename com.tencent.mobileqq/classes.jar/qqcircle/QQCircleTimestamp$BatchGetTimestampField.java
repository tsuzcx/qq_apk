package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleTimestamp$BatchGetTimestampField
  extends MessageMicro<BatchGetTimestampField>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "uID", "toUID", "groupID", "timestamp" }, new Object[] { "", "", "", Long.valueOf(0L) }, BatchGetTimestampField.class);
  public final PBStringField groupID = PBField.initString("");
  public final PBInt64Field timestamp = PBField.initInt64(0L);
  public final PBStringField toUID = PBField.initString("");
  public final PBStringField uID = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleTimestamp.BatchGetTimestampField
 * JD-Core Version:    0.7.0.1
 */