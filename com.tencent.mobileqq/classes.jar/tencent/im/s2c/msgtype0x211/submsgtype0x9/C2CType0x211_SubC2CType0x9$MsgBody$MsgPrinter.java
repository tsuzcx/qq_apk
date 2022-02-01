package tencent.im.s2c.msgtype0x211.submsgtype0x9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class C2CType0x211_SubC2CType0x9$MsgBody$MsgPrinter
  extends MessageMicro<MsgPrinter>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public C2CType0x211_SubC2CType0x9.MsgBody.HPPrinterStateInfo hp_printer_state_info = new C2CType0x211_SubC2CType0x9.MsgBody.HPPrinterStateInfo();
  public final PBRepeatMessageField<C2CType0x211_SubC2CType0x9.MsgBody.SupportFileInfo> rpt_msg_support_file_info = PBField.initRepeatMessage(C2CType0x211_SubC2CType0x9.MsgBody.SupportFileInfo.class);
  public final PBRepeatField<String> rpt_string_printer = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField<Long> rpt_uint64_session_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBStringField str_result_msg = PBField.initString("");
  public final PBUInt32Field uint32_print_result = PBField.initUInt32(0);
  public final PBUInt64Field uint64_print_session_id = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 50, 58 }, new String[] { "rpt_string_printer", "uint64_print_session_id", "uint32_print_result", "str_result_msg", "rpt_uint64_session_id", "rpt_msg_support_file_info", "hp_printer_state_info" }, new Object[] { "", localLong, Integer.valueOf(0), "", localLong, null, null }, MsgPrinter.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9.MsgBody.MsgPrinter
 * JD-Core Version:    0.7.0.1
 */