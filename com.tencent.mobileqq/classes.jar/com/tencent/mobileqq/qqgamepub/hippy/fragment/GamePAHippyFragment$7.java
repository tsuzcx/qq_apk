package com.tencent.mobileqq.qqgamepub.hippy.fragment;

import com.tencent.mobileqq.qqgamepub.mvp.model.buisness.QQGameHippyModel;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyPresenter;

class GamePAHippyFragment$7
  implements Runnable
{
  GamePAHippyFragment$7(GamePAHippyFragment paramGamePAHippyFragment, int paramInt, String paramString) {}
  
  public void run()
  {
    try
    {
      QQGameHippyModel localQQGameHippyModel = (QQGameHippyModel)((QQGameHippyPresenter)this.this$0.a).b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append("");
      localQQGameHippyModel.b(localStringBuilder.toString(), this.b);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragment.7
 * JD-Core Version:    0.7.0.1
 */