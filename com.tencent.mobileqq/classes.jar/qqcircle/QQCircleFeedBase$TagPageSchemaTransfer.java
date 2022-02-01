package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleFeedBase$TagPageSchemaTransfer
  extends MessageMicro<TagPageSchemaTransfer>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field endTime = PBField.initInt64(0L);
  public final PBInt64Field startTime = PBField.initInt64(0L);
  public final PBStringField tagName = PBField.initString("");
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "startTime", "endTime", "tagName" }, new Object[] { localLong, localLong, "" }, TagPageSchemaTransfer.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.TagPageSchemaTransfer
 * JD-Core Version:    0.7.0.1
 */