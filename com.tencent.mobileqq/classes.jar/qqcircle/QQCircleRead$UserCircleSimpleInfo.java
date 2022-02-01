package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleRead$UserCircleSimpleInfo
  extends MessageMicro<UserCircleSimpleInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "circleID", "name", "jumpUrl", "circleType" }, new Object[] { "", "", "", Integer.valueOf(0) }, UserCircleSimpleInfo.class);
  public final PBStringField circleID = PBField.initString("");
  public final PBInt32Field circleType = PBField.initInt32(0);
  public final PBStringField jumpUrl = PBField.initString("");
  public final PBStringField name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleRead.UserCircleSimpleInfo
 * JD-Core Version:    0.7.0.1
 */