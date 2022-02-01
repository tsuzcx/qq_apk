package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleRankinglist$GetRankingListRsp
  extends MessageMicro<GetRankingListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField busiRptInfo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field endTime = PBField.initUInt32(0);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public QQCircleRankinglist.RankingItem hostUinRank = new QQCircleRankinglist.RankingItem();
  public final PBInt32Field isActiveRank = PBField.initInt32(0);
  public final PBRepeatMessageField<QQCircleRankinglist.RankingItem> items = PBField.initRepeatMessage(QQCircleRankinglist.RankingItem.class);
  public final PBUInt32Field startTime = PBField.initUInt32(0);
  public final PBStringField title = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50, 56, 794 }, new String[] { "extInfo", "items", "startTime", "endTime", "title", "hostUinRank", "isActiveRank", "busiRptInfo" }, new Object[] { null, null, localInteger, localInteger, "", null, localInteger, localByteStringMicro }, GetRankingListRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleRankinglist.GetRankingListRsp
 * JD-Core Version:    0.7.0.1
 */