package tencent.im.lbs;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class member_lbs$NeighbourInfo
  extends MessageMicro<NeighbourInfo>
{
  public static final int DOUBLE_DISTANCE_FIELD_NUMBER = 4;
  public static final int INT64_LATITUDE_FIELD_NUMBER = 2;
  public static final int INT64_LONGITUDE_FIELD_NUMBER = 3;
  public static final int STR_NICK_FIELD_NUMBER = 7;
  public static final int UINT32_AGE_FIELD_NUMBER = 6;
  public static final int UINT32_SEX_FIELD_NUMBER = 5;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBDoubleField double_distance = PBField.initDouble(0.0D);
  public final PBInt64Field int64_latitude = PBField.initInt64(0L);
  public final PBInt64Field int64_longitude = PBField.initInt64(0L);
  public final PBBytesField str_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sex = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 33, 40, 48, 58 }, new String[] { "uint64_uin", "int64_latitude", "int64_longitude", "double_distance", "uint32_sex", "uint32_age", "str_nick" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Double.valueOf(0.0D), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, NeighbourInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.lbs.member_lbs.NeighbourInfo
 * JD-Core Version:    0.7.0.1
 */