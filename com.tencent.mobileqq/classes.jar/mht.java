import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

class mht
  implements View.OnTouchListener
{
  mht(mhr parammhr) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = mhr.a(this.a).a();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      int i = Calendar.getInstance().get(11) * 60 + Calendar.getInstance().get(12);
      if (paramView.getId() == 2131373599)
      {
        mhr.a(this.a, 0);
        if (((mhr.a(this.a).a().w != 2) && (mhr.a(this.a).a().w != 3)) || (mhr.b(this.a) == 2) || (mhr.b(this.a) == 3) || (bool) || (!mvd.b())) {
          break label616;
        }
        mhr.a(this.a, true);
        paramView = new mhv(this);
        if ((mhr.a(this.a).a().x <= i) && (i < mhr.a(this.a).a().y)) {
          break label590;
        }
        paramView = bhlq.a(mhr.a(this.a), 0, null, anzj.a(2131707788), anzj.a(2131707786), anzj.a(2131707785), paramView, paramView);
        if (paramView != null)
        {
          paramView.show();
          mvd.a();
        }
      }
      for (;;)
      {
        bdll.b(null, "CliOper", "", "", "0X800A564", "0X800A564", 0, 0, "", "", "", "");
        return false;
        if (paramView.getId() == 2131373602)
        {
          mhr.a(this.a, 1);
          break;
        }
        QLog.i("QavDoubleVideoSharpnessMangaer", 1, "hdModeFreeUse. curMinute = " + i + ", startTime = " + mhr.a(this.a).a().x + ", endTime = " + mhr.a(this.a).a().y + ", tips = " + mhr.a(this.a).a().n);
        if ((bool) || ((mhr.a(this.a).a().x <= i) && (i < mhr.a(this.a).a().y)))
        {
          if (paramView.getId() == 2131373609)
          {
            mhr.a(this.a, 2);
            break;
          }
          mhr.a(this.a, 3);
          break;
        }
        mhr.a(this.a, true);
        if (paramView.getId() == 2131373609) {
          mhr.b(this.a, 2);
        }
        for (;;)
        {
          paramView = new mhu(this);
          if ((mhr.a(this.a).a().x > i) || (i >= mhr.a(this.a).a().y))
          {
            paramView = bhlq.a(mhr.a(this.a), 0, anzj.a(2131707782), null, anzj.a(2131707783), anzj.a(2131707784), paramView, paramView);
            if (paramView != null) {
              paramView.show();
            }
          }
          bdll.b(null, "CliOper", "", "", "0X800A562", "0X800A562", 0, 0, "", "", "", "");
          return false;
          mhr.b(this.a, 3);
        }
        label590:
        this.a.c();
        mhr.a(this.a, false);
        mhr.a(this.a);
      }
      label616:
      mhr.a(this.a);
      bdll.b(null, "CliOper", "", "", "0X800A344", "0X800A344", mhr.b(this.a) + 1, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mht
 * JD-Core Version:    0.7.0.1
 */