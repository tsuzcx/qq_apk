package tencent.im.oidb.cmd0x592;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.trunk.Qworkflow.Qworkflow.Timespan;

public final class oidb_0x592$RepeatedScheduleShareInfo
  extends MessageMicro<RepeatedScheduleShareInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_schedule_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<Qworkflow.Timespan> rpt_msg_share_timespan = PBField.initRepeatMessage(Qworkflow.Timespan.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_schedule_id", "rpt_msg_share_timespan" }, new Object[] { localByteStringMicro, null }, RepeatedScheduleShareInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x592.oidb_0x592.RepeatedScheduleShareInfo
 * JD-Core Version:    0.7.0.1
 */