package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleCounter$PreRecommendCountInfoReq
  extends MessageMicro<PreRecommendCountInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "extInfo", "appId", "userId", "sceneType" }, new Object[] { null, "", "", Integer.valueOf(0) }, PreRecommendCountInfoReq.class);
  public final PBStringField appId = PBField.initString("");
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBInt32Field sceneType = PBField.initInt32(0);
  public final PBStringField userId = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleCounter.PreRecommendCountInfoReq
 * JD-Core Version:    0.7.0.1
 */