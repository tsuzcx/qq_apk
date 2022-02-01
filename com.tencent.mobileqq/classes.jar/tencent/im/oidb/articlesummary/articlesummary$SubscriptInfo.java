package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class articlesummary$SubscriptInfo
  extends MessageMicro<SubscriptInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_background_color = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subscript_color = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subscript_txt = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_is_show_top = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subscript_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40 }, new String[] { "bytes_subscript_txt", "bytes_subscript_color", "bytes_background_color", "uint32_subscript_type", "uint32_is_show_top" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localInteger, localInteger }, SubscriptInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.SubscriptInfo
 * JD-Core Version:    0.7.0.1
 */