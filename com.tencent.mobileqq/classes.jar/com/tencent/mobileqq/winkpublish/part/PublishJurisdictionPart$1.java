package com.tencent.mobileqq.winkpublish.part;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.api.IPublishLauncher;
import com.tencent.mobileqq.winkpublish.viewmodel.PublishJurisdictionViewModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PublishJurisdictionPart$1
  implements View.OnClickListener
{
  PublishJurisdictionPart$1(PublishJurisdictionPart paramPublishJurisdictionPart) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131442098)
    {
      PublishJurisdictionPart.a(this.a).a(Boolean.valueOf(true));
    }
    else if (paramView.getId() == 2131442092)
    {
      PublishJurisdictionPart.a(this.a).a(Boolean.valueOf(false));
    }
    else if (paramView.getId() == 2131442101)
    {
      Intent localIntent = new Intent();
      Bundle localBundle = new Bundle();
      localBundle.putString("disableUinId", PublishJurisdictionPart.a(this.a).d);
      localBundle.putString("disableGroupId", PublishJurisdictionPart.a(this.a).e);
      localIntent.putExtra("disableRightInfo", localBundle);
      ((IPublishLauncher)QRoute.api(IPublishLauncher.class)).launchFSHybirdActivity(this.a.g(), "https://h5.qzone.qq.com/v2/qflash/right/setting", localIntent, -1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishJurisdictionPart.1
 * JD-Core Version:    0.7.0.1
 */