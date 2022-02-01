package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;

public final class QQCircleBill$StBillDetail
  extends MessageMicro<StBillDetail>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField billid = PBField.initString("");
  public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
  public FeedCloudMeta.StFeed feed = new FeedCloudMeta.StFeed();
  public QQCirclePaybase.StGiftData giftData = new QQCirclePaybase.StGiftData();
  public final PBUInt64Field opTime = PBField.initUInt64(0L);
  public FeedCloudMeta.StUser opUser = new FeedCloudMeta.StUser();
  public final PBUInt32Field payMoney = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 50, 58 }, new String[] { "billid", "opUser", "opTime", "giftData", "payMoney", "feed", "busiData" }, new Object[] { "", null, Long.valueOf(0L), null, Integer.valueOf(0), null, localByteStringMicro }, StBillDetail.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleBill.StBillDetail
 * JD-Core Version:    0.7.0.1
 */