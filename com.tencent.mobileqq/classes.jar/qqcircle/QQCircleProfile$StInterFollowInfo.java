package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleProfile$StInterFollowInfo
  extends MessageMicro<StInterFollowInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "nicks", "total" }, new Object[] { "", Integer.valueOf(0) }, StInterFollowInfo.class);
  public final PBRepeatField<String> nicks = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBInt32Field total = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleProfile.StInterFollowInfo
 * JD-Core Version:    0.7.0.1
 */