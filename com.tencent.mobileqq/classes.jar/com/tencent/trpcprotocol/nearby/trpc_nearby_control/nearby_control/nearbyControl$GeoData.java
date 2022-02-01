package com.tencent.trpcprotocol.nearby.trpc_nearby_control.nearby_control;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearbyControl$GeoData
  extends MessageMicro<GeoData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field coordinate = PBField.initUInt32(0);
  public final PBDoubleField latitude = PBField.initDouble(0.0D);
  public final PBDoubleField longitude = PBField.initDouble(0.0D);
  
  static
  {
    Double localDouble = Double.valueOf(0.0D);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 9, 17, 24 }, new String[] { "longitude", "latitude", "coordinate" }, new Object[] { localDouble, localDouble, Integer.valueOf(0) }, GeoData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.nearby.trpc_nearby_control.nearby_control.nearbyControl.GeoData
 * JD-Core Version:    0.7.0.1
 */