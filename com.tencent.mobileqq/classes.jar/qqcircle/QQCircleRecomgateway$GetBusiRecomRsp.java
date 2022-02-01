package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleRecomgateway$GetBusiRecomRsp
  extends MessageMicro<GetBusiRecomRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "recomInfo", "attachInfo" }, new Object[] { null, "" }, GetBusiRecomRsp.class);
  public final PBStringField attachInfo = PBField.initString("");
  public final PBRepeatMessageField<QQCircleDitto.RecomFeedsInfo> recomInfo = PBField.initRepeatMessage(QQCircleDitto.RecomFeedsInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleRecomgateway.GetBusiRecomRsp
 * JD-Core Version:    0.7.0.1
 */