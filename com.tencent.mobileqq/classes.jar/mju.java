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
      if (paramView.getId() == 2131372860)
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
        paramView = bdgm.a(mjs.a(this.a), 0, null, alud.a(2131709303), alud.a(2131709301), alud.a(2131709300), paramView, paramView);
        if (paramView != null)
        {
          paramView.show();
          mww.a();
        }
      }
      for (;;)
      {
        azqs.b(null, "CliOper", "", "", "0X800A564", "0X800A564", 0, 0, "", "", "", "");
        return false;
        if (paramView.getId() == 2131372863)
        {
          mjs.a(this.a, 1);
          break;
        }
        QLog.i("QavDoubleVideoSharpnessMangaer", 1, "hdModeFreeUse. curMinute = " + i + ", startTime = " + mjs.a(this.a).a().w + ", endTime = " + mjs.a(this.a).a().x + ", tips = " + mjs.a(this.a).a().n);
        if ((bool) || ((mjs.a(this.a).a().w <= i) && (i < mjs.a(this.a).a().x)))
        {
          if (paramView.getId() == 2131372870)
          {
            mjs.a(this.a, 2);
            break;
          }
          mjs.a(this.a, 3);
          break;
        }
        mjs.a(this.a, true);
        if (paramView.getId() == 2131372870) {
          mjs.b(this.a, 2);
        }
        for (;;)
        {
          paramView = new mjv(this);
          if ((mjs.a(this.a).a().w > i) || (i >= mjs.a(this.a).a().x))
          {
            paramView = bdgm.a(mjs.a(this.a), 0, alud.a(2131709297), null, alud.a(2131709298), alud.a(2131709299), paramView, paramView);
            if (paramView != null) {
              paramView.show();
            }
          }
          azqs.b(null, "CliOper", "", "", "0X800A562", "0X800A562", 0, 0, "", "", "", "");
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
      azqs.b(null, "CliOper", "", "", "0X800A344", "0X800A344", mjs.b(this.a) + 1, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mju
 * JD-Core Version:    0.7.0.1
 */