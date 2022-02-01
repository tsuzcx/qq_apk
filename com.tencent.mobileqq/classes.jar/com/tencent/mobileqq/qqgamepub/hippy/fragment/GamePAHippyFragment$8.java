package com.tencent.mobileqq.qqgamepub.hippy.fragment;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyPresenter;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qqgamepub.view.NavBarQQGamePub;
import com.tencent.mobileqq.qqgamepub.web.QQGameReportLogic;
import com.tencent.qphone.base.util.QLog;

class GamePAHippyFragment$8
  implements Runnable
{
  GamePAHippyFragment$8(GamePAHippyFragment paramGamePAHippyFragment, GmpEnterInfoRsp paramGmpEnterInfoRsp) {}
  
  public void run()
  {
    if ((this.this$0.getQBaseActivity() != null) && (!this.this$0.getQBaseActivity().isFinishing()) && (this.this$0.isAdded()) && (GamePAHippyFragment.g(this.this$0) != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGamePub_GamePubAccountHippyFragment", 1, "show game enter icon");
      }
      GamePAHippyFragment.g(this.this$0).setCurType(2);
      GamePAHippyFragment.g(this.this$0).a(false);
      GamePAHippyFragment.g(this.this$0).a(this.a.icon, this.a.content, this.a.url);
      GamePAHippyFragment.g(this.this$0).setmBubbleid(this.a.bubbleId);
      GamePubAccountHelper.a(this.a);
      ((QQGameHippyPresenter)this.this$0.a).w().a(this.a.bubbleId, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragment.8
 * JD-Core Version:    0.7.0.1
 */