package tencent.im.oidb.cmd0xe37;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class cmd0xe37$Req0xe37
  extends MessageMicro<Req0xe37>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cmd_0x346_req_body = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_cmd_0x346_req_body" }, new Object[] { localByteStringMicro }, Req0xe37.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe37.cmd0xe37.Req0xe37
 * JD-Core Version:    0.7.0.1
 */