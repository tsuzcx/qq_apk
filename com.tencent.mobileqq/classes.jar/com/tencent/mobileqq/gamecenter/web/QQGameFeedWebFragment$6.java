package com.tencent.mobileqq.gamecenter.web;

import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;

class QQGameFeedWebFragment$6
  implements IPreloadService.OnGetPathListener
{
  QQGameFeedWebFragment$6(QQGameFeedWebFragment paramQQGameFeedWebFragment, View paramView) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    ThreadManagerV2.getUIHandlerV2().post(new QQGameFeedWebFragment.6.1(this, paramInt, paramPathResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.6
 * JD-Core Version:    0.7.0.1
 */