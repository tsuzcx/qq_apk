package tencent.im.profile.forward;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class sysmsg_push$ForwardBody
  extends MessageMicro<ForwardBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public sysmsg_push.AppointmentNot msg_appointment_not = new sysmsg_push.AppointmentNot();
  public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 162 }, new String[] { "uint32_notify_type", "uint32_op_type", "msg_appointment_not" }, new Object[] { localInteger, localInteger, null }, ForwardBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.profile.forward.sysmsg_push.ForwardBody
 * JD-Core Version:    0.7.0.1
 */