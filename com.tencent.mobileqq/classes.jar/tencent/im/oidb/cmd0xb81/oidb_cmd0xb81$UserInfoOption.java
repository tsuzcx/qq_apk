package tencent.im.oidb.cmd0xb81;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xb81$UserInfoOption
  extends MessageMicro<UserInfoOption>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_account_cc_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_account_sysid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_activity_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_add_friend = PBField.initUInt32(0);
  public final PBUInt32Field uint32_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_bg_pic = PBField.initUInt32(0);
  public final PBUInt32Field uint32_bind_rel = PBField.initUInt32(0);
  public final PBUInt32Field uint32_constellation = PBField.initUInt32(0);
  public final PBUInt32Field uint32_content_account_info = PBField.initUInt32(0);
  public final PBUInt32Field uint32_desc = PBField.initUInt32(0);
  public final PBUInt32Field uint32_disable_bind = PBField.initUInt32(0);
  public final PBUInt32Field uint32_disable_cache = PBField.initUInt32(0);
  public final PBUInt32Field uint32_disable_comment_recommed = PBField.initUInt32(0);
  public final PBUInt32Field uint32_disable_qb = PBField.initUInt32(0);
  public final PBUInt32Field uint32_edu_info = PBField.initUInt32(0);
  public final PBUInt32Field uint32_friend_remark = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_head_decoration = PBField.initUInt32(0);
  public final PBUInt32Field uint32_head_real_url = PBField.initUInt32(0);
  public final PBUInt32Field uint32_head_url = PBField.initUInt32(0);
  public final PBUInt32Field uint32_home_page_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_home_url = PBField.initUInt32(0);
  public final PBUInt32Field uint32_kandian_head = PBField.initUInt32(0);
  public final PBUInt32Field uint32_kandian_nick = PBField.initUInt32(0);
  public final PBUInt32Field uint32_live_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mp_auth = PBField.initUInt32(0);
  public final PBUInt32Field uint32_nick = PBField.initUInt32(0);
  public final PBUInt32Field uint32_openid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_publish_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_qb_desc = PBField.initUInt32(0);
  public final PBUInt32Field uint32_qb_head = PBField.initUInt32(0);
  public final PBUInt32Field uint32_qb_name = PBField.initUInt32(0);
  public final PBUInt32Field uint32_qq_head = PBField.initUInt32(0);
  public final PBUInt32Field uint32_qq_nick = PBField.initUInt32(0);
  public final PBUInt32Field uint32_region = PBField.initUInt32(0);
  public final PBUInt32Field uint32_secrecy = PBField.initUInt32(0);
  public final PBUInt32Field uint32_share_head_url = PBField.initUInt32(0);
  public final PBUInt32Field uint32_share_nick = PBField.initUInt32(0);
  public final PBUInt32Field uint32_unowned_user = PBField.initUInt32(0);
  public final PBUInt32Field uint32_up_ident_info = PBField.initUInt32(0);
  public final PBUInt32Field uint32_upgc_account_info = PBField.initUInt32(0);
  public final PBUInt32Field uint32_upgc_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_user_identity_icon = PBField.initUInt32(0);
  public final PBUInt32Field uint32_user_tag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_user_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 240, 248, 256, 264, 272, 280, 288, 296, 304, 312, 320, 328, 336, 344, 352, 360, 368, 376, 384, 392, 400, 408, 416, 1600, 1608, 1616, 1624, 1640, 1648, 1656, 1664, 1672 }, new String[] { "uint32_nick", "uint32_head_url", "uint32_qq_nick", "uint32_friend_remark", "uint32_kandian_nick", "uint32_qq_head", "uint32_kandian_head", "uint32_share_nick", "uint32_share_head_url", "uint32_desc", "uint32_mp_auth", "uint32_user_type", "uint32_home_url", "uint32_account_sysid", "uint32_head_real_url", "uint32_gender", "uint32_account_cc_level", "uint32_unowned_user", "uint32_disable_comment_recommed", "uint32_live_status", "uint32_head_decoration", "uint32_content_account_info", "uint32_activity_level", "uint32_upgc_account_info", "uint32_publish_flag", "uint32_qb_name", "uint32_qb_head", "uint32_qb_desc", "uint32_user_identity_icon", "uint32_up_ident_info", "uint32_add_friend", "uint32_age", "uint32_constellation", "uint32_region", "uint32_edu_info", "uint32_user_tag", "uint32_bg_pic", "uint32_home_page_type", "uint32_openid", "uint32_upgc_flag", "uint32_bind_rel", "uint32_disable_bind", "uint32_disable_cache", "uint32_disable_qb", "uint32_secrecy" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger }, UserInfoOption.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.UserInfoOption
 * JD-Core Version:    0.7.0.1
 */