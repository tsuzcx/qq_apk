package pttcenterservice;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PttShortVideo$DataHole
  extends MessageMicro<DataHole>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_begin", "uint64_end" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, DataHole.class);
  public final PBUInt64Field uint64_begin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_end = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     pttcenterservice.PttShortVideo.DataHole
 * JD-Core Version:    0.7.0.1
 */