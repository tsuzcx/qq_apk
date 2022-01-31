package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQCircleFeedBase$StRecomReportInfo
  extends MessageMicro<StRecomReportInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "recomInfos" }, new Object[] { null }, StRecomReportInfo.class);
  public final PBRepeatMessageField<QQCircleFeedBase.StSingleRecomReportInfo> recomInfos = PBField.initRepeatMessage(QQCircleFeedBase.StSingleRecomReportInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StRecomReportInfo
 * JD-Core Version:    0.7.0.1
 */