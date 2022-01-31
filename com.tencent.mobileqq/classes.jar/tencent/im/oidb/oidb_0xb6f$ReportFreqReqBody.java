package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class oidb_0xb6f$ReportFreqReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "identity", "invoke_times" }, new Object[] { null, Long.valueOf(1L) }, ReportFreqReqBody.class);
  public oidb_0xb6f.Identity identity = new oidb_0xb6f.Identity();
  public final PBInt64Field invoke_times = PBField.initInt64(1L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xb6f.ReportFreqReqBody
 * JD-Core Version:    0.7.0.1
 */