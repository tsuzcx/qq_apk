package tencent.im.oidb.cmd0x983;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x983$AddonItem
  extends MessageMicro<AddonItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_addon_id" }, new Object[] { Integer.valueOf(0) }, AddonItem.class);
  public final PBUInt32Field uint32_addon_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x983.oidb_cmd0x983.AddonItem
 * JD-Core Version:    0.7.0.1
 */