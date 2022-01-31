package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xb6f$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "report_freq_req", "set_threshold_req", "get_available_freq_req" }, new Object[] { null, null, null }, ReqBody.class);
  public oidb_0xb6f.GetAvailableFreqReqBody get_available_freq_req = new oidb_0xb6f.GetAvailableFreqReqBody();
  public oidb_0xb6f.ReportFreqReqBody report_freq_req = new oidb_0xb6f.ReportFreqReqBody();
  public oidb_0xb6f.SetThresholdReqBody set_threshold_req = new oidb_0xb6f.SetThresholdReqBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xb6f.ReqBody
 * JD-Core Version:    0.7.0.1
 */