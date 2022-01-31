import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;

public class rvs
  implements View.OnClickListener
{
  public rvs(CommonSuspensionGestureLayout paramCommonSuspensionGestureLayout) {}
  
  public void onClick(View paramView)
  {
    CommonSuspensionGestureLayout.a(this.a).a(true, 0, 5);
    CommonSuspensionGestureLayout.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rvs
 * JD-Core Version:    0.7.0.1
 */