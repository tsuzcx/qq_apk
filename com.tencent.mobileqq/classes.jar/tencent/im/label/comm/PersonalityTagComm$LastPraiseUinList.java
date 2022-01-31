package tencent.im.label.comm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class PersonalityTagComm$LastPraiseUinList
  extends MessageMicro<LastPraiseUinList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_uin2time" }, new Object[] { null }, LastPraiseUinList.class);
  public final PBRepeatMessageField<PersonalityTagComm.Uin2Time> rpt_uin2time = PBField.initRepeatMessage(PersonalityTagComm.Uin2Time.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.label.comm.PersonalityTagComm.LastPraiseUinList
 * JD-Core Version:    0.7.0.1
 */