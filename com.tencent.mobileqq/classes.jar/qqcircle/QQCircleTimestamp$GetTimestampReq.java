package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleTimestamp$GetTimestampReq
  extends MessageMicro<GetTimestampReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "page_type", "uid", "group_id", "to_uid" }, new Object[] { Integer.valueOf(0), "", "", "" }, GetTimestampReq.class);
  public final PBStringField group_id = PBField.initString("");
  public final PBEnumField page_type = PBField.initEnum(0);
  public final PBStringField to_uid = PBField.initString("");
  public final PBStringField uid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleTimestamp.GetTimestampReq
 * JD-Core Version:    0.7.0.1
 */