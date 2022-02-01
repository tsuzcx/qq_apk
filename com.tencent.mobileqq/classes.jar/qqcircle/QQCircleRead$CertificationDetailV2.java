package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class QQCircleRead$CertificationDetailV2
  extends MessageMicro<CertificationDetailV2>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field circleStatue = PBField.initInt32(0);
  public final PBInt32Field circleType = PBField.initInt32(0);
  public QQCircleBase.StaffInfo staffInfo = new QQCircleBase.StaffInfo();
  public QQCircleBase.StudentInfo studentInfo = new QQCircleBase.StudentInfo();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "circleType", "circleStatue", "studentInfo", "staffInfo" }, new Object[] { localInteger, localInteger, null, null }, CertificationDetailV2.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleRead.CertificationDetailV2
 * JD-Core Version:    0.7.0.1
 */