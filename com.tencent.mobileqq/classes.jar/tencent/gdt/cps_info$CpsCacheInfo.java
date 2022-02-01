package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cps_info$CpsCacheInfo
  extends MessageMicro<CpsCacheInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42 }, new String[] { "trace_id", "kol_id", "media_info", "pcg_media_trace_infos", "product_share_info" }, new Object[] { "", Long.valueOf(0L), null, null, null }, CpsCacheInfo.class);
  public final PBUInt64Field kol_id = PBField.initUInt64(0L);
  public cps_info.CpsCacheInfo.MediaInfo media_info = new cps_info.CpsCacheInfo.MediaInfo();
  public final PBRepeatMessageField<cps_info.PcgMediaTraceInfo> pcg_media_trace_infos = PBField.initRepeatMessage(cps_info.PcgMediaTraceInfo.class);
  public final PBRepeatMessageField<cps_info.ProductShareInfo> product_share_info = PBField.initRepeatMessage(cps_info.ProductShareInfo.class);
  public final PBStringField trace_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.gdt.cps_info.CpsCacheInfo
 * JD-Core Version:    0.7.0.1
 */