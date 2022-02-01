package tencent.im.s2c.msgtype0x210.submsgtype0x11f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x11f$PersonalSetting
  extends MessageMicro<PersonalSetting>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_font_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_player_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_theme_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_theme_id", "uint32_player_id", "uint32_font_id" }, new Object[] { localInteger, localInteger, localInteger }, PersonalSetting.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x11f.SubMsgType0x11f.PersonalSetting
 * JD-Core Version:    0.7.0.1
 */