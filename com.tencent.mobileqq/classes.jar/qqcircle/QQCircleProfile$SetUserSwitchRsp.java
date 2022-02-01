package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class QQCircleProfile$SetUserSwitchRsp
  extends MessageMicro<SetUserSwitchRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "value" }, new Object[] { Integer.valueOf(0) }, SetUserSwitchRsp.class);
  public final PBInt32Field value = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleProfile.SetUserSwitchRsp
 * JD-Core Version:    0.7.0.1
 */