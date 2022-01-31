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
  extends MessageMicro<PbMsgInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public OnlinePushTrans.ExtGroupKeyInfo ext_group_key_info = new OnlinePushTrans.ExtGroupKeyInfo();
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
  public final PBUInt32Field uint32_general_flag = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 74, 82, 88, 98, 136 }, new String[] { "from_uin", "to_uin", "msg_type", "msg_subtype", "msg_seq", "msg_uid", "msg_time", "real_msg_time", "nick_name", "msg_data", "svr_ip", "ext_group_key_info", "uint32_general_flag" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", localByteStringMicro, Integer.valueOf(0), null, Integer.valueOf(0) }, PbMsgInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.onlinepush.OnlinePushTrans.PbMsgInfo
 * JD-Core Version:    0.7.0.1
 */