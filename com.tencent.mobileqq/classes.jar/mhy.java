import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.VideoController;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

class mhy
  implements View.OnTouchListener
{
  mhy(mhw parammhw) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = mhw.a(this.a).a();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      int i = Calendar.getInstance().get(11) * 60 + Calendar.getInstance().get(12);
      if (paramView.getId() == 2131373728)
      {
        mhw.a(this.a, 0);
        if (((mhw.a(this.a).a().w != 2) && (mhw.a(this.a).a().w != 3)) || (mhw.b(this.a) == 2) || (mhw.b(this.a) == 3) || (bool) || (!mvk.b())) {
          break label616;
        }
        mhw.a(this.a, true);
        paramView = new mia(this);
        if ((mhw.a(this.a).a().x <= i) && (i < mhw.a(this.a).a().y)) {
          break label590;
        }
        paramView = bhdj.a(mhw.a(this.a), 0, null, anvx.a(2131708367), anvx.a(2131708365), anvx.a(2131708364), paramView, paramView);
        if (paramView != null)
        {
          paramView.show();
          mvk.a();
        }
      }
      for (;;)
      {
        bdla.b(null, "CliOper", "", "", "0X800A564", "0X800A564", 0, 0, "", "", "", "");
        return false;
        if (paramView.getId() == 2131373731)
        {
          mhw.a(this.a, 1);
          break;
        }
        QLog.i("QavDoubleVideoSharpnessMangaer", 1, "hdModeFreeUse. curMinute = " + i + ", startTime = " + mhw.a(this.a).a().x + ", endTime = " + mhw.a(this.a).a().y + ", tips = " + mhw.a(this.a).a().n);
        if ((bool) || ((mhw.a(this.a).a().x <= i) && (i < mhw.a(this.a).a().y)))
        {
          if (paramView.getId() == 2131373738)
          {
            mhw.a(this.a, 2);
            break;
          }
          mhw.a(this.a, 3);
          break;
        }
        mhw.a(this.a, true);
        if (paramView.getId() == 2131373738) {
          mhw.b(this.a, 2);
        }
        for (;;)
        {
          paramView = new mhz(this);
          if ((mhw.a(this.a).a().x > i) || (i >= mhw.a(this.a).a().y))
          {
            paramView = bhdj.a(mhw.a(this.a), 0, anvx.a(2131708361), null, anvx.a(2131708362), anvx.a(2131708363), paramView, paramView);
            if (paramView != null) {
              paramView.show();
            }
          }
          bdla.b(null, "CliOper", "", "", "0X800A562", "0X800A562", 0, 0, "", "", "", "");
          return false;
          mhw.b(this.a, 3);
        }
        label590:
        this.a.c();
        mhw.a(this.a, false);
        mhw.a(this.a);
      }
      label616:
      mhw.a(this.a);
      bdla.b(null, "CliOper", "", "", "0X800A344", "0X800A344", mhw.b(this.a) + 1, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mhy
 * JD-Core Version:    0.7.0.1
 */