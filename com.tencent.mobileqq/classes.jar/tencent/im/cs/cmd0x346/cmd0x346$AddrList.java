package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x346$AddrList
  extends MessageMicro<AddrList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18, 26, 32 }, new String[] { "rpt_str_ip", "rpt_str_domain", "uint32_port" }, new Object[] { "", "", Integer.valueOf(0) }, AddrList.class);
  public final PBStringField rpt_str_domain = PBField.initString("");
  public final PBRepeatField<String> rpt_str_ip = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field uint32_port = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.cmd0x346.cmd0x346.AddrList
 * JD-Core Version:    0.7.0.1
 */