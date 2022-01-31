package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleBase$StaffInfo
  extends MessageMicro<StaffInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 58, 66, 72, 80 }, new String[] { "name", "companyName", "position", "email", "evidencePicturies", "optime", "id", "companyLogo", "onboardingTime", "leaveTime" }, new Object[] { "", "", "", "", "", Long.valueOf(0L), "", "", Integer.valueOf(0), Integer.valueOf(0) }, StaffInfo.class);
  public final PBStringField companyLogo = PBField.initString("");
  public final PBStringField companyName = PBField.initString("");
  public final PBStringField email = PBField.initString("");
  public final PBRepeatField<String> evidencePicturies = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField id = PBField.initString("");
  public final PBUInt32Field leaveTime = PBField.initUInt32(0);
  public final PBStringField name = PBField.initString("");
  public final PBUInt32Field onboardingTime = PBField.initUInt32(0);
  public final PBInt64Field optime = PBField.initInt64(0L);
  public final PBStringField position = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleBase.StaffInfo
 * JD-Core Version:    0.7.0.1
 */