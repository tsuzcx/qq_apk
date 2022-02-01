package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGamePreDownloadService;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;

class TextHeaderView$4
  implements View.OnClickListener
{
  TextHeaderView$4(TextHeaderView paramTextHeaderView, Context paramContext, QQGameMsgInfo paramQQGameMsgInfo, int paramInt, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(TextHeaderView.a(this.e)))
    {
      if (!((IQQGamePreDownloadService)QRoute.api(IQQGamePreDownloadService.class)).interceptJumpHippy(TextHeaderView.a(this.e)))
      {
        localObject = new Intent(this.a, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", TextHeaderView.a(this.e));
        this.a.startActivity((Intent)localObject);
      }
      Object localObject = new HashMap();
      ((Map)localObject).put(Integer.valueOf(2), this.b.gameAppId);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c);
      localStringBuilder.append("");
      ((Map)localObject).put(Integer.valueOf(3), localStringBuilder.toString());
      ((Map)localObject).put(Integer.valueOf(4), "20");
      ((Map)localObject).put(Integer.valueOf(24), this.d);
      GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "769", "205019", this.b.gameAppId, "76901", "1", "160", (Map)localObject);
      ((IQQGameReportService)QRoute.api(IQQGameReportService.class)).reportGamePubAccountMsgStatus(3, this.b.paMsgid, TextHeaderView.a(this.e));
      try
      {
        ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).publicAccountTianshuReport(118, this.b, this.c);
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.TextHeaderView.4
 * JD-Core Version:    0.7.0.1
 */