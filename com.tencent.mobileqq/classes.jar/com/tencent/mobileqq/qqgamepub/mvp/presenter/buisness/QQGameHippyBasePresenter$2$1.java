package com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness;

import android.text.TextUtils;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.utils.IArkPubicEventWrap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class QQGameHippyBasePresenter$2$1
  implements Runnable
{
  QQGameHippyBasePresenter$2$1(QQGameHippyBasePresenter.2 param2, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      QQGameMsgInfo localQQGameMsgInfo = (QQGameMsgInfo)localIterator.next();
      if (!TextUtils.isEmpty(localQQGameMsgInfo.arkAppName))
      {
        ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).addNotify(localQQGameMsgInfo.arkAppName);
        this.b.a.f.add(localQQGameMsgInfo.arkAppName);
      }
    }
    this.b.a.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyBasePresenter.2.1
 * JD-Core Version:    0.7.0.1
 */