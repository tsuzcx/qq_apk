package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class qq_ad$QQAdReportRsp
  extends MessageMicro<QQAdReportRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret_code", "click_id" }, new Object[] { Integer.valueOf(0), "" }, QQAdReportRsp.class);
  public final PBStringField click_id = PBField.initString("");
  public final PBInt32Field ret_code = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qq_ad.QQAdReportRsp
 * JD-Core Version:    0.7.0.1
 */