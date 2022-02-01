package tencent.im.oidb.cmd0xe84;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBSInt32Field;

public final class oidb_0xe84$CustomData
  extends MessageMicro<CustomData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_icon_link = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_jump_link = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_png_link = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_text_color = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0xe84.Condition msg_condi = new oidb_0xe84.Condition();
  public final PBSInt32Field sint32_result = PBField.initSInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58 }, new String[] { "sint32_result", "msg_condi", "bytes_data", "bytes_jump_link", "bytes_png_link", "bytes_icon_link", "bytes_text_color" }, new Object[] { Integer.valueOf(0), null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5 }, CustomData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe84.oidb_0xe84.CustomData
 * JD-Core Version:    0.7.0.1
 */