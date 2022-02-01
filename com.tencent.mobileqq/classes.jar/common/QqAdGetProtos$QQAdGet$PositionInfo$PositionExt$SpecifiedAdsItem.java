package common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QqAdGetProtos$QQAdGet$PositionInfo$PositionExt$SpecifiedAdsItem
  extends MessageMicro<SpecifiedAdsItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "aid", "creative_id", "prefetch_timestamp" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, SpecifiedAdsItem.class);
  public final PBUInt64Field aid = PBField.initUInt64(0L);
  public final PBUInt64Field creative_id = PBField.initUInt64(0L);
  public final PBUInt32Field prefetch_timestamp = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     common.QqAdGetProtos.QQAdGet.PositionInfo.PositionExt.SpecifiedAdsItem
 * JD-Core Version:    0.7.0.1
 */