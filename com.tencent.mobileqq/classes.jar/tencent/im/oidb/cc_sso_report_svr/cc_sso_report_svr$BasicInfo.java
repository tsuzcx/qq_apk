package tencent.im.oidb.cc_sso_report_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cc_sso_report_svr$BasicInfo
  extends MessageMicro<BasicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field channel = PBField.initUInt32(0);
  public final PBUInt32Field platform = PBField.initUInt32(0);
  public final PBStringField version = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "channel", "platform", "version" }, new Object[] { localInteger, localInteger, "" }, BasicInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cc_sso_report_svr.cc_sso_report_svr.BasicInfo
 * JD-Core Version:    0.7.0.1
 */