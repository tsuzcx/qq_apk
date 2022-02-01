package cooperation.vip.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class VipGeneralAdvPopWindow$4
  implements View.OnTouchListener
{
  VipGeneralAdvPopWindow$4(VipGeneralAdvPopWindow paramVipGeneralAdvPopWindow) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.a.d();
      return true;
    }
    if (paramMotionEvent.getAction() == 4)
    {
      this.a.d();
      return true;
    }
    return paramView.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.widget.VipGeneralAdvPopWindow.4
 * JD-Core Version:    0.7.0.1
 */