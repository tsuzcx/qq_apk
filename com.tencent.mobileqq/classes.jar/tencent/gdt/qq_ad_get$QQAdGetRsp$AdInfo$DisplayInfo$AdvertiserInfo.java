package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo
  extends MessageMicro<AdvertiserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field ad_first_category = PBField.initUInt64(0L);
  public final PBUInt64Field ad_industry_id = PBField.initUInt64(0L);
  public final PBUInt64Field ad_second_category = PBField.initUInt64(0L);
  public final PBUInt64Field advertiser_id = PBField.initUInt64(0L);
  public final PBStringField corporate_image_name = PBField.initString("");
  public final PBStringField corporate_logo = PBField.initString("");
  public final PBStringField corporation_name = PBField.initString("");
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 56 }, new String[] { "corporation_name", "corporate_image_name", "corporate_logo", "advertiser_id", "ad_first_category", "ad_second_category", "ad_industry_id" }, new Object[] { "", "", "", localLong, localLong, localLong, localLong }, AdvertiserInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo
 * JD-Core Version:    0.7.0.1
 */