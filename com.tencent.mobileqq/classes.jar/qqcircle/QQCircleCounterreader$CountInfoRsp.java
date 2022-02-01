package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleCounterreader$CountInfoRsp
  extends MessageMicro<CountInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "rptRedPoint" }, new Object[] { null, null }, CountInfoRsp.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBRepeatMessageField<QQCircleCounterreader.RedPointInfo> rptRedPoint = PBField.initRepeatMessage(QQCircleCounterreader.RedPointInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleCounterreader.CountInfoRsp
 * JD-Core Version:    0.7.0.1
 */