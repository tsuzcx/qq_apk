package tencent.im.oidb.cmd0xad6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xad6$ArticleExtInfo
  extends MessageMicro<ArticleExtInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_comment_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64_comment = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_read_count = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_read_count", "uint64_comment", "bytes_comment_url" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro }, ArticleExtInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.ArticleExtInfo
 * JD-Core Version:    0.7.0.1
 */