package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_msg_head$InstInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 80 }, new String[] { "uint32_apppid", "uint32_instid", "uint32_platform", "enum_device_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, InstInfo.class);
  public final PBEnumField enum_device_type = PBField.initEnum(0);
  public final PBUInt32Field uint32_apppid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_instid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_platform = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_head.InstInfo
 * JD-Core Version:    0.7.0.1
 */