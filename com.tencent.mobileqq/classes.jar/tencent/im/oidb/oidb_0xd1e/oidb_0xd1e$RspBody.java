package tencent.im.oidb.oidb_0xd1e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xd1e$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82 }, new String[] { "sub_comment_create_rsp", "sub_comment_delete_rsp", "sub_comment_strike_rsp", "first_comment_create_rsp", "first_comment_delete_rsp", "first_comment_strike_rsp", "first_comment_like_set_rsp", "sub_comment_like_set_rsp", "author_comment_delete_rsp", "first_comment_author_top_set_rsp" }, new Object[] { null, null, null, null, null, null, null, null, null, null }, RspBody.class);
  public oidb_0xd1e.AuthorCommentDeleteRsp author_comment_delete_rsp = new oidb_0xd1e.AuthorCommentDeleteRsp();
  public oidb_0xd1e.FirstCommentAuthorTopSetRsp first_comment_author_top_set_rsp = new oidb_0xd1e.FirstCommentAuthorTopSetRsp();
  public oidb_0xd1e.FirstCommentCreateRsp first_comment_create_rsp = new oidb_0xd1e.FirstCommentCreateRsp();
  public oidb_0xd1e.FirstCommentDeleteRsp first_comment_delete_rsp = new oidb_0xd1e.FirstCommentDeleteRsp();
  public oidb_0xd1e.FirstCommentLikeSetRsp first_comment_like_set_rsp = new oidb_0xd1e.FirstCommentLikeSetRsp();
  public oidb_0xd1e.FirstCommentStrikeRsp first_comment_strike_rsp = new oidb_0xd1e.FirstCommentStrikeRsp();
  public oidb_0xd1e.SubCommentCreateRsp sub_comment_create_rsp = new oidb_0xd1e.SubCommentCreateRsp();
  public oidb_0xd1e.SubCommentDeleteRsp sub_comment_delete_rsp = new oidb_0xd1e.SubCommentDeleteRsp();
  public oidb_0xd1e.SubCommentLikeSetRsp sub_comment_like_set_rsp = new oidb_0xd1e.SubCommentLikeSetRsp();
  public oidb_0xd1e.SubCommentStrikeRsp sub_comment_strike_rsp = new oidb_0xd1e.SubCommentStrikeRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.RspBody
 * JD-Core Version:    0.7.0.1
 */