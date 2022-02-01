package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQCircleRelation$BatchVerifyRelationReq
  extends MessageMicro<BatchVerifyRelationReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uins", "followMethod" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, BatchVerifyRelationReq.class);
  public final PBUInt32Field followMethod = PBField.initUInt32(0);
  public final PBRepeatField<Long> uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleRelation.BatchVerifyRelationReq
 * JD-Core Version:    0.7.0.1
 */