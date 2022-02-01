package com.tencent.mobileqq.qqgift.mvvm.business.view;

import com.tencent.mobileqq.qqgift.callback.IQQGiftAnimationListener;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

class QQGiftPAGAnimationViewImpl$1
  implements PAGView.PAGViewListener
{
  QQGiftPAGAnimationViewImpl$1(QQGiftPAGAnimationViewImpl paramQQGiftPAGAnimationViewImpl) {}
  
  public void onAnimationCancel(PAGView paramPAGView)
  {
    if (!paramPAGView.isPlaying())
    {
      paramPAGView.setComposition(null);
      paramPAGView.flush();
    }
  }
  
  public void onAnimationEnd(PAGView paramPAGView)
  {
    if (QQGiftPAGAnimationViewImpl.a(this.a) != null) {
      QQGiftPAGAnimationViewImpl.a(this.a).b();
    }
    if (!paramPAGView.isPlaying())
    {
      paramPAGView.setComposition(null);
      paramPAGView.flush();
    }
  }
  
  public void onAnimationRepeat(PAGView paramPAGView) {}
  
  public void onAnimationStart(PAGView paramPAGView)
  {
    if (QQGiftPAGAnimationViewImpl.a(this.a) != null) {
      QQGiftPAGAnimationViewImpl.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.view.QQGiftPAGAnimationViewImpl.1
 * JD-Core Version:    0.7.0.1
 */