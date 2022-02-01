package tencent.im.oidb.cmd0xb86;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_cmd0xb86$UserInfoModifyFlag
  extends MessageMicro<UserInfoModifyFlag>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "msg_nick_flag", "msg_head_flag", "msg_desc_flag", "msg_bg_pic_flag" }, new Object[] { null, null, null, null }, UserInfoModifyFlag.class);
  public oidb_cmd0xb86.ModifyInfoFlag msg_bg_pic_flag = new oidb_cmd0xb86.ModifyInfoFlag();
  public oidb_cmd0xb86.ModifyInfoFlag msg_desc_flag = new oidb_cmd0xb86.ModifyInfoFlag();
  public oidb_cmd0xb86.ModifyInfoFlag msg_head_flag = new oidb_cmd0xb86.ModifyInfoFlag();
  public oidb_cmd0xb86.ModifyInfoFlag msg_nick_flag = new oidb_cmd0xb86.ModifyInfoFlag();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb86.oidb_cmd0xb86.UserInfoModifyFlag
 * JD-Core Version:    0.7.0.1
 */