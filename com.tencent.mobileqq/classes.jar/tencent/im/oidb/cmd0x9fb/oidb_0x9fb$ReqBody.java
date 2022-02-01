package tencent.im.oidb.cmd0x9fb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x9fb$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int32_channel = PBField.initInt32(0);
  public oidb_0x9fb.GroupLabel msg_group_label = new oidb_0x9fb.GroupLabel();
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmdid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_reason = PBField.initUInt32(0);
  public final PBUInt64Field uint64_last_group_code = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48 }, new String[] { "uint32_appid", "uint32_cmdid", "int32_channel", "uint64_last_group_code", "msg_group_label", "uint32_reason" }, new Object[] { localInteger, localInteger, localInteger, Long.valueOf(0L), null, localInteger }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9fb.oidb_0x9fb.ReqBody
 * JD-Core Version:    0.7.0.1
 */