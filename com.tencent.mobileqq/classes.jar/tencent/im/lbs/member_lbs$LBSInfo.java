package tencent.im.lbs;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class member_lbs$LBSInfo
  extends MessageMicro<LBSInfo>
{
  public static final int INT64_PRECISION_FIELD_NUMBER = 6;
  public static final int MSG_ATTR_FIELD_NUMBER = 5;
  public static final int MSG_GPS_FIELD_NUMBER = 1;
  public static final int RPT_MSG_CELLS_FIELD_NUMBER = 3;
  public static final int RPT_MSG_WIFIS_FIELD_NUMBER = 2;
  public static final int UINT32_IP_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 37, 42, 48 }, new String[] { "msg_gps", "rpt_msg_wifis", "rpt_msg_cells", "uint32_ip", "msg_attr", "int64_precision" }, new Object[] { null, null, null, Integer.valueOf(0), null, Long.valueOf(0L) }, LBSInfo.class);
  public final PBInt64Field int64_precision = PBField.initInt64(0L);
  public member_lbs.Attr msg_attr = new member_lbs.Attr();
  public member_lbs.GPS msg_gps = new member_lbs.GPS();
  public final PBRepeatMessageField<member_lbs.Cell> rpt_msg_cells = PBField.initRepeatMessage(member_lbs.Cell.class);
  public final PBRepeatMessageField<member_lbs.Wifi> rpt_msg_wifis = PBField.initRepeatMessage(member_lbs.Wifi.class);
  public final PBFixed32Field uint32_ip = PBField.initFixed32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.lbs.member_lbs.LBSInfo
 * JD-Core Version:    0.7.0.1
 */