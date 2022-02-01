package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ark_form_data$ArkFormData$FormInfo
  extends MessageMicro<FormInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "form_module_id", "index" }, new Object[] { "", Integer.valueOf(0) }, FormInfo.class);
  public final PBStringField form_module_id = PBField.initString("");
  public final PBUInt32Field index = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.gdt.ark_form_data.ArkFormData.FormInfo
 * JD-Core Version:    0.7.0.1
 */