package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ark_form_data$ArkFormData$AdInfo$DisplayInfo$AdvertiserInfo
  extends MessageMicro<AdvertiserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 32 }, new String[] { "advertiser_id" }, new Object[] { Long.valueOf(0L) }, AdvertiserInfo.class);
  public final PBUInt64Field advertiser_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.gdt.ark_form_data.ArkFormData.AdInfo.DisplayInfo.AdvertiserInfo
 * JD-Core Version:    0.7.0.1
 */