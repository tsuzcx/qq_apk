package tencent.im.oidb.cmd0x875;

import appoint.define.appoint_define.RichText;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x875$Details
  extends MessageMicro<Details>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_back_color = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<ByteStringMicro> bytes_pictures = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBBytesField bytes_text_body = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public appoint_define.RichText rich_text_body = new appoint_define.RichText();
  public final PBUInt32Field uint32_pictures_total = PBField.initUInt32(0);
  public final PBUInt32Field uint32_post_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50, 56 }, new String[] { "bytes_title", "bytes_pictures", "uint32_pictures_total", "bytes_text_body", "rich_text_body", "bytes_back_color", "uint32_post_type" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, null, localByteStringMicro4, Integer.valueOf(0) }, Details.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x875.oidb_0x875.Details
 * JD-Core Version:    0.7.0.1
 */