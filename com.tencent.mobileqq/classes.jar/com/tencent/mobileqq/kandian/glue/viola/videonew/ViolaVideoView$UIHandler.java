package com.tencent.mobileqq.kandian.glue.viola.videonew;

import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

class ViolaVideoView$UIHandler
  extends Handler
{
  private ViolaVideoView$UIHandler(ViolaVideoView paramViolaVideoView) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    String str = "";
    switch (i)
    {
    default: 
    case 8: 
      if (ViolaVideoView.a(this.a).a() == null) {
        return;
      }
      ViolaVideoView.a(this.a).clearAnimation();
      ViolaVideoView.a(this.a).setBackgroundDrawable(ViolaVideoView.a(this.a, 2130843373));
      ViolaVideoView.b(this.a).setVisibility(8);
      ViolaVideoView.b(this.a).setText("");
      return;
    case 7: 
      if (ViolaVideoView.a(this.a).a() == null) {
        return;
      }
      ViolaVideoView.a(this.a).clearAnimation();
      ViolaVideoView.a(this.a).setBackgroundDrawable(ViolaVideoView.a(this.a, 2130843373));
      ViolaVideoView.b(this.a).setVisibility(0);
      ViolaVideoView.b(this.a).setText("");
      return;
    case 6: 
      if (ViolaVideoView.a(this.a).a() == null) {
        return;
      }
      ViolaVideoView.a(this.a).clearAnimation();
      ViolaVideoView.a(this.a).setBackgroundDrawable(ViolaVideoView.a(this.a, 2130843372));
      ViolaVideoView.b(this.a).setVisibility(8);
      ViolaVideoView.b(this.a).setText("");
      if ((ViolaVideoView.c(this.a).getVisibility() == 0) && (NetworkUtil.isMobileNetWork(this.a.getContext())))
      {
        ViolaVideoView.a(this.a).setVisibility(0);
        ViolaVideoView.c(this.a).setVisibility(8);
        return;
      }
      break;
    case 5: 
      if (ViolaVideoView.a(this.a).a() == null) {
        return;
      }
      ViolaVideoView.a(this.a).clearAnimation();
      ViolaVideoView.a(this.a).setBackgroundDrawable(ViolaVideoView.a(this.a, 2130843372));
      ViolaVideoView.b(this.a).setText("");
      return;
    case 4: 
      if (ViolaVideoView.a(this.a).a() == null) {
        return;
      }
      ViolaVideoView.a(this.a).clearAnimation();
      ViolaVideoView.a(this.a).setBackgroundDrawable(ViolaVideoView.a(this.a, 2130848896));
      ViolaVideoView.b(this.a).setVisibility(0);
      ViolaVideoView.b(this.a).setVisibility(0);
      TextView localTextView = ViolaVideoView.b(this.a);
      if (paramMessage.obj != null) {
        str = paramMessage.obj.toString();
      }
      localTextView.setText(str);
      return;
    case 3: 
      if (ViolaVideoView.a(this.a).a() == null) {
        return;
      }
      ViolaVideoView.a(this.a).setBackgroundDrawable(ViolaVideoView.a(this.a, 2130843371));
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
    case 2: 
      if (ViolaVideoView.a(this.a).a() == null) {
        return;
      }
      ViolaVideoView.a(this.a).clearAnimation();
      ViolaVideoView.a(this.a).setBackgroundDrawable(ViolaVideoView.a(this.a, 2130843373));
      ViolaVideoView.b(this.a).setVisibility(0);
      ViolaVideoView.b(this.a).setText("");
      return;
    case 1: 
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("mUiHandler.postDelayed() innerChangePlayButton(MSG_SHOW_LOADING_BTN) mIsNeedShowLoading = ");
        paramMessage.append(ViolaVideoView.a(this.a));
        QLog.d("ViolaVideoView", 2, paramMessage.toString());
      }
      if (ViolaVideoView.a(this.a))
      {
        ViolaVideoView.a(this.a, 3, null);
        return;
      }
      break;
    case 0: 
      ViolaVideoView.a(this.a).sendEmptyMessageDelayed(0, 3000L);
      long l = ViolaVideoView.a(this.a);
      l = 3000L - (System.currentTimeMillis() - l);
      if (l > 0L)
      {
        ViolaVideoView.a(this.a).removeMessages(0);
        ViolaVideoView.a(this.a).sendEmptyMessageDelayed(0, l);
        return;
      }
      if (ViolaVideoView.a(this.a).a()) {
        ViolaVideoView.a(this.a, false);
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.ViolaVideoView.UIHandler
 * JD-Core Version:    0.7.0.1
 */