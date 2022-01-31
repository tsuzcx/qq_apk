package tencent.aio.media.open;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class aio_media_open$RspOpenIdentify
  extends MessageMicro<RspOpenIdentify>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_button_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_confirm_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_introduce_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_introduce_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public aio_media_open.ResultInfo msg_result = new aio_media_open.ResultInfo();
  public final PBUInt32Field uint32_business_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48 }, new String[] { "msg_result", "bytes_button_text", "bytes_confirm_text", "bytes_introduce_title", "bytes_introduce_text", "uint32_business_type" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0) }, RspOpenIdentify.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.aio.media.open.aio_media_open.RspOpenIdentify
 * JD-Core Version:    0.7.0.1
 */