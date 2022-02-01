package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleSwitch$GetCircleTabBucketRsp
  extends MessageMicro<GetCircleTabBucketRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "sws", "isNewRegUid", "expId", "circleLayoutType" }, new Object[] { null, Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(1) }, GetCircleTabBucketRsp.class);
  public final PBEnumField circleLayoutType = PBField.initEnum(1);
  public final PBUInt32Field expId = PBField.initUInt32(0);
  public final PBBoolField isNewRegUid = PBField.initBool(false);
  public final PBRepeatMessageField<QQCircleSwitch.StSwitch> sws = PBField.initRepeatMessage(QQCircleSwitch.StSwitch.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleSwitch.GetCircleTabBucketRsp
 * JD-Core Version:    0.7.0.1
 */