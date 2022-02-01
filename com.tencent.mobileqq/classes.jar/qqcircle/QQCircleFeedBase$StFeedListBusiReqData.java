package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StFeedMusic;
import feedcloud.FeedCloudMeta.StGPSV2;

public final class QQCircleFeedBase$StFeedListBusiReqData
  extends MessageMicro<StFeedListBusiReqData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public QQCircleFeedBase.StPageRedPointInfo RedPointInfo = new QQCircleFeedBase.StPageRedPointInfo();
  public final PBEnumField allPushPageLayoutType = PBField.initEnum(1);
  public FeedCloudMeta.StFeed detailFeed = new FeedCloudMeta.StFeed();
  public final PBStringField entrySchema = PBField.initString("");
  public FeedCloudMeta.StGPSV2 gpsInfo = new FeedCloudMeta.StGPSV2();
  public final PBUInt64Field groupNumber = PBField.initUInt64(0L);
  public final PBBoolField isCloudSealReq = PBField.initBool(false);
  public final PBBoolField isNewPageStyle = PBField.initBool(false);
  public final PBBoolField isReqLayer = PBField.initBool(false);
  public final PBInt64Field lastPrePullAt = PBField.initInt64(0L);
  public final PBStringField lightSDKVersion = PBField.initString("");
  public FeedCloudMeta.StFeedMusic musicInfo = new FeedCloudMeta.StFeedMusic();
  public final PBBoolField noRecom = PBField.initBool(false);
  public final PBEnumField pageLayoutType = PBField.initEnum(1);
  public final PBInt32Field pullSceneType = PBField.initInt32(0);
  public final PBUInt32Field pymkSourcePage = PBField.initUInt32(0);
  public final PBStringField refreshAttachInfo = PBField.initString("");
  public final PBStringField schemaTrans = PBField.initString("");
  public QQCircleFeedBase.StSimulateData simulateInfo = new QQCircleFeedBase.StSimulateData();
  public final PBStringField tabAttachInfo = PBField.initString("");
  public final PBStringField tagId = PBField.initString("");
  public final PBStringField tagName = PBField.initString("");
  
  static
  {
    Integer localInteger1 = Integer.valueOf(0);
    Boolean localBoolean = Boolean.valueOf(false);
    Integer localInteger2 = Integer.valueOf(1);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 48, 58, 66, 72, 90, 96, 106, 114, 122, 128, 136, 144, 152, 162, 168, 176, 186 }, new String[] { "tabAttachInfo", "gpsInfo", "isReqLayer", "tagId", "tagName", "noRecom", "refreshAttachInfo", "detailFeed", "groupNumber", "simulateInfo", "pullSceneType", "schemaTrans", "RedPointInfo", "entrySchema", "isCloudSealReq", "pymkSourcePage", "isNewPageStyle", "allPushPageLayoutType", "lightSDKVersion", "pageLayoutType", "lastPrePullAt", "musicInfo" }, new Object[] { "", null, localBoolean, "", "", localBoolean, "", null, Long.valueOf(0L), null, localInteger1, "", null, "", localBoolean, localInteger1, localBoolean, localInteger2, "", localInteger2, Long.valueOf(0L), null }, StFeedListBusiReqData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StFeedListBusiReqData
 * JD-Core Version:    0.7.0.1
 */