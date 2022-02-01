package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GetHotChatList$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field get_poi_group = PBField.initUInt32(0);
  public final PBUInt32Field get_wifi_group = PBField.initUInt32(0);
  public LBS.Wifi joined_wifi = new LBS.Wifi();
  public LBS.LBSInfo lbs_info = new LBS.LBSInfo();
  public final PBUInt32Field uint32_msg_tab_switch_off_all = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "get_wifi_group", "get_poi_group", "joined_wifi", "lbs_info", "uint32_msg_tab_switch_off_all" }, new Object[] { localInteger, localInteger, null, null, localInteger }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.hotchat.GetHotChatList.ReqBody
 * JD-Core Version:    0.7.0.1
 */