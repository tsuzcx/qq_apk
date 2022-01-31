import android.view.View;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;

public class mto
  implements ViewStub.OnInflateListener
{
  public mto(SubscriptRecommendController paramSubscriptRecommendController) {}
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    this.a.a = paramView;
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mto
 * JD-Core Version:    0.7.0.1
 */