package tencent.im.cs.longconn.voip;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hd_video_voip_2$CmdGetCallTypeReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uint32_from_flag", "msg_from_tel", "msg_to_tel", "uint32_call_policy" }, new Object[] { Integer.valueOf(0), null, null, Integer.valueOf(0) }, CmdGetCallTypeReqBody.class);
  public hd_video_voip_2.TelInfo msg_from_tel = new hd_video_voip_2.TelInfo();
  public hd_video_voip_2.TelInfo msg_to_tel = new hd_video_voip_2.TelInfo();
  public final PBUInt32Field uint32_call_policy = PBField.initUInt32(0);
  public final PBUInt32Field uint32_from_flag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.cs.longconn.voip.hd_video_voip_2.CmdGetCallTypeReqBody
 * JD-Core Version:    0.7.0.1
 */