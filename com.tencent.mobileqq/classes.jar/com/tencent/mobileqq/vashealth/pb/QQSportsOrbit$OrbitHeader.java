package com.tencent.mobileqq.vashealth.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQSportsOrbit$OrbitHeader
  extends MessageMicro<OrbitHeader>
{
  static final MessageMicro.FieldMap __fieldMap__;
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
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 45, 50, 56, 64, 72, 80 }, new String[] { "type", "startTime", "endTime", "totalTime", "distance", "kmRecords", "totalSteps", "platform", "source", "stepType" }, new Object[] { localInteger, localInteger, localInteger, localInteger, Float.valueOf(0.0F), null, localInteger, localInteger, localInteger, localInteger }, OrbitHeader.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.pb.QQSportsOrbit.OrbitHeader
 * JD-Core Version:    0.7.0.1
 */