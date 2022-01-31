package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GetHotChatList$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "wifi_info", "poi_info_list", "uint32_msg_tab_switch_off_all" }, new Object[] { null, null, Integer.valueOf(0) }, RspBody.class);
  public final PBRepeatMessageField<Common.WifiPOIInfo> poi_info_list = PBField.initRepeatMessage(Common.WifiPOIInfo.class);
  public final PBUInt32Field uint32_msg_tab_switch_off_all = PBField.initUInt32(0);
  public Common.WifiPOIInfo wifi_info = new Common.WifiPOIInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.hotchat.GetHotChatList.RspBody
 * JD-Core Version:    0.7.0.1
 */