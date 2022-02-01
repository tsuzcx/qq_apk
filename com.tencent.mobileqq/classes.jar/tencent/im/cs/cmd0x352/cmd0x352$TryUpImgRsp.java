package tencent.im.cs.cmd0x352;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x352$TryUpImgRsp
  extends MessageMicro<TryUpImgRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_file_exit = PBField.initBool(false);
  public final PBBytesField bytes_big_down_para = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_big_thumb_down_para = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_client_ip6 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_down_domain = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_encrypt_dstip = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_fail_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_original_down_para = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_thumb_down_para = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_up_resid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_up_ukey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_up_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public cmd0x352.ImgInfo msg_img_info = new cmd0x352.ImgInfo();
  public cmd0x352.TryUpInfo4Busi msg_info4busi = new cmd0x352.TryUpInfo4Busi();
  public final PBRepeatMessageField<cmd0x352.IPv6Info> rpt_msg_up_ip6 = PBField.initRepeatMessage(cmd0x352.IPv6Info.class);
  public final PBRepeatField<Integer> rpt_uint32_up_ip = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField<Integer> rpt_uint32_up_port = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_client_ip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_https_url_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt32Field uint32_roamdays = PBField.initUInt32(0);
  public final PBUInt64Field uint64_block_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_file_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_up_offset = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
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
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50, 56, 64, 74, 82, 90, 96, 104, 114, 120, 210, 218, 482, 490, 498, 514, 522, 528, 8010 }, new String[] { "uint64_file_id", "uint32_client_ip", "uint32_result", "bytes_fail_msg", "bool_file_exit", "msg_img_info", "rpt_uint32_up_ip", "rpt_uint32_up_port", "bytes_up_ukey", "bytes_up_resid", "bytes_up_uuid", "uint64_up_offset", "uint64_block_size", "bytes_encrypt_dstip", "uint32_roamdays", "rpt_msg_up_ip6", "bytes_client_ip6", "bytes_thumb_down_para", "bytes_original_down_para", "bytes_down_domain", "bytes_big_down_para", "bytes_big_thumb_down_para", "uint32_https_url_flag", "msg_info4busi" }, new Object[] { localLong, localInteger, localInteger, localByteStringMicro1, Boolean.valueOf(false), null, localInteger, localInteger, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localLong, localLong, localByteStringMicro5, localInteger, null, localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, localByteStringMicro9, localByteStringMicro10, localByteStringMicro11, localInteger, null }, TryUpImgRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.cmd0x352.cmd0x352.TryUpImgRsp
 * JD-Core Version:    0.7.0.1
 */