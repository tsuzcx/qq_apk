import NS_KING_INTERFACE.stPostCommentDingRsp;
import com.tribe.async.dispatch.Dispatcher;

class tdd
  implements tgt
{
  tdd(tcu paramtcu) {}
  
  public void a(the paramthe)
  {
    if ((paramthe.jdField_a_of_type_JavaLangObject instanceof stPostCommentDingRsp))
    {
      stPostCommentDingRsp localstPostCommentDingRsp = (stPostCommentDingRsp)paramthe.jdField_a_of_type_JavaLangObject;
      tlo.d(tcu.a(), "回复点赞/取消成功,nothing is " + localstPostCommentDingRsp.nothing);
      uht.a().dispatch(this.a.a(new Object[] { Integer.valueOf(7), Integer.valueOf(paramthe.b), paramthe.jdField_a_of_type_JavaLangString, localstPostCommentDingRsp }));
      return;
    }
    tlo.d(tcu.a(), "回复点赞失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tdd
 * JD-Core Version:    0.7.0.1
 */