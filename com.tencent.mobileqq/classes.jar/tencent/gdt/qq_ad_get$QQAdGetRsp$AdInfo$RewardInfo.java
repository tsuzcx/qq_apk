package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qq_ad_get$QQAdGetRsp$AdInfo$RewardInfo
  extends MessageMicro<RewardInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field reward_time = PBField.initUInt32(0);
  public final PBUInt32Field sdk_report_interval = PBField.initUInt32(0);
  public final PBStringField sdk_report_url = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "reward_time", "sdk_report_url", "sdk_report_interval" }, new Object[] { localInteger, "", localInteger }, RewardInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.RewardInfo
 * JD-Core Version:    0.7.0.1
 */