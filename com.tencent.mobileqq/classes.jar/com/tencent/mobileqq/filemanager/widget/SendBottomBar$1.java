package com.tencent.mobileqq.filemanager.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.util.IClickListenerVer51;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SendBottomBar$1
  implements View.OnClickListener
{
  SendBottomBar$1(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (SendBottomBar.a(this.a) != null) {
      SendBottomBar.a(this.a).a();
    }
    if (SendBottomBar.a(this.a)) {
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).previewFavImageFile(SendBottomBar.a(this.a));
    } else {
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).previewImage(SendBottomBar.a(this.a), SendBottomBar.a(this.a), SendBottomBar.a(this.a).g());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.SendBottomBar.1
 * JD-Core Version:    0.7.0.1
 */