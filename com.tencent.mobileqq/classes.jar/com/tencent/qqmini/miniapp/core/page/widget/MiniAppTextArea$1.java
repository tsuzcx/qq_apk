package com.tencent.qqmini.miniapp.core.page.widget;

import android.animation.ObjectAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.qqmini.miniapp.core.page.NativeViewContainer;
import com.tencent.qqmini.miniapp.core.page.PageWebviewContainer;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;

class MiniAppTextArea$1
  implements Runnable
{
  MiniAppTextArea$1(MiniAppTextArea paramMiniAppTextArea) {}
  
  public void run()
  {
    QMLog.i("MiniAppTextArea", "translateRunable isKeyboardShow :  " + MiniAppTextArea.access$000(this.this$0));
    if ((this.this$0.isFocused()) && (MiniAppTextArea.access$000(this.this$0)) && (MiniAppTextArea.access$100(this.this$0) != null) && (MiniAppTextArea.access$100(this.this$0).getPageWebviewContainer() != null)) {
      if (MiniAppTextArea.access$100(this.this$0).isCustomNavibar())
      {
        i = 0;
        i = DisplayUtil.getRealHeight(this.this$0.getContext()) - (i + (this.this$0.getTop() - MiniAppTextArea.access$100(this.this$0).getPageWebviewContainer().getNativeViewScrollY()) + MiniAppTextArea.access$200(this.this$0));
        if ((MiniAppTextArea.access$300(this.this$0) <= i) || (!MiniAppTextArea.access$400(this.this$0)) || (!MiniAppTextArea.access$000(this.this$0))) {
          break label269;
        }
        QMLog.i("MiniAppTextArea", "up !!! ");
        localObjectAnimator = ObjectAnimator.ofFloat(MiniAppTextArea.access$100(this.this$0).getPageWebviewContainer(), "translationY", new float[] { MiniAppTextArea.access$500(this.this$0), -(MiniAppTextArea.access$300(this.this$0) - i) });
        localObjectAnimator.setDuration(200L);
        localObjectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        localObjectAnimator.start();
        MiniAppTextArea.access$502(this.this$0, -(MiniAppTextArea.access$300(this.this$0) - i));
      }
    }
    label269:
    while ((MiniAppTextArea.access$000(this.this$0)) || (MiniAppTextArea.access$100(this.this$0) == null) || (MiniAppTextArea.access$100(this.this$0).getPageWebviewContainer() == null))
    {
      for (;;)
      {
        return;
        int i = MiniAppTextArea.access$100(this.this$0).getNaviBarHeight();
      }
      QMLog.i("MiniAppTextArea", "keep !!! ");
      return;
    }
    QMLog.i("MiniAppTextArea", "down !!! ");
    MiniAppTextArea.access$502(this.this$0, 0);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(MiniAppTextArea.access$100(this.this$0).getPageWebviewContainer(), "translationY", new float[] { MiniAppTextArea.access$100(this.this$0).getPageWebviewContainer().getTranslationY(), 0.0F });
    localObjectAnimator.setDuration(200L);
    localObjectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    localObjectAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.widget.MiniAppTextArea.1
 * JD-Core Version:    0.7.0.1
 */