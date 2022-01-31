package tencent.im.oidb.cmd0xb81;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xb81$UserInfoItem
  extends MessageMicro<UserInfoItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public oidb_cmd0xb81.AccountLevelInfo account_level_info = new oidb_cmd0xb81.AccountLevelInfo();
  public oidb_cmd0xb81.BindRelationship bind_rel = new oidb_cmd0xb81.BindRelationship();
  public final PBBytesField bytes_desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_friend_remark = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_kandian_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_qq_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_share_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0xb81.AccountInfo msg_account_info = new oidb_cmd0xb81.AccountInfo();
  public oidb_cmd0xb81.HeadInfo msg_head_info = new oidb_cmd0xb81.HeadInfo();
  public oidb_cmd0xb81.HeadInfo msg_kandian_head = new oidb_cmd0xb81.HeadInfo();
  public oidb_cmd0xb81.HeadInfo msg_qq_head = new oidb_cmd0xb81.HeadInfo();
  public oidb_cmd0xb81.HeadInfo msg_share_head_url = new oidb_cmd0xb81.HeadInfo();
  public final PBStringField str_bg_pic = PBField.initString("");
  public final PBStringField string_home_url = PBField.initString("");
  public final PBUInt32Field uint32_account_sysid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_bg_pic_default = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_home_page_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_info_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mp_auth_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_upgc_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_user_type = PBField.initUInt32(0);
  public oidb_cmd0xb81.AppUserOpenID user_openid = new oidb_cmd0xb81.AppUserOpenID();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 96, 104, 114, 240, 248, 256, 266, 1602, 1608, 1616, 1626, 1632, 1642 }, new String[] { "msg_account_info", "bytes_nick", "msg_head_info", "bytes_qq_nick", "bytes_friend_remark", "bytes_kandian_nick", "msg_qq_head", "msg_kandian_head", "bytes_share_nick", "msg_share_head_url", "bytes_desc", "uint32_mp_auth_flag", "uint32_user_type", "string_home_url", "uint32_account_sysid", "uint32_info_type", "uint32_gender", "account_level_info", "str_bg_pic", "uint32_bg_pic_default", "uint32_home_page_type", "user_openid", "uint32_upgc_flag", "bind_rel" }, new Object[] { null, localByteStringMicro1, null, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, null, null, localByteStringMicro5, null, localByteStringMicro6, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, "", Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), null }, UserInfoItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.UserInfoItem
 * JD-Core Version:    0.7.0.1
 */