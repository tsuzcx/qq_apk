package pb.unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UnifyTabSearch$SubHotWord
  extends MessageMicro<SubHotWord>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField search_word = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField show_word = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field word_id = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "word_id", "show_word", "search_word" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, SubHotWord.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pb.unify.search.UnifyTabSearch.SubHotWord
 * JD-Core Version:    0.7.0.1
 */