package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleRankinglist$GetRankingListReq
  extends MessageMicro<GetRankingListReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField circleName = PBField.initString("");
  public final PBInt32Field count = PBField.initInt32(0);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBInt32Field listClass = PBField.initInt32(0);
  public final PBUInt32Field listTime = PBField.initUInt32(0);
  public final PBInt32Field listType = PBField.initInt32(0);
  public final PBInt32Field needHostUinRank = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50, 56 }, new String[] { "extInfo", "listType", "count", "listTime", "listClass", "circleName", "needHostUinRank" }, new Object[] { null, localInteger, localInteger, localInteger, localInteger, "", localInteger }, GetRankingListReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleRankinglist.GetRankingListReq
 * JD-Core Version:    0.7.0.1
 */