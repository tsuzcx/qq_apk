package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleEnvHub$ExposeTipsReq
  extends MessageMicro<ExposeTipsReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "userId", "tipsId" }, new Object[] { "", Integer.valueOf(0) }, ExposeTipsReq.class);
  public final PBInt32Field tipsId = PBField.initInt32(0);
  public final PBStringField userId = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleEnvHub.ExposeTipsReq
 * JD-Core Version:    0.7.0.1
 */