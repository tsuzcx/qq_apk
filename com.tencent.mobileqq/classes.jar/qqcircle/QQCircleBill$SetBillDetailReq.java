package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StFeed;

public final class QQCircleBill$SetBillDetailReq
  extends MessageMicro<SetBillDetailReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field billType = PBField.initUInt32(0);
  public final PBStringField billid = PBField.initString("");
  public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public FeedCloudMeta.StFeed feed = new FeedCloudMeta.StFeed();
  public QQCirclePaybase.StGiftData giftData = new QQCirclePaybase.StGiftData();
  public final PBUInt64Field opTime = PBField.initUInt64(0L);
  public final PBUInt32Field payMoney = PBField.initUInt32(0);
  public final PBStringField toUID = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 48, 58, 66, 74 }, new String[] { "extInfo", "billid", "billType", "giftData", "payMoney", "opTime", "toUID", "feed", "busiData" }, new Object[] { null, "", localInteger, null, localInteger, Long.valueOf(0L), "", null, localByteStringMicro }, SetBillDetailReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleBill.SetBillDetailReq
 * JD-Core Version:    0.7.0.1
 */