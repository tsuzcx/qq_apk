package tencent.im.oidb.cmd0xad6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_cmd0xad6$Article
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_html = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0xad6.ArticleCommonInfo msg_article_common = new oidb_cmd0xad6.ArticleCommonInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_article_common", "bytes_html" }, new Object[] { null, localByteStringMicro }, Article.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.Article
 * JD-Core Version:    0.7.0.1
 */