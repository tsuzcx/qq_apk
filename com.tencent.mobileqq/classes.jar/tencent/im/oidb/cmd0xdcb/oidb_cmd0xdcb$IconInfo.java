package tencent.im.oidb.cmd0xdcb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xdcb$IconInfo
  extends MessageMicro<IconInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "feeds_msg_icon_url", "feeds_default_icon_url", "uint32_is_use_gif", "str_jump_schema" }, new Object[] { "", "", Integer.valueOf(0), "" }, IconInfo.class);
  public final PBStringField feeds_default_icon_url = PBField.initString("");
  public final PBStringField feeds_msg_icon_url = PBField.initString("");
  public final PBStringField str_jump_schema = PBField.initString("");
  public final PBUInt32Field uint32_is_use_gif = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdcb.oidb_cmd0xdcb.IconInfo
 * JD-Core Version:    0.7.0.1
 */