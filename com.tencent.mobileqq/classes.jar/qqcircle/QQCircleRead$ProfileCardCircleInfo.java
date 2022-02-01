package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQCircleRead$ProfileCardCircleInfo
  extends MessageMicro<ProfileCardCircleInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "userCircleList" }, new Object[] { null }, ProfileCardCircleInfo.class);
  public final PBRepeatMessageField<QQCircleRead.UserCircleSimpleInfo> userCircleList = PBField.initRepeatMessage(QQCircleRead.UserCircleSimpleInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleRead.ProfileCardCircleInfo
 * JD-Core Version:    0.7.0.1
 */