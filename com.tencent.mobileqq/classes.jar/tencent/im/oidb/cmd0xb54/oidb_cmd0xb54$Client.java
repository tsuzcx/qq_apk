package tencent.im.oidb.cmd0xb54;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xb54$Client
  extends MessageMicro<Client>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_version", "uint32_type" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, Client.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.Client
 * JD-Core Version:    0.7.0.1
 */