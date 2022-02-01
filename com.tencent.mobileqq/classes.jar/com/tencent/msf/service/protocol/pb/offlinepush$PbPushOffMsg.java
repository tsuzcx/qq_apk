package com.tencent.msf.service.protocol.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class offlinepush$PbPushOffMsg
  extends MessageMicro
{
  public static final int C2C_TMP_MSG_HEAD_FIELD_NUMBER = 8;
  public static final int DISCUSS_INFO_FIELD_NUMBER = 7;
  public static final int DWVIEDOTYPE_FIELD_NUMBER = 11;
  public static final int FROM_NICK_FIELD_NUMBER = 4;
  public static final int FROM_UIN_FIELD_NUMBER = 1;
  public static final int GROUP_INFO_FIELD_NUMBER = 6;
  public static final int MSG_FLAG_FIELD_NUMBER = 10;
  public static final int MSG_STR_FIELD_NUMBER = 5;
  public static final int MSG_TYPE_FIELD_NUMBER = 3;
  public static final int SVR_IP_FIELD_NUMBER = 9;
  public static final int TO_UIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public offlinepush.C2CTmpOffMsgHead c2c_tmp_msg_head = new offlinepush.C2CTmpOffMsgHead();
  public offlinepush.DiscussOffInfo discuss_info = new offlinepush.DiscussOffInfo();
  public final PBUInt32Field dwViedoType = PBField.initUInt32(0);
  public final PBBytesField from_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field from_uin = PBField.initUInt64(0L);
  public offlinepush.GroupOffInfo group_info = new offlinepush.GroupOffInfo();
  public final PBUInt32Field msg_flag = PBField.initUInt32(0);
  public final PBBytesField msg_str = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field msg_type = PBField.initUInt32(0);
  public final PBUInt32Field svr_ip = PBField.initUInt32(0);
  public final PBUInt64Field to_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 66, 72, 80, 88 }, new String[] { "from_uin", "to_uin", "msg_type", "from_nick", "msg_str", "group_info", "discuss_info", "c2c_tmp_msg_head", "svr_ip", "msg_flag", "dwViedoType" }, new Object[] { localLong, localLong, localInteger, localByteStringMicro1, localByteStringMicro2, null, null, null, localInteger, localInteger, localInteger }, PbPushOffMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.msf.service.protocol.pb.offlinepush.PbPushOffMsg
 * JD-Core Version:    0.7.0.1
 */