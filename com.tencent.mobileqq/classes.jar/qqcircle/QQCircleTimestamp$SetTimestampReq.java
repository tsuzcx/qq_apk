package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleTimestamp$SetTimestampReq
  extends MessageMicro<SetTimestampReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field expire = PBField.initInt64(0L);
  public final PBStringField group_id = PBField.initString("");
  public final PBEnumField page_type = PBField.initEnum(0);
  public final PBInt64Field timestamp = PBField.initInt64(0L);
  public final PBStringField to_uid = PBField.initString("");
  public final PBStringField uid = PBField.initString("");
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48 }, new String[] { "timestamp", "page_type", "uid", "group_id", "to_uid", "expire" }, new Object[] { localLong, Integer.valueOf(0), "", "", "", localLong }, SetTimestampReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleTimestamp.SetTimestampReq
 * JD-Core Version:    0.7.0.1
 */