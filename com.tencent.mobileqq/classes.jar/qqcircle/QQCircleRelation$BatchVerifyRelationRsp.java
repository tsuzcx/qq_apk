package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQCircleRelation$BatchVerifyRelationRsp
  extends MessageMicro<BatchVerifyRelationRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "infos" }, new Object[] { null }, BatchVerifyRelationRsp.class);
  public final PBRepeatMessageField<QQCircleRelation.RelationInfo> infos = PBField.initRepeatMessage(QQCircleRelation.RelationInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleRelation.BatchVerifyRelationRsp
 * JD-Core Version:    0.7.0.1
 */