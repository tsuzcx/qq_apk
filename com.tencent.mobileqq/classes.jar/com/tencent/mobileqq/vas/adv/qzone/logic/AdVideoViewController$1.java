package com.tencent.mobileqq.vas.adv.qzone.logic;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZLog;

class AdVideoViewController$1
  implements View.OnClickListener
{
  AdVideoViewController$1(AdVideoViewController paramAdVideoViewController) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if ((paramView != null) && (paramView.getId() == 2131427854))
    {
      QZLog.i("AdVideoView", " @getGdtInfo dispear");
      if (!TextUtils.isEmpty(AdVideoViewController.a(this.a).negativeFeedbackUrl))
      {
        localObject = AdVideoViewController.a(this.a).negativeFeedbackUrl.replace("__ACT_TYPE__", "2001");
        this.a.a((String)localObject);
      }
      if (AdVideoViewController.b(this.a) != null)
      {
        AdVideoViewController.c(this.a).setVisibility(8);
        localObject = this.a;
        ((AdVideoViewController)localObject).a(3, AdVideoViewController.a((AdVideoViewController)localObject).recCookie);
        localObject = this.a;
        ((AdVideoViewController)localObject).a(((AdVideoViewController)localObject).b, AdVideoViewController.b(this.a));
      }
    }
    else
    {
      localObject = this.a;
      ((AdVideoViewController)localObject).a(AdVideoViewController.d((AdVideoViewController)localObject), AdVideoViewController.a(this.a));
      localObject = this.a;
      ((AdVideoViewController)localObject).a(2, AdVideoViewController.a((AdVideoViewController)localObject).recCookie);
      if ((AdVideoViewController.a(this.a) != null) && (this.a.d == null)) {
        this.a.d = new AdVideoViewController.1.1(this);
      }
      AdVideoViewController.a(this.a, true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.qzone.logic.AdVideoViewController.1
 * JD-Core Version:    0.7.0.1
 */