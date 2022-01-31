package tencent.im.lbs;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class member_lbs$NeighbourNumber
  extends MessageMicro<NeighbourNumber>
{
  public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 1;
  public static final int UINT64_LOCATED_NUMBER_FIELD_NUMBER = 3;
  public static final int UINT64_NEIGHBOUR_NUMBER_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_group_code", "uint64_neighbour_number", "uint64_located_number" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, NeighbourNumber.class);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_located_number = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_neighbour_number = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.lbs.member_lbs.NeighbourNumber
 * JD-Core Version:    0.7.0.1
 */