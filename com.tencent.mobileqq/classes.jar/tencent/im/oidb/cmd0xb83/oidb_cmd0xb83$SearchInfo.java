package tencent.im.oidb.cmd0xb83;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_cmd0xb83$SearchInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_key = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_key" }, new Object[] { localByteStringMicro }, SearchInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.SearchInfo
 * JD-Core Version:    0.7.0.1
 */