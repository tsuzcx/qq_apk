package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleConfig$GetMooncakeRsp
  extends MessageMicro<GetMooncakeRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field allowLongVideo = PBField.initInt32(0);
  public final PBInt64Field featureMask = PBField.initInt64(0L);
  public final PBRepeatField<String> needClientReportSuccessRateCmd = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBInt32Field nextTimeInterval = PBField.initInt32(0);
  public final PBInt32Field videoLength = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40 }, new String[] { "allowLongVideo", "videoLength", "nextTimeInterval", "needClientReportSuccessRateCmd", "featureMask" }, new Object[] { localInteger, localInteger, localInteger, "", Long.valueOf(0L) }, GetMooncakeRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleConfig.GetMooncakeRsp
 * JD-Core Version:    0.7.0.1
 */