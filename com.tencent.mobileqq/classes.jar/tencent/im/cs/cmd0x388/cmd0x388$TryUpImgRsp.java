package tencent.im.cs.cmd0x388;

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

public final class cmd0x388$TryUpImgRsp
  extends MessageMicro<TryUpImgRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_file_exit = PBField.initBool(false);
  public final PBBoolField bool_new_big_chan = PBField.initBool(false);
  public final PBBytesField bytes_client_ip6 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_download_index = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_fail_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_up_ukey = PBField.initBytes(ByteStringMicro.EMPTY);
  public cmd0x388.ImgInfo msg_img_info = new cmd0x388.ImgInfo();
  public cmd0x388.TryUpInfo4Busi msg_info4busi = new cmd0x388.TryUpInfo4Busi();
  public final PBRepeatMessageField<cmd0x388.IPv6Info> rpt_msg_up_ip6 = PBField.initRepeatMessage(cmd0x388.IPv6Info.class);
  public final PBRepeatField<Integer> rpt_uint32_up_ip = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField<Integer> rpt_uint32_up_port = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt64Field uint64_block_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_file_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_fileid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_up_offset = PBField.initUInt64(0L);
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 48, 56, 66, 72, 80, 88, 96, 210, 218, 226, 8010 }, new String[] { "uint64_file_id", "uint32_result", "bytes_fail_msg", "bool_file_exit", "msg_img_info", "rpt_uint32_up_ip", "rpt_uint32_up_port", "bytes_up_ukey", "uint64_fileid", "uint64_up_offset", "uint64_block_size", "bool_new_big_chan", "rpt_msg_up_ip6", "bytes_client_ip6", "bytes_download_index", "msg_info4busi" }, new Object[] { localLong, localInteger, localByteStringMicro1, localBoolean, null, localInteger, localInteger, localByteStringMicro2, localLong, localLong, localLong, localBoolean, null, localByteStringMicro3, localByteStringMicro4, null }, TryUpImgRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.cmd0x388.cmd0x388.TryUpImgRsp
 * JD-Core Version:    0.7.0.1
 */