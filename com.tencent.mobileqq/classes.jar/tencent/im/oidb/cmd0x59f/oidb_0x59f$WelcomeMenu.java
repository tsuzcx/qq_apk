package tencent.im.oidb.cmd0x59f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x59f$WelcomeMenu
  extends MessageMicro<WelcomeMenu>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 88, 98, 106, 114 }, new String[] { "uint32_id", "str_icon_url", "str_wording", "str_target_url" }, new Object[] { Integer.valueOf(0), "", "", "" }, WelcomeMenu.class);
  public final PBStringField str_icon_url = PBField.initString("");
  public final PBStringField str_target_url = PBField.initString("");
  public final PBStringField str_wording = PBField.initString("");
  public final PBUInt32Field uint32_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x59f.oidb_0x59f.WelcomeMenu
 * JD-Core Version:    0.7.0.1
 */