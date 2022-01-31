package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "aid", "traceid", "via", "view_id" }, new Object[] { Long.valueOf(0L), "", "", "" }, TraceInfo.class);
  public final PBUInt64Field aid = PBField.initUInt64(0L);
  public final PBStringField traceid = PBField.initString("");
  public final PBStringField via = PBField.initString("");
  public final PBStringField view_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo
 * JD-Core Version:    0.7.0.1
 */