package com.tencent.pb.extendfriend;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ExtendFriendSquareInfo$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_req_page_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_req_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint64_uin", "bytes_req_page_cookies", "uint32_req_num" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.extendfriend.ExtendFriendSquareInfo.ReqBody
 * JD-Core Version:    0.7.0.1
 */