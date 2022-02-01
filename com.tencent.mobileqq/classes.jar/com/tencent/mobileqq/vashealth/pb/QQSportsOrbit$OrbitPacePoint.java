package com.tencent.mobileqq.vashealth.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class QQSportsOrbit$OrbitPacePoint
  extends MessageMicro<OrbitPacePoint>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field km = PBField.initInt32(0);
  public final PBDoubleField latitude = PBField.initDouble(0.0D);
  public final PBDoubleField longitude = PBField.initDouble(0.0D);
  public final PBInt32Field time = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Double localDouble = Double.valueOf(0.0D);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 25, 33 }, new String[] { "km", "time", "latitude", "longitude" }, new Object[] { localInteger, localInteger, localDouble, localDouble }, OrbitPacePoint.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.pb.QQSportsOrbit.OrbitPacePoint
 * JD-Core Version:    0.7.0.1
 */