package tencent.im.oidb.cmd0x89a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x89a$GroupExInfoOnly
  extends MessageMicro<GroupExInfoOnly>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_money_for_add_group = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tribe_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_tribe_id", "uint32_money_for_add_group" }, new Object[] { localInteger, localInteger }, GroupExInfoOnly.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x89a.oidb_0x89a.GroupExInfoOnly
 * JD-Core Version:    0.7.0.1
 */