package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleStorage$UserBehaviorRecord
  extends MessageMicro<UserBehaviorRecord>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField behaviorType = PBField.initEnum(0);
  public final PBUInt32Field optTime = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "behaviorType", "optTime" }, new Object[] { localInteger, localInteger }, UserBehaviorRecord.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleStorage.UserBehaviorRecord
 * JD-Core Version:    0.7.0.1
 */