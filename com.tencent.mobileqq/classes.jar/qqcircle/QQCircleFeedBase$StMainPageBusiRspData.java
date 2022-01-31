package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StTagInfo;

public final class QQCircleFeedBase$StMainPageBusiRspData
  extends MessageMicro<StMainPageBusiRspData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "urlInfo", "opMask", "recomTagList" }, new Object[] { null, Integer.valueOf(0), null }, StMainPageBusiRspData.class);
  public final PBRepeatField<Integer> opMask = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatMessageField<FeedCloudMeta.StTagInfo> recomTagList = PBField.initRepeatMessage(FeedCloudMeta.StTagInfo.class);
  public final PBRepeatMessageField<FeedCloudCommon.Entry> urlInfo = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StMainPageBusiRspData
 * JD-Core Version:    0.7.0.1
 */