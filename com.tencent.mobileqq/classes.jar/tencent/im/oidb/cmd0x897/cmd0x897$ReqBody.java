package tencent.im.oidb.cmd0x897;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class cmd0x897$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_grp_next_visitor" }, new Object[] { null }, ReqBody.class);
  public final PBRepeatMessageField<cmd0x897.GroupNextVisitor> rpt_msg_grp_next_visitor = PBField.initRepeatMessage(cmd0x897.GroupNextVisitor.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x897.cmd0x897.ReqBody
 * JD-Core Version:    0.7.0.1
 */