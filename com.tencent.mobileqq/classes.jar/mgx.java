import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

class mgx
  implements View.OnTouchListener
{
  mgx(mgv parammgv) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = mgv.a(this.a).a();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      int i = Calendar.getInstance().get(11) * 60 + Calendar.getInstance().get(12);
      if (paramView.getId() == 2131373475)
      {
        mgv.a(this.a, 0);
        if (((mgv.a(this.a).a().w != 2) && (mgv.a(this.a).a().w != 3)) || (mgv.b(this.a) == 2) || (mgv.b(this.a) == 3) || (bool) || (!mue.b())) {
          break label616;
        }
        mgv.a(this.a, true);
        paramView = new mgz(this);
        if ((mgv.a(this.a).a().x <= i) && (i < mgv.a(this.a).a().y)) {
          break label590;
        }
        paramView = bglp.a(mgv.a(this.a), 0, null, anni.a(2131707679), anni.a(2131707677), anni.a(2131707676), paramView, paramView);
        if (paramView != null)
        {
          paramView.show();
          mue.a();
        }
      }
      for (;;)
      {
        bcst.b(null, "CliOper", "", "", "0X800A564", "0X800A564", 0, 0, "", "", "", "");
        return false;
        if (paramView.getId() == 2131373478)
        {
          mgv.a(this.a, 1);
          break;
        }
        QLog.i("QavDoubleVideoSharpnessMangaer", 1, "hdModeFreeUse. curMinute = " + i + ", startTime = " + mgv.a(this.a).a().x + ", endTime = " + mgv.a(this.a).a().y + ", tips = " + mgv.a(this.a).a().n);
        if ((bool) || ((mgv.a(this.a).a().x <= i) && (i < mgv.a(this.a).a().y)))
        {
          if (paramView.getId() == 2131373485)
          {
            mgv.a(this.a, 2);
            break;
          }
          mgv.a(this.a, 3);
          break;
        }
        mgv.a(this.a, true);
        if (paramView.getId() == 2131373485) {
          mgv.b(this.a, 2);
        }
        for (;;)
        {
          paramView = new mgy(this);
          if ((mgv.a(this.a).a().x > i) || (i >= mgv.a(this.a).a().y))
          {
            paramView = bglp.a(mgv.a(this.a), 0, anni.a(2131707673), null, anni.a(2131707674), anni.a(2131707675), paramView, paramView);
            if (paramView != null) {
              paramView.show();
            }
          }
          bcst.b(null, "CliOper", "", "", "0X800A562", "0X800A562", 0, 0, "", "", "", "");
          return false;
          mgv.b(this.a, 3);
        }
        label590:
        this.a.c();
        mgv.a(this.a, false);
        mgv.a(this.a);
      }
      label616:
      mgv.a(this.a);
      bcst.b(null, "CliOper", "", "", "0X800A344", "0X800A344", mgv.b(this.a) + 1, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mgx
 * JD-Core Version:    0.7.0.1
 */