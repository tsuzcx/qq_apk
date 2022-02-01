package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class QQCircleFeedBase$StVideoBusiData
  extends MessageMicro<StVideoBusiData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "simulate_date", "kuolie_data" }, new Object[] { null, null }, StVideoBusiData.class);
  public QQCircleFeedBase.StKuoliePasterData kuolie_data = new QQCircleFeedBase.StKuoliePasterData();
  public QQCircleFeedBase.StSimulateData simulate_date = new QQCircleFeedBase.StSimulateData();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StVideoBusiData
 * JD-Core Version:    0.7.0.1
 */