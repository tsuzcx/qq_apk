package tencent.im.cs.video.voip;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hd_video_voip2$CmdPhoneSpeedTestRsp$IPSpeedSvrInfo
  extends MessageMicro<IPSpeedSvrInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 16 }, new String[] { "fixed32_server_ip", "uint32_server_port" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, IPSpeedSvrInfo.class);
  public final PBFixed32Field fixed32_server_ip = PBField.initFixed32(0);
  public final PBUInt32Field uint32_server_port = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.video.voip.hd_video_voip2.CmdPhoneSpeedTestRsp.IPSpeedSvrInfo
 * JD-Core Version:    0.7.0.1
 */