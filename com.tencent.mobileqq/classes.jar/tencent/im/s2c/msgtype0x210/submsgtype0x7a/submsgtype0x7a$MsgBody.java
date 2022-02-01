package tencent.im.s2c.msgtype0x210.submsgtype0x7a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0x7a$MsgBody
  extends MessageMicro<MsgBody>
{
  public static final int BYTES_CONTENT_FIELD_NUMBER = 1;
  public static final int STRING_DISCUSS_NICK_FIELD_NUMBER = 5;
  public static final int STRING_NICK_FIELD_NUMBER = 3;
  public static final int UINT64_AT_TIME_FIELD_NUMBER = 7;
  public static final int UINT64_DISCUSS_UIN_FIELD_NUMBER = 4;
  public static final int UINT64_FROM_UIN_FIELD_NUMBER = 2;
  public static final int UINT64_SEQ_FIELD_NUMBER = 6;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField string_discuss_nick = PBField.initString("");
  public final PBStringField string_nick = PBField.initString("");
  public final PBUInt64Field uint64_at_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_discuss_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 42, 48, 56 }, new String[] { "bytes_content", "uint64_from_uin", "string_nick", "uint64_discuss_uin", "string_discuss_nick", "uint64_seq", "uint64_at_time" }, new Object[] { localByteStringMicro, localLong, "", localLong, "", localLong, localLong }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x7a.submsgtype0x7a.MsgBody
 * JD-Core Version:    0.7.0.1
 */