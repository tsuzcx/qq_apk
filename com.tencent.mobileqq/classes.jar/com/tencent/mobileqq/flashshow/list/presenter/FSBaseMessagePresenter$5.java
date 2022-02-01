package com.tencent.mobileqq.flashshow.list.presenter;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.mobileqq.flashshow.widgets.common.FSAvatarView;
import com.tencent.mobileqq.utils.ViewUtils;

class FSBaseMessagePresenter$5
  implements Runnable
{
  FSBaseMessagePresenter$5(FSBaseMessagePresenter paramFSBaseMessagePresenter) {}
  
  public void run()
  {
    Object localObject = new Rect();
    this.this$0.f.getHitRect((Rect)localObject);
    int i = ViewUtils.dip2px(10.0F);
    ((Rect)localObject).left -= i;
    ((Rect)localObject).top -= i;
    ((Rect)localObject).right += i;
    ((Rect)localObject).bottom += i;
    localObject = new TouchDelegate((Rect)localObject, this.this$0.f);
    this.this$0.a.setTouchDelegate((TouchDelegate)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.list.presenter.FSBaseMessagePresenter.5
 * JD-Core Version:    0.7.0.1
 */