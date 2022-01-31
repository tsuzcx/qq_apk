import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.av.ui.QavPanel;
import com.tencent.qphone.base.util.QLog;

public class jzl
  implements View.OnTouchListener
{
  public jzl(QavPanel paramQavPanel) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavPanel", 2, "onTouch action: " + paramMotionEvent.getAction());
    }
    if (paramView == this.a.m)
    {
      if (paramMotionEvent.getAction() == 0)
      {
        this.a.d.setAlpha(0.5F);
        this.a.e.setAlpha(0.5F);
      }
      for (;;)
      {
        return this.a.a.onTouch(paramView, paramMotionEvent);
        if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
        {
          this.a.d.setAlpha(1.0F);
          this.a.e.setAlpha(1.0F);
        }
      }
    }
    if (paramMotionEvent.getAction() == 0) {
      paramView.setAlpha(0.5F);
    }
    for (;;)
    {
      return false;
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
        paramView.setAlpha(1.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jzl
 * JD-Core Version:    0.7.0.1
 */