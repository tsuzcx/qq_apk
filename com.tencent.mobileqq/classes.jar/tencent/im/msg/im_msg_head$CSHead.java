package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_msg_head$CSHead
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 85, 88, 101, 104, 117, 120, 133, 136, 149, 152, 160, 168, 176, 184, 192 }, new String[] { "uint64_uin", "uint32_command", "uint32_seq", "uint32_version", "uint32_retry_times", "uint32_client_type", "uint32_pubno", "uint32_localid", "uint32_timezone", "uint32_client_ip", "uint32_client_port", "uint32_conn_ip", "uint32_conn_port", "uint32_interface_ip", "uint32_interface_port", "uint32_actual_ip", "uint32_flag", "uint32_timestamp", "uint32_subcmd", "uint32_result", "uint32_app_id", "uint32_instance_id", "uint64_session_id", "uint32_idc_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, CSHead.class);
  public final PBFixed32Field uint32_actual_ip = PBField.initFixed32(0);
  public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
  public final PBFixed32Field uint32_client_ip = PBField.initFixed32(0);
  public final PBUInt32Field uint32_client_port = PBField.initUInt32(0);
  public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_command = PBField.initUInt32(0);
  public final PBFixed32Field uint32_conn_ip = PBField.initFixed32(0);
  public final PBUInt32Field uint32_conn_port = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_idc_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_instance_id = PBField.initUInt32(0);
  public final PBFixed32Field uint32_interface_ip = PBField.initFixed32(0);
  public final PBUInt32Field uint32_interface_port = PBField.initUInt32(0);
  public final PBUInt32Field uint32_localid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pubno = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt32Field uint32_retry_times = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  public final PBFixed32Field uint32_timestamp = PBField.initFixed32(0);
  public final PBUInt32Field uint32_timezone = PBField.initUInt32(0);
  public final PBUInt32Field uint32_version = PBField.initUInt32(0);
  public final PBUInt64Field uint64_session_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_head.CSHead
 * JD-Core Version:    0.7.0.1
 */