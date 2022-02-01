package tencent.im.oidb.location;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qq_lbs_share$AssemblyPointData
  extends MessageMicro<AssemblyPointData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBDoubleField lat = PBField.initDouble(0.0D);
  public final PBDoubleField lon = PBField.initDouble(0.0D);
  public final PBEnumField operation = PBField.initEnum(1);
  public final PBUInt64Field operator = PBField.initUInt64(0L);
  public final PBBytesField poi_address = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField poi_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field update_ts = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 25, 33, 40, 50, 58 }, new String[] { "operator", "operation", "lon", "lat", "update_ts", "poi_name", "poi_address" }, new Object[] { Long.valueOf(0L), Integer.valueOf(1), Double.valueOf(0.0D), Double.valueOf(0.0D), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, AssemblyPointData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.location.qq_lbs_share.AssemblyPointData
 * JD-Core Version:    0.7.0.1
 */