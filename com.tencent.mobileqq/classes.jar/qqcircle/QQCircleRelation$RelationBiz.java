package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQCircleRelation$RelationBiz
  extends MessageMicro<RelationBiz>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field certification = PBField.initInt32(0);
  public final PBStringField logo = PBField.initString("");
  public final PBStringField nick = PBField.initString("");
  public final PBInt32Field qqRelation = PBField.initInt32(0);
  public final PBStringField sign = PBField.initString("");
  public final PBUInt64Field timestamp = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50 }, new String[] { "timestamp", "nick", "sign", "qqRelation", "certification", "logo" }, new Object[] { Long.valueOf(0L), "", "", localInteger, localInteger, "" }, RelationBiz.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleRelation.RelationBiz
 * JD-Core Version:    0.7.0.1
 */