package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCirclePrivateMsgShow$StChangePMSettingReq
  extends MessageMicro<StChangePMSettingReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "setting" }, new Object[] { null, null }, StChangePMSettingReq.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public QQCirclePrivateMsgShow.StPMSettingData setting = new QQCirclePrivateMsgShow.StPMSettingData();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCirclePrivateMsgShow.StChangePMSettingReq
 * JD-Core Version:    0.7.0.1
 */