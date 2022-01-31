package tencent.im.oidb.cmd0x88d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x88d$GroupExInfoOnly
  extends MessageMicro<GroupExInfoOnly>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_tribe_id", "uint32_money_for_add_group" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GroupExInfoOnly.class);
  public final PBUInt32Field uint32_money_for_add_group = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tribe_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupExInfoOnly
 * JD-Core Version:    0.7.0.1
 */