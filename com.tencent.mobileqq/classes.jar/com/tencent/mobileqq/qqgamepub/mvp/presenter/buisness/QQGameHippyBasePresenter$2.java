package com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.hippy.GamePubAccountMsgObserver;
import java.util.ArrayList;
import java.util.List;

class QQGameHippyBasePresenter$2
  extends GamePubAccountMsgObserver
{
  QQGameHippyBasePresenter$2(QQGameHippyBasePresenter paramQQGameHippyBasePresenter) {}
  
  public void a(ArrayList<QQGameMsgInfo> paramArrayList)
  {
    super.a(paramArrayList);
    if ((this.a.e != null) && (this.a.e.size() <= this.a.q())) {
      ThreadManagerV2.getUIHandlerV2().post(new QQGameHippyBasePresenter.2.1(this, paramArrayList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyBasePresenter.2
 * JD-Core Version:    0.7.0.1
 */