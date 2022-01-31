package tencent.im.cs.longconn.voip;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hd_video_voip_2$CmdPhoneSpeedTestRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 82 }, new String[] { "uint32_result", "uint32_test_type", "uint32_pkglen", "uint32_pkgnum_per_second", "uint32_sendpkg_keep_time", "uint32_ping_interval_time", "uint32_ping_cnt", "uint32_ping_packet_size", "uint32_server_interval", "rpt_msg_ipspeed_info_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, CmdPhoneSpeedTestRsp.class);
  public final PBRepeatMessageField rpt_msg_ipspeed_info_list = PBField.initRepeatMessage(hd_video_voip_2.CmdPhoneSpeedTestRsp.IPSpeedSvrInfo.class);
  public final PBUInt32Field uint32_ping_cnt = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ping_interval_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ping_packet_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pkglen = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pkgnum_per_second = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sendpkg_keep_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_server_interval = PBField.initUInt32(0);
  public final PBUInt32Field uint32_test_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.cs.longconn.voip.hd_video_voip_2.CmdPhoneSpeedTestRsp
 * JD-Core Version:    0.7.0.1
 */