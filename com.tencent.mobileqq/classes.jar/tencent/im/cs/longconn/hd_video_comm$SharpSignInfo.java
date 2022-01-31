package tencent.im.cs.longconn;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hd_video_comm$SharpSignInfo
  extends MessageMicro<SharpSignInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 98, 106, 112, 122 }, new String[] { "uint64_uin", "uint32_business_type", "uint64_business_id", "uint64_roomId", "uint32_timestamp", "uint32_timeout", "uint32_clientseq", "uint32_interface_ip", "uint32_interface_port", "uint32_engine_ip", "uint32_engine_port", "msg_initiator_addr", "rpt_receiver_addr", "uint32_client_ip", "msg_crypt_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, Integer.valueOf(0), null }, SharpSignInfo.class);
  public hd_video_comm.CryptInfo msg_crypt_info = new hd_video_comm.CryptInfo();
  public hd_video_comm.AddrInfo msg_initiator_addr = new hd_video_comm.AddrInfo();
  public final PBRepeatMessageField<hd_video_comm.AddrInfo> rpt_receiver_addr = PBField.initRepeatMessage(hd_video_comm.AddrInfo.class);
  public final PBUInt32Field uint32_business_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_client_ip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_clientseq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_engine_ip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_engine_port = PBField.initUInt32(0);
  public final PBUInt32Field uint32_interface_ip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_interface_port = PBField.initUInt32(0);
  public final PBUInt32Field uint32_timeout = PBField.initUInt32(0);
  public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
  public final PBUInt64Field uint64_business_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_roomId = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.cs.longconn.hd_video_comm.SharpSignInfo
 * JD-Core Version:    0.7.0.1
 */