package tencent.im.oidb.oidb_0xd1e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xd1e$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82 }, new String[] { "sub_comment_create_req", "sub_comment_delete_req", "sub_comment_strike_req", "first_comment_create_req", "first_comment_delete_req", "first_comment_strike_req", "first_comment_like_set_req", "sub_comment_like_set_req", "author_comment_delete_req", "first_comment_author_top_set_req" }, new Object[] { null, null, null, null, null, null, null, null, null, null }, ReqBody.class);
  public oidb_0xd1e.AuthorCommentDeleteReq author_comment_delete_req = new oidb_0xd1e.AuthorCommentDeleteReq();
  public oidb_0xd1e.FirstCommentAuthorTopSetReq first_comment_author_top_set_req = new oidb_0xd1e.FirstCommentAuthorTopSetReq();
  public oidb_0xd1e.FirstCommentCreateReq first_comment_create_req = new oidb_0xd1e.FirstCommentCreateReq();
  public oidb_0xd1e.FirstCommentDeleteReq first_comment_delete_req = new oidb_0xd1e.FirstCommentDeleteReq();
  public oidb_0xd1e.FirstCommentLikeSetReq first_comment_like_set_req = new oidb_0xd1e.FirstCommentLikeSetReq();
  public oidb_0xd1e.FirstCommentStrikeReq first_comment_strike_req = new oidb_0xd1e.FirstCommentStrikeReq();
  public oidb_0xd1e.SubCommentCreateReq sub_comment_create_req = new oidb_0xd1e.SubCommentCreateReq();
  public oidb_0xd1e.SubCommentDeleteReq sub_comment_delete_req = new oidb_0xd1e.SubCommentDeleteReq();
  public oidb_0xd1e.SubCommentLikeSetReq sub_comment_like_set_req = new oidb_0xd1e.SubCommentLikeSetReq();
  public oidb_0xd1e.SubCommentStrikeReq sub_comment_strike_req = new oidb_0xd1e.SubCommentStrikeReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.ReqBody
 * JD-Core Version:    0.7.0.1
 */