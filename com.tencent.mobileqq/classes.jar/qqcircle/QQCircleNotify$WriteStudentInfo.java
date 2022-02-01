package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleNotify$WriteStudentInfo
  extends MessageMicro<WriteStudentInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "action", "uin", "msgID", "studentInfo" }, new Object[] { Integer.valueOf(0), "", "", null }, WriteStudentInfo.class);
  public final PBInt32Field action = PBField.initInt32(0);
  public final PBStringField msgID = PBField.initString("");
  public QQCircleBase.StudentInfo studentInfo = new QQCircleBase.StudentInfo();
  public final PBStringField uin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleNotify.WriteStudentInfo
 * JD-Core Version:    0.7.0.1
 */