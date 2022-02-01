package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x27$BinaryMsg
  extends MessageMicro<BinaryMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_op_value = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_op_type", "bytes_op_value" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, BinaryMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.BinaryMsg
 * JD-Core Version:    0.7.0.1
 */