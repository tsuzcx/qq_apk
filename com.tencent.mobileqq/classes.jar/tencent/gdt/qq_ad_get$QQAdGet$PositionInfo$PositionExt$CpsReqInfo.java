package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qq_ad_get$QQAdGet$PositionInfo$PositionExt$CpsReqInfo
  extends MessageMicro<CpsReqInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "product_id", "catelog_id", "product_link_info", "pcg_media_trace_info", "product_share_info" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), null, null, null }, CpsReqInfo.class);
  public final PBUInt64Field catelog_id = PBField.initUInt64(0L);
  public final PBRepeatMessageField<cps_info.PcgMediaTraceInfo> pcg_media_trace_info = PBField.initRepeatMessage(cps_info.PcgMediaTraceInfo.class);
  public final PBRepeatField<Long> product_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatMessageField<qq_ad_get.QQAdGet.PositionInfo.PositionExt.ProductLinkInfo> product_link_info = PBField.initRepeatMessage(qq_ad_get.QQAdGet.PositionInfo.PositionExt.ProductLinkInfo.class);
  public final PBRepeatMessageField<qq_ad_get.QQAdGet.PositionInfo.PositionExt.ProductShareInfo> product_share_info = PBField.initRepeatMessage(qq_ad_get.QQAdGet.PositionInfo.PositionExt.ProductShareInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt.CpsReqInfo
 * JD-Core Version:    0.7.0.1
 */