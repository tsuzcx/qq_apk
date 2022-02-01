package com.tencent.mobileqq.qqgamepub.hippy.fragment;

import android.view.View;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyPresenter;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;

class GamePAHippyFragment$2
  implements OnItemSelectListener
{
  GamePAHippyFragment$2(GamePAHippyFragment paramGamePAHippyFragment) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if (paramInt == 5)
    {
      ((QQGameHippyPresenter)this.a.a).u();
      return;
    }
    if (paramInt == 1) {
      ((QQGameHippyPresenter)this.a.a).v();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragment.2
 * JD-Core Version:    0.7.0.1
 */