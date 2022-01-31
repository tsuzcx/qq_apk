package tencent.im.oidb.cmd0x8f8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0x8f8$SubCmd20DelLiteMailIndexReq
  extends MessageMicro<SubCmd20DelLiteMailIndexReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_lite_mail_index" }, new Object[] { null }, SubCmd20DelLiteMailIndexReq.class);
  public final PBRepeatMessageField<oidb_0x8f8.LiteMailIndexInfo> rpt_msg_lite_mail_index = PBField.initRepeatMessage(oidb_0x8f8.LiteMailIndexInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f8.oidb_0x8f8.SubCmd20DelLiteMailIndexReq
 * JD-Core Version:    0.7.0.1
 */