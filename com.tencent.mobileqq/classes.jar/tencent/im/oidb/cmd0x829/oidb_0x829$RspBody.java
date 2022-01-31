package tencent.im.oidb.cmd0x829;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0x829$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_add_frd_info" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField rpt_add_frd_info = PBField.initRepeatMessage(oidb_0x829.AddFrdInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x829.oidb_0x829.RspBody
 * JD-Core Version:    0.7.0.1
 */