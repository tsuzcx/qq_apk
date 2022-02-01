package tencent.im.mutualmark;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mutualmark$MutualActionDay
  extends MessageMicro<MutualActionDay>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field uint64_day = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_type = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_type", "uint64_day", "uint64_time" }, new Object[] { localLong, localLong, localLong }, MutualActionDay.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.mutualmark.mutualmark.MutualActionDay
 * JD-Core Version:    0.7.0.1
 */