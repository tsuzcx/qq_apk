package tencent.im.oidb.cmd0xb31;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xb31$SimilarItem
  extends MessageMicro<SimilarItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 64 }, new String[] { "type", "title", "name", "url", "jump_url", "sub_title", "icon_url", "show_both_head" }, new Object[] { Integer.valueOf(1), "", "", "", "", "", "", Integer.valueOf(0) }, SimilarItem.class);
  public final PBStringField icon_url = PBField.initString("");
  public final PBStringField jump_url = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBUInt32Field show_both_head = PBField.initUInt32(0);
  public final PBStringField sub_title = PBField.initString("");
  public final PBStringField title = PBField.initString("");
  public final PBEnumField type = PBField.initEnum(1);
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb31.oidb_0xb31.SimilarItem
 * JD-Core Version:    0.7.0.1
 */