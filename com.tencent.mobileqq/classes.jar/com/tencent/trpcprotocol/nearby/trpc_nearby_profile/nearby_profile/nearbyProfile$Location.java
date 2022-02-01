package com.tencent.trpcprotocol.nearby.trpc_nearby_profile.nearby_profile;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nearbyProfile$Location
  extends MessageMicro<Location>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField city = PBField.initString("");
  public final PBBytesField city_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field city_zone_id = PBField.initUInt32(0);
  public final PBStringField country = PBField.initString("");
  public final PBUInt64Field latitude = PBField.initUInt64(0L);
  public final PBUInt64Field longitude = PBField.initUInt64(0L);
  public final PBStringField province = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 56 }, new String[] { "country", "province", "city", "city_id", "city_zone_id", "latitude", "longitude" }, new Object[] { "", "", "", localByteStringMicro, Integer.valueOf(0), localLong, localLong }, Location.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.nearby.trpc_nearby_profile.nearby_profile.nearbyProfile.Location
 * JD-Core Version:    0.7.0.1
 */