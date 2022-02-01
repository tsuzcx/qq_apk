package tencent.im.s2c.msgtype0x210.submsgtype0x146;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class submsgtype0x146$TabData
  extends MessageMicro<TabData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField first_show = PBField.initBool(false);
  public final PBUInt32Field tab_id = PBField.initUInt32(0);
  public final PBEnumField tab_status = PBField.initEnum(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "tab_id", "tab_status", "first_show" }, new Object[] { localInteger, localInteger, Boolean.valueOf(false) }, TabData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x146.submsgtype0x146.TabData
 * JD-Core Version:    0.7.0.1
 */