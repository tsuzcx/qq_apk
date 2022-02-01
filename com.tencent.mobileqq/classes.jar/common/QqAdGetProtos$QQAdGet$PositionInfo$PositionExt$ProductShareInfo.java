package common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QqAdGetProtos$QQAdGet$PositionInfo$PositionExt$ProductShareInfo
  extends MessageMicro<ProductShareInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "product_id", "share_info" }, new Object[] { Long.valueOf(0L), null }, ProductShareInfo.class);
  public final PBUInt64Field product_id = PBField.initUInt64(0L);
  public QqAdGetProtos.QQAdGet.PositionInfo.PositionExt.ShareInfo share_info = new QqAdGetProtos.QQAdGet.PositionInfo.PositionExt.ShareInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     common.QqAdGetProtos.QQAdGet.PositionInfo.PositionExt.ProductShareInfo
 * JD-Core Version:    0.7.0.1
 */