package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleFamous$CircleFamousGrade
  extends MessageMicro<CircleFamousGrade>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field end = PBField.initUInt32(0);
  public final PBInt32Field grade = PBField.initInt32(0);
  public final PBUInt32Field start = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "start", "end", "grade" }, new Object[] { localInteger, localInteger, localInteger }, CircleFamousGrade.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleFamous.CircleFamousGrade
 * JD-Core Version:    0.7.0.1
 */