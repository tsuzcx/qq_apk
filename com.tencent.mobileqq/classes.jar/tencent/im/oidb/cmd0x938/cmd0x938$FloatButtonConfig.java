package tencent.im.oidb.cmd0x938;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x938$FloatButtonConfig
  extends MessageMicro<FloatButtonConfig>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_button_image_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_button_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_button_back_color = PBField.initUInt32(0);
  public final PBUInt32Field uint32_button_word_color = PBField.initUInt32(0);
  public final PBUInt32Field uint32_like_count = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "bytes_button_wording", "bytes_button_image_url", "uint32_button_word_color", "uint32_button_back_color", "uint32_like_count" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localInteger, localInteger, localInteger }, FloatButtonConfig.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x938.cmd0x938.FloatButtonConfig
 * JD-Core Version:    0.7.0.1
 */