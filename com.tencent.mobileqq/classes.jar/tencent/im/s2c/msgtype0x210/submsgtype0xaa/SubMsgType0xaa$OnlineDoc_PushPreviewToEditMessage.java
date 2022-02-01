package tencent.im.s2c.msgtype0x210.submsgtype0xaa;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0xaa$OnlineDoc_PushPreviewToEditMessage
  extends MessageMicro<OnlineDoc_PushPreviewToEditMessage>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_aio_session = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pad_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_version = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_version", "bytes_title", "bytes_pad_url", "bytes_aio_session" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, OnlineDoc_PushPreviewToEditMessage.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.OnlineDoc_PushPreviewToEditMessage
 * JD-Core Version:    0.7.0.1
 */