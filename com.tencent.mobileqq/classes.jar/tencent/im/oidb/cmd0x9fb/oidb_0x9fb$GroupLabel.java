package tencent.im.oidb.cmd0x9fb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x9fb$GroupLabel
  extends MessageMicro<GroupLabel>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "uin_info", "uint32_number_label", "uint32_label_style" }, new Object[] { null, Integer.valueOf(5), Integer.valueOf(0) }, GroupLabel.class);
  public oidb_0x9fb.UinInfo uin_info = new oidb_0x9fb.UinInfo();
  public final PBUInt32Field uint32_label_style = PBField.initUInt32(0);
  public final PBUInt32Field uint32_number_label = PBField.initUInt32(5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9fb.oidb_0x9fb.GroupLabel
 * JD-Core Version:    0.7.0.1
 */