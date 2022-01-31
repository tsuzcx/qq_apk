package pb.unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UnifySearchDiscovery$HotSearchItem
  extends MessageMicro<HotSearchItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField detail_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField img_bg_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField img_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField mark_bg_color = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField mark_text_color = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField recall_word = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField right_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field show_type = PBField.initUInt32(0);
  public final PBBytesField text_color = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field wz_ts = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 88, 98 }, new String[] { "show_type", "img_url", "title", "detail_text", "jump_url", "mark_text_color", "mark_bg_color", "img_bg_url", "text_color", "right_icon_url", "wz_ts", "recall_word" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, localByteStringMicro9, Integer.valueOf(0), localByteStringMicro10 }, HotSearchItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pb.unify.search.UnifySearchDiscovery.HotSearchItem
 * JD-Core Version:    0.7.0.1
 */