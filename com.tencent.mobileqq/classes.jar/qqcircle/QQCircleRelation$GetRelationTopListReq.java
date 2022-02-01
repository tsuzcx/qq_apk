package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class QQCircleRelation$GetRelationTopListReq
  extends MessageMicro<GetRelationTopListReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field needCount = PBField.initInt32(0);
  public final PBInt32Field num = PBField.initInt32(0);
  public final PBInt32Field page = PBField.initInt32(0);
  public final PBInt32Field relType = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "num", "relType", "needCount", "page" }, new Object[] { localInteger, localInteger, localInteger, localInteger }, GetRelationTopListReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleRelation.GetRelationTopListReq
 * JD-Core Version:    0.7.0.1
 */