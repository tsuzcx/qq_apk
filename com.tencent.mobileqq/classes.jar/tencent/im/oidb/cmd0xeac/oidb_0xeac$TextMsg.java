package tencent.im.oidb.cmd0xeac;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_0xeac$TextMsg
  extends MessageMicro<TextMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField str = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str" }, new Object[] { localByteStringMicro }, TextMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeac.oidb_0xeac.TextMsg
 * JD-Core Version:    0.7.0.1
 */