import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.QavPanel;

public class mhs
  implements View.OnTouchListener
{
  public mhs(QavPanel paramQavPanel) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((!this.a.h.isEnabled()) || (this.a.a == null)) {}
    int i;
    do
    {
      return false;
      i = this.a.a();
      paramView = this.a.a.a().a();
      switch (paramMotionEvent.getAction())
      {
      case 2: 
      default: 
        return false;
      case 0: 
        if ((i == 0) || (i == 1) || (i == 2))
        {
          if (i == 2)
          {
            if (!QavPanel.a(this.a)) {
              break label247;
            }
            paramView.a("MotionEventDown", true);
            paramView.b("MotionEventDown", 1);
            this.a.a("MotionEventDown", 2, 1, true);
          }
          QavPanel.a(this.a).setAlpha(127);
          QavPanel.a(this.a).setColor(1291845632);
        }
        if (QavPanel.b(this.a))
        {
          QavPanel.a(this.a, false);
          QavPanel.a(this.a).removeMessages(256);
          QavPanel.a(this.a).sendEmptyMessageDelayed(256, 200L);
          QavPanel.a(this.a).removeMessages(261);
        }
        break;
      }
    } while (QavPanel.a(this.a) == null);
    QavPanel.a(this.a).a();
    return false;
    label247:
    if (this.a.a.a().h()) {
      this.a.a.a().h("MotionEventDown", 1);
    }
    for (;;)
    {
      this.a.a("MotionEventDown", 2, 1, false);
      QavPanel.a(this.a).a(false, false);
      break;
      this.a.a.a().a("MotionEventDown", QavPanel.a(this.a).a(), false, true, 1);
    }
    QavPanel.a(this.a).setAlpha(255);
    QavPanel.a(this.a).setAlpha(255);
    QavPanel.a(this.a).removeMessages(256);
    QavPanel.a(this.a).removeMessages(261);
    if (i == 3)
    {
      QavPanel.a(this.a, true);
      if (QavPanel.a(this.a))
      {
        paramView.a("MotionEventACTION_UP", true);
        paramView.b("MotionEventACTION_UP", 1);
        this.a.a("MotionEventUP", 3, 1, true);
      }
    }
    for (;;)
    {
      QavPanel.a(this.a).a();
      return false;
      this.a.a.a().a("MotionEventACTION_UP", QavPanel.a(this.a).a(), false, true, 1);
      this.a.a("MotionEventACTION_UP", 3, 1, false);
      QavPanel.a(this.a).a(false, true);
      continue;
      if (i == 1) {
        QavPanel.a(this.a).setColor(-1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mhs
 * JD-Core Version:    0.7.0.1
 */