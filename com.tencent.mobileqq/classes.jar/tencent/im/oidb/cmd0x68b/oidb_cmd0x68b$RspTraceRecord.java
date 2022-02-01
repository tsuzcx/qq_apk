package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x68b$RspTraceRecord
  extends MessageMicro<RspTraceRecord>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_method = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_cost = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_method", "uint32_cost" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, RspTraceRecord.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspTraceRecord
 * JD-Core Version:    0.7.0.1
 */