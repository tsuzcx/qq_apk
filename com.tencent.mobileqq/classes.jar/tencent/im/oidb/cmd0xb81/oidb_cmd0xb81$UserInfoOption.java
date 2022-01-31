package tencent.im.oidb.cmd0xb81;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xb81$UserInfoOption
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_nick", "uint32_head_url" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, UserInfoOption.class);
  public final PBUInt32Field uint32_head_url = PBField.initUInt32(0);
  public final PBUInt32Field uint32_nick = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.UserInfoOption
 * JD-Core Version:    0.7.0.1
 */