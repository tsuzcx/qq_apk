package common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QqAdGetProtos$QQAdGet$PositionInfo$PositionExt$CpsReqInfo
  extends MessageMicro<CpsReqInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field catelog_id = PBField.initUInt64(0L);
  public final PBRepeatMessageField<QqAdGetProtos.PcgMediaTraceInfo> pcg_media_trace_info = PBField.initRepeatMessage(QqAdGetProtos.PcgMediaTraceInfo.class);
  public final PBRepeatField<Long> product_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatMessageField<QqAdGetProtos.QQAdGet.PositionInfo.PositionExt.ProductLinkInfo> product_link_info = PBField.initRepeatMessage(QqAdGetProtos.QQAdGet.PositionInfo.PositionExt.ProductLinkInfo.class);
  public final PBRepeatMessageField<QqAdGetProtos.QQAdGet.PositionInfo.PositionExt.ProductShareInfo> product_share_info = PBField.initRepeatMessage(QqAdGetProtos.QQAdGet.PositionInfo.PositionExt.ProductShareInfo.class);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "product_id", "catelog_id", "product_link_info", "pcg_media_trace_info", "product_share_info" }, new Object[] { localLong, localLong, null, null, null }, CpsReqInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     common.QqAdGetProtos.QQAdGet.PositionInfo.PositionExt.CpsReqInfo
 * JD-Core Version:    0.7.0.1
 */