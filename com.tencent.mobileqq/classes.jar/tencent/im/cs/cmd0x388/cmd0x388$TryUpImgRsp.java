package tencent.im.cs.cmd0x388;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x388$TryUpImgRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_file_exit = PBField.initBool(false);
  public final PBBoolField bool_new_big_chan = PBField.initBool(false);
  public final PBBytesField bytes_fail_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_up_ukey = PBField.initBytes(ByteStringMicro.EMPTY);
  public cmd0x388.ImgInfo msg_img_info = new cmd0x388.ImgInfo();
  public cmd0x388.TryUpInfo4Busi msg_info4busi = new cmd0x388.TryUpInfo4Busi();
  public final PBRepeatField rpt_uint32_up_ip = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField rpt_uint32_up_port = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt64Field uint64_block_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_file_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_fileid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_up_offset = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 48, 56, 66, 72, 80, 88, 96, 8010 }, new String[] { "uint64_file_id", "uint32_result", "bytes_fail_msg", "bool_file_exit", "msg_img_info", "rpt_uint32_up_ip", "rpt_uint32_up_port", "bytes_up_ukey", "uint64_fileid", "uint64_up_offset", "uint64_block_size", "bool_new_big_chan", "msg_info4busi" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, Boolean.valueOf(false), null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false), null }, TryUpImgRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x388.cmd0x388.TryUpImgRsp
 * JD-Core Version:    0.7.0.1
 */