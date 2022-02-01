package tencent.im.oidb.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class DynamicSearch$SubItemText
  extends MessageMicro<SubItemText>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField color = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField text = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "text", "color" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, SubItemText.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.search.DynamicSearch.SubItemText
 * JD-Core Version:    0.7.0.1
 */