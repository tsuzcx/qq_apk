package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StGPSV2;

public final class QQCircleFeedBase$StFeedListBusiReqData
  extends MessageMicro<StFeedListBusiReqData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 48, 58, 66, 72 }, new String[] { "tabAttachInfo", "gpsInfo", "isReqLayer", "tagId", "tagName", "noRecom", "refreshAttachInfo", "detailFeed", "groupNumber" }, new Object[] { "", null, Boolean.valueOf(false), "", "", Boolean.valueOf(false), "", null, Long.valueOf(0L) }, StFeedListBusiReqData.class);
  public FeedCloudMeta.StFeed detailFeed = new FeedCloudMeta.StFeed();
  public FeedCloudMeta.StGPSV2 gpsInfo = new FeedCloudMeta.StGPSV2();
  public final PBUInt64Field groupNumber = PBField.initUInt64(0L);
  public final PBBoolField isReqLayer = PBField.initBool(false);
  public final PBBoolField noRecom = PBField.initBool(false);
  public final PBStringField refreshAttachInfo = PBField.initString("");
  public final PBStringField tabAttachInfo = PBField.initString("");
  public final PBStringField tagId = PBField.initString("");
  public final PBStringField tagName = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StFeedListBusiReqData
 * JD-Core Version:    0.7.0.1
 */