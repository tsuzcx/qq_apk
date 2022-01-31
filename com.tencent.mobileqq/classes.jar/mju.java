import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

class mju
  implements View.OnTouchListener
{
  mju(mjs parammjs) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = mjs.a(this.a).a();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      int i = Calendar.getInstance().get(11) * 60 + Calendar.getInstance().get(12);
      if (paramView.getId() == 2131372834)
      {
        mjs.a(this.a, 0);
        if (((mjs.a(this.a).a().v != 2) && (mjs.a(this.a).a().v != 3)) || (mjs.b(this.a) == 2) || (mjs.b(this.a) == 3) || (bool) || (!mww.b())) {
          break label616;
        }
        mjs.a(this.a, true);
        paramView = new mjw(this);
        if ((mjs.a(this.a).a().w <= i) && (i < mjs.a(this.a).a().x)) {
          break label590;
        }
        paramView = bdcd.a(mjs.a(this.a), 0, null, alpo.a(2131709291), alpo.a(2131709289), alpo.a(2131709288), paramView, paramView);
        if (paramView != null)
        {
          paramView.show();
          mww.a();
        }
      }
      for (;;)
      {
        azmj.b(null, "CliOper", "", "", "0X800A564", "0X800A564", 0, 0, "", "", "", "");
        return false;
        if (paramView.getId() == 2131372837)
        {
          mjs.a(this.a, 1);
          break;
        }
        QLog.i("QavDoubleVideoSharpnessMangaer", 1, "hdModeFreeUse. curMinute = " + i + ", startTime = " + mjs.a(this.a).a().w + ", endTime = " + mjs.a(this.a).a().x + ", tips = " + mjs.a(this.a).a().n);
        if ((bool) || ((mjs.a(this.a).a().w <= i) && (i < mjs.a(this.a).a().x)))
        {
          if (paramView.getId() == 2131372844)
          {
            mjs.a(this.a, 2);
            break;
          }
          mjs.a(this.a, 3);
          break;
        }
        mjs.a(this.a, true);
        if (paramView.getId() == 2131372844) {
          mjs.b(this.a, 2);
        }
        for (;;)
        {
          paramView = new mjv(this);
          if ((mjs.a(this.a).a().w > i) || (i >= mjs.a(this.a).a().x))
          {
            paramView = bdcd.a(mjs.a(this.a), 0, alpo.a(2131709285), null, alpo.a(2131709286), alpo.a(2131709287), paramView, paramView);
            if (paramView != null) {
              paramView.show();
            }
          }
          azmj.b(null, "CliOper", "", "", "0X800A562", "0X800A562", 0, 0, "", "", "", "");
          return false;
          mjs.b(this.a, 3);
        }
        label590:
        this.a.c();
        mjs.a(this.a, false);
        mjs.a(this.a);
      }
      label616:
      mjs.a(this.a);
      azmj.b(null, "CliOper", "", "", "0X800A344", "0X800A344", mjs.b(this.a) + 1, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mju
 * JD-Core Version:    0.7.0.1
 */