package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StTagInfo;

public final class QQCircleFeedBase$StMainPageBusiRspData
  extends MessageMicro<StMainPageBusiRspData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public QQCircleFeedBase.StPageRedPointInfo RedPointInfo = new QQCircleFeedBase.StPageRedPointInfo();
  public QQCircleFeedBase.StBlackInfo blackInfo = new QQCircleFeedBase.StBlackInfo();
  public final PBUInt32Field fuelValue = PBField.initUInt32(0);
  public final PBUInt32Field giftCnt = PBField.initUInt32(0);
  public final PBStringField giftJumpUrl = PBField.initString("");
  public final PBRepeatField<Integer> opMask = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field pattonType = PBField.initUInt32(0);
  public final PBBytesField profileBusiData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<FeedCloudMeta.StTagInfo> recomTagList = PBField.initRepeatMessage(FeedCloudMeta.StTagInfo.class);
  public final PBUInt32Field timeInterval = PBField.initUInt32(0);
  public final PBRepeatMessageField<FeedCloudCommon.Entry> urlInfo = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 50, 56, 66, 72, 82, 90 }, new String[] { "urlInfo", "opMask", "recomTagList", "fuelValue", "pattonType", "profileBusiData", "giftCnt", "giftJumpUrl", "timeInterval", "blackInfo", "RedPointInfo" }, new Object[] { null, Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), "", Integer.valueOf(0), null, null }, StMainPageBusiRspData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StMainPageBusiRspData
 * JD-Core Version:    0.7.0.1
 */