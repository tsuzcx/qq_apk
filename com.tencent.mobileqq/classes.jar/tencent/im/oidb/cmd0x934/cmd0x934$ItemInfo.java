package tencent.im.oidb.cmd0x934;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd0x934$ItemInfo
  extends MessageMicro<ItemInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "title", "icon", "url", "color", "font_color", "border_color" }, new Object[] { "", "", "", "", "", "" }, ItemInfo.class);
  public final PBStringField border_color = PBField.initString("");
  public final PBStringField color = PBField.initString("");
  public final PBStringField font_color = PBField.initString("");
  public final PBStringField icon = PBField.initString("");
  public final PBStringField title = PBField.initString("");
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x934.cmd0x934.ItemInfo
 * JD-Core Version:    0.7.0.1
 */