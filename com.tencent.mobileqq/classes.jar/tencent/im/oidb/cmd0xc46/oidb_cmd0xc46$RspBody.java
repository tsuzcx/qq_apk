package tencent.im.oidb.cmd0xc46;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xc46$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public oidb_cmd0xc46.ArticleInfo article_info = new oidb_cmd0xc46.ArticleInfo();
  public oidb_cmd0xc46.Banner banner = new oidb_cmd0xc46.Banner();
  public final PBRepeatMessageField<oidb_cmd0xc46.Comment> comment_list = PBField.initRepeatMessage(oidb_cmd0xc46.Comment.class);
  public oidb_cmd0xc46.ExtraInfo extra_info = new oidb_cmd0xc46.ExtraInfo();
  public oidb_cmd0xc46.Comment first_comment_detail = new oidb_cmd0xc46.Comment();
  public final PBRepeatMessageField<oidb_cmd0xc46.Comment> hot_comment_list = PBField.initRepeatMessage(oidb_cmd0xc46.Comment.class);
  public final PBUInt32Field next = PBField.initUInt32(0);
  public final PBBytesField page_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "next", "page_cookie", "article_info", "hot_comment_list", "comment_list", "first_comment_detail", "banner", "extra_info" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, null, null, null, null, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.RspBody
 * JD-Core Version:    0.7.0.1
 */