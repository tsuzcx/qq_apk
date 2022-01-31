package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleFeedBase$StFeedListBusiRspData
  extends MessageMicro<StFeedListBusiRspData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 64 }, new String[] { "exploredPageData", "schoolPageData", "campanyPageData", "cityPageData", "tagPageData", "followPageData", "opMask" }, new Object[] { null, null, null, null, null, null, Integer.valueOf(0) }, StFeedListBusiRspData.class);
  public QQCircleFeedBase.StCampanyPageData campanyPageData = new QQCircleFeedBase.StCampanyPageData();
  public QQCircleFeedBase.StCityPageData cityPageData = new QQCircleFeedBase.StCityPageData();
  public QQCircleFeedBase.StExplorePageData exploredPageData = new QQCircleFeedBase.StExplorePageData();
  public QQCircleFeedBase.StFollowPageData followPageData = new QQCircleFeedBase.StFollowPageData();
  public final PBRepeatField<Integer> opMask = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public QQCircleFeedBase.StSchoolPageData schoolPageData = new QQCircleFeedBase.StSchoolPageData();
  public QQCircleFeedBase.StTagPageData tagPageData = new QQCircleFeedBase.StTagPageData();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StFeedListBusiRspData
 * JD-Core Version:    0.7.0.1
 */