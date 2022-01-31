package tencent.im.group;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class group_member_info$MemberGameInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "str_game_name", "str_level_name", "str_level_icon", "str_game_font_color", "str_game_background_color", "str_game_url", "str_desc_info" }, new Object[] { "", "", "", "", "", "", "" }, MemberGameInfo.class);
  public final PBRepeatField str_desc_info = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField str_game_background_color = PBField.initString("");
  public final PBStringField str_game_font_color = PBField.initString("");
  public final PBStringField str_game_name = PBField.initString("");
  public final PBStringField str_game_url = PBField.initString("");
  public final PBStringField str_level_icon = PBField.initString("");
  public final PBStringField str_level_name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.group.group_member_info.MemberGameInfo
 * JD-Core Version:    0.7.0.1
 */