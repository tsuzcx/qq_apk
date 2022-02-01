package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleFeedBase$StFeedListBusiRspData
  extends MessageMicro<StFeedListBusiRspData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<Integer> NoUse = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public QQCircleFeedBase.StBackflowPymkPageData backflowPymkPageData = new QQCircleFeedBase.StBackflowPymkPageData();
  public QQCircleFeedBase.StCampanyPageData campanyPageData = new QQCircleFeedBase.StCampanyPageData();
  public QQCircleFeedBase.StCityPageData cityPageData = new QQCircleFeedBase.StCityPageData();
  public QQCircleFeedBase.StCommSchemaCollectPageData commSchemaCollectPageData = new QQCircleFeedBase.StCommSchemaCollectPageData();
  public QQCircleFeedBase.StExplorePageData exploredPageData = new QQCircleFeedBase.StExplorePageData();
  public QQCircleFeedBase.StFashionCopyPageData fashionCopyPageData = new QQCircleFeedBase.StFashionCopyPageData();
  public QQCircleFeedBase.StFollowPageData followPageData = new QQCircleFeedBase.StFollowPageData();
  public QQCircleFeedBase.StGpsPageData gpsPageData = new QQCircleFeedBase.StGpsPageData();
  public QQCircleFeedBase.StHomeButtonBubbleData homeButtonBubbleData = new QQCircleFeedBase.StHomeButtonBubbleData();
  public QQCircleFeedBase.StMusicPageData musicPageData = new QQCircleFeedBase.StMusicPageData();
  public QQCircleFeedBase.StNewUserPymkPageData newUserPymkPageData = new QQCircleFeedBase.StNewUserPymkPageData();
  public final PBRepeatField<Integer> opMask = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBEnumField pageLayoutType = PBField.initEnum(1);
  public QQCircleFeedBase.StPhotoSelectorRecomPageData photoSelectorRecomPageData = new QQCircleFeedBase.StPhotoSelectorRecomPageData();
  public final PBStringField refreshAttachInfo = PBField.initString("");
  public final PBInt64Field rspExpireAt = PBField.initInt64(0L);
  public final PBInt64Field rspTimestamp = PBField.initInt64(0L);
  public final PBStringField schemaTrans = PBField.initString("");
  public QQCircleFeedBase.StSchoolPageData schoolPageData = new QQCircleFeedBase.StSchoolPageData();
  public QQCircleFeedBase.StTagPageData tagPageData = new QQCircleFeedBase.StTagPageData();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56, 64, 74, 82, 88, 98, 106, 114, 122, 130, 138, 144, 154, 160, 170 }, new String[] { "exploredPageData", "schoolPageData", "campanyPageData", "cityPageData", "tagPageData", "followPageData", "NoUse", "opMask", "refreshAttachInfo", "gpsPageData", "rspTimestamp", "fashionCopyPageData", "newUserPymkPageData", "commSchemaCollectPageData", "schemaTrans", "homeButtonBubbleData", "backflowPymkPageData", "pageLayoutType", "photoSelectorRecomPageData", "rspExpireAt", "musicPageData" }, new Object[] { null, null, null, null, null, null, localInteger, localInteger, "", null, Long.valueOf(0L), null, null, null, "", null, null, Integer.valueOf(1), null, Long.valueOf(0L), null }, StFeedListBusiRspData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StFeedListBusiRspData
 * JD-Core Version:    0.7.0.1
 */