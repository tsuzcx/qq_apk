package localpb.readinjoy;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Readinjoy$ArticleTagInfo
  extends MessageMicro<ArticleTagInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_tag_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64_tag_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_tag_id", "bytes_tag_name" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, ArticleTagInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     localpb.readinjoy.Readinjoy.ArticleTagInfo
 * JD-Core Version:    0.7.0.1
 */