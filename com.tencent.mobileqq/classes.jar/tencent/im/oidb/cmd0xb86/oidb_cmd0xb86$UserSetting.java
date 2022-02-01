package tencent.im.oidb.cmd0xb86;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xb86$UserSetting
  extends MessageMicro<UserSetting>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 56 }, new String[] { "uint32_disable_comment_recommed" }, new Object[] { Integer.valueOf(0) }, UserSetting.class);
  public final PBUInt32Field uint32_disable_comment_recommed = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb86.oidb_cmd0xb86.UserSetting
 * JD-Core Version:    0.7.0.1
 */