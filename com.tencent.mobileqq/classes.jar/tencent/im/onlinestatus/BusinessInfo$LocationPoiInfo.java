package tencent.im.onlinestatus;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BusinessInfo$LocationPoiInfo
  extends MessageMicro<LocationPoiInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBDoubleField direction = PBField.initDouble(0.0D);
  public final PBUInt32Field flag = PBField.initUInt32(0);
  public final PBDoubleField latitude = PBField.initDouble(0.0D);
  public final PBDoubleField longitude = PBField.initDouble(0.0D);
  public final PBUInt64Field operatoruin = PBField.initUInt64(0L);
  public final PBBytesField poi_address = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField poi_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field update_time = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 17, 25, 33, 40, 50, 58, 64 }, new String[] { "operatoruin", "longitude", "latitude", "direction", "update_time", "poi_name", "poi_address", "flag" }, new Object[] { Long.valueOf(0L), Double.valueOf(0.0D), Double.valueOf(0.0D), Double.valueOf(0.0D), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, LocationPoiInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.onlinestatus.BusinessInfo.LocationPoiInfo
 * JD-Core Version:    0.7.0.1
 */