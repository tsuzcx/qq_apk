package tencent.im.pb.qqsport;

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
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 9, 17, 25, 32, 45, 53, 61, 69, 72, 80, 93, 96 }, new String[] { "speed", "latitude", "longitude", "time", "latitudef", "longitudef", "timef", "speedf", "accuracy", "step", "altitude", "millisecond" }, new Object[] { Double.valueOf(0.0D), Double.valueOf(0.0D), Double.valueOf(0.0D), Integer.valueOf(0), Float.valueOf(0.0F), Float.valueOf(0.0F), Integer.valueOf(0), Float.valueOf(0.0F), Integer.valueOf(0), Integer.valueOf(0), Float.valueOf(0.0F), Integer.valueOf(0) }, OrbitPoint.class);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.pb.qqsport.QQSportsOrbit.OrbitPoint
 * JD-Core Version:    0.7.0.1
 */