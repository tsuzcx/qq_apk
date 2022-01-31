package tencent.im.oidb.cmd0x89a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x89a$GroupGeoInfo
  extends MessageMicro<GroupGeoInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField string_geo_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_city_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_latitude = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_longtitude = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_poi_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40 }, new String[] { "uint32_city_id", "uint64_longtitude", "uint64_latitude", "string_geo_content", "uint64_poi_id" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro, Long.valueOf(0L) }, GroupGeoInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x89a.oidb_0x89a.GroupGeoInfo
 * JD-Core Version:    0.7.0.1
 */