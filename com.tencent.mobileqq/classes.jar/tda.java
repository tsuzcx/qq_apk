import NS_KING_INTERFACE.stDeleteFeedCommentRsp;
import NS_KING_SOCIALIZE_META.stMetaComment;
import NS_KING_SOCIALIZE_META.stMetaReply;
import com.tribe.async.dispatch.Dispatcher;

class tda
  implements tgt
{
  tda(tcu paramtcu, stMetaComment paramstMetaComment, stMetaReply paramstMetaReply) {}
  
  public void a(the paramthe)
  {
    if ((paramthe.jdField_a_of_type_JavaLangObject instanceof stDeleteFeedCommentRsp))
    {
      stDeleteFeedCommentRsp localstDeleteFeedCommentRsp = (stDeleteFeedCommentRsp)paramthe.jdField_a_of_type_JavaLangObject;
      paramthe = this.jdField_a_of_type_Tcu.a(new Object[] { Integer.valueOf(6), Integer.valueOf(paramthe.b), paramthe.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment.id, this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaReply, this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaReply.id, Integer.valueOf(this.jdField_a_of_type_Tcu.hashCode()) });
      umc.a().dispatch(paramthe);
      return;
    }
    tlo.d(tcu.a(), "删除回复失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tda
 * JD-Core Version:    0.7.0.1
 */