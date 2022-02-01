package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$BasicInfo
  extends MessageMicro<BasicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field ad_type = PBField.initUInt32(0);
  public final PBStringField desc = PBField.initString("");
  public qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent element_structure_content = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent();
  public final PBRepeatField<String> hit_keywords = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField img = PBField.initString("");
  public final PBStringField img_s = PBField.initString("");
  public final PBBoolField is_mdpa_ad = PBField.initBool(false);
  public final PBBoolField is_preview_ad = PBField.initBool(false);
  public final PBStringField marketing_pendant = PBField.initString("");
  public final PBRepeatMessageField<qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.MaterialInfo> materials = PBField.initRepeatMessage(qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.MaterialInfo.class);
  public final PBUInt32Field pic_height = PBField.initUInt32(0);
  public final PBUInt32Field pic_width = PBField.initUInt32(0);
  public qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.QQBrowserExternalInfo qq_browser_ext_info = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.QQBrowserExternalInfo();
  public final PBStringField txt = PBField.initString("");
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 56, 66, 74, 82, 90, 98, 104, 112 }, new String[] { "img", "img_s", "txt", "desc", "pic_width", "pic_height", "ad_type", "element_structure_content", "marketing_pendant", "hit_keywords", "materials", "qq_browser_ext_info", "is_preview_ad", "is_mdpa_ad" }, new Object[] { "", "", "", "", localInteger, localInteger, localInteger, null, "", "", null, null, localBoolean, localBoolean }, BasicInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo
 * JD-Core Version:    0.7.0.1
 */