package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FudaiActiveReport$ExceptionHandle
  extends MessageMicro<ExceptionHandle>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "task_id", "errcode", "msg", "version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0) }, ExceptionHandle.class);
  public final PBEnumField errcode = PBField.initEnum(0);
  public final PBStringField msg = PBField.initString("");
  public final PBUInt32Field task_id = PBField.initUInt32(0);
  public final PBUInt32Field version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     fudai.FudaiActiveReport.ExceptionHandle
 * JD-Core Version:    0.7.0.1
 */