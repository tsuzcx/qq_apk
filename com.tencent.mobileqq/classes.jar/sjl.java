import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;

public class sjl
  implements View.OnClickListener
{
  public sjl(WSRecommendFragment paramWSRecommendFragment) {}
  
  public void onClick(View paramView)
  {
    sne.b("weishi-beacon", "返回按钮");
    WSRecommendFragment.a(this.a);
    WSRecommendFragment.b(this.a);
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sjl
 * JD-Core Version:    0.7.0.1
 */