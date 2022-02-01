package common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QqAdGetProtos$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo
  extends MessageMicro<AdvertiserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48 }, new String[] { "corporation_name", "corporate_image_name", "corporate_logo", "advertiser_id", "ad_first_category", "ad_second_category" }, new Object[] { "", "", "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, AdvertiserInfo.class);
  public final PBUInt64Field ad_first_category = PBField.initUInt64(0L);
  public final PBUInt64Field ad_second_category = PBField.initUInt64(0L);
  public final PBUInt64Field advertiser_id = PBField.initUInt64(0L);
  public final PBStringField corporate_image_name = PBField.initString("");
  public final PBStringField corporate_logo = PBField.initString("");
  public final PBStringField corporation_name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     common.QqAdGetProtos.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo
 * JD-Core Version:    0.7.0.1
 */