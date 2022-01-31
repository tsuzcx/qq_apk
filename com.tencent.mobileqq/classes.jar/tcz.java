import NS_KING_INTERFACE.stPostCommentReplyRsp;
import NS_KING_SOCIALIZE_META.stMetaReply;
import com.tribe.async.dispatch.Dispatcher;

class tcz
  implements tgt
{
  tcz(tcu paramtcu, stMetaReply paramstMetaReply) {}
  
  public void a(the paramthe)
  {
    if ((paramthe.jdField_a_of_type_JavaLangObject instanceof stPostCommentReplyRsp))
    {
      stPostCommentReplyRsp localstPostCommentReplyRsp = (stPostCommentReplyRsp)paramthe.jdField_a_of_type_JavaLangObject;
      paramthe = this.jdField_a_of_type_Tcu.a(new Object[] { Integer.valueOf(4), Integer.valueOf(paramthe.b), paramthe.jdField_a_of_type_JavaLangString, localstPostCommentReplyRsp, this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaReply, this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaReply.id, Integer.valueOf(this.jdField_a_of_type_Tcu.hashCode()) });
      umc.a().dispatch(paramthe);
      return;
    }
    tlo.d(tcu.a(), "添加回复失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tcz
 * JD-Core Version:    0.7.0.1
 */