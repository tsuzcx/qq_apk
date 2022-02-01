package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QWalletPubAdReport$ReportRsp
  extends MessageMicro<ReportRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "ret", "msg", "uin" }, new Object[] { Integer.valueOf(0), "", "" }, ReportRsp.class);
  public final PBStringField msg = PBField.initString("");
  public final PBInt32Field ret = PBField.initInt32(0);
  public final PBStringField uin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.qqwallet.QWalletPubAdReport.ReportRsp
 * JD-Core Version:    0.7.0.1
 */