import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;

public class tcf
  implements View.OnClickListener
{
  public tcf(WSRecommendFragment paramWSRecommendFragment) {}
  
  public void onClick(View paramView)
  {
    WSRecommendFragment.a(this.a).b();
    ((tjl)this.a.b()).a(true, true, "");
    ((tjl)this.a.b()).a("");
    WSRecommendFragment.a(this.a).setVisibility(8);
    this.a.a(false);
    tjr.a(136, 1, null);
    tju.b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tcf
 * JD-Core Version:    0.7.0.1
 */