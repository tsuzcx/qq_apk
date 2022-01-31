import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.VideoController;

class lws
  implements View.OnTouchListener
{
  lws(lwq paramlwq) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = lwq.a(this.a).a();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      if (paramView.getId() == 2131306770) {
        lwq.a(this.a, 0);
      }
      while ((lwq.a(this.a).a().v == 2) && (lwq.a(this.a) != 2) && (!bool) && (mjg.b()))
      {
        lwq.a(this.a, true);
        paramView = new lwu(this);
        paramView = babr.a(lwq.a(this.a), 0, null, ajjy.a(2131643123), ajjy.a(2131643121), ajjy.a(2131643120), paramView, paramView);
        if (paramView != null)
        {
          paramView.show();
          mjg.a();
        }
        awqx.b(null, "CliOper", "", "", "0X800A564", "0X800A564", 0, 0, "", "", "", "");
        return false;
        if (paramView.getId() == 2131306776)
        {
          lwq.a(this.a, 1);
        }
        else if (bool)
        {
          lwq.a(this.a, 2);
        }
        else
        {
          lwq.a(this.a, true);
          paramView = new lwt(this);
          paramView = babr.a(lwq.a(this.a), 0, ajjy.a(2131643117), null, ajjy.a(2131643118), ajjy.a(2131643119), paramView, paramView);
          if (paramView != null) {
            paramView.show();
          }
          awqx.b(null, "CliOper", "", "", "0X800A562", "0X800A562", 0, 0, "", "", "", "");
          return false;
        }
      }
      lwq.a(this.a);
      awqx.b(null, "CliOper", "", "", "0X800A344", "0X800A344", lwq.a(this.a) + 1, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lws
 * JD-Core Version:    0.7.0.1
 */