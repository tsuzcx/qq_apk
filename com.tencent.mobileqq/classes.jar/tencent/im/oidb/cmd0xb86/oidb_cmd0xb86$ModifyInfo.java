package tencent.im.oidb.cmd0xb86;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_cmd0xb86$ModifyInfo
  extends MessageMicro<ModifyInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField modify_token = PBField.initString("");
  public oidb_cmd0xb86.HeadInfo msg_head = new oidb_cmd0xb86.HeadInfo();
  public oidb_cmd0xb86.UserSetting msg_setting = new oidb_cmd0xb86.UserSetting();
  public oidb_cmd0xb86.SystemUserInfo msg_sys_info = new oidb_cmd0xb86.SystemUserInfo();
  public final PBStringField str_bg_pic = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 106, 114, 122 }, new String[] { "bytes_nick", "msg_head", "bytes_desc", "str_bg_pic", "msg_sys_info", "msg_setting", "modify_token" }, new Object[] { localByteStringMicro1, null, localByteStringMicro2, "", null, null, "" }, ModifyInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb86.oidb_cmd0xb86.ModifyInfo
 * JD-Core Version:    0.7.0.1
 */