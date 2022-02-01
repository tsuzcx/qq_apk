package tencent.im.oidb.cmd0xcde;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_cmd0xcde$GetEncryptKeyRsp
  extends MessageMicro<GetEncryptKeyRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField encrypt_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField file_meta = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "encrypt_key", "file_meta" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, GetEncryptKeyRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcde.oidb_cmd0xcde.GetEncryptKeyRsp
 * JD-Core Version:    0.7.0.1
 */