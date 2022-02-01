package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQCircleProfile$StProfileBizData
  extends MessageMicro<StProfileBizData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42 }, new String[] { "followText", "groupIDList", "bindGroupStatus", "interFollowList", "interFollowInfo" }, new Object[] { "", Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), null }, StProfileBizData.class);
  public final PBInt32Field bindGroupStatus = PBField.initInt32(0);
  public final PBStringField followText = PBField.initString("");
  public final PBRepeatField<Long> groupIDList = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public QQCircleProfile.StInterFollowInfo interFollowInfo = new QQCircleProfile.StInterFollowInfo();
  public final PBRepeatField<Long> interFollowList = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleProfile.StProfileBizData
 * JD-Core Version:    0.7.0.1
 */