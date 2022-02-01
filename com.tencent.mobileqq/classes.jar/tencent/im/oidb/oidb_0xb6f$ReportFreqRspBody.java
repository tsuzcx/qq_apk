package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xb6f$ReportFreqRspBody
  extends MessageMicro<ReportFreqRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 32, 40 }, new String[] { "identity", "remain_times", "expire_time" }, new Object[] { null, Long.valueOf(0L), Integer.valueOf(0) }, ReportFreqRspBody.class);
  public final PBUInt32Field expire_time = PBField.initUInt32(0);
  public oidb_0xb6f.Identity identity = new oidb_0xb6f.Identity();
  public final PBInt64Field remain_times = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xb6f.ReportFreqRspBody
 * JD-Core Version:    0.7.0.1
 */