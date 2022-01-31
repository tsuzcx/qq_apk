package tencent.intimate_relation;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class intimate_relation$SnsRelationInfo
  extends MessageMicro<SnsRelationInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "intimate_list" }, new Object[] { null }, SnsRelationInfo.class);
  public final PBRepeatMessageField<intimate_relation.IntimateInfo> intimate_list = PBField.initRepeatMessage(intimate_relation.IntimateInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.intimate_relation.intimate_relation.SnsRelationInfo
 * JD-Core Version:    0.7.0.1
 */