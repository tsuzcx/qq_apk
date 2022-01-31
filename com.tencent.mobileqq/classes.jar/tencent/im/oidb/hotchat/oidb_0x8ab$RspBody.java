package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8ab$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "poi_info", "join_poi_status" }, new Object[] { null, Integer.valueOf(0) }, RspBody.class);
  public final PBUInt32Field join_poi_status = PBField.initUInt32(0);
  public Common.WifiPOIInfo poi_info = new Common.WifiPOIInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.hotchat.oidb_0x8ab.RspBody
 * JD-Core Version:    0.7.0.1
 */