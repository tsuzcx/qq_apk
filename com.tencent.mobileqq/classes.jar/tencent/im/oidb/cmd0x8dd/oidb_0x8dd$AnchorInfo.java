package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8dd$AnchorInfo
  extends MessageMicro<AnchorInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field love_game_id = PBField.initUInt32(0);
  public final PBStringField str_live_avatar_gif = PBField.initString("");
  public final PBStringField str_live_boardcast_gif = PBField.initString("");
  public final PBStringField str_live_jump_url = PBField.initString("");
  public final PBStringField str_live_wording = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_live_avatar_animation = PBField.initUInt32(0);
  public final PBUInt32Field uint32_live_flag = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 56, 64 }, new String[] { "uint32_live_flag", "str_live_jump_url", "str_live_avatar_gif", "str_live_boardcast_gif", "str_live_wording", "uint32_live_avatar_animation", "love_game_id", "type" }, new Object[] { localInteger, "", "", "", "", localInteger, localInteger, localInteger }, AnchorInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8dd.oidb_0x8dd.AnchorInfo
 * JD-Core Version:    0.7.0.1
 */