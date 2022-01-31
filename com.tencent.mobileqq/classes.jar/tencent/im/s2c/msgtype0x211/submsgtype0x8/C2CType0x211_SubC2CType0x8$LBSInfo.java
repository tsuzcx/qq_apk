package tencent.im.s2c.msgtype0x211.submsgtype0x8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class C2CType0x211_SubC2CType0x8$LBSInfo
  extends MessageMicro
{
  public static final int MSG_GPS_FIELD_NUMBER = 1;
  public static final int RPT_MSG_CELLS_FIELD_NUMBER = 3;
  public static final int RPT_MSG_WIFIS_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_gps", "rpt_msg_wifis", "rpt_msg_cells" }, new Object[] { null, null, null }, LBSInfo.class);
  public C2CType0x211_SubC2CType0x8.GPS msg_gps = new C2CType0x211_SubC2CType0x8.GPS();
  public final PBRepeatMessageField rpt_msg_cells = PBField.initRepeatMessage(C2CType0x211_SubC2CType0x8.Cell.class);
  public final PBRepeatMessageField rpt_msg_wifis = PBField.initRepeatMessage(C2CType0x211_SubC2CType0x8.Wifi.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x8.C2CType0x211_SubC2CType0x8.LBSInfo
 * JD-Core Version:    0.7.0.1
 */