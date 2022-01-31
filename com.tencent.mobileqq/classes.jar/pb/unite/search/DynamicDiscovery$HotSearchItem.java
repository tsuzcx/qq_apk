package pb.unite.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DynamicDiscovery$HotSearchItem
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField detail_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField img_bg_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField img_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField mark_bg_color = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField mark_text_color = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field show_type = PBField.initUInt32(0);
  public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "show_type", "img_url", "title", "detail_text", "jump_url", "mark_text_color", "mark_bg_color", "img_bg_url" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7 }, HotSearchItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     pb.unite.search.DynamicDiscovery.HotSearchItem
 * JD-Core Version:    0.7.0.1
 */