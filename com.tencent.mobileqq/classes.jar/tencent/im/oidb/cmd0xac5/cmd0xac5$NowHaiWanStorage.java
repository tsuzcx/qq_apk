package tencent.im.oidb.cmd0xac5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class cmd0xac5$NowHaiWanStorage
  extends MessageMicro<NowHaiWanStorage>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_haiwan_record" }, new Object[] { null }, NowHaiWanStorage.class);
  public final PBRepeatMessageField<cmd0xac5.HaiWanRecord> rpt_msg_haiwan_record = PBField.initRepeatMessage(cmd0xac5.HaiWanRecord.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xac5.cmd0xac5.NowHaiWanStorage
 * JD-Core Version:    0.7.0.1
 */