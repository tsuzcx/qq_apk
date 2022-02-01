package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StFeed;

public final class QQCirclePay$StPayRewardReq
  extends MessageMicro<StPayRewardReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public FeedCloudMeta.StFeed feed = new FeedCloudMeta.StFeed();
  public QQCirclePaybase.StGiftData giftData = new QQCirclePaybase.StGiftData();
  public final PBUInt64Field opTime = PBField.initUInt64(0L);
  public final PBInt64Field opTimeNs = PBField.initInt64(0L);
  public QQCirclePay.StPayRetryDetail retryDetail = new QQCirclePay.StPayRetryDetail();
  public final PBStringField toUID = PBField.initString("");
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 56 }, new String[] { "extInfo", "giftData", "toUID", "feed", "opTime", "retryDetail", "opTimeNs" }, new Object[] { null, null, "", null, localLong, null, localLong }, StPayRewardReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCirclePay.StPayRewardReq
 * JD-Core Version:    0.7.0.1
 */