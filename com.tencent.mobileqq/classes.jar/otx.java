import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;

public class otx
  implements View.OnTouchListener
{
  public otx(QRDisplayActivity paramQRDisplayActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      return false;
      if (paramMotionEvent.getAction() == 0)
      {
        this.a.b.setImageResource(2130843874);
      }
      else if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        this.a.b.setImageResource(2130843873);
      }
      else if (paramMotionEvent.getAction() == 2)
      {
        int i = (int)paramMotionEvent.getRawX();
        int j = (int)paramMotionEvent.getRawY();
        if (!QRDisplayActivity.a(paramView, i, j))
        {
          this.a.b.setImageResource(2130843873);
          continue;
          if (paramMotionEvent.getAction() == 0)
          {
            this.a.c.setImageResource(2130843876);
          }
          else if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
          {
            this.a.c.setImageResource(2130843875);
          }
          else if (paramMotionEvent.getAction() == 2)
          {
            i = (int)paramMotionEvent.getRawX();
            j = (int)paramMotionEvent.getRawY();
            if (!QRDisplayActivity.a(paramView, i, j))
            {
              this.a.c.setImageResource(2130843875);
              continue;
              if (paramMotionEvent.getAction() == 0)
              {
                this.a.d.setImageResource(2130843878);
              }
              else if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
              {
                this.a.d.setImageResource(2130843877);
              }
              else if (paramMotionEvent.getAction() == 2)
              {
                i = (int)paramMotionEvent.getRawX();
                j = (int)paramMotionEvent.getRawY();
                if (!QRDisplayActivity.a(paramView, i, j)) {
                  this.a.d.setImageResource(2130843877);
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     otx
 * JD-Core Version:    0.7.0.1
 */