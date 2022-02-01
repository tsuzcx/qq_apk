package tencent.im.s2c.msgtype0x210.submsgtype0x11a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class submsgtype0x11a$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_encrypt_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_token = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_biz_type = PBField.initEnum(1);
  public final PBEnumField enum_result = PBField.initEnum(0);
  public submsgtype0x11a.UserData msg_user_data = new submsgtype0x11a.UserData();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40 }, new String[] { "enum_result", "bytes_token", "bytes_encrypt_key", "msg_user_data", "enum_biz_type" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, null, Integer.valueOf(1) }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x11a.submsgtype0x11a.MsgBody
 * JD-Core Version:    0.7.0.1
 */