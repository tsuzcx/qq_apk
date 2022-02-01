package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCirclePrivateMsgShow$StGetPMSettingRsp
  extends MessageMicro<StGetPMSettingRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "setting", "fuelCostRange" }, new Object[] { null, null, null }, StGetPMSettingRsp.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public QQCirclePrivateMsgShow.StFuelCostRange fuelCostRange = new QQCirclePrivateMsgShow.StFuelCostRange();
  public QQCirclePrivateMsgShow.StPMSettingData setting = new QQCirclePrivateMsgShow.StPMSettingData();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCirclePrivateMsgShow.StGetPMSettingRsp
 * JD-Core Version:    0.7.0.1
 */