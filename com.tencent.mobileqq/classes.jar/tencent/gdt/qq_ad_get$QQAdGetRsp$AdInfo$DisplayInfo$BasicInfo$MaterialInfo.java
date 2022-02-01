package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$BasicInfo$MaterialInfo
  extends MessageMicro<MaterialInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "search_txt", "search_desc", "image_url", "click_url", "price", "title" }, new Object[] { "", "", "", "", "", "" }, MaterialInfo.class);
  public final PBStringField click_url = PBField.initString("");
  public final PBStringField image_url = PBField.initString("");
  public final PBStringField price = PBField.initString("");
  public final PBStringField search_desc = PBField.initString("");
  public final PBStringField search_txt = PBField.initString("");
  public final PBStringField title = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.MaterialInfo
 * JD-Core Version:    0.7.0.1
 */