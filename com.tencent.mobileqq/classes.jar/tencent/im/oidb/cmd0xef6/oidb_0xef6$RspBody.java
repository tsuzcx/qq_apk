package tencent.im.oidb.cmd0xef6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xef6$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "idol_list" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField<oidb_0xef6.IdolInfo> idol_list = PBField.initRepeatMessage(oidb_0xef6.IdolInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xef6.oidb_0xef6.RspBody
 * JD-Core Version:    0.7.0.1
 */