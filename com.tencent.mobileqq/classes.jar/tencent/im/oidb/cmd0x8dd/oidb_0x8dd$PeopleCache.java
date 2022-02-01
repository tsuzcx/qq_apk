package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0x8dd$PeopleCache
  extends MessageMicro<PeopleCache>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_people" }, new Object[] { null }, PeopleCache.class);
  public final PBRepeatMessageField<oidb_0x8dd.NearbyPeople> rpt_msg_people = PBField.initRepeatMessage(oidb_0x8dd.NearbyPeople.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8dd.oidb_0x8dd.PeopleCache
 * JD-Core Version:    0.7.0.1
 */