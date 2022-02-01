package tencent.im.oidb.cmd0xc76;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_cmd0xc76$Setting
  extends MessageMicro<Setting>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "desc", "item" }, new Object[] { "", null }, Setting.class);
  public final PBStringField desc = PBField.initString("");
  public final PBRepeatMessageField<oidb_cmd0xc76.Item> item = PBField.initRepeatMessage(oidb_cmd0xc76.Item.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc76.oidb_cmd0xc76.Setting
 * JD-Core Version:    0.7.0.1
 */