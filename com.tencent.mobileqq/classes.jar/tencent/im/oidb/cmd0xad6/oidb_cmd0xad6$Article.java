package tencent.im.oidb.cmd0xad6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xad6$Article
  extends MessageMicro<Article>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_html = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0xad6.ArticleCommonInfo msg_article_common = new oidb_cmd0xad6.ArticleCommonInfo();
  public final PBUInt32Field uint32_zip = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "msg_article_common", "bytes_html", "uint32_zip" }, new Object[] { null, localByteStringMicro, Integer.valueOf(0) }, Article.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.Article
 * JD-Core Version:    0.7.0.1
 */