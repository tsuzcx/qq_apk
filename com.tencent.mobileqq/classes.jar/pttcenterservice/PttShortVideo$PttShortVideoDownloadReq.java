package pttcenterservice;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PttShortVideo$PttShortVideoDownloadReq
  extends MessageMicro<PttShortVideoDownloadReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_fileid = PBField.initString("");
  public final PBUInt32Field uint32_agent_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_business_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_chat_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_down_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flag_support_large_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_inner_addr = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_host_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_transfer_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_scene_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_fromuin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_touin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 66, 72, 80, 88, 96, 104, 112, 120, 160 }, new String[] { "uint64_fromuin", "uint64_touin", "uint32_chat_type", "uint32_client_type", "str_fileid", "uint64_group_code", "uint32_agent_type", "bytes_file_md5", "uint32_business_type", "uint32_file_type", "uint32_down_type", "uint32_scene_type", "uint32_need_inner_addr", "uint32_req_transfer_type", "uint32_req_host_type", "uint32_flag_support_large_size" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, PttShortVideoDownloadReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pttcenterservice.PttShortVideo.PttShortVideoDownloadReq
 * JD-Core Version:    0.7.0.1
 */