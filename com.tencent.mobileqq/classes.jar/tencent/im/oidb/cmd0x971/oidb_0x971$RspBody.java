package tencent.im.oidb.cmd0x971;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0x971$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "notices" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField notices = PBField.initRepeatMessage(oidb_0x971.NoticeInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x971.oidb_0x971.RspBody
 * JD-Core Version:    0.7.0.1
 */