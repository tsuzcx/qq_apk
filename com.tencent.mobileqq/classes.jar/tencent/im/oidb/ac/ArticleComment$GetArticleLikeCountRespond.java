package tencent.im.oidb.ac;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ArticleComment$GetArticleLikeCountRespond
  extends MessageMicro<GetArticleLikeCountRespond>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "ret", "count" }, new Object[] { null, Integer.valueOf(0) }, GetArticleLikeCountRespond.class);
  public final PBUInt32Field count = PBField.initUInt32(0);
  public ArticleComment.RetInfo ret = new ArticleComment.RetInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.ac.ArticleComment.GetArticleLikeCountRespond
 * JD-Core Version:    0.7.0.1
 */