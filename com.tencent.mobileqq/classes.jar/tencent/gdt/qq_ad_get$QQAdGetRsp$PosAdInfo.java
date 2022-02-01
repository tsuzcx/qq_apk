package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qq_ad_get$QQAdGetRsp$PosAdInfo
  extends MessageMicro<PosAdInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<qq_ad_get.QQAdGetRsp.AdInfo> ads_info = PBField.initRepeatMessage(qq_ad_get.QQAdGetRsp.AdInfo.class);
  public final PBRepeatMessageField<qq_ad_get.QQAdGetRsp.ContractEmptyAdResponse> contract_empty_ad_response = PBField.initRepeatMessage(qq_ad_get.QQAdGetRsp.ContractEmptyAdResponse.class);
  public qq_ad_get.QQAdGetRsp.PosAdInfo.FrequencyInfo frequency_info = new qq_ad_get.QQAdGetRsp.PosAdInfo.FrequencyInfo();
  public final PBStringField msg = PBField.initString("");
  public indicator.NoAdIndicator no_ad_indicator = new indicator.NoAdIndicator();
  public final PBStringField pos_id = PBField.initString("");
  public final PBInt32Field report_type = PBField.initInt32(0);
  public final PBInt32Field ret = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 58, 802 }, new String[] { "ret", "msg", "pos_id", "ads_info", "no_ad_indicator", "report_type", "frequency_info", "contract_empty_ad_response" }, new Object[] { localInteger, "", "", null, null, localInteger, null, null }, PosAdInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo
 * JD-Core Version:    0.7.0.1
 */