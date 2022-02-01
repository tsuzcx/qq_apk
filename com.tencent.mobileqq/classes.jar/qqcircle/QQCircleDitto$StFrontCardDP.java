package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StUser;

public final class QQCircleDitto$StFrontCardDP
  extends MessageMicro<StFrontCardDP>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "recomUser", "matchReson", "recomCommReson", "recomReason", "buttons" }, new Object[] { null, "", "", "", null }, StFrontCardDP.class);
  public final PBRepeatMessageField<QQCircleDitto.StButton> buttons = PBField.initRepeatMessage(QQCircleDitto.StButton.class);
  public final PBRepeatField<String> matchReson = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField recomCommReson = PBField.initString("");
  public final PBRepeatField<String> recomReason = PBField.initRepeat(PBStringField.__repeatHelper__);
  public FeedCloudMeta.StUser recomUser = new FeedCloudMeta.StUser();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleDitto.StFrontCardDP
 * JD-Core Version:    0.7.0.1
 */