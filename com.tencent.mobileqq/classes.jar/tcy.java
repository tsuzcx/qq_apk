import NS_KING_INTERFACE.stDeleteFeedCommentRsp;
import NS_KING_SOCIALIZE_META.stMetaComment;
import com.tribe.async.dispatch.Dispatcher;

class tcy
  implements tgt
{
  tcy(tcu paramtcu, stMetaComment paramstMetaComment) {}
  
  public void a(the paramthe)
  {
    if ((paramthe.jdField_a_of_type_JavaLangObject instanceof stDeleteFeedCommentRsp))
    {
      stDeleteFeedCommentRsp localstDeleteFeedCommentRsp = (stDeleteFeedCommentRsp)paramthe.jdField_a_of_type_JavaLangObject;
      paramthe = this.jdField_a_of_type_Tcu.a(new Object[] { Integer.valueOf(5), Integer.valueOf(paramthe.b), paramthe.jdField_a_of_type_JavaLangString, localstDeleteFeedCommentRsp, this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment.id, Integer.valueOf(this.jdField_a_of_type_Tcu.hashCode()) });
      umc.a().dispatch(paramthe);
      return;
    }
    tlo.d(tcu.a(), "删除评论失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tcy
 * JD-Core Version:    0.7.0.1
 */