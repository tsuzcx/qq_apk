package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$BasicInfo
  extends MessageMicro<BasicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field ad_type = PBField.initUInt32(0);
  public final PBStringField desc = PBField.initString("");
  public qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent element_structure_content = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent();
  public final PBStringField img = PBField.initString("");
  public final PBStringField img_s = PBField.initString("");
  public final PBStringField marketing_pendant = PBField.initString("");
  public final PBUInt32Field pic_height = PBField.initUInt32(0);
  public final PBUInt32Field pic_width = PBField.initUInt32(0);
  public final PBStringField txt = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 56, 66, 74 }, new String[] { "img", "img_s", "txt", "desc", "pic_width", "pic_height", "ad_type", "element_structure_content", "marketing_pendant" }, new Object[] { "", "", "", "", localInteger, localInteger, localInteger, null, "" }, BasicInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo
 * JD-Core Version:    0.7.0.1
 */