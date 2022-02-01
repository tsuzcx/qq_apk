package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class im_msg_body$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField msg_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField msg_encrypt_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public im_msg_body.RichText rich_text = new im_msg_body.RichText();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "rich_text", "msg_content", "msg_encrypt_content" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2 }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.MsgBody
 * JD-Core Version:    0.7.0.1
 */