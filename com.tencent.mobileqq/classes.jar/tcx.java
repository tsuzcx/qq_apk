import NS_KING_INTERFACE.stPostFeedCommentRsp;
import NS_KING_SOCIALIZE_META.stMetaComment;
import com.tribe.async.dispatch.Dispatcher;

class tcx
  implements tgt
{
  tcx(tcu paramtcu) {}
  
  public void a(the paramthe)
  {
    if ((paramthe.jdField_a_of_type_JavaLangObject instanceof stPostFeedCommentRsp))
    {
      stPostFeedCommentRsp localstPostFeedCommentRsp = (stPostFeedCommentRsp)paramthe.jdField_a_of_type_JavaLangObject;
      stMetaComment localstMetaComment = localstPostFeedCommentRsp.getComment();
      tlo.c(tcu.a(), "---CommentEvent, addFeedComment！");
      paramthe = this.a.a(new Object[] { Integer.valueOf(3), Integer.valueOf(paramthe.b), paramthe.jdField_a_of_type_JavaLangString, localstPostFeedCommentRsp, localstMetaComment.id, Integer.valueOf(this.a.hashCode()) });
      uht.a().dispatch(paramthe);
      return;
    }
    tlo.d(tcu.a(), "添加评论失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tcx
 * JD-Core Version:    0.7.0.1
 */