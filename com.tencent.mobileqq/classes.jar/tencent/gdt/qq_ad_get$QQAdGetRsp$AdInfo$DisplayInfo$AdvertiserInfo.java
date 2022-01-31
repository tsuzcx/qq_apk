package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "corporation_name", "corporate_image_name", "corporate_logo" }, new Object[] { "", "", "" }, AdvertiserInfo.class);
  public final PBStringField corporate_image_name = PBField.initString("");
  public final PBStringField corporate_logo = PBField.initString("");
  public final PBStringField corporation_name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo
 * JD-Core Version:    0.7.0.1
 */