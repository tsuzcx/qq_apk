package tencent.im.oidb.cmd0xa2a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xa2a$LBSInfo
  extends MessageMicro<LBSInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 37, 42, 48 }, new String[] { "msg_gpsdw", "rpt_msg_wifis", "rpt_msg_cells", "uint32_ip", "msg_attr", "int64_precision" }, new Object[] { null, null, null, Integer.valueOf(0), null, Long.valueOf(0L) }, LBSInfo.class);
  public final PBInt64Field int64_precision = PBField.initInt64(0L);
  public oidb_0xa2a.Attr msg_attr = new oidb_0xa2a.Attr();
  public oidb_0xa2a.GPS msg_gpsdw = new oidb_0xa2a.GPS();
  public final PBRepeatMessageField<oidb_0xa2a.Cell> rpt_msg_cells = PBField.initRepeatMessage(oidb_0xa2a.Cell.class);
  public final PBRepeatMessageField<oidb_0xa2a.Wifi> rpt_msg_wifis = PBField.initRepeatMessage(oidb_0xa2a.Wifi.class);
  public final PBFixed32Field uint32_ip = PBField.initFixed32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa2a.oidb_0xa2a.LBSInfo
 * JD-Core Version:    0.7.0.1
 */