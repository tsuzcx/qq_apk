package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StGPSV2;

public final class QQCircleFeedBase$StFeedListBusiReqData
  extends MessageMicro<StFeedListBusiReqData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 48 }, new String[] { "tabAttachInfo", "gpsInfo", "isReqLayer", "tagId", "tagName", "noRecom" }, new Object[] { "", null, Boolean.valueOf(false), "", "", Boolean.valueOf(false) }, StFeedListBusiReqData.class);
  public FeedCloudMeta.StGPSV2 gpsInfo = new FeedCloudMeta.StGPSV2();
  public final PBBoolField isReqLayer = PBField.initBool(false);
  public final PBBoolField noRecom = PBField.initBool(false);
  public final PBStringField tabAttachInfo = PBField.initString("");
  public final PBStringField tagId = PBField.initString("");
  public final PBStringField tagName = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StFeedListBusiReqData
 * JD-Core Version:    0.7.0.1
 */