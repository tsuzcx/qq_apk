package tencent.im.oidb.cmd0xa8c;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xa8c$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_poid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64_flower_num = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_flower_point = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "bytes_poid", "uint64_flower_num", "uint64_flower_point" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Long.valueOf(0L) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa8c.oidb_0xa8c.ReqBody
 * JD-Core Version:    0.7.0.1
 */