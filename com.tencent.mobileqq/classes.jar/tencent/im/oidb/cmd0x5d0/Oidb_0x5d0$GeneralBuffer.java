package tencent.im.oidb.cmd0x5d0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class Oidb_0x5d0$GeneralBuffer
  extends MessageMicro<GeneralBuffer>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_value" }, new Object[] { localByteStringMicro }, GeneralBuffer.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.GeneralBuffer
 * JD-Core Version:    0.7.0.1
 */