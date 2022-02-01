package tencent.im.new_year_report;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PackReport$PkgResp
  extends MessageMicro<PkgResp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "retcode", "retmsg" }, new Object[] { Integer.valueOf(0), "" }, PkgResp.class);
  public final PBUInt32Field retcode = PBField.initUInt32(0);
  public final PBStringField retmsg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.new_year_report.PackReport.PkgResp
 * JD-Core Version:    0.7.0.1
 */