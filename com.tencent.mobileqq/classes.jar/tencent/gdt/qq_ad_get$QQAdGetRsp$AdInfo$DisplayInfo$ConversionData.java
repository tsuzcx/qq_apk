package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$ConversionData
  extends MessageMicro<ConversionData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "conversion_desc", "conversion_target_type" }, new Object[] { "", Integer.valueOf(0) }, ConversionData.class);
  public final PBStringField conversion_desc = PBField.initString("");
  public final PBInt32Field conversion_target_type = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ConversionData
 * JD-Core Version:    0.7.0.1
 */