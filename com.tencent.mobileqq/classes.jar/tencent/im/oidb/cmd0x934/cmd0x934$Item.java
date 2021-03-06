package tencent.im.oidb.cmd0x934;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x934$Item
  extends MessageMicro<Item>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField desc = PBField.initString("");
  public final PBBoolField hot = PBField.initBool(false);
  public final PBUInt32Field id = PBField.initUInt32(0);
  public final PBUInt32Field is_receive = PBField.initUInt32(0);
  public final PBUInt32Field is_set = PBField.initUInt32(0);
  public final PBUInt64Field mark = PBField.initUInt64(0L);
  public cmd0x934.ItemInfo off_info = new cmd0x934.ItemInfo();
  public cmd0x934.ItemInfo on_info = new cmd0x934.ItemInfo();
  public final PBStringField setting_url = PBField.initString("");
  public final PBUInt32Field version = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 58, 66, 7992, 8000 }, new String[] { "off_info", "on_info", "hot", "id", "version", "mark", "setting_url", "desc", "is_set", "is_receive" }, new Object[] { null, null, Boolean.valueOf(false), localInteger, localInteger, Long.valueOf(0L), "", "", localInteger, localInteger }, Item.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x934.cmd0x934.Item
 * JD-Core Version:    0.7.0.1
 */