package tencent.im.oidb.cmd0xcd1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class Oidb_0xcd1$EmptyPackagePage
  extends MessageMicro<EmptyPackagePage>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "enable", "wording", "jump_wording", "jump_url" }, new Object[] { Integer.valueOf(0), "", "", "" }, EmptyPackagePage.class);
  public final PBInt32Field enable = PBField.initInt32(0);
  public final PBStringField jump_url = PBField.initString("");
  public final PBStringField jump_wording = PBField.initString("");
  public final PBStringField wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcd1.Oidb_0xcd1.EmptyPackagePage
 * JD-Core Version:    0.7.0.1
 */