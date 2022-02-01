package com.tencent.mobileqq.winkpublish.part;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.winkpublish.base.BaseBlockPart;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.mobileqq.winkpublish.view.FSCheckBox;
import com.tencent.mobileqq.winkpublish.viewmodel.PublishShareViewModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class PublishSharePart
  extends BaseBlockPart
  implements View.OnClickListener, SimpleEventReceiver
{
  public static final String a;
  private LinearLayout b;
  private FSCheckBox e;
  private long f = 0L;
  private PublishShareViewModel g;
  private View.OnClickListener h;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(UploadConstants.a);
    localStringBuilder.append("FSPublishSharePart");
    a = localStringBuilder.toString();
  }
  
  private void d()
  {
    if (this.g == null) {
      this.g = ((PublishShareViewModel)a(PublishShareViewModel.class));
    }
    this.g.a.observe(j(), new PublishSharePart.2(this));
  }
  
  public long a(long paramLong)
  {
    return System.currentTimeMillis() - paramLong;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView.findViewById(2131442111).setVisibility(0);
    this.b = ((LinearLayout)paramView.findViewById(2131442113));
    this.b.setOnClickListener(this);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable1 = c().getResources().getDrawable(2130846086);
    Drawable localDrawable2 = c().getResources().getDrawable(2130846085);
    localStateListDrawable.addState(new int[] { 16842912 }, localDrawable2);
    localStateListDrawable.addState(new int[] { -16842912 }, localDrawable1);
    localStateListDrawable.addState(new int[0], localDrawable1);
    this.e = ((FSCheckBox)paramView.findViewById(2131442112));
    this.e.setOnClickListener(this);
    this.e.setBackgroundDrawable(localStateListDrawable);
    this.e.setGravity(16);
    this.h = new PublishSharePart.1(this);
    this.e.setmShareClickListener(this.h);
    d();
  }
  
  public void c(boolean paramBoolean)
  {
    FSCheckBox localFSCheckBox = this.e;
    localFSCheckBox.a = paramBoolean;
    if (!paramBoolean) {
      localFSCheckBox.setSyncChecked(false);
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    return new ArrayList();
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    super.onActivityDestroyed(paramActivity);
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i == 2131442113) || (i == 2131442112)) {
      this.g.b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishSharePart
 * JD-Core Version:    0.7.0.1
 */