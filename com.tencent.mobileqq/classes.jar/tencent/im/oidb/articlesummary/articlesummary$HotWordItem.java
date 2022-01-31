package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class articlesummary$HotWordItem
  extends MessageMicro<HotWordItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField hot_word = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField index_bg_color = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField index_word_color = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "hot_word", "index_word_color", "index_bg_color", "jump_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, HotWordItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.HotWordItem
 * JD-Core Version:    0.7.0.1
 */