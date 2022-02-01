package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleCounter$RedPointJumpInfo
  extends MessageMicro<RedPointJumpInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField jumpLink = PBField.initString("");
  public final PBEnumField jumpType = PBField.initEnum(0);
  public final PBRepeatField<Integer> redPointSources = PBField.initRepeat(PBInt32Field.__repeatHelper__);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "jumpType", "jumpLink", "redPointSources" }, new Object[] { localInteger, "", localInteger }, RedPointJumpInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleCounter.RedPointJumpInfo
 * JD-Core Version:    0.7.0.1
 */