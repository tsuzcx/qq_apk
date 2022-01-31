package tencent.im.cs.cmd0x352;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x352$GetImgUrlReq
  extends MessageMicro<GetImgUrlReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_address_book = PBField.initBool(false);
  public final PBBytesField bytes_build_ver = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_resid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_bu_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_inner_ip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pic_up_timestamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_platform_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_term = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_transfer_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src_file_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_url_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_url_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 48, 56, 64, 72, 80, 88, 96, 106, 112, 120 }, new String[] { "uint64_src_uin", "uint64_dst_uin", "bytes_file_resid", "uint32_url_flag", "uint32_url_type", "uint32_req_term", "uint32_req_platform_type", "uint32_src_file_type", "uint32_inner_ip", "bool_address_book", "uint32_bu_type", "bytes_build_ver", "uint32_pic_up_timestamp", "uint32_req_transfer_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0) }, GetImgUrlReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.cs.cmd0x352.cmd0x352.GetImgUrlReq
 * JD-Core Version:    0.7.0.1
 */