package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QWalletPubAdReport$QueryReq
  extends MessageMicro<QueryReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "uin", "pskey", "channel", "terminal_infor" }, new Object[] { "", "", Integer.valueOf(0), null }, QueryReq.class);
  public final PBInt32Field channel = PBField.initInt32(0);
  public final PBStringField pskey = PBField.initString("");
  public QWalletPubAdReport.TerminalInfor terminal_infor = new QWalletPubAdReport.TerminalInfor();
  public final PBStringField uin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.qqwallet.QWalletPubAdReport.QueryReq
 * JD-Core Version:    0.7.0.1
 */