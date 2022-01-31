package tencent.im.cs.cmd0x352;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x352$GetImgUrlRsp
  extends MessageMicro<GetImgUrlRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_big_down_para = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_big_thumb_down_para = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_client_ip6 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_down_domain = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_fail_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_resid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_original_down_para = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_thumb_down_para = PBField.initBytes(ByteStringMicro.EMPTY);
  public cmd0x352.ImgInfo msg_img_info = new cmd0x352.ImgInfo();
  public final PBRepeatField<ByteStringMicro> rpt_bytes_big_down_url = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatField<ByteStringMicro> rpt_bytes_original_down_url = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatField<ByteStringMicro> rpt_bytes_thumb_down_url = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatMessageField<cmd0x352.IPv6Info> rpt_msg_down_ip6 = PBField.initRepeatMessage(cmd0x352.IPv6Info.class);
  public final PBRepeatField<Integer> rpt_uint32_down_ip = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField<Integer> rpt_uint32_down_port = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_client_ip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_https_url_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  
  static
  {
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
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50, 58, 64, 72, 82, 90, 98, 106, 114, 122, 128, 210, 218 }, new String[] { "bytes_file_resid", "uint32_client_ip", "uint32_result", "bytes_fail_msg", "rpt_bytes_thumb_down_url", "rpt_bytes_original_down_url", "msg_img_info", "rpt_uint32_down_ip", "rpt_uint32_down_port", "bytes_thumb_down_para", "bytes_original_down_para", "bytes_down_domain", "rpt_bytes_big_down_url", "bytes_big_down_para", "bytes_big_thumb_down_para", "uint32_https_url_flag", "rpt_msg_down_ip6", "bytes_client_ip6" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, localByteStringMicro9, localByteStringMicro10, Integer.valueOf(0), null, localByteStringMicro11 }, GetImgUrlRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.cs.cmd0x352.cmd0x352.GetImgUrlRsp
 * JD-Core Version:    0.7.0.1
 */