package tencent.im.oidb.cmd0xf77;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xf77$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "community_list" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField<oidb_cmd0xf77.Community> community_list = PBField.initRepeatMessage(oidb_cmd0xf77.Community.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf77.oidb_cmd0xf77.RspBody
 * JD-Core Version:    0.7.0.1
 */