package tencent.im.oidb.cmd0xb86;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb86$UserInfo
  extends MessageMicro<UserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_3t_bid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0xb86.UserInfoDetail info_detail = new oidb_cmd0xb86.UserInfoDetail();
  public oidb_cmd0xb86.ExamineUserInfo msg_examine_userinfo = new oidb_cmd0xb86.ExamineUserInfo();
  public oidb_cmd0xb86.HeadInfo msg_head = new oidb_cmd0xb86.HeadInfo();
  public final PBUInt32Field uint32_cc_account_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_disable_comment_recommed = PBField.initUInt32(0);
  public final PBUInt32Field uint32_home_page_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mp_auth = PBField.initUInt32(0);
  public final PBUInt32Field uint32_unowned_user = PBField.initUInt32(0);
  public final PBUInt32Field uint32_upgc_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_user_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_bind_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_id_create_time = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 56, 66, 72, 96, 106, 122, 128, 136, 1624 }, new String[] { "bytes_nick", "msg_head", "bytes_desc", "uint64_bind_uin", "uint32_user_type", "uint32_mp_auth", "uint64_id_create_time", "bytes_3t_bid", "uint32_home_page_type", "uint32_cc_account_level", "msg_examine_userinfo", "info_detail", "uint32_unowned_user", "uint32_disable_comment_recommed", "uint32_upgc_flag" }, new Object[] { localByteStringMicro1, null, localByteStringMicro2, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, UserInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb86.oidb_cmd0xb86.UserInfo
 * JD-Core Version:    0.7.0.1
 */