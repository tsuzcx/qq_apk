package com.tencent.pb.onlinepush;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class OnlinePushTrans$PbMsgInfo
  extends MessageMicro
{
  public static final int FROM_UIN_FIELD_NUMBER = 1;
  public static final int MSG_DATA_FIELD_NUMBER = 10;
  public static final int MSG_SEQ_FIELD_NUMBER = 5;
  public static final int MSG_SUBTYPE_FIELD_NUMBER = 4;
  public static final int MSG_TIME_FIELD_NUMBER = 7;
  public static final int MSG_TYPE_FIELD_NUMBER = 3;
  public static final int MSG_UID_FIELD_NUMBER = 6;
  public static final int NICK_NAME_FIELD_NUMBER = 9;
  public static final int REAL_MSG_TIME_FIELD_NUMBER = 8;
  public static final int SVR_IP_FIELD_NUMBER = 11;
  public static final int TO_UIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field from_uin = PBField.initUInt64(0L);
  public final PBBytesField msg_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field msg_subtype = PBField.initUInt32(0);
  public final PBUInt32Field msg_time = PBField.initUInt32(0);
  public final PBUInt32Field msg_type = PBField.initUInt32(0);
  public final PBUInt64Field msg_uid = PBField.initUInt64(0L);
  public final PBStringField nick_name = PBField.initString("");
  public final PBUInt32Field real_msg_time = PBField.initUInt32(0);
  public final PBUInt32Field svr_ip = PBField.initUInt32(0);
  public final PBUInt64Field to_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 74, 82, 88 }, new String[] { "from_uin", "to_uin", "msg_type", "msg_subtype", "msg_seq", "msg_uid", "msg_time", "real_msg_time", "nick_name", "msg_data", "svr_ip" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", localByteStringMicro, Integer.valueOf(0) }, PbMsgInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.onlinepush.OnlinePushTrans.PbMsgInfo
 * JD-Core Version:    0.7.0.1
 */