package tencent.im.s2c.msgtype0x210.submsgtype0xcc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0xcc$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_msg_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sub_type = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_vid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50, 58, 66 }, new String[] { "uint32_msg_type", "bytes_msg_info", "uint64_uin", "bytes_union_id", "bytes_sub_type", "bytes_feed_id", "bytes_vid", "bytes_cover_url" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6 }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xcc.SubMsgType0xcc.MsgBody
 * JD-Core Version:    0.7.0.1
 */