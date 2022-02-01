package tencent.im.oidb.cmd0xb86;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb86$SystemUserInfo
  extends MessageMicro<SystemUserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_3t_bid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_platfrom_ext = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0xb86.BindUser msg_bind_user = new oidb_cmd0xb86.BindUser();
  public oidb_cmd0xb86.AppUserOpenID msg_openid = new oidb_cmd0xb86.AppUserOpenID();
  public final PBUInt32Field uint32_account_sysid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cc_account_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_home_page_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mp_auth = PBField.initUInt32(0);
  public final PBUInt32Field uint32_unowned_user = PBField.initUInt32(0);
  public final PBUInt32Field uint32_upgc_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_user_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_id_create_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_registered_type = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 56, 66, 74, 80, 88, 96, 104, 1624 }, new String[] { "uint32_user_type", "uint32_mp_auth", "uint64_id_create_time", "bytes_3t_bid", "msg_bind_user", "uint64_registered_type", "bytes_platfrom_ext", "msg_openid", "uint32_home_page_type", "uint32_account_sysid", "uint32_cc_account_level", "uint32_unowned_user", "uint32_upgc_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, null, Long.valueOf(0L), localByteStringMicro2, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SystemUserInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb86.oidb_cmd0xb86.SystemUserInfo
 * JD-Core Version:    0.7.0.1
 */