package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class msg_svc$PbGetMsgReq
  extends MessageMicro<PbGetMsgReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_server_buf = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field context_flag = PBField.initUInt32(0);
  public final PBUInt32Field latest_ramble_number = PBField.initUInt32(20);
  public final PBBytesField msg_ctrl_buf = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field msg_req_type = PBField.initUInt32(0);
  public final PBUInt32Field online_sync_flag = PBField.initUInt32(1);
  public final PBUInt32Field other_ramble_number = PBField.initUInt32(3);
  public final PBBytesField pubaccount_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field ramble_flag = PBField.initUInt32(1);
  public final PBBytesField sync_cookie = PBField.initBytes(ByteStringMicro.copyFromUtf8(""));
  public final PBEnumField sync_flag = PBField.initEnum(0);
  public final PBUInt32Field whisper_session_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger1 = Integer.valueOf(0);
    Integer localInteger2 = Integer.valueOf(1);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.copyFromUtf8("");
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 64, 72, 82, 90, 98 }, new String[] { "sync_flag", "sync_cookie", "ramble_flag", "latest_ramble_number", "other_ramble_number", "online_sync_flag", "context_flag", "whisper_session_id", "msg_req_type", "pubaccount_cookie", "msg_ctrl_buf", "bytes_server_buf" }, new Object[] { localInteger1, localByteStringMicro1, localInteger2, Integer.valueOf(20), Integer.valueOf(3), localInteger2, localInteger1, localInteger1, localInteger1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, PbGetMsgReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbGetMsgReq
 * JD-Core Version:    0.7.0.1
 */