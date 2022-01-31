package tencent.im.msgsync.cmd0x100;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Submsgtype0x8a$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_reserved = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<Submsgtype0x8a.MsgInfo> msg_info = PBField.initRepeatMessage(Submsgtype0x8a.MsgInfo.class);
  public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_inst_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_long_message_flag = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42 }, new String[] { "msg_info", "uint32_app_id", "uint32_inst_id", "uint32_long_message_flag", "bytes_reserved" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.msgsync.cmd0x100.Submsgtype0x8a.ReqBody
 * JD-Core Version:    0.7.0.1
 */