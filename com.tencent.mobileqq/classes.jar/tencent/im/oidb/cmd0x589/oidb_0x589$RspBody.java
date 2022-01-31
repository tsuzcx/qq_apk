package tencent.im.oidb.cmd0x589;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x589$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_app_id", "rpt_msg_open_id" }, new Object[] { Long.valueOf(0L), null }, RspBody.class);
  public final PBRepeatMessageField rpt_msg_open_id = PBField.initRepeatMessage(oidb_0x589.GetUserOpenIdRsp.class);
  public final PBUInt64Field uint64_app_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x589.oidb_0x589.RspBody
 * JD-Core Version:    0.7.0.1
 */