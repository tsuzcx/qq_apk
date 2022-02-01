package com.tencent.mobileqq.gamecenter.view;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.util.QQGameConstant;
import com.tencent.mobileqq.qqgamepub.api.IQQGamePreDownloadService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TextHeaderView$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(TextHeaderView.a(this.c)))
    {
      if (!((IQQGamePreDownloadService)QRoute.api(IQQGamePreDownloadService.class)).interceptJumpHippy(TextHeaderView.a(this.c)))
      {
        Intent localIntent = new Intent(this.a, QQBrowserActivity.class);
        localIntent.putExtra("url", TextHeaderView.a(this.c));
        this.a.startActivityForResult(localIntent, 0);
      }
      QQGameConstant.a(this.b, 0);
      ((IApolloExtensionHandler)((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface().getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(3, this.b.getExtInfoFromExtStr("pa_msgId"), TextHeaderView.a(this.c));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.TextHeaderView.1
 * JD-Core Version:    0.7.0.1
 */