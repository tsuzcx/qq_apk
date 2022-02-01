package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$BasicInfo$CreativeElementStructureContent$Label
  extends MessageMicro<Label>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 48, 56, 64 }, new String[] { "coordinate_x", "coordinate_y", "content", "direction", "landing_page_url", "angle", "percent", "order" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Label.class);
  public final PBUInt32Field angle = PBField.initUInt32(0);
  public final PBStringField content = PBField.initString("");
  public final PBUInt32Field coordinate_x = PBField.initUInt32(0);
  public final PBUInt32Field coordinate_y = PBField.initUInt32(0);
  public final PBEnumField direction = PBField.initEnum(0);
  public final PBStringField landing_page_url = PBField.initString("");
  public final PBUInt32Field order = PBField.initUInt32(0);
  public final PBUInt32Field percent = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent.Label
 * JD-Core Version:    0.7.0.1
 */