package tencent.im.oidb.cmd0x439;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x439$ArticleInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_article_subject = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_article_sum_pic = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_article_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint64_article_id", "bytes_article_subject", "bytes_article_url", "bytes_article_sum_pic" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, ArticleInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x439.oidb_cmd0x439.ArticleInfo
 * JD-Core Version:    0.7.0.1
 */