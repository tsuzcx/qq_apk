package com.tencent.mobileqq.flashshow.widgets.comment;

import android.os.Handler;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.CreateResultListener;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.qphone.base.util.QLog;

class FSPanelLoadingView$1
  implements AnimationDrawableFactory.CreateResultListener
{
  FSPanelLoadingView$1(FSPanelLoadingView paramFSPanelLoadingView) {}
  
  public void a(boolean paramBoolean, QQAnimationDrawable paramQQAnimationDrawable)
  {
    if ((paramBoolean) && (paramQQAnimationDrawable != null))
    {
      paramQQAnimationDrawable.b(false);
      FSPanelLoadingView.a(this.a, paramQQAnimationDrawable);
      this.a.getMainHandler().post(new FSPanelLoadingView.1.1(this));
      return;
    }
    this.a.getMainHandler().post(new FSPanelLoadingView.1.2(this));
    QLog.e("FSPanelLoadingView", 1, "fetchAnimDrawable fail! use static logo");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.FSPanelLoadingView.1
 * JD-Core Version:    0.7.0.1
 */