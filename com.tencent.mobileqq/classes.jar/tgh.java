import NS_KING_INTERFACE.stPostFeedDingRsp;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;

class tgh
  implements tgt
{
  tgh(tgg paramtgg, String paramString, int paramInt, boolean paramBoolean) {}
  
  public void a(the paramthe)
  {
    int j = 0;
    int i = 0;
    LikeRspEvent localLikeRspEvent = new LikeRspEvent(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if ((paramthe == null) || (paramthe.a == null))
    {
      tlo.a("WSLikeAnimationManger", "点赞失败:-1");
      paramthe = this.jdField_a_of_type_Tgg;
      str = this.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Boolean)
      {
        i = 0;
        tgg.a(paramthe, str, localLikeRspEvent, i);
      }
    }
    for (;;)
    {
      tff.a().a(localLikeRspEvent);
      return;
      i = 1;
      break;
      if (!(paramthe.a instanceof stPostFeedDingRsp)) {
        break label189;
      }
      paramthe = (stPostFeedDingRsp)paramthe.a;
      if (paramthe == null)
      {
        tlo.a("WSLikeAnimationManger", "服务器失败！！！");
        paramthe = this.jdField_a_of_type_Tgg;
        str = this.jdField_a_of_type_JavaLangString;
        if (this.jdField_a_of_type_Boolean) {}
        for (;;)
        {
          tgg.a(paramthe, str, localLikeRspEvent, i);
          break;
          i = 1;
        }
      }
      i = paramthe.is_ding;
      localLikeRspEvent.setRpsStatus(4301);
      localLikeRspEvent.setRspIsDing(i);
      if (i == 0) {
        tlo.a("WSLikeAnimationManger", "请求后变成：没有点赞-by微视");
      } else {
        tlo.a("WSLikeAnimationManger", "请求后变成：已经点赞-by微视");
      }
    }
    label189:
    tlo.a("WSLikeAnimationManger", "点赞失败:-2");
    paramthe = this.jdField_a_of_type_Tgg;
    String str = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Boolean) {}
    for (i = j;; i = 1)
    {
      tgg.a(paramthe, str, localLikeRspEvent, i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tgh
 * JD-Core Version:    0.7.0.1
 */