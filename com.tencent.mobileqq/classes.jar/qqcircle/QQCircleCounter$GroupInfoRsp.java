package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleCounter$GroupInfoRsp
  extends MessageMicro<GroupInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "groupinfo", "nextTime" }, new Object[] { null, null, Integer.valueOf(0) }, GroupInfoRsp.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBRepeatMessageField<QQCircleCounter.GroupInfo> groupinfo = PBField.initRepeatMessage(QQCircleCounter.GroupInfo.class);
  public final PBUInt32Field nextTime = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleCounter.GroupInfoRsp
 * JD-Core Version:    0.7.0.1
 */