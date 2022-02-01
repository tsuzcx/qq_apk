package tencent.im.oidb.oidb_0xefd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xefd$RspResult
  extends MessageMicro<RspResult>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82 }, new String[] { "sub_comment_create_rsp", "sub_comment_delete_rsp", "sub_comment_strike_rsp", "first_comment_create_rsp", "first_comment_delete_rsp", "first_comment_strike_rsp", "first_comment_like_set_rsp", "sub_comment_like_set_rsp", "author_comment_delete_rsp", "first_comment_author_top_set_rsp" }, new Object[] { null, null, null, null, null, null, null, null, null, null }, RspResult.class);
  public oidb_0xefd.AuthorCommentDeleteRsp author_comment_delete_rsp = new oidb_0xefd.AuthorCommentDeleteRsp();
  public oidb_0xefd.FirstCommentAuthorTopSetRsp first_comment_author_top_set_rsp = new oidb_0xefd.FirstCommentAuthorTopSetRsp();
  public oidb_0xefd.FirstCommentCreateRsp first_comment_create_rsp = new oidb_0xefd.FirstCommentCreateRsp();
  public oidb_0xefd.FirstCommentDeleteRsp first_comment_delete_rsp = new oidb_0xefd.FirstCommentDeleteRsp();
  public oidb_0xefd.FirstCommentLikeSetRsp first_comment_like_set_rsp = new oidb_0xefd.FirstCommentLikeSetRsp();
  public oidb_0xefd.FirstCommentStrikeRsp first_comment_strike_rsp = new oidb_0xefd.FirstCommentStrikeRsp();
  public oidb_0xefd.SubCommentCreateRsp sub_comment_create_rsp = new oidb_0xefd.SubCommentCreateRsp();
  public oidb_0xefd.SubCommentDeleteRsp sub_comment_delete_rsp = new oidb_0xefd.SubCommentDeleteRsp();
  public oidb_0xefd.SubCommentLikeSetRsp sub_comment_like_set_rsp = new oidb_0xefd.SubCommentLikeSetRsp();
  public oidb_0xefd.SubCommentStrikeRsp sub_comment_strike_rsp = new oidb_0xefd.SubCommentStrikeRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xefd.oidb_0xefd.RspResult
 * JD-Core Version:    0.7.0.1
 */