package tencent.im.oidb.cmd0x934;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class cmd0x934$Item
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "off_info", "on_info", "hot" }, new Object[] { null, null, Boolean.valueOf(false) }, Item.class);
  public final PBBoolField hot = PBField.initBool(false);
  public cmd0x934.ItemInfo off_info = new cmd0x934.ItemInfo();
  public cmd0x934.ItemInfo on_info = new cmd0x934.ItemInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x934.cmd0x934.Item
 * JD-Core Version:    0.7.0.1
 */