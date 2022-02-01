package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleRankinglist$ClassifyUserReq
  extends MessageMicro<ClassifyUserReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "extInfo", "listType", "opType", "uids" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), "" }, ClassifyUserReq.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBInt32Field listType = PBField.initInt32(0);
  public final PBInt32Field opType = PBField.initInt32(0);
  public final PBRepeatField<String> uids = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleRankinglist.ClassifyUserReq
 * JD-Core Version:    0.7.0.1
 */