package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xb6f$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "report_freq_rsp", "set_threshold_rsp", "get_available_freq_rsp" }, new Object[] { null, null, null }, RspBody.class);
  public oidb_0xb6f.GetAvailableFreqRspBody get_available_freq_rsp = new oidb_0xb6f.GetAvailableFreqRspBody();
  public oidb_0xb6f.ReportFreqRspBody report_freq_rsp = new oidb_0xb6f.ReportFreqRspBody();
  public oidb_0xb6f.SetThresholdRspBody set_threshold_rsp = new oidb_0xb6f.SetThresholdRspBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xb6f.RspBody
 * JD-Core Version:    0.7.0.1
 */