package com.tencent.msf.service.protocol.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class offlinepush$C2CTmpOffMsgHead
  extends MessageMicro
{
  public static final int C2C_TYPE_FIELD_NUMBER = 1;
  public static final int DISCUSS_REMARK_FIELD_NUMBER = 12;
  public static final int DIS_NAME_FIELD_NUMBER = 13;
  public static final int FROM_PHONE_FIELD_NUMBER = 7;
  public static final int GROUP_CARD_FIELD_NUMBER = 10;
  public static final int GROUP_CODE_FIELD_NUMBER = 4;
  public static final int GROUP_NAME_FIELD_NUMBER = 11;
  public static final int GROUP_UIN_FIELD_NUMBER = 3;
  public static final int LOCK_DISPLAY_FIELD_NUMBER = 9;
  public static final int SERVICE_TYPE_FIELD_NUMBER = 2;
  public static final int SIG_FIELD_NUMBER = 5;
  public static final int SIG_TYPE_FIELD_NUMBER = 6;
  public static final int TO_PHONE_FIELD_NUMBER = 8;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field c2c_type = PBField.initUInt32(0);
  public final PBBytesField dis_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField discuss_remark = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField from_phone = PBField.initString("");
  public final PBBytesField group_card = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBBytesField group_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field group_uin = PBField.initUInt64(0L);
  public final PBUInt32Field lock_display = PBField.initUInt32(0);
  public final PBUInt32Field service_type = PBField.initUInt32(0);
  public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field sig_type = PBField.initUInt32(0);
  public final PBStringField to_phone = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 58, 66, 72, 82, 90, 98, 106 }, new String[] { "c2c_type", "service_type", "group_uin", "group_code", "sig", "sig_type", "from_phone", "to_phone", "lock_display", "group_card", "group_name", "discuss_remark", "dis_name" }, new Object[] { localInteger, localInteger, localLong, localLong, localByteStringMicro1, localInteger, "", "", localInteger, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5 }, C2CTmpOffMsgHead.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.msf.service.protocol.pb.offlinepush.C2CTmpOffMsgHead
 * JD-Core Version:    0.7.0.1
 */