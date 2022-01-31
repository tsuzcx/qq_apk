package tencent.im.oidb.cmd0xff1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xff1$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0xff1.RspAlarmRing msg_rsp_alarm_ring = new oidb_0xff1.RspAlarmRing();
  public oidb_0xff1.RspRevertAlarm msg_rsp_revert_alarm = new oidb_0xff1.RspRevertAlarm();
  public oidb_0xff1.RspSetAlarm msg_rsp_setalarm = new oidb_0xff1.RspSetAlarm();
  public final PBUInt32Field uint32_retcode = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "uint32_retcode", "bytes_errmsg", "msg_rsp_setalarm", "msg_rsp_revert_alarm", "msg_rsp_alarm_ring" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, null, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xff1.oidb_0xff1.RspBody
 * JD-Core Version:    0.7.0.1
 */