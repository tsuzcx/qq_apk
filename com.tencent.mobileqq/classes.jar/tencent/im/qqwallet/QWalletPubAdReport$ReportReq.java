package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QWalletPubAdReport$ReportReq
  extends MessageMicro<ReportReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "uin", "pskey", "ad_reslut", "channel", "terminal_infor" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0), null }, ReportReq.class);
  public final PBInt32Field ad_reslut = PBField.initInt32(0);
  public final PBInt32Field channel = PBField.initInt32(0);
  public final PBStringField pskey = PBField.initString("");
  public QWalletPubAdReport.TerminalInfor terminal_infor = new QWalletPubAdReport.TerminalInfor();
  public final PBStringField uin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.qqwallet.QWalletPubAdReport.ReportReq
 * JD-Core Version:    0.7.0.1
 */