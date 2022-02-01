package tencent.im.oidb.cmd0xad6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xad6$ArticleCommonInfo
  extends MessageMicro<ArticleCommonInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_account_author = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_account_desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_account_icon = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_account_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_article_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_article_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_date = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_original_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_proteus_json_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_row_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_share_words = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_tags = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0xad6.ArticleCover msg_cover = new oidb_cmd0xad6.ArticleCover();
  public final PBUInt32Field uint32_article_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_source = PBField.initUInt32(0);
  public final PBUInt64Field uint64_public_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro11 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro12 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro13 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro14 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 98, 104, 114, 120, 130, 138, 146, 154, 162, 168 }, new String[] { "bytes_row_key", "bytes_title", "bytes_desc", "bytes_account_name", "bytes_account_icon", "bytes_account_author", "bytes_date", "msg_cover", "bytes_share_words", "uint32_article_flag", "bytes_account_desc", "uint64_public_uin", "bytes_original_url", "bytes_tags", "bytes_article_id", "bytes_proteus_json_data", "bytes_article_url", "uint32_source" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, null, localByteStringMicro8, localInteger, localByteStringMicro9, Long.valueOf(0L), localByteStringMicro10, localByteStringMicro11, localByteStringMicro12, localByteStringMicro13, localByteStringMicro14, localInteger }, ArticleCommonInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.ArticleCommonInfo
 * JD-Core Version:    0.7.0.1
 */