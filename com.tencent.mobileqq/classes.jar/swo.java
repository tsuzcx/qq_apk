import android.view.ViewStub;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.main.CommonLoadingView;

public class swo
  implements Runnable
{
  public swo(Leba paramLeba) {}
  
  public void run()
  {
    ViewStub localViewStub = (ViewStub)this.a.a(2131364872);
    ((CommonLoadingView)this.a.a(2131363809)).setVisibility(8);
    localViewStub.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     swo
 * JD-Core Version:    0.7.0.1
 */