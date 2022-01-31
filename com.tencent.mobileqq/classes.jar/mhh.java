import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

class mhh
  implements View.OnTouchListener
{
  mhh(mhf parammhf) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = mhf.a(this.a).a();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      int i = Calendar.getInstance().get(11) * 60 + Calendar.getInstance().get(12);
      if (paramView.getId() == 2131372476)
      {
        mhf.a(this.a, 0);
        if (((mhf.a(this.a).a().v != 2) && (mhf.a(this.a).a().v != 3)) || (mhf.b(this.a) == 2) || (mhf.b(this.a) == 3) || (bool) || (!muf.b())) {
          break label616;
        }
        mhf.a(this.a, true);
        paramView = new mhj(this);
        if ((mhf.a(this.a).a().w <= i) && (i < mhf.a(this.a).a().x)) {
          break label590;
        }
        paramView = bbcv.a(mhf.a(this.a), 0, null, ajyc.a(2131708908), ajyc.a(2131708906), ajyc.a(2131708905), paramView, paramView);
        if (paramView != null)
        {
          paramView.show();
          muf.a();
        }
      }
      for (;;)
      {
        axqw.b(null, "CliOper", "", "", "0X800A564", "0X800A564", 0, 0, "", "", "", "");
        return false;
        if (paramView.getId() == 2131372479)
        {
          mhf.a(this.a, 1);
          break;
        }
        QLog.i("QavDoubleVideoSharpnessMangaer", 1, "hdModeFreeUse. curMinute = " + i + ", startTime = " + mhf.a(this.a).a().w + ", endTime = " + mhf.a(this.a).a().x + ", tips = " + mhf.a(this.a).a().n);
        if ((bool) || ((mhf.a(this.a).a().w <= i) && (i < mhf.a(this.a).a().x)))
        {
          if (paramView.getId() == 2131372486)
          {
            mhf.a(this.a, 2);
            break;
          }
          mhf.a(this.a, 3);
          break;
        }
        mhf.a(this.a, true);
        if (paramView.getId() == 2131372486) {
          mhf.b(this.a, 2);
        }
        for (;;)
        {
          paramView = new mhi(this);
          if ((mhf.a(this.a).a().w > i) || (i >= mhf.a(this.a).a().x))
          {
            paramView = bbcv.a(mhf.a(this.a), 0, ajyc.a(2131708902), null, ajyc.a(2131708903), ajyc.a(2131708904), paramView, paramView);
            if (paramView != null) {
              paramView.show();
            }
          }
          axqw.b(null, "CliOper", "", "", "0X800A562", "0X800A562", 0, 0, "", "", "", "");
          return false;
          mhf.b(this.a, 3);
        }
        label590:
        this.a.c();
        mhf.a(this.a, false);
        mhf.a(this.a);
      }
      label616:
      mhf.a(this.a);
      axqw.b(null, "CliOper", "", "", "0X800A344", "0X800A344", mhf.b(this.a) + 1, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mhh
 * JD-Core Version:    0.7.0.1
 */