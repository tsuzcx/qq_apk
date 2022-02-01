package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudCity$GeoInfo
  extends MessageMicro<GeoInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField city = PBField.initString("");
  public final PBStringField cityCode = PBField.initString("");
  public final PBStringField country = PBField.initString("");
  public final PBStringField defaultName = PBField.initString("");
  public final PBStringField district = PBField.initString("");
  public final PBInt32Field districtCode = PBField.initInt32(0);
  public final PBBoolField isForeign = PBField.initBool(false);
  public final PBStringField nationalCode = PBField.initString("");
  public final PBStringField province = PBField.initString("");
  public final PBInt32Field range = PBField.initInt32(0);
  public final PBStringField road = PBField.initString("");
  public final PBStringField town = PBField.initString("");
  public final PBStringField village = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 104 }, new String[] { "districtCode", "range", "country", "province", "city", "district", "town", "village", "road", "defaultName", "cityCode", "nationalCode", "isForeign" }, new Object[] { localInteger, localInteger, "", "", "", "", "", "", "", "", "", "", Boolean.valueOf(false) }, GeoInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudCity.GeoInfo
 * JD-Core Version:    0.7.0.1
 */