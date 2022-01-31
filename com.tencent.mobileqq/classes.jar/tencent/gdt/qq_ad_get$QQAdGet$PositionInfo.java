package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qq_ad_get$QQAdGet$PositionInfo
  extends MessageMicro<PositionInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "pos_id", "ad_count", "pos_ext" }, new Object[] { "", Integer.valueOf(0), null }, PositionInfo.class);
  public final PBUInt32Field ad_count = PBField.initUInt32(0);
  public qq_ad_get.QQAdGet.PositionInfo.PositionExt pos_ext = new qq_ad_get.QQAdGet.PositionInfo.PositionExt();
  public final PBStringField pos_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGet.PositionInfo
 * JD-Core Version:    0.7.0.1
 */