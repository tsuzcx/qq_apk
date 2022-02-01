package tencent.im.s2c.msgtype0x210.submsgtype0xaa;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0xaa$OnlineDoc_PushChangeTitleMessage
  extends MessageMicro<OnlineDoc_PushChangeTitleMessage>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_last_editor_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_localpadid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_domainid = PBField.initUInt32(0);
  public final PBUInt64Field uint64_last_edit_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_last_editor_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 48 }, new String[] { "uint32_domainid", "bytes_localpadid", "bytes_title", "uint64_last_editor_uin", "bytes_last_editor_nick", "uint64_last_edit_time" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localLong, localByteStringMicro3, localLong }, OnlineDoc_PushChangeTitleMessage.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.OnlineDoc_PushChangeTitleMessage
 * JD-Core Version:    0.7.0.1
 */