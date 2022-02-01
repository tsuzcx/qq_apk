package tencent.im.oidb.cmd0x59f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0x59f$WelcomePage
  extends MessageMicro<WelcomePage>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 98, 106, 242 }, new String[] { "str_big_photo_url", "str_big_photo_wording", "str_welcome_msg", "rpt_menu_list" }, new Object[] { "", "", "", null }, WelcomePage.class);
  public final PBRepeatMessageField<oidb_0x59f.WelcomeMenu> rpt_menu_list = PBField.initRepeatMessage(oidb_0x59f.WelcomeMenu.class);
  public final PBStringField str_big_photo_url = PBField.initString("");
  public final PBStringField str_big_photo_wording = PBField.initString("");
  public final PBStringField str_welcome_msg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x59f.oidb_0x59f.WelcomePage
 * JD-Core Version:    0.7.0.1
 */