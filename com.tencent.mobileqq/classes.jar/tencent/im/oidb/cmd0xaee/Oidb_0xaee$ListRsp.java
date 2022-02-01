package tencent.im.oidb.cmd0xaee;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class Oidb_0xaee$ListRsp
  extends MessageMicro<ListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_template" }, new Object[] { null }, ListRsp.class);
  public final PBRepeatMessageField<Oidb_0xaee.Template> rpt_template = PBField.initRepeatMessage(Oidb_0xaee.Template.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xaee.Oidb_0xaee.ListRsp
 * JD-Core Version:    0.7.0.1
 */