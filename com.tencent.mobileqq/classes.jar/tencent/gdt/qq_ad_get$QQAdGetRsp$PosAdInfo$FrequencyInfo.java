package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qq_ad_get$QQAdGetRsp$PosAdInfo$FrequencyInfo
  extends MessageMicro<FrequencyInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field exposure_frequency_time = PBField.initUInt32(0);
  public final PBUInt32Field request_frequency_time = PBField.initUInt32(0);
  public final PBUInt32Field request_frequency_time_adlimit = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "exposure_frequency_time", "request_frequency_time", "request_frequency_time_adlimit" }, new Object[] { localInteger, localInteger, localInteger }, FrequencyInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo.FrequencyInfo
 * JD-Core Version:    0.7.0.1
 */