package tencent.im.oidb.cmd0xb86;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_cmd0xb86$UserInfoDetail
  extends MessageMicro<UserInfoDetail>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "nick", "head", "desc", "bg_pic" }, new Object[] { null, null, null, null }, UserInfoDetail.class);
  public oidb_cmd0xb86.BgPicInfo bg_pic = new oidb_cmd0xb86.BgPicInfo();
  public oidb_cmd0xb86.DescInfo desc = new oidb_cmd0xb86.DescInfo();
  public oidb_cmd0xb86.HeadInfo head = new oidb_cmd0xb86.HeadInfo();
  public oidb_cmd0xb86.NickInfo nick = new oidb_cmd0xb86.NickInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb86.oidb_cmd0xb86.UserInfoDetail
 * JD-Core Version:    0.7.0.1
 */