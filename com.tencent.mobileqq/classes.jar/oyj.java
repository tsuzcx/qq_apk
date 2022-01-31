import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnOverScrollHandler;
import com.tencent.qphone.base.util.QLog;

public class oyj
  extends GestureDetector.SimpleOnGestureListener
{
  public oyj(TouchWebView paramTouchWebView) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (((this.a.f) && (paramFloat2 < 0.0F)) || ((this.a.g) && (this.a.a != null)))
    {
      this.a.a.a((int)(paramFloat2 / 1.5D));
      this.a.g = true;
    }
    if ((this.a.getParent() instanceof RefreshView))
    {
      paramMotionEvent1 = (RefreshView)this.a.getParent();
      if ((paramMotionEvent1.getScrollY() >= 0) && (this.a.a != null) && (this.a.g))
      {
        if (QLog.isColorLevel()) {
          QLog.i("CustomWebView", 2, "RefreshView scrollY: " + paramMotionEvent1.getScrollY());
        }
        this.a.a.a();
        this.a.g = false;
        this.a.f = false;
      }
    }
    return false;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oyj
 * JD-Core Version:    0.7.0.1
 */