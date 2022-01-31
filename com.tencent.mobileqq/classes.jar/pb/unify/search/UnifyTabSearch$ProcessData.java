package pb.unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UnifyTabSearch$ProcessData
  extends MessageMicro<ProcessData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field group_mask = PBField.initUInt32(0);
  public final PBBytesField key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField value = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "group_mask", "key", "value" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, ProcessData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     pb.unify.search.UnifyTabSearch.ProcessData
 * JD-Core Version:    0.7.0.1
 */