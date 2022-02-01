package tencent.im.oidb.cmd0x75e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_cmd0x75e$ArticleInfo
  extends MessageMicro<ArticleInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_article_xml = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_article_xml" }, new Object[] { localByteStringMicro }, ArticleInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x75e.oidb_cmd0x75e.ArticleInfo
 * JD-Core Version:    0.7.0.1
 */