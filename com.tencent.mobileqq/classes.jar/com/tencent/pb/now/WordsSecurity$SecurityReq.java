package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WordsSecurity$SecurityReq
  extends MessageMicro<SecurityReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField biz_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field check_mask = PBField.initUInt32(0);
  public final PBBytesField check_word = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field client_ip = PBField.initUInt32(0);
  public final PBBytesField from_nick_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField from_user_type = PBField.initEnum(0);
  public final PBBytesField imei = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
  public final PBUInt32Field svr_type = PBField.initUInt32(0);
  public final PBUInt64Field to_uin = PBField.initUInt64(0L);
  public final PBEnumField to_user_type = PBField.initEnum(0);
  public final PBUInt32Field use_white_list = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 58, 64, 72, 80, 90, 98 }, new String[] { "check_word", "check_mask", "svr_type", "from_user_type", "to_user_type", "to_uin", "from_nick_name", "client_ip", "use_white_list", "room_id", "biz_id", "imei" }, new Object[] { localByteStringMicro1, localInteger, localInteger, localInteger, localInteger, localLong, localByteStringMicro2, localInteger, localInteger, localLong, localByteStringMicro3, localByteStringMicro4 }, SecurityReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.now.WordsSecurity.SecurityReq
 * JD-Core Version:    0.7.0.1
 */