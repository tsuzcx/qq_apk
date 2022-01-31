package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qq_ad_get$QQAdGet$PositionInfo$PositionExt
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "share_info", "deep_link_version" }, new Object[] { null, Integer.valueOf(0) }, PositionExt.class);
  public final PBUInt32Field deep_link_version = PBField.initUInt32(0);
  public qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo share_info = new qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt
 * JD-Core Version:    0.7.0.1
 */