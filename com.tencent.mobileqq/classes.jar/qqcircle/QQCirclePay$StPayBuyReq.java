package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCirclePay$StPayBuyReq
  extends MessageMicro<StPayBuyReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public QQCirclePaybase.StGiftData giftData = new QQCirclePaybase.StGiftData();
  public final PBUInt64Field opTime = PBField.initUInt64(0L);
  public final PBInt64Field opTimeNs = PBField.initInt64(0L);
  public QQCirclePay.StPayRetryDetail retryDetail = new QQCirclePay.StPayRetryDetail();
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40 }, new String[] { "extInfo", "giftData", "opTime", "retryDetail", "opTimeNs" }, new Object[] { null, null, localLong, null, localLong }, StPayBuyReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCirclePay.StPayBuyReq
 * JD-Core Version:    0.7.0.1
 */