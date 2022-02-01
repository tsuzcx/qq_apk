package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QWalletPubAdReport$TerminalInfor
  extends MessageMicro<TerminalInfor>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56, 66 }, new String[] { "model", "appid", "edition", "qq_version", "device_name", "client_os", "root_flag", "device_id" }, new Object[] { "", "", "", "", "", "", Integer.valueOf(0), "" }, TerminalInfor.class);
  public final PBStringField appid = PBField.initString("");
  public final PBStringField client_os = PBField.initString("");
  public final PBStringField device_id = PBField.initString("");
  public final PBStringField device_name = PBField.initString("");
  public final PBStringField edition = PBField.initString("");
  public final PBStringField model = PBField.initString("");
  public final PBStringField qq_version = PBField.initString("");
  public final PBInt32Field root_flag = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.qqwallet.QWalletPubAdReport.TerminalInfor
 * JD-Core Version:    0.7.0.1
 */