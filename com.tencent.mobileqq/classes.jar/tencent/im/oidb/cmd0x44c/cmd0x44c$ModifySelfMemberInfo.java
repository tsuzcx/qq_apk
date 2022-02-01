package tencent.im.oidb.cmd0x44c;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class cmd0x44c$ModifySelfMemberInfo
  extends MessageMicro<ModifySelfMemberInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_name_card = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_name_card" }, new Object[] { localByteStringMicro }, ModifySelfMemberInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x44c.cmd0x44c.ModifySelfMemberInfo
 * JD-Core Version:    0.7.0.1
 */