package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8dd$NearbyConfig
  extends MessageMicro<NearbyConfig>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public oidb_0x8dd.AlumnusConf msg_alumnus_conf = new oidb_0x8dd.AlumnusConf();
  public oidb_0x8dd.LoginConf msg_login_conf = new oidb_0x8dd.LoginConf();
  public oidb_0x8dd.RecommPeopleConf msg_recomm_people_conf = new oidb_0x8dd.RecommPeopleConf();
  public oidb_0x8dd.VideoChatConf msg_video_chat_conf = new oidb_0x8dd.VideoChatConf();
  public final PBStringField str_security_detail_url = PBField.initString("");
  public final PBStringField str_security_tips = PBField.initString("");
  public final PBUInt32Field uint32_can_add_sub_interest = PBField.initUInt32(0);
  public final PBUInt32Field uint32_heart_increment = PBField.initUInt32(0);
  public final PBUInt32Field uint32_use_interest_tag = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 48, 56, 74, 82 }, new String[] { "str_security_tips", "str_security_detail_url", "uint32_use_interest_tag", "msg_alumnus_conf", "msg_recomm_people_conf", "uint32_can_add_sub_interest", "uint32_heart_increment", "msg_video_chat_conf", "msg_login_conf" }, new Object[] { "", "", localInteger, null, null, localInteger, localInteger, null, null }, NearbyConfig.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8dd.oidb_0x8dd.NearbyConfig
 * JD-Core Version:    0.7.0.1
 */