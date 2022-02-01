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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("translateRunable isKeyboardShow :  ");
    ((StringBuilder)localObject).append(MiniAppTextArea.access$000(this.this$0));
    QMLog.i("MiniAppTextArea", ((StringBuilder)localObject).toString());
    if ((this.this$0.isFocused()) && (MiniAppTextArea.access$000(this.this$0)) && (MiniAppTextArea.access$100(this.this$0) != null) && (MiniAppTextArea.access$100(this.this$0).getPageWebviewContainer() != null))
    {
      if (MiniAppTextArea.access$100(this.this$0).isCustomNavibar()) {
        i = 0;
      } else {
        i = MiniAppTextArea.access$100(this.this$0).getNaviBarHeight();
      }
      int i = DisplayUtil.getRealHeight(this.this$0.getContext()) - (this.this$0.getTop() - MiniAppTextArea.access$100(this.this$0).getPageWebviewContainer().getNativeViewScrollY() + i + MiniAppTextArea.access$200(this.this$0));
      if ((MiniAppTextArea.access$300(this.this$0) > i) && (MiniAppTextArea.access$400(this.this$0)) && (MiniAppTextArea.access$000(this.this$0)))
      {
        QMLog.i("MiniAppTextArea", "up !!! ");
        localObject = ObjectAnimator.ofFloat(MiniAppTextArea.access$100(this.this$0).getPageWebviewContainer(), "translationY", new float[] { MiniAppTextArea.access$500(this.this$0), -(MiniAppTextArea.access$300(this.this$0) - i) });
        ((ObjectAnimator)localObject).setDuration(200L);
        ((ObjectAnimator)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
        ((ObjectAnimator)localObject).start();
        localObject = this.this$0;
        MiniAppTextArea.access$502((MiniAppTextArea)localObject, -(MiniAppTextArea.access$300((MiniAppTextArea)localObject) - i));
        return;
      }
      QMLog.i("MiniAppTextArea", "keep !!! ");
      return;
    }
    if ((!MiniAppTextArea.access$000(this.this$0)) && (MiniAppTextArea.access$100(this.this$0) != null) && (MiniAppTextArea.access$100(this.this$0).getPageWebviewContainer() != null))
    {
      QMLog.i("MiniAppTextArea", "down !!! ");
      MiniAppTextArea.access$502(this.this$0, 0);
      localObject = ObjectAnimator.ofFloat(MiniAppTextArea.access$100(this.this$0).getPageWebviewContainer(), "translationY", new float[] { MiniAppTextArea.access$100(this.this$0).getPageWebviewContainer().getTranslationY(), 0.0F });
      ((ObjectAnimator)localObject).setDuration(200L);
      ((ObjectAnimator)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
      ((ObjectAnimator)localObject).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.widget.MiniAppTextArea.1
 * JD-Core Version:    0.7.0.1
 */