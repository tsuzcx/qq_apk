package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class ark_form_data$ArkFormData
  extends MessageMicro<ArkFormData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ad_info", "form_info" }, new Object[] { null, null }, ArkFormData.class);
  public qq_ad_get.QQAdGetRsp.AdInfo ad_info = new qq_ad_get.QQAdGetRsp.AdInfo();
  public ark_form_data.ArkFormData.FormInfo form_info = new ark_form_data.ArkFormData.FormInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.gdt.ark_form_data.ArkFormData
 * JD-Core Version:    0.7.0.1
 */