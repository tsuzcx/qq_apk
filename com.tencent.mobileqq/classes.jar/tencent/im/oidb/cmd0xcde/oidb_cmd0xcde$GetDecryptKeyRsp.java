package tencent.im.oidb.cmd0xcde;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_cmd0xcde$GetDecryptKeyRsp
  extends MessageMicro<GetDecryptKeyRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField dncrypt_key = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "dncrypt_key" }, new Object[] { localByteStringMicro }, GetDecryptKeyRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcde.oidb_cmd0xcde.GetDecryptKeyRsp
 * JD-Core Version:    0.7.0.1
 */