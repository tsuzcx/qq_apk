import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyCutImageView;

class ogt
  implements View.OnTouchListener
{
  ogt(ogr paramogr) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      ogr.a(this.a).performClick();
    }
    if (ogr.a(this.a, paramMotionEvent.getX(), paramMotionEvent.getY()).booleanValue()) {}
    for (int i = 101;; i = 102)
    {
      int j = ogr.a(this.a, ogr.a(this.a));
      ogr.a(this.a, i, j + 1);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ogt
 * JD-Core Version:    0.7.0.1
 */