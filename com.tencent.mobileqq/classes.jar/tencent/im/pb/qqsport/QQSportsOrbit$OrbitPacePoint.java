package tencent.im.pb.qqsport;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class QQSportsOrbit$OrbitPacePoint
  extends MessageMicro<OrbitPacePoint>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 25, 33 }, new String[] { "km", "time", "latitude", "longitude" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Double.valueOf(0.0D), Double.valueOf(0.0D) }, OrbitPacePoint.class);
  public final PBInt32Field km = PBField.initInt32(0);
  public final PBDoubleField latitude = PBField.initDouble(0.0D);
  public final PBDoubleField longitude = PBField.initDouble(0.0D);
  public final PBInt32Field time = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.pb.qqsport.QQSportsOrbit.OrbitPacePoint
 * JD-Core Version:    0.7.0.1
 */