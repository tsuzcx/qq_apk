import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.VideoController;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

class mhc
  implements View.OnTouchListener
{
  mhc(mha parammha) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = mha.a(this.a).a();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      int i = Calendar.getInstance().get(11) * 60 + Calendar.getInstance().get(12);
      if (paramView.getId() == 2131373515)
      {
        mha.a(this.a, 0);
        if (((mha.a(this.a).a().w != 2) && (mha.a(this.a).a().w != 3)) || (mha.b(this.a) == 2) || (mha.b(this.a) == 3) || (bool) || (!mum.b())) {
          break label616;
        }
        mha.a(this.a, true);
        paramView = new mhe(this);
        if ((mha.a(this.a).a().x <= i) && (i < mha.a(this.a).a().y)) {
          break label590;
        }
        paramView = bfur.a(mha.a(this.a), 0, null, amtj.a(2131708020), amtj.a(2131708018), amtj.a(2131708017), paramView, paramView);
        if (paramView != null)
        {
          paramView.show();
          mum.a();
        }
      }
      for (;;)
      {
        bcef.b(null, "CliOper", "", "", "0X800A564", "0X800A564", 0, 0, "", "", "", "");
        return false;
        if (paramView.getId() == 2131373518)
        {
          mha.a(this.a, 1);
          break;
        }
        QLog.i("QavDoubleVideoSharpnessMangaer", 1, "hdModeFreeUse. curMinute = " + i + ", startTime = " + mha.a(this.a).a().x + ", endTime = " + mha.a(this.a).a().y + ", tips = " + mha.a(this.a).a().n);
        if ((bool) || ((mha.a(this.a).a().x <= i) && (i < mha.a(this.a).a().y)))
        {
          if (paramView.getId() == 2131373525)
          {
            mha.a(this.a, 2);
            break;
          }
          mha.a(this.a, 3);
          break;
        }
        mha.a(this.a, true);
        if (paramView.getId() == 2131373525) {
          mha.b(this.a, 2);
        }
        for (;;)
        {
          paramView = new mhd(this);
          if ((mha.a(this.a).a().x > i) || (i >= mha.a(this.a).a().y))
          {
            paramView = bfur.a(mha.a(this.a), 0, amtj.a(2131708014), null, amtj.a(2131708015), amtj.a(2131708016), paramView, paramView);
            if (paramView != null) {
              paramView.show();
            }
          }
          bcef.b(null, "CliOper", "", "", "0X800A562", "0X800A562", 0, 0, "", "", "", "");
          return false;
          mha.b(this.a, 3);
        }
        label590:
        this.a.c();
        mha.a(this.a, false);
        mha.a(this.a);
      }
      label616:
      mha.a(this.a);
      bcef.b(null, "CliOper", "", "", "0X800A344", "0X800A344", mha.b(this.a) + 1, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mhc
 * JD-Core Version:    0.7.0.1
 */