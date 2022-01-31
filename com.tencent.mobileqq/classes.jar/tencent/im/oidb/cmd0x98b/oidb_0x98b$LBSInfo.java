package tencent.im.oidb.cmd0x98b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class oidb_0x98b$LBSInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "int32_lat", "int32_lon", "msg_lbs_sig" }, new Object[] { Integer.valueOf(900000000), Integer.valueOf(900000000), null }, LBSInfo.class);
  public final PBInt32Field int32_lat = PBField.initInt32(900000000);
  public final PBInt32Field int32_lon = PBField.initInt32(900000000);
  public oidb_0x98b.LBSSig msg_lbs_sig = new oidb_0x98b.LBSSig();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x98b.oidb_0x98b.LBSInfo
 * JD-Core Version:    0.7.0.1
 */