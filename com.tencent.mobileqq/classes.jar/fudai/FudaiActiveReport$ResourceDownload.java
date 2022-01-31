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
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "result", "url", "version", "task_id" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, ResourceDownload.class);
  public final PBEnumField result = PBField.initEnum(0);
  public final PBUInt32Field task_id = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
  public final PBUInt32Field version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     fudai.FudaiActiveReport.ResourceDownload
 * JD-Core Version:    0.7.0.1
 */