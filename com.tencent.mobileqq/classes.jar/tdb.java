import NS_KING_INTERFACE.stPostCommentDingRsp;
import NS_KING_SOCIALIZE_META.stMetaComment;
import com.tribe.async.dispatch.Dispatcher;

class tdb
  implements tgt
{
  tdb(tcu paramtcu, stMetaComment paramstMetaComment) {}
  
  public void a(the paramthe)
  {
    if ((paramthe.jdField_a_of_type_JavaLangObject instanceof stPostCommentDingRsp))
    {
      stPostCommentDingRsp localstPostCommentDingRsp = (stPostCommentDingRsp)paramthe.jdField_a_of_type_JavaLangObject;
      if (this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment.isDing == 1) {
        tlo.d(tcu.a(), "点赞成功,nothing is " + localstPostCommentDingRsp.nothing);
      }
      for (;;)
      {
        uht.a().dispatch(this.jdField_a_of_type_Tcu.a(new Object[] { Integer.valueOf(7), Integer.valueOf(paramthe.b), paramthe.jdField_a_of_type_JavaLangString, localstPostCommentDingRsp }));
        return;
        tlo.d(tcu.a(), "取消点赞成功,nothing is " + localstPostCommentDingRsp.nothing);
      }
    }
    tlo.d(tcu.a(), "评论点赞失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tdb
 * JD-Core Version:    0.7.0.1
 */