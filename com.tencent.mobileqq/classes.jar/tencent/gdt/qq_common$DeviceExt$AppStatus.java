package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qq_common$DeviceExt$AppStatus
  extends MessageMicro<AppStatus>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "installed", "uninstalled" }, new Object[] { "", "" }, AppStatus.class);
  public final PBRepeatField<String> installed = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField<String> uninstalled = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.gdt.qq_common.DeviceExt.AppStatus
 * JD-Core Version:    0.7.0.1
 */