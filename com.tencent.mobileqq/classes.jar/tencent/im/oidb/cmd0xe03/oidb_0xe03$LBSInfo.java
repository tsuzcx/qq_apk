package tencent.im.oidb.cmd0xe03;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xe03$LBSInfo
  extends MessageMicro<LBSInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_gps", "rpt_msg_wifis", "rpt_msg_cells" }, new Object[] { null, null, null }, LBSInfo.class);
  public oidb_0xe03.GPS msg_gps = new oidb_0xe03.GPS();
  public final PBRepeatMessageField<oidb_0xe03.Cell> rpt_msg_cells = PBField.initRepeatMessage(oidb_0xe03.Cell.class);
  public final PBRepeatMessageField<oidb_0xe03.Wifi> rpt_msg_wifis = PBField.initRepeatMessage(oidb_0xe03.Wifi.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe03.oidb_0xe03.LBSInfo
 * JD-Core Version:    0.7.0.1
 */