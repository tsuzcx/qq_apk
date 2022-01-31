package tencent.im.oidb.cmd0xd4b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xd4b$CheckUserSubStatusRsp
  extends MessageMicro<CheckUserSubStatusRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "rpt_subscribe_status" }, new Object[] { Integer.valueOf(0) }, CheckUserSubStatusRsp.class);
  public final PBRepeatField<Integer> rpt_subscribe_status = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd4b.oidb_0xd4b.CheckUserSubStatusRsp
 * JD-Core Version:    0.7.0.1
 */