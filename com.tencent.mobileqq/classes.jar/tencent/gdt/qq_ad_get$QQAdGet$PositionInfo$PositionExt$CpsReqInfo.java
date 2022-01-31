package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qq_ad_get$QQAdGet$PositionInfo$PositionExt$CpsReqInfo
  extends MessageMicro<CpsReqInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16 }, new String[] { "catelog_id" }, new Object[] { Long.valueOf(0L) }, CpsReqInfo.class);
  public final PBUInt64Field catelog_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt.CpsReqInfo
 * JD-Core Version:    0.7.0.1
 */