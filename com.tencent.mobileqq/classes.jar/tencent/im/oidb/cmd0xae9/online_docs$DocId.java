package tencent.im.oidb.cmd0xae9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class online_docs$DocId
  extends MessageMicro<DocId>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field domain_id = PBField.initUInt64(0L);
  public final PBBytesField pad_id = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "domain_id", "pad_id" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, DocId.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xae9.online_docs.DocId
 * JD-Core Version:    0.7.0.1
 */