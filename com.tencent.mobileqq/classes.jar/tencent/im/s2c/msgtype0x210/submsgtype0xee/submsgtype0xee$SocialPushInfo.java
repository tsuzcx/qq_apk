package tencent.im.s2c.msgtype0x210.submsgtype0xee;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0xee$SocialPushInfo
  extends MessageMicro<SocialPushInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField string_biu_comment = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_biu_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint64_feeds_id", "string_biu_reason", "string_biu_comment" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, SocialPushInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.SocialPushInfo
 * JD-Core Version:    0.7.0.1
 */