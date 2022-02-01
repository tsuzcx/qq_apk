package tencent.im.oidb.cmd0xca6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class WeatherReportStore$WeatherWarningDetail
  extends MessageMicro<WeatherWarningDetail>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField affect = PBField.initString("");
  public final PBUInt32Field area_id = PBField.initUInt32(0);
  public final PBStringField cancle_desc = PBField.initString("");
  public final PBStringField city = PBField.initString("");
  public final PBStringField content = PBField.initString("");
  public final PBStringField defend = PBField.initString("");
  public final PBStringField id = PBField.initString("");
  public final PBInt32Field level = PBField.initInt32(0);
  public final PBStringField level_name = PBField.initString("");
  public final PBInt32Field op_time = PBField.initInt32(0);
  public final PBStringField province = PBField.initString("");
  public final PBStringField pub_org = PBField.initString("");
  public final PBInt32Field pub_time = PBField.initInt32(0);
  public final PBInt32Field status = PBField.initInt32(0);
  public final PBInt32Field type = PBField.initInt32(0);
  public final PBStringField type_name = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50, 56, 64, 74, 82, 90, 98, 106, 114, 122, 130 }, new String[] { "id", "area_id", "type", "level", "status", "content", "pub_time", "op_time", "pub_org", "affect", "defend", "cancle_desc", "province", "city", "type_name", "level_name" }, new Object[] { "", localInteger, localInteger, localInteger, localInteger, "", localInteger, localInteger, "", "", "", "", "", "", "", "" }, WeatherWarningDetail.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xca6.WeatherReportStore.WeatherWarningDetail
 * JD-Core Version:    0.7.0.1
 */