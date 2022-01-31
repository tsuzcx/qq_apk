package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xb6f$SetThresholdReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "identity", "threshold_info" }, new Object[] { null, null }, SetThresholdReqBody.class);
  public oidb_0xb6f.Identity identity = new oidb_0xb6f.Identity();
  public oidb_0xb6f.ThresholdInfo threshold_info = new oidb_0xb6f.ThresholdInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xb6f.SetThresholdReqBody
 * JD-Core Version:    0.7.0.1
 */