package com.tencent.msf.service.protocol.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class offlinepush$GroupOffInfo
  extends MessageMicro
{
  public static final int GROUP_CARD_FIELD_NUMBER = 4;
  public static final int GROUP_CODE_FIELD_NUMBER = 1;
  public static final int GROUP_INFO_SEQ_FIELD_NUMBER = 3;
  public static final int GROUP_NAME_FIELD_NUMBER = 5;
  public static final int GROUP_TYPE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField group_card = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBUInt64Field group_info_seq = PBField.initUInt64(0L);
  public final PBBytesField group_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field group_type = PBField.initUInt32(0);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "group_code", "group_type", "group_info_seq", "group_card", "group_name" }, new Object[] { localLong, Integer.valueOf(0), localLong, localByteStringMicro1, localByteStringMicro2 }, GroupOffInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.msf.service.protocol.pb.offlinepush.GroupOffInfo
 * JD-Core Version:    0.7.0.1
 */