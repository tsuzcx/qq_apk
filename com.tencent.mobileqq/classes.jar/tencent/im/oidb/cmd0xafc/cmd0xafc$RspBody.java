package tencent.im.oidb.cmd0xafc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.NearbyConfig;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.SelfInfo;

public final class cmd0xafc$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_heart_beat_interval", "msg_self_info", "msg_config" }, new Object[] { Integer.valueOf(0), null, null }, RspBody.class);
  public oidb_0x8dd.NearbyConfig msg_config = new oidb_0x8dd.NearbyConfig();
  public oidb_0x8dd.SelfInfo msg_self_info = new oidb_0x8dd.SelfInfo();
  public final PBUInt32Field uint32_heart_beat_interval = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xafc.cmd0xafc.RspBody
 * JD-Core Version:    0.7.0.1
 */