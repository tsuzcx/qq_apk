package tencent.im.oidb.cmd0x5d6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x5d6$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_seq", "rpt_msg_update_buffer", "uint32_domain" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0) }, ReqBody.class);
  public final PBRepeatMessageField rpt_msg_update_buffer = PBField.initRepeatMessage(oidb_0x5d6.SnsUpateBuffer.class);
  public final PBUInt32Field uint32_domain = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5d6.oidb_0x5d6.ReqBody
 * JD-Core Version:    0.7.0.1
 */