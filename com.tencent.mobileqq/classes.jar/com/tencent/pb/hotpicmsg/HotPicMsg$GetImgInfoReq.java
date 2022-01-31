package com.tencent.pb.hotpicmsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class HotPicMsg$GetImgInfoReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_client_ver = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_session_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_build_ver = PBField.initUInt32(0);
  public final PBUInt32Field uint32_end_pic_index = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_update = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pic_tag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
  public final PBUInt32Field uint32_start_pic_index = PBField.initUInt32(0);
  public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56, 64, 74 }, new String[] { "bytes_session_id", "uint64_src_uin", "uint32_src_term", "uint32_build_ver", "uint32_pic_tag", "uint32_start_pic_index", "uint32_end_pic_index", "uint32_need_update", "bytes_client_ver" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, GetImgInfoReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.hotpicmsg.HotPicMsg.GetImgInfoReq
 * JD-Core Version:    0.7.0.1
 */