package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TroopTips0x857$MediaChangePushInfo$PersonalSetting
  extends MessageMicro<PersonalSetting>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_theme_id", "uint32_player_id", "uint32_font_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, PersonalSetting.class);
  public final PBUInt32Field uint32_font_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_player_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_theme_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857.MediaChangePushInfo.PersonalSetting
 * JD-Core Version:    0.7.0.1
 */