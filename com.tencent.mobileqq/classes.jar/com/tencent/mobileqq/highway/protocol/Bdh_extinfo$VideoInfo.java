package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Bdh_extinfo$VideoInfo
  extends MessageMicro<VideoInfo>
{
  public static final int BYTES_BIN_MD5_FIELD_NUMBER = 3;
  public static final int UINT32_FORMAT_FIELD_NUMBER = 4;
  public static final int UINT32_IDX_FIELD_NUMBER = 1;
  public static final int UINT32_IS_AUDIO_FIELD_NUMBER = 9;
  public static final int UINT32_RES_LEN_FIELD_NUMBER = 5;
  public static final int UINT32_RES_WIDTH_FIELD_NUMBER = 6;
  public static final int UINT32_SIZE_FIELD_NUMBER = 2;
  public static final int UINT32_TIME_FIELD_NUMBER = 7;
  public static final int UINT64_STARTTIME_FIELD_NUMBER = 8;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_bin_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_format = PBField.initUInt32(0);
  public final PBUInt32Field uint32_idx = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_audio = PBField.initUInt32(0);
  public final PBUInt32Field uint32_res_len = PBField.initUInt32(0);
  public final PBUInt32Field uint32_res_width = PBField.initUInt32(0);
  public final PBUInt32Field uint32_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_starttime = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 56, 64, 72 }, new String[] { "uint32_idx", "uint32_size", "bytes_bin_md5", "uint32_format", "uint32_res_len", "uint32_res_width", "uint32_time", "uint64_starttime", "uint32_is_audio" }, new Object[] { localInteger, localInteger, localByteStringMicro, localInteger, localInteger, localInteger, localInteger, Long.valueOf(0L), localInteger }, VideoInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.Bdh_extinfo.VideoInfo
 * JD-Core Version:    0.7.0.1
 */