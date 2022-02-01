package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo
  extends MessageMicro<TraceInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field aid = PBField.initUInt64(0L);
  public final PBUInt64Field creative_id = PBField.initUInt64(0L);
  public final PBStringField net_log_req_id = PBField.initString("");
  public final PBInt64Field noco_id = PBField.initInt64(0L);
  public final PBStringField product_id = PBField.initString("");
  public final PBUInt32Field quality_product_id = PBField.initUInt32(0);
  public final PBStringField traceid = PBField.initString("");
  public final PBStringField via = PBField.initString("");
  public final PBStringField view_id = PBField.initString("");
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 58, 64, 72 }, new String[] { "aid", "traceid", "via", "view_id", "product_id", "noco_id", "net_log_req_id", "creative_id", "quality_product_id" }, new Object[] { localLong, "", "", "", "", localLong, "", localLong, Integer.valueOf(0) }, TraceInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo
 * JD-Core Version:    0.7.0.1
 */