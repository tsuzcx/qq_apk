package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQCircleFeedBase$GroupPageSchemaTransfer
  extends MessageMicro<GroupPageSchemaTransfer>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field endTime = PBField.initInt64(0L);
  public final PBUInt64Field groupNumber = PBField.initUInt64(0L);
  public final PBInt64Field startTime = PBField.initInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "startTime", "endTime", "groupNumber" }, new Object[] { localLong, localLong, localLong }, GroupPageSchemaTransfer.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.GroupPageSchemaTransfer
 * JD-Core Version:    0.7.0.1
 */