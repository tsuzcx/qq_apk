package common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QqAdGetProtos$QQAdGet$PositionInfo$PositionExt$ShareInfo
  extends MessageMicro<ShareInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "share_rate", "share_check" }, new Object[] { Integer.valueOf(0), "" }, ShareInfo.class);
  public final PBStringField share_check = PBField.initString("");
  public final PBUInt32Field share_rate = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     common.QqAdGetProtos.QQAdGet.PositionInfo.PositionExt.ShareInfo
 * JD-Core Version:    0.7.0.1
 */