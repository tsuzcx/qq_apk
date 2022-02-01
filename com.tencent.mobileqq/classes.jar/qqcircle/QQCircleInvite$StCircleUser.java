package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleInvite$StCircleUser
  extends MessageMicro<StCircleUser>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field invalid = PBField.initInt32(0);
  public final PBUInt32Field uin = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uin", "invalid" }, new Object[] { localInteger, localInteger }, StCircleUser.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleInvite.StCircleUser
 * JD-Core Version:    0.7.0.1
 */