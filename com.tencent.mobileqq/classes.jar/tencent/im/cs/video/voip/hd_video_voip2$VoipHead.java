package tencent.im.cs.video.voip;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hd_video_voip2$VoipHead
  extends MessageMicro<VoipHead>
{
  public static final int CMD_GET_CALL_TYPE_REQ = 51;
  public static final int CMD_GET_CALL_TYPE_RSP = 52;
  public static final int CMD_PHONE_BIND_ID_REQ = 1;
  public static final int CMD_PHONE_BIND_ID_RSP = 2;
  public static final int CMD_PHONE_CALLBACK_REQ = 3;
  public static final int CMD_PHONE_CALLBACK_RSP = 4;
  public static final int CMD_PHONE_CANCEL_CALLBACK_REQ = 5;
  public static final int CMD_PHONE_CANCEL_CALLBACK_RSP = 6;
  public static final int CMD_PHONE_H5_CHECK_REQ = 19;
  public static final int CMD_PHONE_H5_CHECK_RSP = 20;
  public static final int CMD_PHONE_MULTICHAT_CANCEL_REQ = 17;
  public static final int CMD_PHONE_MULTICHAT_CANCEL_RSP = 18;
  public static final int CMD_PHONE_MULTICHAT_CREATE_REQ = 9;
  public static final int CMD_PHONE_MULTICHAT_CREATE_RSP = 10;
  public static final int CMD_PHONE_MULTICHAT_INVITE_REQ = 11;
  public static final int CMD_PHONE_MULTICHAT_INVITE_RSP = 12;
  public static final int CMD_PHONE_MULTICHAT_KICK_REQ = 15;
  public static final int CMD_PHONE_MULTICHAT_KICK_RSP = 16;
  public static final int CMD_PHONE_MULTICHAT_QUERY_REQ = 13;
  public static final int CMD_PHONE_MULTICHAT_QUERY_RSP = 14;
  public static final int CMD_PHONE_SPEED_TEST_REQ = 7;
  public static final int CMD_PHONE_SPEED_TEST_RSP = 8;
  public static final int ERR_BILL_NOT_ENOUGH = 3;
  public static final int ERR_CALLBACK_SERVER = 4;
  public static final int ERR_CANCEL_CALLBACK = 5;
  public static final int ERR_MULTICHAT_CONFID = 12;
  public static final int ERR_MULTICHAT_OVER_MAX = 11;
  public static final int ERR_MULTICHAT_PARA = 13;
  public static final int ERR_MULTICHAT_PHONE = 10;
  public static final int ERR_MULTICHAT_SERVER = 9;
  public static final int ERR_PHONE_ERROR = 7;
  public static final int ERR_PHONE_FOREIGN = 8;
  public static final int ERR_PHONE_LIMIT = 6;
  public static final int ERR_PHONE_NOT_SUPPORT = 1;
  public static final int ERR_QCALL_BOTH_MASK = 16;
  public static final int ERR_QCALL_CALLEE_MASK = 15;
  public static final int ERR_QCALL_CALLER_MASK = 14;
  public static final int ERR_UNKNOWN = 255;
  public static final int ERR_VOIP_NO_PERMISSION = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_build_ver = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_sub_service_type = PBField.initInt32(0);
  public final PBUInt32Field uint32_app_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_biz_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
  public final PBUInt32Field uint32_error_no = PBField.initUInt32(0);
  public final PBUInt32Field uint32_term_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 64, 176 }, new String[] { "uint64_uin", "uint64_seq", "uint32_cmd", "uint32_error_no", "bytes_build_ver", "uint32_term_type", "uint32_app_type", "uint32_biz_id", "int32_sub_service_type" }, new Object[] { localLong, localLong, localInteger, localInteger, localByteStringMicro, localInteger, localInteger, localInteger, localInteger }, VoipHead.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.video.voip.hd_video_voip2.VoipHead
 * JD-Core Version:    0.7.0.1
 */