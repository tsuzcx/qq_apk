import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.ViolaVideoView;
import com.tencent.qphone.base.util.QLog;

public class sqm
  extends Handler
{
  private sqm(ViolaVideoView paramViolaVideoView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return;
                        ViolaVideoView.a(this.a).sendEmptyMessageDelayed(0, 3000L);
                        long l = ViolaVideoView.a(this.a);
                        l = 3000L - (System.currentTimeMillis() - l);
                        if (l > 0L)
                        {
                          ViolaVideoView.a(this.a).removeMessages(0);
                          ViolaVideoView.a(this.a).sendEmptyMessageDelayed(0, l);
                          return;
                        }
                      } while (!ViolaVideoView.a(this.a).d());
                      ViolaVideoView.a(this.a, false);
                      return;
                      if (QLog.isColorLevel()) {
                        QLog.d("ViolaVideoView", 2, "mUiHandler.postDelayed() innerChangePlayButton(MSG_SHOW_LOADING_BTN) mIsNeedShowLoading = " + ViolaVideoView.a(this.a));
                      }
                    } while (!ViolaVideoView.a(this.a));
                    ViolaVideoView.a(this.a, 3, null);
                    return;
                  } while (ViolaVideoView.a(this.a).a() == null);
                  ViolaVideoView.a(this.a).setBackgroundDrawable(ViolaVideoView.a(this.a, 2130842834));
                  ViolaVideoView.a(this.a).clearAnimation();
                  paramMessage = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
                  paramMessage.setDuration(500L);
                  paramMessage.setRepeatCount(-1);
                  paramMessage.setRepeatMode(1);
                  paramMessage.setStartTime(-1L);
                  paramMessage.setInterpolator(new LinearInterpolator());
                  ViolaVideoView.a(this.a).startAnimation(paramMessage);
                  ViolaVideoView.b(this.a).setVisibility(0);
                  ViolaVideoView.b(this.a).setText("");
                  return;
                } while (ViolaVideoView.a(this.a).a() == null);
                ViolaVideoView.a(this.a).clearAnimation();
                ViolaVideoView.a(this.a).setBackgroundDrawable(ViolaVideoView.a(this.a, 2130842836));
                ViolaVideoView.b(this.a).setVisibility(0);
                ViolaVideoView.b(this.a).setText("");
                return;
              } while (ViolaVideoView.a(this.a).a() == null);
              ViolaVideoView.a(this.a).clearAnimation();
              ViolaVideoView.a(this.a).setBackgroundDrawable(ViolaVideoView.a(this.a, 2130842836));
              ViolaVideoView.b(this.a).setVisibility(8);
              ViolaVideoView.b(this.a).setText("");
              return;
            } while (ViolaVideoView.a(this.a).a() == null);
            ViolaVideoView.a(this.a).clearAnimation();
            ViolaVideoView.a(this.a).setBackgroundDrawable(ViolaVideoView.a(this.a, 2130842836));
            ViolaVideoView.b(this.a).setVisibility(0);
            ViolaVideoView.b(this.a).setText("");
            return;
          } while (ViolaVideoView.a(this.a).a() == null);
          ViolaVideoView.a(this.a).clearAnimation();
          ViolaVideoView.a(this.a).setBackgroundDrawable(ViolaVideoView.a(this.a, 2130842835));
          ViolaVideoView.b(this.a).setText("");
          return;
        } while (ViolaVideoView.a(this.a).a() == null);
        ViolaVideoView.a(this.a).clearAnimation();
        ViolaVideoView.a(this.a).setBackgroundDrawable(ViolaVideoView.a(this.a, 2130842835));
        ViolaVideoView.b(this.a).setVisibility(8);
        ViolaVideoView.b(this.a).setText("");
      } while ((ViolaVideoView.c(this.a).getVisibility() != 0) || (!bdin.b(this.a.getContext())));
      ViolaVideoView.a(this.a).setVisibility(0);
      ViolaVideoView.c(this.a).setVisibility(8);
      return;
    } while (ViolaVideoView.a(this.a).a() == null);
    ViolaVideoView.a(this.a).clearAnimation();
    ViolaVideoView.a(this.a).setBackgroundDrawable(ViolaVideoView.a(this.a, 2130848138));
    ViolaVideoView.b(this.a).setVisibility(0);
    ViolaVideoView.b(this.a).setVisibility(0);
    TextView localTextView = ViolaVideoView.b(this.a);
    if (paramMessage.obj != null) {}
    for (paramMessage = paramMessage.obj.toString();; paramMessage = "")
    {
      localTextView.setText(paramMessage);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sqm
 * JD-Core Version:    0.7.0.1
 */