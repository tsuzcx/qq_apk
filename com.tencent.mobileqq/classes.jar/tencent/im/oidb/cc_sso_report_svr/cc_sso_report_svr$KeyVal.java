package tencent.im.oidb.cc_sso_report_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class cc_sso_report_svr$KeyVal
  extends MessageMicro<KeyVal>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "key", "val" }, new Object[] { "", "" }, KeyVal.class);
  public final PBStringField key = PBField.initString("");
  public final PBStringField val = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cc_sso_report_svr.cc_sso_report_svr.KeyVal
 * JD-Core Version:    0.7.0.1
 */