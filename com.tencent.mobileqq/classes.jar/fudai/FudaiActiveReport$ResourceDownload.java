package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FudaiActiveReport$ResourceDownload
  extends MessageMicro<ResourceDownload>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField result = PBField.initEnum(0);
  public final PBUInt32Field task_id = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
  public final PBUInt32Field version = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "result", "url", "version", "task_id" }, new Object[] { localInteger, "", localInteger, localInteger }, ResourceDownload.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     fudai.FudaiActiveReport.ResourceDownload
 * JD-Core Version:    0.7.0.1
 */