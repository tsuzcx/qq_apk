package tencent.im.oidb.cmd0xa6d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xa6d$LBSInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_gps", "rpt_msg_wifis", "rpt_msg_cells" }, new Object[] { null, null, null }, LBSInfo.class);
  public oidb_0xa6d.GPS msg_gps = new oidb_0xa6d.GPS();
  public final PBRepeatMessageField rpt_msg_cells = PBField.initRepeatMessage(oidb_0xa6d.Cell.class);
  public final PBRepeatMessageField rpt_msg_wifis = PBField.initRepeatMessage(oidb_0xa6d.Wifi.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa6d.oidb_0xa6d.LBSInfo
 * JD-Core Version:    0.7.0.1
 */