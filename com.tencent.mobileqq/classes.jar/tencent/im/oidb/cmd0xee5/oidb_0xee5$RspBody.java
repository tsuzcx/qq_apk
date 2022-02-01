package tencent.im.oidb.cmd0xee5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xee5$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_quest" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField<oidb_0xee5.QuestTimes> rpt_quest = PBField.initRepeatMessage(oidb_0xee5.QuestTimes.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xee5.oidb_0xee5.RspBody
 * JD-Core Version:    0.7.0.1
 */