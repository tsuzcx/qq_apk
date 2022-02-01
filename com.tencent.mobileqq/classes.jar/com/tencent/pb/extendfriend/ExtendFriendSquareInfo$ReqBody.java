package com.tencent.pb.extendfriend;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ExtendFriendSquareInfo$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_req_buff = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_req_page_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
  public ExtendFriendSquareInfo.LBSInfo msg_lbs_info = new ExtendFriendSquareInfo.LBSInfo();
  public final PBBytesField str_keyword = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_get_online_number = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 48, 58 }, new String[] { "uint64_uin", "bytes_req_page_cookies", "uint32_req_num", "str_keyword", "bytes_req_buff", "uint32_get_online_number", "msg_lbs_info" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localInteger, localByteStringMicro2, localByteStringMicro3, localInteger, null }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.extendfriend.ExtendFriendSquareInfo.ReqBody
 * JD-Core Version:    0.7.0.1
 */