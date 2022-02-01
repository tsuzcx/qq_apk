package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCirclePrivateMsgShow$StChangePMSettingRsp
  extends MessageMicro<StChangePMSettingRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42 }, new String[] { "extInfo", "errCode", "errMsg", "setting", "fuelCostRange" }, new Object[] { null, Integer.valueOf(0), "", null, null }, StChangePMSettingRsp.class);
  public final PBInt32Field errCode = PBField.initInt32(0);
  public final PBStringField errMsg = PBField.initString("");
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public QQCirclePrivateMsgShow.StFuelCostRange fuelCostRange = new QQCirclePrivateMsgShow.StFuelCostRange();
  public QQCirclePrivateMsgShow.StPMSettingData setting = new QQCirclePrivateMsgShow.StPMSettingData();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCirclePrivateMsgShow.StChangePMSettingRsp
 * JD-Core Version:    0.7.0.1
 */