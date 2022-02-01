package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class QQCircleProfile$SetUserSwitchReq
  extends MessageMicro<SetUserSwitchReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field switchType = PBField.initInt32(0);
  public final PBInt32Field value = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "switchType", "value" }, new Object[] { localInteger, localInteger }, SetUserSwitchReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleProfile.SetUserSwitchReq
 * JD-Core Version:    0.7.0.1
 */