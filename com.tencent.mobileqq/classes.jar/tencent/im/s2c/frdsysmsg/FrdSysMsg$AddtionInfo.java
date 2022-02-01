package tencent.im.s2c.frdsysmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FrdSysMsg$AddtionInfo
  extends MessageMicro<AddtionInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "uint32_poke", "uint32_format", "str_entity_category", "str_entity_name", "str_entity_url" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", "" }, AddtionInfo.class);
  public final PBStringField str_entity_category = PBField.initString("");
  public final PBStringField str_entity_name = PBField.initString("");
  public final PBStringField str_entity_url = PBField.initString("");
  public final PBUInt32Field uint32_format = PBField.initUInt32(0);
  public final PBUInt32Field uint32_poke = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.frdsysmsg.FrdSysMsg.AddtionInfo
 * JD-Core Version:    0.7.0.1
 */