package tencent.im.s2c.msgtype0x210.submsgtype0xb3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0xb3$PushAddFrdNotify
  extends MessageMicro<PushAddFrdNotify>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_fuin_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_mobile = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBFixed32Field fixed32_timestamp = PBField.initFixed32(0);
  public final PBUInt32Field uint32_source_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subsource_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_fuin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_fuin_bubble_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_req_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 29, 34, 42, 48, 56, 66, 72 }, new String[] { "uint64_fuin", "uint64_fuin_bubble_id", "fixed32_timestamp", "bytes_wording", "bytes_fuin_nick", "uint32_source_id", "uint32_subsource_id", "bytes_mobile", "uint64_req_uin" }, new Object[] { localLong, localLong, localInteger, localByteStringMicro1, localByteStringMicro2, localInteger, localInteger, localByteStringMicro3, localLong }, PushAddFrdNotify.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xb3.SubMsgType0xb3.PushAddFrdNotify
 * JD-Core Version:    0.7.0.1
 */