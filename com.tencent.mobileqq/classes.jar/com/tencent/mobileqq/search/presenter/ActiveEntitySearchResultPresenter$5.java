package com.tencent.mobileqq.search.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ActiveEntitySearchResultPresenter$5
  implements View.OnClickListener
{
  ActiveEntitySearchResultPresenter$5(ActiveEntitySearchResultPresenter paramActiveEntitySearchResultPresenter, GroupBaseNetSearchModelItem paramGroupBaseNetSearchModelItem) {}
  
  public void onClick(View paramView)
  {
    if (this.a.R == 0)
    {
      ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openGuild(ActiveEntitySearchResultPresenter.c(this.b), paramView.getContext(), false, null, this.a.b);
    }
    else
    {
      int i = 246614;
      if (this.a.m == 99) {
        i = 246613;
      }
      ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).addGuildByAuthSig(paramView.getContext(), this.a.b, this.a.T, i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.ActiveEntitySearchResultPresenter.5
 * JD-Core Version:    0.7.0.1
 */