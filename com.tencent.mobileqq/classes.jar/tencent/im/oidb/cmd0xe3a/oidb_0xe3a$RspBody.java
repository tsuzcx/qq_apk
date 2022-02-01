package tencent.im.oidb.cmd0xe3a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe3a$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_next_time_for_aio_report" }, new Object[] { Long.valueOf(0L) }, RspBody.class);
  public final PBUInt64Field uint64_next_time_for_aio_report = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe3a.oidb_0xe3a.RspBody
 * JD-Core Version:    0.7.0.1
 */