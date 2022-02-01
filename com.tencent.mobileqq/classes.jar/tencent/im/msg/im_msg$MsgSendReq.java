package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_msg$MsgSendReq
  extends MessageMicro<MsgSendReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bu_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field conn_msg_flag = PBField.initUInt32(0);
  public im_msg.Msg msg = new im_msg.Msg();
  public final PBUInt32Field msg_tail_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "msg", "bu_msg", "msg_tail_id", "conn_msg_flag", "bytes_cookie" }, new Object[] { null, localByteStringMicro1, localInteger, localInteger, localByteStringMicro2 }, MsgSendReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.msg.im_msg.MsgSendReq
 * JD-Core Version:    0.7.0.1
 */