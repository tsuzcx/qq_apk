package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hummer_commelem$MsgElemInfo_servtype18
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_auth_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_listid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_number = PBField.initUInt32(0);
  public final PBUInt64Field uint64_current_amount = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_total_amount = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "uint64_current_amount", "uint64_total_amount", "bytes_listid", "bytes_auth_key", "uint32_number" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, MsgElemInfo_servtype18.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype18
 * JD-Core Version:    0.7.0.1
 */