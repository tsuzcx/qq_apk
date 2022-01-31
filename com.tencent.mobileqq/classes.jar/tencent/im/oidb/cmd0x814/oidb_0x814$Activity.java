package tencent.im.oidb.cmd0x814;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0x814$Activity
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "id", "name", "cover", "url" }, new Object[] { "", "", "", "" }, Activity.class);
  public final PBStringField cover = PBField.initString("");
  public final PBStringField id = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x814.oidb_0x814.Activity
 * JD-Core Version:    0.7.0.1
 */