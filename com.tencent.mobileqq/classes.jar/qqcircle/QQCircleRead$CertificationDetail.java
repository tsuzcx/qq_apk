package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class QQCircleRead$CertificationDetail
  extends MessageMicro<CertificationDetail>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "circleType", "circleStatue", "studentInfo", "staffInfo" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null }, CertificationDetail.class);
  public final PBInt32Field circleStatue = PBField.initInt32(0);
  public final PBInt32Field circleType = PBField.initInt32(0);
  public QQCircleBase.StaffInfo staffInfo = new QQCircleBase.StaffInfo();
  public QQCircleBase.StudentInfo studentInfo = new QQCircleBase.StudentInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleRead.CertificationDetail
 * JD-Core Version:    0.7.0.1
 */