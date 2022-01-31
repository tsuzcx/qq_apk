package msf.onlinepush;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import msf.msgcomm.msg_comm.Msg;

public final class msg_onlinepush$PbPushMsg
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_push_token = PBField.initBytes(ByteStringMicro.EMPTY);
  public msg_comm.Msg msg = new msg_comm.Msg();
  public final PBInt32Field svrip = PBField.initInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "msg", "svrip", "bytes_push_token" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro }, PbPushMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     msf.onlinepush.msg_onlinepush.PbPushMsg
 * JD-Core Version:    0.7.0.1
 */