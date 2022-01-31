package com.tencent.mobileqq.troop.org.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xac5$NowHaiWanStorage
  extends MessageMicro<NowHaiWanStorage>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_haiwan_record" }, new Object[] { null }, NowHaiWanStorage.class);
  public final PBRepeatMessageField<oidb_0xac5.HaiWanRecord> rpt_msg_haiwan_record = PBField.initRepeatMessage(oidb_0xac5.HaiWanRecord.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.org.pb.oidb_0xac5.NowHaiWanStorage
 * JD-Core Version:    0.7.0.1
 */