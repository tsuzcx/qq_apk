package tencent.im.oidb.cmd0x58b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class cmd0x58b$GetConfNameForPushRsp
  extends MessageMicro<GetConfNameForPushRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_conf_name = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_conf_name" }, new Object[] { localByteStringMicro }, GetConfNameForPushRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x58b.cmd0x58b.GetConfNameForPushRsp
 * JD-Core Version:    0.7.0.1
 */