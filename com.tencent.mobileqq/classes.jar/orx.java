import android.graphics.Rect;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.util.AccessibilityUtil;

class orx
  extends TouchDelegate
{
  orx(orw paramorw, Rect paramRect, View paramView)
  {
    super(paramRect, paramView);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      if (QRDisplayActivity.a(this.a.a) != null)
      {
        QRDisplayActivity.a(this.a.a, false);
        QRDisplayActivity.a(this.a.a).start();
        continue;
        if (QRDisplayActivity.a(this.a.a) != null) {
          QRDisplayActivity.a(this.a.a).cancel();
        }
        if (!QRDisplayActivity.a(this.a.a))
        {
          AccessibilityUtil.c(this.a.a.d);
          this.a.a.onClick(this.a.a.d);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     orx
 * JD-Core Version:    0.7.0.1
 */