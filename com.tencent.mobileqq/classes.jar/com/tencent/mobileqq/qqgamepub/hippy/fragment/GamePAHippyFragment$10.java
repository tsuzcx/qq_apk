package com.tencent.mobileqq.qqgamepub.hippy.fragment;

import com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyPresenter;
import com.tencent.mobileqq.qqgamepub.view.QQGamePubViewpager;
import com.tencent.mobileqq.qqgamepub.web.view.QQGameIndicator2;

class GamePAHippyFragment$10
  implements Runnable
{
  GamePAHippyFragment$10(GamePAHippyFragment paramGamePAHippyFragment, int paramInt) {}
  
  public void run()
  {
    if ((GamePAHippyFragment.h(this.this$0) != null) && (((QQGameHippyPresenter)this.this$0.a).z() != null))
    {
      ((QQGameHippyPresenter)this.this$0.a).A();
      GamePAHippyFragment.a(this.this$0).a();
      GamePAHippyFragment.h(this.this$0).setCurrentItem(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragment.10
 * JD-Core Version:    0.7.0.1
 */