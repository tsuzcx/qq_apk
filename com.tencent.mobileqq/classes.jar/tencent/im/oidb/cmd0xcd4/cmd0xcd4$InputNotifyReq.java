package tencent.im.oidb.cmd0xcd4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xcd4$InputNotifyReq
  extends MessageMicro<InputNotifyReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_event_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ime = PBField.initUInt32(0);
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint64_to_uin", "uint32_ime", "uint32_event_type", "bytes_pb_reserve" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localByteStringMicro }, InputNotifyReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcd4.cmd0xcd4.InputNotifyReq
 * JD-Core Version:    0.7.0.1
 */