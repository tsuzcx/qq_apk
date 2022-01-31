package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudMeta.StTagInfo;

public final class QQCircleFeedBase$StExplorePageData
  extends MessageMicro<StExplorePageData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "recomTagList" }, new Object[] { null }, StExplorePageData.class);
  public final PBRepeatMessageField<FeedCloudMeta.StTagInfo> recomTagList = PBField.initRepeatMessage(FeedCloudMeta.StTagInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StExplorePageData
 * JD-Core Version:    0.7.0.1
 */