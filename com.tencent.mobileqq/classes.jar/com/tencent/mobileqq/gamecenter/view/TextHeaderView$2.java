package com.tencent.mobileqq.gamecenter.view;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.util.QQGameConstant;
import com.tencent.mobileqq.qqgamepub.api.IQQGamePreDownloadService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TextHeaderView$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(TextHeaderView.a(this.d)))
    {
      if (!((IQQGamePreDownloadService)QRoute.api(IQQGamePreDownloadService.class)).interceptJumpHippy(TextHeaderView.a(this.d)))
      {
        localObject = new Intent(this.a, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", TextHeaderView.a(this.d));
        this.a.startActivityForResult((Intent)localObject, 0);
      }
      Object localObject = QQGameConstant.a(this.b, 0);
      new WadlReportBuilder().a("dc00087").h("769").c("205019").b((String)localObject).a(1, "76901").a(11, "1").a(12, "160").a(2, QQGameConstant.a(this.c)).a(4, "20").a();
      ((IApolloExtensionHandler)((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface().getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(3, this.b.getExtInfoFromExtStr("pa_msgId"), TextHeaderView.a(this.d));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.TextHeaderView.2
 * JD-Core Version:    0.7.0.1
 */