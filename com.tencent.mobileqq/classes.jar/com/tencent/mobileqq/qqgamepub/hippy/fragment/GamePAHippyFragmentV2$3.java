package com.tencent.mobileqq.qqgamepub.hippy.fragment;

import com.tencent.mobileqq.qqgamepub.mvp.model.buisness.QQGameHippyModel;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyPresenterV2;

class GamePAHippyFragmentV2$3
  implements Runnable
{
  GamePAHippyFragmentV2$3(GamePAHippyFragmentV2 paramGamePAHippyFragmentV2, int paramInt, String paramString) {}
  
  public void run()
  {
    try
    {
      QQGameHippyModel localQQGameHippyModel = (QQGameHippyModel)((QQGameHippyPresenterV2)this.this$0.a).b();
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
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragmentV2.3
 * JD-Core Version:    0.7.0.1
 */