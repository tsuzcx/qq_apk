package tencent.im.oidb.cmd0xb77;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xb77$TemplateItem
  extends MessageMicro<TemplateItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "key", "type", "value" }, new Object[] { "", Integer.valueOf(0), "" }, TemplateItem.class);
  public final PBStringField key = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBStringField value = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.TemplateItem
 * JD-Core Version:    0.7.0.1
 */