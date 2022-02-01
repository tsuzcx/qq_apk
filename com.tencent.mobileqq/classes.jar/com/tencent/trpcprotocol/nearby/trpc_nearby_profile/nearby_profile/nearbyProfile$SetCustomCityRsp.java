package com.tencent.trpcprotocol.nearby.trpc_nearby_profile.nearby_profile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nearbyProfile$SetCustomCityRsp
  extends MessageMicro<SetCustomCityRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field city_code = PBField.initUInt32(0);
  public final PBUInt64Field latitude = PBField.initUInt64(0L);
  public final PBUInt32Field left_cnt = PBField.initUInt32(0);
  public final PBUInt64Field longitude = PBField.initUInt64(0L);
  public final PBUInt32Field ret_code = PBField.initUInt32(0);
  public final PBStringField ret_msg = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48 }, new String[] { "ret_code", "ret_msg", "left_cnt", "city_code", "latitude", "longitude" }, new Object[] { localInteger, "", localInteger, localInteger, localLong, localLong }, SetCustomCityRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.nearby.trpc_nearby_profile.nearby_profile.nearbyProfile.SetCustomCityRsp
 * JD-Core Version:    0.7.0.1
 */