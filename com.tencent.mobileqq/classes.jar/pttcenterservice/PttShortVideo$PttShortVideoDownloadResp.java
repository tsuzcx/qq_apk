package pttcenterservice;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PttShortVideo$PttShortVideoDownloadResp
  extends MessageMicro<PttShortVideoDownloadResp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_downloadkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_encrypt_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_server_quic_para = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public PttShortVideo.PttShortVideoAddr msg_download_addr = new PttShortVideo.PttShortVideoAddr();
  public final PBRepeatMessageField<PttShortVideo.PttShortVideoIpList> rpt_diff_area_inner_addr = PBField.initRepeatMessage(PttShortVideo.PttShortVideoIpList.class);
  public final PBRepeatMessageField<PttShortVideo.PttShortVideoIpList> rpt_diff_area_out_addr = PBField.initRepeatMessage(PttShortVideo.PttShortVideoIpList.class);
  public final PBRepeatMessageField<PttShortVideo.PttShortVideoIpList> rpt_same_area_inner_addr = PBField.initRepeatMessage(PttShortVideo.PttShortVideoIpList.class);
  public final PBRepeatMessageField<PttShortVideo.PttShortVideoIpList> rpt_same_area_out_addr = PBField.initRepeatMessage(PttShortVideo.PttShortVideoIpList.class);
  public final PBStringField str_ret_msg = PBField.initString("");
  public final PBUInt32Field uint32_flag_server_quic_proto_enable = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 240, 250 }, new String[] { "int32_ret_code", "str_ret_msg", "rpt_same_area_out_addr", "rpt_diff_area_out_addr", "bytes_downloadkey", "bytes_file_md5", "rpt_same_area_inner_addr", "rpt_diff_area_inner_addr", "msg_download_addr", "bytes_encrypt_key", "uint32_flag_server_quic_proto_enable", "bytes_server_quic_para" }, new Object[] { localInteger, "", null, null, localByteStringMicro1, localByteStringMicro2, null, null, null, localByteStringMicro3, localInteger, localByteStringMicro4 }, PttShortVideoDownloadResp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     pttcenterservice.PttShortVideo.PttShortVideoDownloadResp
 * JD-Core Version:    0.7.0.1
 */