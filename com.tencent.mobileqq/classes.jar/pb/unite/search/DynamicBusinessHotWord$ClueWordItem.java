package pb.unite.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class DynamicBusinessHotWord$ClueWordItem
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField word = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField word_id = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "word_id", "word" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, ClueWordItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     pb.unite.search.DynamicBusinessHotWord.ClueWordItem
 * JD-Core Version:    0.7.0.1
 */