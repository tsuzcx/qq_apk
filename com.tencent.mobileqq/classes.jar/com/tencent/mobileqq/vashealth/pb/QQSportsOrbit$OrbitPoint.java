package com.tencent.mobileqq.vashealth.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class QQSportsOrbit$OrbitPoint
  extends MessageMicro<OrbitPoint>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field accuracy = PBField.initInt32(0);
  public final PBFloatField altitude = PBField.initFloat(0.0F);
  public final PBDoubleField latitude = PBField.initDouble(0.0D);
  public final PBFloatField latitudef = PBField.initFloat(0.0F);
  public final PBDoubleField longitude = PBField.initDouble(0.0D);
  public final PBFloatField longitudef = PBField.initFloat(0.0F);
  public final PBInt32Field millisecond = PBField.initInt32(0);
  public final PBDoubleField speed = PBField.initDouble(0.0D);
  public final PBFloatField speedf = PBField.initFloat(0.0F);
  public final PBInt32Field step = PBField.initInt32(0);
  public final PBInt32Field time = PBField.initInt32(0);
  public final PBFixed32Field timef = PBField.initFixed32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Double localDouble = Double.valueOf(0.0D);
    Float localFloat = Float.valueOf(0.0F);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 9, 17, 25, 32, 45, 53, 61, 69, 72, 80, 93, 96 }, new String[] { "speed", "latitude", "longitude", "time", "latitudef", "longitudef", "timef", "speedf", "accuracy", "step", "altitude", "millisecond" }, new Object[] { localDouble, localDouble, localDouble, localInteger, localFloat, localFloat, localInteger, localFloat, localInteger, localInteger, localFloat, localInteger }, OrbitPoint.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.pb.QQSportsOrbit.OrbitPoint
 * JD-Core Version:    0.7.0.1
 */