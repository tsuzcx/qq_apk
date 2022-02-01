package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleCountergroup$GetGroupCountRsp
  extends MessageMicro<GetGroupCountRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField content = PBField.initString("");
  public final PBUInt32Field count = PBField.initUInt32(0);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBUInt32Field hasMore = PBField.initUInt32(0);
  public final PBStringField iconUrl = PBField.initString("");
  public final PBUInt32Field latestFeedTime = PBField.initUInt32(0);
  public final PBUInt32Field timeInterval = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 56 }, new String[] { "extInfo", "count", "hasMore", "timeInterval", "content", "iconUrl", "latestFeedTime" }, new Object[] { null, localInteger, localInteger, localInteger, "", "", localInteger }, GetGroupCountRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleCountergroup.GetGroupCountRsp
 * JD-Core Version:    0.7.0.1
 */