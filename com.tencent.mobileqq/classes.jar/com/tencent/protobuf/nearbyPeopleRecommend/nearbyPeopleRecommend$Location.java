package com.tencent.protobuf.nearbyPeopleRecommend;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class nearbyPeopleRecommend$Location
  extends MessageMicro<Location>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int32_coordinate = PBField.initInt32(0);
  public final PBInt32Field int32_latitude = PBField.initInt32(0);
  public final PBInt32Field int32_longitude = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "int32_latitude", "int32_longitude", "int32_coordinate" }, new Object[] { localInteger, localInteger, localInteger }, Location.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protobuf.nearbyPeopleRecommend.nearbyPeopleRecommend.Location
 * JD-Core Version:    0.7.0.1
 */