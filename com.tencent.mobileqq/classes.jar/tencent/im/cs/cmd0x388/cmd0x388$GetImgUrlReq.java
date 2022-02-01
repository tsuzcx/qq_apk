package tencent.im.cs.cmd0x388;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x388$GetImgUrlReq
  extends MessageMicro<GetImgUrlReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_build_ver = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_bu_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_width = PBField.initUInt32(0);
  public final PBUInt32Field uint32_inner_ip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_original_pic = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pic_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pic_up_timestamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_platform_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_term = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_transfer_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_retry_req = PBField.initUInt32(0);
  public final PBUInt32Field uint32_url_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_url_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_file_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_fileid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 56, 64, 72, 80, 90, 96, 104, 112, 120, 128, 136, 144, 152, 160 }, new String[] { "uint64_group_code", "uint64_dst_uin", "uint64_fileid", "bytes_file_md5", "uint32_url_flag", "uint32_url_type", "uint32_req_term", "uint32_req_platform_type", "uint32_inner_ip", "uint32_bu_type", "bytes_build_ver", "uint64_file_id", "uint64_file_size", "uint32_original_pic", "uint32_retry_req", "uint32_file_height", "uint32_file_width", "uint32_pic_type", "uint32_pic_up_timestamp", "uint32_req_transfer_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetImgUrlReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.cmd0x388.cmd0x388.GetImgUrlReq
 * JD-Core Version:    0.7.0.1
 */