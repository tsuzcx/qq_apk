package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCirclePay$StPayBuyRsp
  extends MessageMicro<StPayBuyRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "payComm", "myFuelMoney" }, new Object[] { null, null, Long.valueOf(0L) }, StPayBuyRsp.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBInt64Field myFuelMoney = PBField.initInt64(0L);
  public QQCirclePay.StPayComm payComm = new QQCirclePay.StPayComm();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCirclePay.StPayBuyRsp
 * JD-Core Version:    0.7.0.1
 */