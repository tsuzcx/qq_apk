package tencent.im.oidb.cmd0xb81;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb81$UserInfoItem
  extends MessageMicro<UserInfoItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public oidb_cmd0xb81.AccountLevelInfo account_level_info = new oidb_cmd0xb81.AccountLevelInfo();
  public oidb_cmd0xb81.ActivityLevel activity_level = new oidb_cmd0xb81.ActivityLevel();
  public oidb_cmd0xb81.AddFriendSetting add_friend_setting = new oidb_cmd0xb81.AddFriendSetting();
  public oidb_cmd0xb81.BindRelationship bind_rel = new oidb_cmd0xb81.BindRelationship();
  public final PBBytesField bytes_desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_friend_remark = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_kandian_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_qq_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_share_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0xb81.ContentAccountInfo content_account_info = new oidb_cmd0xb81.ContentAccountInfo();
  public oidb_cmd0xb81.EduInfo edu_info = new oidb_cmd0xb81.EduInfo();
  public oidb_cmd0xb81.HeadDecoration head_decoration = new oidb_cmd0xb81.HeadDecoration();
  public oidb_cmd0xb81.Secrecy kd_secrecy = new oidb_cmd0xb81.Secrecy();
  public oidb_cmd0xb81.LiveStatus live_status = new oidb_cmd0xb81.LiveStatus();
  public oidb_cmd0xb81.AccountInfo msg_account_info = new oidb_cmd0xb81.AccountInfo();
  public oidb_cmd0xb81.HeadInfo msg_head_info = new oidb_cmd0xb81.HeadInfo();
  public oidb_cmd0xb81.HeadInfo msg_kandian_head = new oidb_cmd0xb81.HeadInfo();
  public oidb_cmd0xb81.HeadInfo msg_qb_head = new oidb_cmd0xb81.HeadInfo();
  public oidb_cmd0xb81.HeadInfo msg_qq_head = new oidb_cmd0xb81.HeadInfo();
  public oidb_cmd0xb81.HeadInfo msg_share_head_url = new oidb_cmd0xb81.HeadInfo();
  public oidb_cmd0xb81.Secrecy qq_secrecy = new oidb_cmd0xb81.Secrecy();
  public oidb_cmd0xb81.Region region = new oidb_cmd0xb81.Region();
  public final PBRepeatMessageField<oidb_cmd0xb81.UserTag> rpt_user_tag = PBField.initRepeatMessage(oidb_cmd0xb81.UserTag.class);
  public oidb_cmd0xb81.Secrecy secrecy = new oidb_cmd0xb81.Secrecy();
  public final PBStringField str_bg_pic = PBField.initString("");
  public final PBStringField str_constellation = PBField.initString("");
  public final PBStringField str_qb_desc = PBField.initString("");
  public final PBStringField str_qb_name = PBField.initString("");
  public final PBStringField string_home_url = PBField.initString("");
  public final PBUInt32Field uint32_account_sysid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_bg_pic_default = PBField.initUInt32(0);
  public final PBUInt32Field uint32_disable_comment_recommed = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_home_page_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_info_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mp_auth_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_publish_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_rt_read = PBField.initUInt32(0);
  public final PBUInt32Field uint32_unowned_user = PBField.initUInt32(0);
  public final PBUInt32Field uint32_upgc_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_user_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_majia_id = PBField.initUInt64(0L);
  public oidb_cmd0xb81.UPIdentInfo up_ident_info = new oidb_cmd0xb81.UPIdentInfo();
  public oidb_cmd0xb81.UpgcAccountInfo upgc_account_info = new oidb_cmd0xb81.UpgcAccountInfo();
  public oidb_cmd0xb81.UserIdentityIcon user_identity_icon = new oidb_cmd0xb81.UserIdentityIcon();
  public oidb_cmd0xb81.AppUserOpenID user_openid = new oidb_cmd0xb81.AppUserOpenID();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 96, 104, 114, 240, 248, 256, 266, 272, 280, 290, 298, 306, 314, 322, 328, 338, 346, 354, 362, 370, 378, 384, 394, 402, 410, 418, 1592, 1602, 1608, 1616, 1626, 1632, 1642, 1648, 1658, 1666, 1674 }, new String[] { "msg_account_info", "bytes_nick", "msg_head_info", "bytes_qq_nick", "bytes_friend_remark", "bytes_kandian_nick", "msg_qq_head", "msg_kandian_head", "bytes_share_nick", "msg_share_head_url", "bytes_desc", "uint32_mp_auth_flag", "uint32_user_type", "string_home_url", "uint32_account_sysid", "uint32_info_type", "uint32_gender", "account_level_info", "uint32_unowned_user", "uint32_disable_comment_recommed", "live_status", "head_decoration", "content_account_info", "activity_level", "upgc_account_info", "uint32_publish_flag", "str_qb_name", "msg_qb_head", "str_qb_desc", "user_identity_icon", "up_ident_info", "add_friend_setting", "uint32_age", "str_constellation", "region", "edu_info", "rpt_user_tag", "uint32_rt_read", "str_bg_pic", "uint32_bg_pic_default", "uint32_home_page_type", "user_openid", "uint32_upgc_flag", "bind_rel", "uint64_majia_id", "secrecy", "kd_secrecy", "qq_secrecy" }, new Object[] { null, localByteStringMicro1, null, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, null, null, localByteStringMicro5, null, localByteStringMicro6, localInteger, localInteger, "", localInteger, localInteger, localInteger, null, localInteger, localInteger, null, null, null, null, null, localInteger, "", null, "", null, null, null, localInteger, "", null, null, null, localInteger, "", localInteger, localInteger, null, localInteger, null, Long.valueOf(0L), null, null, null }, UserInfoItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.UserInfoItem
 * JD-Core Version:    0.7.0.1
 */