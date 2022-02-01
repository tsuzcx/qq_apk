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
      if (ViolaVideoView.a(this.a).m() == null) {
        return;
      }
      ViolaVideoView.i(this.a).clearAnimation();
      ViolaVideoView.i(this.a).setBackgroundDrawable(ViolaVideoView.a(this.a, 2130844327));
      ViolaVideoView.j(this.a).setVisibility(8);
      ViolaVideoView.k(this.a).setText("");
      return;
    case 7: 
      if (ViolaVideoView.a(this.a).m() == null) {
        return;
      }
      ViolaVideoView.i(this.a).clearAnimation();
      ViolaVideoView.i(this.a).setBackgroundDrawable(ViolaVideoView.a(this.a, 2130844327));
      ViolaVideoView.j(this.a).setVisibility(0);
      ViolaVideoView.k(this.a).setText("");
      return;
    case 6: 
      if (ViolaVideoView.a(this.a).m() == null) {
        return;
      }
      ViolaVideoView.i(this.a).clearAnimation();
      ViolaVideoView.i(this.a).setBackgroundDrawable(ViolaVideoView.a(this.a, 2130844326));
      ViolaVideoView.j(this.a).setVisibility(8);
      ViolaVideoView.k(this.a).setText("");
      if ((ViolaVideoView.l(this.a).getVisibility() == 0) && (NetworkUtil.isMobileNetWork(this.a.getContext())))
      {
        ViolaVideoView.i(this.a).setVisibility(0);
        ViolaVideoView.l(this.a).setVisibility(8);
        return;
      }
      break;
    case 5: 
      if (ViolaVideoView.a(this.a).m() == null) {
        return;
      }
      ViolaVideoView.i(this.a).clearAnimation();
      ViolaVideoView.i(this.a).setBackgroundDrawable(ViolaVideoView.a(this.a, 2130844326));
      ViolaVideoView.k(this.a).setText("");
      return;
    case 4: 
      if (ViolaVideoView.a(this.a).m() == null) {
        return;
      }
      ViolaVideoView.i(this.a).clearAnimation();
      ViolaVideoView.i(this.a).setBackgroundDrawable(ViolaVideoView.a(this.a, 2130850563));
      ViolaVideoView.j(this.a).setVisibility(0);
      ViolaVideoView.k(this.a).setVisibility(0);
      TextView localTextView = ViolaVideoView.k(this.a);
      if (paramMessage.obj != null) {
        str = paramMessage.obj.toString();
      }
      localTextView.setText(str);
      return;
    case 3: 
      if (ViolaVideoView.a(this.a).m() == null) {
        return;
      }
      ViolaVideoView.i(this.a).setBackgroundDrawable(ViolaVideoView.a(this.a, 2130844325));
      ViolaVideoView.i(this.a).clearAnimation();
      paramMessage = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
      paramMessage.setDuration(500L);
      paramMessage.setRepeatCount(-1);
      paramMessage.setRepeatMode(1);
      paramMessage.setStartTime(-1L);
      paramMessage.setInterpolator(new LinearInterpolator());
      ViolaVideoView.i(this.a).startAnimation(paramMessage);
      ViolaVideoView.j(this.a).setVisibility(0);
      ViolaVideoView.k(this.a).setText("");
      return;
    case 2: 
      if (ViolaVideoView.a(this.a).m() == null) {
        return;
      }
      ViolaVideoView.i(this.a).clearAnimation();
      ViolaVideoView.i(this.a).setBackgroundDrawable(ViolaVideoView.a(this.a, 2130844327));
      ViolaVideoView.j(this.a).setVisibility(0);
      ViolaVideoView.k(this.a).setText("");
      return;
    case 1: 
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("mUiHandler.postDelayed() innerChangePlayButton(MSG_SHOW_LOADING_BTN) mIsNeedShowLoading = ");
        paramMessage.append(ViolaVideoView.h(this.a));
        QLog.d("ViolaVideoView", 2, paramMessage.toString());
      }
      if (ViolaVideoView.h(this.a))
      {
        ViolaVideoView.a(this.a, 3, null);
        return;
      }
      break;
    case 0: 
      ViolaVideoView.f(this.a).sendEmptyMessageDelayed(0, 3000L);
      long l = ViolaVideoView.g(this.a);
      l = 3000L - (System.currentTimeMillis() - l);
      if (l > 0L)
      {
        ViolaVideoView.f(this.a).removeMessages(0);
        ViolaVideoView.f(this.a).sendEmptyMessageDelayed(0, l);
        return;
      }
      if (ViolaVideoView.a(this.a).g()) {
        ViolaVideoView.b(this.a, false);
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.ViolaVideoView.UIHandler
 * JD-Core Version:    0.7.0.1
 */