import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.qphone.base.util.QLog;

class mpq
  implements View.OnTouchListener
{
  mpq(mpn parammpn) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    try
    {
      QLog.w(this.a.i, 1, "OnTouch Close, view[" + paramView.getResources().getResourceName(paramView.getId()) + "]");
      this.a.a(false, 3);
      return true;
    }
    catch (Exception paramMotionEvent)
    {
      for (;;)
      {
        QLog.w(this.a.i, 1, "OnTouch Close, view[" + paramView.getId() + "]");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mpq
 * JD-Core Version:    0.7.0.1
 */