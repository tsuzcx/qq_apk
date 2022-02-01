package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ark_form_data$ArkFormData$AdInfo$DestInfo
  extends MessageMicro<DestInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 26, 32 }, new String[] { "canvas_json", "dest_type" }, new Object[] { "", Integer.valueOf(0) }, DestInfo.class);
  public final PBStringField canvas_json = PBField.initString("");
  public final PBUInt32Field dest_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.ark_form_data.ArkFormData.AdInfo.DestInfo
 * JD-Core Version:    0.7.0.1
 */