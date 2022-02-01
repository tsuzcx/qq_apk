package com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness;

import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qqgamepub.mvp.view.buisness.IQQGameWebFeedView;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;

class QQGameWebPresenter$2
  implements Runnable
{
  QQGameWebPresenter$2(QQGameWebPresenter paramQQGameWebPresenter, GmpEnterInfoRsp paramGmpEnterInfoRsp) {}
  
  public void run()
  {
    if (!this.this$0.c()) {
      return;
    }
    GmpEnterInfoRsp localGmpEnterInfoRsp = this.a;
    if ((localGmpEnterInfoRsp != null) && (localGmpEnterInfoRsp.retCode == 0) && (this.a.state == 1))
    {
      this.this$0.y().a(this.a, true);
      return;
    }
    localGmpEnterInfoRsp = GamePubAccountHelper.f();
    this.this$0.y().a(localGmpEnterInfoRsp, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameWebPresenter.2
 * JD-Core Version:    0.7.0.1
 */