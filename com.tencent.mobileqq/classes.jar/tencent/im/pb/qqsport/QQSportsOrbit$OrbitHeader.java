package tencent.im.pb.qqsport;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQSportsOrbit$OrbitHeader
  extends MessageMicro<OrbitHeader>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 45, 50, 56, 64, 72, 80 }, new String[] { "type", "startTime", "endTime", "totalTime", "distance", "kmRecords", "totalSteps", "platform", "source", "stepType" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Float.valueOf(0.0F), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, OrbitHeader.class);
  public final PBFloatField distance = PBField.initFloat(0.0F);
  public final PBInt32Field endTime = PBField.initInt32(0);
  public final PBRepeatMessageField<QQSportsOrbit.OrbitPacePoint> kmRecords = PBField.initRepeatMessage(QQSportsOrbit.OrbitPacePoint.class);
  public final PBInt32Field platform = PBField.initInt32(0);
  public final PBInt32Field source = PBField.initInt32(0);
  public final PBInt32Field startTime = PBField.initInt32(0);
  public final PBInt32Field stepType = PBField.initInt32(0);
  public final PBInt32Field totalSteps = PBField.initInt32(0);
  public final PBInt32Field totalTime = PBField.initInt32(0);
  public final PBInt32Field type = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.pb.qqsport.QQSportsOrbit.OrbitHeader
 * JD-Core Version:    0.7.0.1
 */