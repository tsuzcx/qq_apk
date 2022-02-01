package com.tencent.mobileqq.flashshow.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.mobileqq.flashshow.api.bean.FSPersonalDetailBean;
import com.tencent.mobileqq.flashshow.launcher.FSNativeLauncher;
import com.tencent.mobileqq.flashshow.utils.FSTransUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.api.IUploadTaskManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class FSMainChipPart
  extends FSBasePart
  implements View.OnClickListener
{
  Runnable a = new FSMainChipPart.1(this);
  private View b;
  private View c;
  
  public String a()
  {
    return "FSMainChipPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.b = paramView.findViewById(2131433856);
    this.b.setOnClickListener(this);
    this.c = paramView.findViewById(2131433870);
    this.c.setOnClickListener(this);
    this.c.setVisibility(0);
    ((IUploadTaskManager)QRoute.api(IUploadTaskManager.class)).initQFSConfig();
    ((IUploadTaskManager)QRoute.api(IUploadTaskManager.class)).initUpload();
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    RFThreadManager.getSerialThreadHandler().removeCallbacks(this.a);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    RFThreadManager.getSerialThreadHandler().postDelayed(this.a, 30000L);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131433856)
    {
      FSPersonalDetailBean localFSPersonalDetailBean = new FSPersonalDetailBean(l());
      localFSPersonalDetailBean.setUser(FSTransUtils.b());
      FSNativeLauncher.a(g(), localFSPersonalDetailBean);
    }
    else if (i == 2131433870)
    {
      FSNativeLauncher.a(g(), new Intent());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSMainChipPart
 * JD-Core Version:    0.7.0.1
 */