package tencent.im.cs.longconn.voip;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hd_video_voip_2$SpeedTestInfo
  extends MessageMicro<SpeedTestInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "uint32_total_pkg", "uint32_real_recv_pkg", "uint32_delay", "uint32_jitter", "uint32_loss_continue", "uint32_estimate_bandwidth" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SpeedTestInfo.class);
  public final PBUInt32Field uint32_delay = PBField.initUInt32(0);
  public final PBUInt32Field uint32_estimate_bandwidth = PBField.initUInt32(0);
  public final PBUInt32Field uint32_jitter = PBField.initUInt32(0);
  public final PBUInt32Field uint32_loss_continue = PBField.initUInt32(0);
  public final PBUInt32Field uint32_real_recv_pkg = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total_pkg = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.longconn.voip.hd_video_voip_2.SpeedTestInfo
 * JD-Core Version:    0.7.0.1
 */