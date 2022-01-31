package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleNotify$WriteStaffInfo
  extends MessageMicro<WriteStaffInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "action", "uin", "msgID", "staffInfo" }, new Object[] { Integer.valueOf(0), "", "", null }, WriteStaffInfo.class);
  public final PBInt32Field action = PBField.initInt32(0);
  public final PBStringField msgID = PBField.initString("");
  public QQCircleBase.StaffInfo staffInfo = new QQCircleBase.StaffInfo();
  public final PBStringField uin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleNotify.WriteStaffInfo
 * JD-Core Version:    0.7.0.1
 */