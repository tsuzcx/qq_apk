package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x346$ApplyForwardFileRsp
  extends MessageMicro<ApplyForwardFileRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public final PBStringField str_fileidcrc = PBField.initString("");
  public final PBStringField str_ret_msg = PBField.initString("");
  public final PBUInt64Field uint64_total_space = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_used_space = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 240, 320, 402, 482 }, new String[] { "int32_ret_code", "str_ret_msg", "uint64_total_space", "uint64_used_space", "bytes_uuid", "str_fileidcrc" }, new Object[] { Integer.valueOf(0), "", localLong, localLong, localByteStringMicro, "" }, ApplyForwardFileRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.cmd0x346.cmd0x346.ApplyForwardFileRsp
 * JD-Core Version:    0.7.0.1
 */