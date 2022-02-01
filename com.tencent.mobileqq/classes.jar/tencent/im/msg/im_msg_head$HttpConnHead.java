package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_msg_head$HttpConnHead
  extends MessageMicro<HttpConnHead>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public im_msg_head.TransOidbHead msg_oidbhead = new im_msg_head.TransOidbHead();
  public im_msg_head.RedirectMsg msg_redirect = new im_msg_head.RedirectMsg();
  public final PBFixed32Field uint32_client_ip = PBField.initFixed32(0);
  public final PBUInt32Field uint32_client_port = PBField.initUInt32(0);
  public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_command = PBField.initUInt32(0);
  public final PBUInt32Field uint32_command_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_compress_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_local_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_origin_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pub_no = PBField.initUInt32(0);
  public final PBFixed32Field uint32_qzhttp_ip = PBField.initFixed32(0);
  public final PBUInt32Field uint32_qzhttp_port = PBField.initUInt32(0);
  public final PBUInt32Field uint32_retry_times = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_service_cmdid = PBField.initUInt32(0);
  public final PBFixed32Field uint32_spp_ip = PBField.initFixed32(0);
  public final PBUInt32Field uint32_spp_port = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sub_command = PBField.initUInt32(0);
  public final PBUInt32Field uint32_time_zone = PBField.initUInt32(0);
  public final PBUInt32Field uint32_version = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 93, 96, 109, 112, 125, 128, 136, 146, 152, 160, 168, 178, 184, 192, 202 }, new String[] { "uint64_uin", "uint32_command", "uint32_sub_command", "uint32_seq", "uint32_version", "uint32_retry_times", "uint32_client_type", "uint32_pub_no", "uint32_local_id", "uint32_time_zone", "uint32_client_ip", "uint32_client_port", "uint32_qzhttp_ip", "uint32_qzhttp_port", "uint32_spp_ip", "uint32_spp_port", "uint32_flag", "bytes_key", "uint32_compress_type", "uint32_origin_size", "uint32_error_code", "msg_redirect", "uint32_command_id", "uint32_service_cmdid", "msg_oidbhead" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localByteStringMicro, localInteger, localInteger, localInteger, null, localInteger, localInteger, null }, HttpConnHead.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.msg.im_msg_head.HttpConnHead
 * JD-Core Version:    0.7.0.1
 */