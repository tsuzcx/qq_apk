import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;

public class ruc
  implements View.OnTouchListener
{
  public ruc(ReadInJoyNavigationGridview paramReadInJoyNavigationGridview) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((MotionEventCompat.getActionMasked(paramMotionEvent) == 0) && (ReadInJoyNavigationGridview.a(this.a) != null)) {
      ReadInJoyNavigationGridview.a(this.a).a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ruc
 * JD-Core Version:    0.7.0.1
 */