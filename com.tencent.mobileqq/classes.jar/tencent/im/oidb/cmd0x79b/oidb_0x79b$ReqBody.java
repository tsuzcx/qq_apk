package tencent.im.oidb.cmd0x79b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

public final class oidb_0x79b$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 58 }, new String[] { "uint64_group_code", "info", "uint32_source", "uint32_notify_aio_flag", "uint32_tribe_type", "uint64_tribe_id", "str_tribe_name" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "" }, ReqBody.class);
  public oidb_0x88d.GroupInfo info = new oidb_0x88d.GroupInfo();
  public final PBStringField str_tribe_name = PBField.initString("");
  public final PBUInt32Field uint32_notify_aio_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_source = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tribe_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_tribe_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x79b.oidb_0x79b.ReqBody
 * JD-Core Version:    0.7.0.1
 */