package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qq_ad_get$QQAdGet$PositionInfo$PositionExt$ProductLinkInfo
  extends MessageMicro<ProductLinkInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "product_id", "h5_page", "wx_miniprogram_link", "qq_miniprogram_link" }, new Object[] { Long.valueOf(0L), "", null, null }, ProductLinkInfo.class);
  public final PBStringField h5_page = PBField.initString("");
  public final PBUInt64Field product_id = PBField.initUInt64(0L);
  public qq_ad_get.QQAdGet.PositionInfo.PositionExt.MiniProgramLink qq_miniprogram_link = new qq_ad_get.QQAdGet.PositionInfo.PositionExt.MiniProgramLink();
  public qq_ad_get.QQAdGet.PositionInfo.PositionExt.MiniProgramLink wx_miniprogram_link = new qq_ad_get.QQAdGet.PositionInfo.PositionExt.MiniProgramLink();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt.ProductLinkInfo
 * JD-Core Version:    0.7.0.1
 */