package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StFeed;

public final class QQCircleBillstore$StBillStoreData
  extends MessageMicro<StBillStoreData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field billType = PBField.initUInt32(0);
  public final PBStringField billid = PBField.initString("");
  public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
  public FeedCloudMeta.StFeed feed = new FeedCloudMeta.StFeed();
  public QQCirclePaybase.StGiftData giftData = new QQCirclePaybase.StGiftData();
  public final PBUInt32Field payMoney = PBField.initUInt32(0);
  public final PBStringField toUID = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58 }, new String[] { "billType", "billid", "giftData", "payMoney", "toUID", "feed", "busiData" }, new Object[] { localInteger, "", null, localInteger, "", null, localByteStringMicro }, StBillStoreData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleBillstore.StBillStoreData
 * JD-Core Version:    0.7.0.1
 */