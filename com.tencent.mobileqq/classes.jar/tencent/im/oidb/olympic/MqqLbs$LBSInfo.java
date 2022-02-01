package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class MqqLbs$LBSInfo
  extends MessageMicro<LBSInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_gps", "rpt_msg_wifis", "rpt_msg_cells" }, new Object[] { null, null, null }, LBSInfo.class);
  public MqqLbs.GPS msg_gps = new MqqLbs.GPS();
  public final PBRepeatMessageField<MqqLbs.Cell> rpt_msg_cells = PBField.initRepeatMessage(MqqLbs.Cell.class);
  public final PBRepeatMessageField<MqqLbs.Wifi> rpt_msg_wifis = PBField.initRepeatMessage(MqqLbs.Wifi.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.olympic.MqqLbs.LBSInfo
 * JD-Core Version:    0.7.0.1
 */