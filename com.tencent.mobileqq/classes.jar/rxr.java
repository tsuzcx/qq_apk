import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController;
import com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController.4.1;

public class rxr
  implements View.OnClickListener
{
  public rxr(SlideActiveAnimController paramSlideActiveAnimController) {}
  
  public void onClick(View paramView)
  {
    this.a.d = true;
    SlideActiveAnimController.a(this.a, new SlideActiveAnimController.4.1(this));
    SlideActiveAnimController.a(this.a).postDelayed(SlideActiveAnimController.a(this.a), 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rxr
 * JD-Core Version:    0.7.0.1
 */