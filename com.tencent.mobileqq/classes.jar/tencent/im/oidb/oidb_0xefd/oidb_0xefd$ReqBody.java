package tencent.im.oidb.oidb_0xefd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xefd$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82 }, new String[] { "sub_comment_create_req", "sub_comment_delete_req", "sub_comment_strike_req", "first_comment_create_req", "first_comment_delete_req", "first_comment_strike_req", "first_comment_like_set_req", "sub_comment_like_set_req", "author_comment_delete_req", "first_comment_author_top_set_req" }, new Object[] { null, null, null, null, null, null, null, null, null, null }, ReqBody.class);
  public oidb_0xefd.AuthorCommentDeleteReq author_comment_delete_req = new oidb_0xefd.AuthorCommentDeleteReq();
  public oidb_0xefd.FirstCommentAuthorTopSetReq first_comment_author_top_set_req = new oidb_0xefd.FirstCommentAuthorTopSetReq();
  public oidb_0xefd.FirstCommentCreateReq first_comment_create_req = new oidb_0xefd.FirstCommentCreateReq();
  public oidb_0xefd.FirstCommentDeleteReq first_comment_delete_req = new oidb_0xefd.FirstCommentDeleteReq();
  public oidb_0xefd.FirstCommentLikeSetReq first_comment_like_set_req = new oidb_0xefd.FirstCommentLikeSetReq();
  public oidb_0xefd.FirstCommentStrikeReq first_comment_strike_req = new oidb_0xefd.FirstCommentStrikeReq();
  public oidb_0xefd.SubCommentCreateReq sub_comment_create_req = new oidb_0xefd.SubCommentCreateReq();
  public oidb_0xefd.SubCommentDeleteReq sub_comment_delete_req = new oidb_0xefd.SubCommentDeleteReq();
  public oidb_0xefd.SubCommentLikeSetReq sub_comment_like_set_req = new oidb_0xefd.SubCommentLikeSetReq();
  public oidb_0xefd.SubCommentStrikeReq sub_comment_strike_req = new oidb_0xefd.SubCommentStrikeReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xefd.oidb_0xefd.ReqBody
 * JD-Core Version:    0.7.0.1
 */