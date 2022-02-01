package tencent.im.s2c.msgtype0x210.submsgtype0x146;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class submsgtype0x146$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public submsgtype0x146.TabData tab_data = new submsgtype0x146.TabData();
  public final PBEnumField uint32_push_from = PBField.initEnum(0);
  public final PBEnumField uint32_push_type = PBField.initEnum(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_push_from", "uint32_push_type", "bytes_content", "tab_data" }, new Object[] { localInteger, localInteger, localByteStringMicro, null }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x146.submsgtype0x146.MsgBody
 * JD-Core Version:    0.7.0.1
 */