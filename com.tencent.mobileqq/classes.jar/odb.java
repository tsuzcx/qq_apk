import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyCutImageView;

class odb
  implements View.OnTouchListener
{
  odb(ocz paramocz) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      ocz.a(this.a).performClick();
    }
    if (ocz.a(this.a, paramMotionEvent.getX(), paramMotionEvent.getY()).booleanValue()) {}
    for (int i = 101;; i = 102)
    {
      int j = ocz.a(this.a, ocz.a(this.a));
      ocz.a(this.a, i, j + 1);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     odb
 * JD-Core Version:    0.7.0.1
 */