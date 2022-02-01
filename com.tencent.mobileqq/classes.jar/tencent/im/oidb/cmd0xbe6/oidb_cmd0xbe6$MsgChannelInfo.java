package tencent.im.oidb.cmd0xbe6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xbe6$MsgChannelInfo
  extends MessageMicro<MsgChannelInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "string_name", "uint32_channel_id", "uint32_channel_type" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0) }, MsgChannelInfo.class);
  public final PBStringField string_name = PBField.initString("");
  public final PBUInt32Field uint32_channel_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_channel_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbe6.oidb_cmd0xbe6.MsgChannelInfo
 * JD-Core Version:    0.7.0.1
 */