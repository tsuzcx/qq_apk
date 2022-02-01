package tencent.im.s2c.msgtype0x210.submsgtype0x9b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x9b$PbOfficeNotify
  extends MessageMicro<PbOfficeNotify>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "opt_uint32_myoffice_flag", "rpt_uint64_appid" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, PbOfficeNotify.class);
  public final PBUInt32Field opt_uint32_myoffice_flag = PBField.initUInt32(0);
  public final PBRepeatField<Long> rpt_uint64_appid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x9b.SubMsgType0x9b.PbOfficeNotify
 * JD-Core Version:    0.7.0.1
 */