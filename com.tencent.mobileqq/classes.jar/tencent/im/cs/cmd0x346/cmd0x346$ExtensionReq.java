package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x346$ExtensionReq
  extends MessageMicro<ExtensionReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_phone_convert_type = PBField.initInt32(0);
  public cmd0x346.DelMessageReq msg_del_message_req = new cmd0x346.DelMessageReq();
  public final PBStringField str_dst_phonenum = PBField.initString("");
  public final PBUInt32Field uint32_bdh_cmdid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_download_url_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_auto = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_need_inner_ip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_net_type = PBField.initUInt32(255);
  public final PBUInt32Field uint32_ptt_format = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ptt_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_transfer_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_voice_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_route_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_type = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 162, 800, 720802, 721600, 722400, 723200, 724000, 724800, 725600, 726400, 727200, 728000, 728800 }, new String[] { "uint64_id", "uint64_type", "str_dst_phonenum", "int32_phone_convert_type", "bytes_sig", "uint64_route_id", "msg_del_message_req", "uint32_download_url_type", "uint32_ptt_format", "uint32_is_need_inner_ip", "uint32_net_type", "uint32_voice_type", "uint32_file_type", "uint32_ptt_time", "uint32_bdh_cmdid", "uint32_req_transfer_type", "uint32_is_auto" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ExtensionReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq
 * JD-Core Version:    0.7.0.1
 */