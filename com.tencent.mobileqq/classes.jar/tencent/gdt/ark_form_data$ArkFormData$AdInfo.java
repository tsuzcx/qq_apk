package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ark_form_data$ArkFormData$AdInfo
  extends MessageMicro<AdInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "product_type", "display_info", "report_info", "dest_info" }, new Object[] { Integer.valueOf(0), null, null, null }, AdInfo.class);
  public qq_ad_get.QQAdGetRsp.AdInfo.DestInfo dest_info = new qq_ad_get.QQAdGetRsp.AdInfo.DestInfo();
  public qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo display_info = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo();
  public final PBUInt32Field product_type = PBField.initUInt32(0);
  public qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo report_info = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.gdt.ark_form_data.ArkFormData.AdInfo
 * JD-Core Version:    0.7.0.1
 */