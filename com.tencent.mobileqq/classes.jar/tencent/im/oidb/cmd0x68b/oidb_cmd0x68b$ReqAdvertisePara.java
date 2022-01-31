package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x68b$ReqAdvertisePara
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint64_channel_id", "msg_phone_info", "uint64_last_time" }, new Object[] { Long.valueOf(0L), null, Long.valueOf(0L) }, ReqAdvertisePara.class);
  public oidb_cmd0x68b.PhoneInfo msg_phone_info = new oidb_cmd0x68b.PhoneInfo();
  public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_last_time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqAdvertisePara
 * JD-Core Version:    0.7.0.1
 */