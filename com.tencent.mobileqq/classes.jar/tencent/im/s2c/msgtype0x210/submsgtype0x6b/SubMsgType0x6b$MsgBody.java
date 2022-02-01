package tencent.im.s2c.msgtype0x210.submsgtype0x6b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x6b$MsgBody
  extends MessageMicro<MsgBody>
{
  public static final int BYTES_NO_TEXT_FIELD_NUMBER = 4;
  public static final int BYTES_TIPS_CONTENT_FIELD_NUMBER = 2;
  public static final int BYTES_YES_TEXT_FIELD_NUMBER = 3;
  public static final int UINT64_TO_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_no_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_tips_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_yes_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint64_to_uin", "bytes_tips_content", "bytes_yes_text", "bytes_no_text" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x6b.SubMsgType0x6b.MsgBody
 * JD-Core Version:    0.7.0.1
 */