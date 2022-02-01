package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StFeedAbstract;

public final class QQCircleRecomgateway$CommRecomReq
  extends MessageMicro<CommRecomReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40 }, new String[] { "extInfo", "uid", "curpage", "feeds", "inWhiteList" }, new Object[] { null, "", Integer.valueOf(0), null, Boolean.valueOf(false) }, CommRecomReq.class);
  public final PBUInt32Field curpage = PBField.initUInt32(0);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBRepeatMessageField<FeedCloudMeta.StFeedAbstract> feeds = PBField.initRepeatMessage(FeedCloudMeta.StFeedAbstract.class);
  public final PBBoolField inWhiteList = PBField.initBool(false);
  public final PBStringField uid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleRecomgateway.CommRecomReq
 * JD-Core Version:    0.7.0.1
 */