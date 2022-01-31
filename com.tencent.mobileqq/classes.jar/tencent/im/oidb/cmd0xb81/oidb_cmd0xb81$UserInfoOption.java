package tencent.im.oidb.cmd0xb81;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xb81$UserInfoOption
  extends MessageMicro<UserInfoOption>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 240, 248, 256, 264, 1600, 1608, 1616, 1624, 1640 }, new String[] { "uint32_nick", "uint32_head_url", "uint32_qq_nick", "uint32_friend_remark", "uint32_kandian_nick", "uint32_qq_head", "uint32_kandian_head", "uint32_share_nick", "uint32_share_head_url", "uint32_desc", "uint32_mp_auth", "uint32_user_type", "uint32_home_url", "uint32_account_sysid", "uint32_head_real_url", "uint32_gender", "uint32_account_cc_level", "uint32_bg_pic", "uint32_home_page_type", "uint32_openid", "uint32_upgc_flag", "uint32_bind_rel" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, UserInfoOption.class);
  public final PBUInt32Field uint32_account_cc_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_account_sysid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_bg_pic = PBField.initUInt32(0);
  public final PBUInt32Field uint32_bind_rel = PBField.initUInt32(0);
  public final PBUInt32Field uint32_desc = PBField.initUInt32(0);
  public final PBUInt32Field uint32_friend_remark = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_head_real_url = PBField.initUInt32(0);
  public final PBUInt32Field uint32_head_url = PBField.initUInt32(0);
  public final PBUInt32Field uint32_home_page_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_home_url = PBField.initUInt32(0);
  public final PBUInt32Field uint32_kandian_head = PBField.initUInt32(0);
  public final PBUInt32Field uint32_kandian_nick = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mp_auth = PBField.initUInt32(0);
  public final PBUInt32Field uint32_nick = PBField.initUInt32(0);
  public final PBUInt32Field uint32_openid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_qq_head = PBField.initUInt32(0);
  public final PBUInt32Field uint32_qq_nick = PBField.initUInt32(0);
  public final PBUInt32Field uint32_share_head_url = PBField.initUInt32(0);
  public final PBUInt32Field uint32_share_nick = PBField.initUInt32(0);
  public final PBUInt32Field uint32_upgc_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_user_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.UserInfoOption
 * JD-Core Version:    0.7.0.1
 */