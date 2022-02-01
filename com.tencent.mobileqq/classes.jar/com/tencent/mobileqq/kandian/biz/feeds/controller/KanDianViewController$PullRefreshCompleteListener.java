package com.tencent.mobileqq.kandian.biz.feeds.controller;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoyRefreshManager;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinManager;
import com.tencent.widget.pull2refresh.anim.IAnimManager.PullRefreshComplete;

public class KanDianViewController$PullRefreshCompleteListener
  implements IAnimManager.PullRefreshComplete
{
  public KanDianViewController$PullRefreshCompleteListener(KanDianViewController paramKanDianViewController) {}
  
  public void pullRefreshComplete(boolean paramBoolean)
  {
    if ((KanDianViewController.a(this.a) instanceof BaseActivity))
    {
      AppInterface localAppInterface = ((BaseActivity)KanDianViewController.a(this.a)).getAppInterface();
      if ((localAppInterface != null) && (KanDianViewController.a(this.a) != null) && (!paramBoolean))
      {
        ReadInJoyRefreshManager localReadInJoyRefreshManager = (ReadInJoyRefreshManager)localAppInterface.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
        if ((localReadInJoyRefreshManager.a() == 1) && (localReadInJoyRefreshManager.b()))
        {
          ThreadManager.post(new KanDianViewController.PullRefreshCompleteListener.1(this), 8, null, true);
          return;
        }
        if (((ReadInJoySkinManager)localAppInterface.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a() == 1) {
          ThreadManager.post(new KanDianViewController.PullRefreshCompleteListener.2(this), 8, null, true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.KanDianViewController.PullRefreshCompleteListener
 * JD-Core Version:    0.7.0.1
 */