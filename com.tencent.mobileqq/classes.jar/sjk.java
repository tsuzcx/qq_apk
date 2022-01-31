import UserGrowth.stNotificationRsp;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import com.tencent.biz.pubaccount.weishi_new.view.WeiShiNoticeView;

public class sjk
  implements View.OnClickListener
{
  public sjk(WSRecommendFragment paramWSRecommendFragment) {}
  
  public void onClick(View paramView)
  {
    if (WSRecommendFragment.a(this.a) == null) {
      return;
    }
    int i = WSRecommendFragment.a(this.a).a();
    paramView = WSRecommendFragment.a(this.a, WSRecommendFragment.a(this.a));
    String str = WSRecommendFragment.a(this.a).h5Url;
    snb.c("WSRecommendFragment", "schemeUrl:" + paramView + ", h5Url:" + str);
    snf.a(WSRecommendFragment.a(this.a), paramView, str, i, this.a.a);
    smp.a(112, i, WSRecommendFragment.a(this.a).cid);
    snb.a("weishi-808", "notification jumpUrl" + WSRecommendFragment.a(this.a).jump_url);
    this.a.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sjk
 * JD-Core Version:    0.7.0.1
 */