package tencent.im.oidb.cmd0x91b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

public final class cmd0x91b$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "uint64_group_code", "info", "uint32_source", "uint32_notify_aio_flag", "str_user_data" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0), Integer.valueOf(0), "" }, ReqBody.class);
  public oidb_0x88d.GroupInfo info = new oidb_0x88d.GroupInfo();
  public final PBStringField str_user_data = PBField.initString("");
  public final PBUInt32Field uint32_notify_aio_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_source = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x91b.cmd0x91b.ReqBody
 * JD-Core Version:    0.7.0.1
 */