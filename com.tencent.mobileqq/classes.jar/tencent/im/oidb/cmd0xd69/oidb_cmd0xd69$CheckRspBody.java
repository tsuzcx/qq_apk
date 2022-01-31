package tencent.im.oidb.cmd0xd69;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xd69$CheckRspBody
  extends MessageMicro<CheckRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "is_exsit" }, new Object[] { Integer.valueOf(0) }, CheckRspBody.class);
  public final PBUInt32Field is_exsit = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd69.oidb_cmd0xd69.CheckRspBody
 * JD-Core Version:    0.7.0.1
 */