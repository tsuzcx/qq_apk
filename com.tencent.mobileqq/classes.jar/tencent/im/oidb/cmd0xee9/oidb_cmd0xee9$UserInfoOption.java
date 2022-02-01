package tencent.im.oidb.cmd0xee9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xee9$UserInfoOption
  extends MessageMicro<UserInfoOption>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_live_status" }, new Object[] { Integer.valueOf(0) }, UserInfoOption.class);
  public final PBUInt32Field uint32_live_status = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xee9.oidb_cmd0xee9.UserInfoOption
 * JD-Core Version:    0.7.0.1
 */