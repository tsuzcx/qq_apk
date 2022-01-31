package tencent.im.s2c.msgtype0x210.submsgtype0xae;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;

public final class SubMsgType0xae$PushPeopleMayKnow
  extends MessageMicro<PushPeopleMayKnow>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_wording_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBFixed32Field fixed32_timestamp = PBField.initFixed32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 18 }, new String[] { "fixed32_timestamp", "bytes_wording_msg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, PushPeopleMayKnow.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.PushPeopleMayKnow
 * JD-Core Version:    0.7.0.1
 */