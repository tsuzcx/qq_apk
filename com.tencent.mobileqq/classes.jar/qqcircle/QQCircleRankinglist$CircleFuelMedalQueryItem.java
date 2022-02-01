package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleRankinglist$CircleFuelMedalQueryItem
  extends MessageMicro<CircleFuelMedalQueryItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "uid", "tidList" }, new Object[] { "", "" }, CircleFuelMedalQueryItem.class);
  public final PBRepeatField<String> tidList = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField uid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleRankinglist.CircleFuelMedalQueryItem
 * JD-Core Version:    0.7.0.1
 */