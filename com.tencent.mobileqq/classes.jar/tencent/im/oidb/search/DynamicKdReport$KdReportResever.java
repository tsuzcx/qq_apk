package tencent.im.oidb.search;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class DynamicKdReport$KdReportResever
  extends MessageMicro<KdReportResever>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "sreseverkey", "sresevervalue" }, new Object[] { "", "" }, KdReportResever.class);
  public final PBStringField sreseverkey = PBField.initString("");
  public final PBStringField sresevervalue = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.search.DynamicKdReport.KdReportResever
 * JD-Core Version:    0.7.0.1
 */