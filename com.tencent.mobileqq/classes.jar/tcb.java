import UserGrowth.stNotificationRsp;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import com.tencent.biz.pubaccount.weishi_new.view.WeiShiNoticeView;

public class tcb
  implements View.OnClickListener
{
  public tcb(WSRecommendFragment paramWSRecommendFragment) {}
  
  public void onClick(View paramView)
  {
    if (WSRecommendFragment.a(this.a) == null) {
      return;
    }
    int i = WSRecommendFragment.a(this.a).a();
    paramView = WSRecommendFragment.a(this.a, WSRecommendFragment.a(this.a));
    String str = WSRecommendFragment.a(this.a).h5Url;
    tlo.c("WSRecommendFragment", "schemeUrl:" + paramView + ", h5Url:" + str);
    tlv.a(this.a.jdField_a_of_type_AndroidContentContext, paramView, str, "", i, this.a.jdField_a_of_type_Tmc);
    tju.a(112, i, WSRecommendFragment.a(this.a).cid);
    tlo.a("weishi-808", "notification jumpUrl" + WSRecommendFragment.a(this.a).jump_url);
    this.a.c(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tcb
 * JD-Core Version:    0.7.0.1
 */