package tencent.im.oidb.cmd0x877;

import appoint.define.appoint_define.RichText;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_0x877$MsgWord
  extends MessageMicro<MsgWord>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_buluo_word = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_from_user = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_plain_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public appoint_define.RichText rich_fresh_word = new appoint_define.RichText();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "bytes_from_user", "bytes_plain_text", "bytes_buluo_word", "rich_fresh_word" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, null }, MsgWord.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x877.oidb_0x877.MsgWord
 * JD-Core Version:    0.7.0.1
 */