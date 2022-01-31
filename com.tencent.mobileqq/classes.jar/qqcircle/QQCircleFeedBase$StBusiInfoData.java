package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon.Entry;

public final class QQCircleFeedBase$StBusiInfoData
  extends MessageMicro<StBusiInfoData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "tabInfos", "busiMap", "allPolyInfo", "schoolInfos", "companyInfos" }, new Object[] { null, null, null, null, null }, StBusiInfoData.class);
  public final PBRepeatMessageField<QQCircleFeedBase.StPolyLike> allPolyInfo = PBField.initRepeatMessage(QQCircleFeedBase.StPolyLike.class);
  public final PBRepeatMessageField<FeedCloudCommon.Entry> busiMap = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
  public final PBRepeatMessageField<QQCircleBase.UserCircleInfo> companyInfos = PBField.initRepeatMessage(QQCircleBase.UserCircleInfo.class);
  public final PBRepeatMessageField<QQCircleBase.UserCircleInfo> schoolInfos = PBField.initRepeatMessage(QQCircleBase.UserCircleInfo.class);
  public final PBRepeatMessageField<QQCircleFeedBase.StTabInfo> tabInfos = PBField.initRepeatMessage(QQCircleFeedBase.StTabInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StBusiInfoData
 * JD-Core Version:    0.7.0.1
 */