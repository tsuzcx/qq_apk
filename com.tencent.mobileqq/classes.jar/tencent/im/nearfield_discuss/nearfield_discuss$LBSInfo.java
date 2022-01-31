package tencent.im.nearfield_discuss;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class nearfield_discuss$LBSInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_gps", "rpt_msg_wifis", "rpt_msg_cells" }, new Object[] { null, null, null }, LBSInfo.class);
  public nearfield_discuss.GPS msg_gps = new nearfield_discuss.GPS();
  public final PBRepeatMessageField rpt_msg_cells = PBField.initRepeatMessage(nearfield_discuss.Cell.class);
  public final PBRepeatMessageField rpt_msg_wifis = PBField.initRepeatMessage(nearfield_discuss.Wifi.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.nearfield_discuss.nearfield_discuss.LBSInfo
 * JD-Core Version:    0.7.0.1
 */