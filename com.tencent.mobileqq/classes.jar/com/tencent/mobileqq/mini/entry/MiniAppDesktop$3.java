package com.tencent.mobileqq.mini.entry;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.armap.ConversationActivePendantHolderBase;
import com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopLayout;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ARMapHongBaoListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import mqq.util.WeakReference;

class MiniAppDesktop$3
  extends AnimatorListenerAdapter
{
  MiniAppDesktop$3(MiniAppDesktop paramMiniAppDesktop) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    MiniAppDesktop.access$1202(this.this$0, true);
    if (MiniAppDesktop.access$600(this.this$0) != FrameControllerUtil.a) {
      this.this$0.hideMiniAppEntry(-1);
    }
    MiniAppDesktop.access$300(this.this$0).desktopOpened();
    MiniAppDesktop.access$1300(this.this$0, 2);
    if (MiniAppDesktop.access$500(this.this$0).b != null) {
      MiniAppDesktop.access$500(this.this$0).b.g();
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (MiniAppDesktop.access$600(this.this$0) != FrameControllerUtil.a)
    {
      paramAnimator.cancel();
      this.this$0.hideMiniAppEntry(-1);
      return;
    }
    paramAnimator = this.this$0;
    int i = 0;
    MiniAppDesktop.access$700(paramAnimator, false);
    if ((ThemeUtil.isDefaultTheme()) || (ThemeUtil.isGoldenTheme()) || (DisplayUtil.isWhiteModeTheme()) || (DisplayUtil.isSimpleThemeAndStatusBarOfWhite(ThemeUtil.getCurrentThemeId())))
    {
      paramAnimator = (Activity)MiniAppDesktop.access$800(this.this$0).get();
      if (paramAnimator != null)
      {
        ImmersiveUtils.setStatusTextColor(true, paramAnimator.getWindow());
        MiniAppDesktop.access$902(this.this$0, true);
        if (QLog.isColorLevel()) {
          QLog.d("MiniAppDesktop", 2, "animateOpen, set status bar text color.");
        }
      }
    }
    MiniAppDesktop.access$1000(this.this$0);
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "miniappbringtitlebartofront", 1) == 1) {
      i = 1;
    }
    if (i != 0) {
      MiniAppDesktop.access$1100(this.this$0).bringToFront();
    }
    MiniAppDesktop.access$300(this.this$0).notifyMiniAppDataChanged();
    QLog.d("MiniAppDesktop", 1, "[animation].animateOpen, onAnimationStart");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppDesktop.3
 * JD-Core Version:    0.7.0.1
 */