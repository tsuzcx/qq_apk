package tencent.im.oidb.cmd0x438;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0x438$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "PasswdRedBag" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField<oidb_0x438.RedBagInfo> PasswdRedBag = PBField.initRepeatMessage(oidb_0x438.RedBagInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x438.oidb_0x438.RspBody
 * JD-Core Version:    0.7.0.1
 */