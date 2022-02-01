package im.oidb.wifi_poi_group.cmd0x8e9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public final class cmd0x8e9$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "poi_info", "rpt_rsp_visitor_info" }, new Object[] { null, null }, RspBody.class);
  public Common.WifiPOIInfo poi_info = new Common.WifiPOIInfo();
  public final PBRepeatMessageField<cmd0x8e9.VisitorInfo> rpt_rsp_visitor_info = PBField.initRepeatMessage(cmd0x8e9.VisitorInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     im.oidb.wifi_poi_group.cmd0x8e9.cmd0x8e9.RspBody
 * JD-Core Version:    0.7.0.1
 */