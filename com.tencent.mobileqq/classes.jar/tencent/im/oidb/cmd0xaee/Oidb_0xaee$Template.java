package tencent.im.oidb.cmd0xaee;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0xaee$Template
  extends MessageMicro<Template>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50, 58, 66, 72, 160 }, new String[] { "template_id", "template_name", "group_type", "mob_thumb_url", "mob_prev_url", "web_thumb_url", "web_prev_url", "template_url", "doc_type", "group_code" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), "", "", "", "", "", Integer.valueOf(0), Long.valueOf(0L) }, Template.class);
  public final PBUInt32Field doc_type = PBField.initUInt32(0);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBUInt32Field group_type = PBField.initUInt32(0);
  public final PBStringField mob_prev_url = PBField.initString("");
  public final PBStringField mob_thumb_url = PBField.initString("");
  public final PBUInt32Field template_id = PBField.initUInt32(0);
  public final PBStringField template_name = PBField.initString("");
  public final PBStringField template_url = PBField.initString("");
  public final PBStringField web_prev_url = PBField.initString("");
  public final PBStringField web_thumb_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xaee.Oidb_0xaee.Template
 * JD-Core Version:    0.7.0.1
 */