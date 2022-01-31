import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview.NaviMaskTouchListener;

public class mhs
  implements View.OnTouchListener
{
  public mhs(ReadInJoyNavigationGridview paramReadInJoyNavigationGridview) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((MotionEventCompat.getActionMasked(paramMotionEvent) == 0) && (ReadInJoyNavigationGridview.a(this.a) != null)) {
      ReadInJoyNavigationGridview.a(this.a).a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mhs
 * JD-Core Version:    0.7.0.1
 */