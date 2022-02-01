package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleCounter$CountInfoRsp
  extends MessageMicro<CountInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42 }, new String[] { "extInfo", "rptRedPoint", "retCode", "retMsg", "jumpSchema" }, new Object[] { null, null, Integer.valueOf(0), "", "" }, CountInfoRsp.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBStringField jumpSchema = PBField.initString("");
  public final PBUInt32Field retCode = PBField.initUInt32(0);
  public final PBStringField retMsg = PBField.initString("");
  public final PBRepeatMessageField<QQCircleCounter.RedPointInfo> rptRedPoint = PBField.initRepeatMessage(QQCircleCounter.RedPointInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleCounter.CountInfoRsp
 * JD-Core Version:    0.7.0.1
 */