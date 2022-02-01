package tencent.im.oidb.cmd0x6b6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class oidb_0x6b6$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_error_notify = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_ret = PBField.initInt32(0);
  public oidb_0x6b6.SendFlowerRsp msg_send_flower = new oidb_0x6b6.SendFlowerRsp();
  public oidb_0x6b6.ThrowFlowerRsp msg_throw_flower = new oidb_0x6b6.ThrowFlowerRsp();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 34, 42, 50 }, new String[] { "int32_ret", "bytes_msg", "msg_send_flower", "msg_throw_flower", "bytes_error_notify" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, null, null, localByteStringMicro2 }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6b6.oidb_0x6b6.RspBody
 * JD-Core Version:    0.7.0.1
 */