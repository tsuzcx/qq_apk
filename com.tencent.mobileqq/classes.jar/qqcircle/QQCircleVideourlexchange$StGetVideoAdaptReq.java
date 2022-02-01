package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StVideo;

public final class QQCircleVideourlexchange$StGetVideoAdaptReq
  extends MessageMicro<StGetVideoAdaptReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "extInfo", "from", "userID", "videos" }, new Object[] { null, Integer.valueOf(0), "", null }, StGetVideoAdaptReq.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBInt32Field from = PBField.initInt32(0);
  public final PBStringField userID = PBField.initString("");
  public final PBRepeatMessageField<FeedCloudMeta.StVideo> videos = PBField.initRepeatMessage(FeedCloudMeta.StVideo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleVideourlexchange.StGetVideoAdaptReq
 * JD-Core Version:    0.7.0.1
 */