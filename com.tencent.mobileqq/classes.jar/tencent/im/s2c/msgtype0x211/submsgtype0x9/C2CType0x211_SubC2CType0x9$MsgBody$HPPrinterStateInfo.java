package tencent.im.s2c.msgtype0x211.submsgtype0x9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class C2CType0x211_SubC2CType0x9$MsgBody$HPPrinterStateInfo
  extends MessageMicro<HPPrinterStateInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint64_printer_din", "str_printer_qr_pic_url", "str_printer_qr_open_url", "str_printer_tip_url" }, new Object[] { Long.valueOf(0L), "", "", "" }, HPPrinterStateInfo.class);
  public final PBStringField str_printer_qr_open_url = PBField.initString("");
  public final PBStringField str_printer_qr_pic_url = PBField.initString("");
  public final PBStringField str_printer_tip_url = PBField.initString("");
  public final PBUInt64Field uint64_printer_din = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9.MsgBody.HPPrinterStateInfo
 * JD-Core Version:    0.7.0.1
 */