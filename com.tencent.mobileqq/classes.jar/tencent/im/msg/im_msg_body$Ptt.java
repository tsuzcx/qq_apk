package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_msg_body$Ptt
  extends MessageMicro<Ptt>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_valid = PBField.initBool(false);
  public final PBBytesField bytes_down_para = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_group_file_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_ptt_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_shortcut = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_signature = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<ByteStringMicro> rpt_bytes_ptt_urls = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBUInt32Field uint32_download_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_format = PBField.initUInt32(0);
  public final PBUInt32Field uint32_magic_ptt_index = PBField.initUInt32(0);
  public final PBUInt32Field uint32_server_ip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_server_port = PBField.initUInt32(0);
  public final PBUInt32Field uint32_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_voice_switch = PBField.initUInt32(0);
  public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro11 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro12 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 58, 64, 72, 80, 88, 98, 106, 114, 120, 128, 138, 146, 152, 162, 232, 242, 250, 256 }, new String[] { "uint32_file_type", "uint64_src_uin", "bytes_file_uuid", "bytes_file_md5", "bytes_file_name", "uint32_file_size", "bytes_reserve", "uint32_file_id", "uint32_server_ip", "uint32_server_port", "bool_valid", "bytes_signature", "bytes_shortcut", "bytes_file_key", "uint32_magic_ptt_index", "uint32_voice_switch", "bytes_ptt_url", "bytes_group_file_key", "uint32_time", "bytes_down_para", "uint32_format", "bytes_pb_reserve", "rpt_bytes_ptt_urls", "uint32_download_flag" }, new Object[] { localInteger, Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localInteger, localByteStringMicro4, localInteger, localInteger, localInteger, Boolean.valueOf(false), localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, localInteger, localInteger, localByteStringMicro8, localByteStringMicro9, localInteger, localByteStringMicro10, localInteger, localByteStringMicro11, localByteStringMicro12, localInteger }, Ptt.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.Ptt
 * JD-Core Version:    0.7.0.1
 */