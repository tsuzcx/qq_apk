package tencent.im.lbs;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class member_lbs$MemsDistance
  extends MessageMicro<MemsDistance>
{
  public static final int INT64_DISTANCE_FIELD_NUMBER = 2;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_uin", "int64_distance" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, MemsDistance.class);
  public final PBInt64Field int64_distance = PBField.initInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.lbs.member_lbs.MemsDistance
 * JD-Core Version:    0.7.0.1
 */