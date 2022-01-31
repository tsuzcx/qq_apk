package tencent.im.s2c.msgtype0x210.submsgtype0xe5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Submsgtype0xe5$MsgBody$S2CCallRecordChangePush
  extends MessageMicro<S2CCallRecordChangePush>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 17 }, new String[] { "uint64_kfext", "fixed64_timestamp" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, S2CCallRecordChangePush.class);
  public final PBFixed64Field fixed64_timestamp = PBField.initFixed64(0L);
  public final PBUInt64Field uint64_kfext = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xe5.Submsgtype0xe5.MsgBody.S2CCallRecordChangePush
 * JD-Core Version:    0.7.0.1
 */