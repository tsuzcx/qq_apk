package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleCenter$GetCircleDetailReq
  extends MessageMicro<GetCircleDetailReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "id" }, new Object[] { "" }, GetCircleDetailReq.class);
  public final PBStringField id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleCenter.GetCircleDetailReq
 * JD-Core Version:    0.7.0.1
 */