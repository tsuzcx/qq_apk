import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyCutImageView;

class otp
  implements View.OnTouchListener
{
  otp(otn paramotn) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      otn.a(this.a).performClick();
    }
    if (otn.a(this.a, paramMotionEvent.getX(), paramMotionEvent.getY()).booleanValue()) {}
    for (int i = 101;; i = 102)
    {
      int j = otn.a(this.a, otn.a(this.a));
      otn.a(this.a, i, j + 1);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     otp
 * JD-Core Version:    0.7.0.1
 */