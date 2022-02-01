package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CSDataHighwayHead$PicInfoExt
  extends MessageMicro<PicInfoExt>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_echo_created_by_server = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_app_pic_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_busi_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_img_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_net_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pic_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pic_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pic_width = PBField.initUInt32(0);
  public final PBUInt32Field uint32_plat_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
  public final PBUInt64Field uint64_qqmeet_channel_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_qqmeet_guild_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 82, 88, 96 }, new String[] { "uint32_pic_width", "uint32_pic_height", "uint32_pic_flag", "uint32_busi_type", "uint32_src_term", "uint32_plat_type", "uint32_net_type", "uint32_img_type", "uint32_app_pic_type", "bytes_echo_created_by_server", "uint64_qqmeet_guild_id", "uint64_qqmeet_channel_id" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localByteStringMicro, localLong, localLong }, PicInfoExt.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.PicInfoExt
 * JD-Core Version:    0.7.0.1
 */