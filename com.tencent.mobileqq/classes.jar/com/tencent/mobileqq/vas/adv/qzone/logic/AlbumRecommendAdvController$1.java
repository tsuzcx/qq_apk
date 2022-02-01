package com.tencent.mobileqq.vas.adv.qzone.logic;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZLog;

class AlbumRecommendAdvController$1
  implements View.OnClickListener
{
  AlbumRecommendAdvController$1(AlbumRecommendAdvController paramAlbumRecommendAdvController) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if ((paramView != null) && (paramView.getId() == 2131443385))
    {
      QZLog.i("AlbumRecomAdvInfoView", " @getGdtInfo dispear");
      if (!TextUtils.isEmpty(AlbumRecommendAdvController.a(this.a).negativeFeedbackUrl))
      {
        localObject = AlbumRecommendAdvController.a(this.a).negativeFeedbackUrl.replace("__ACT_TYPE__", "2001");
        this.a.a((String)localObject);
      }
      if (AlbumRecommendAdvController.b(this.a) != null)
      {
        localObject = this.a;
        ((AlbumRecommendAdvController)localObject).a(3, AlbumRecommendAdvController.a((AlbumRecommendAdvController)localObject).recCookie);
        this.a.hideAdView();
      }
    }
    else
    {
      localObject = this.a;
      ((AlbumRecommendAdvController)localObject).a(2, AlbumRecommendAdvController.a((AlbumRecommendAdvController)localObject).recCookie);
      if (this.a.c == null) {
        this.a.c = new AlbumRecommendAdvController.1.1(this);
      }
      if (AlbumRecommendAdvController.c(this.a) != null)
      {
        boolean bool;
        if ((paramView != null) && (paramView.getId() == 2131443389)) {
          bool = true;
        } else {
          bool = false;
        }
        localObject = this.a;
        ((AlbumRecommendAdvController)localObject).a(AlbumRecommendAdvController.c((AlbumRecommendAdvController)localObject), bool);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.qzone.logic.AlbumRecommendAdvController.1
 * JD-Core Version:    0.7.0.1
 */