package com.tencent.mobileqq.winkpublish.part;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.winkpublish.base.BaseBlockPart;
import com.tencent.mobileqq.winkpublish.view.FSSwitch;
import com.tencent.mobileqq.winkpublish.viewmodel.PublishJurisdictionViewModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import java.util.ArrayList;

public class PublishJurisdictionPart
  extends BaseBlockPart
  implements View.OnClickListener, SimpleEventReceiver
{
  private final PublishJurisdictionPart.PublishJurisdictionPartBroadcastReceiver a = new PublishJurisdictionPart.PublishJurisdictionPartBroadcastReceiver(this);
  private RelativeLayout b;
  private RelativeLayout e;
  private RelativeLayout f;
  private RelativeLayout g;
  private RelativeLayout h;
  private RelativeLayout i;
  private RelativeLayout j;
  private RelativeLayout k;
  private View.OnClickListener l;
  private View.OnClickListener m;
  private View.OnClickListener n;
  private View.OnClickListener o;
  private ImageView p;
  private ImageView q;
  private TextView r;
  private TextView s;
  private FSSwitch t;
  private ImageView u;
  private long v = 0L;
  private PublishJurisdictionViewModel w;
  
  private void l()
  {
    this.w.a.observe(j(), new PublishJurisdictionPart.6(this));
    this.w.b.observe(j(), new PublishJurisdictionPart.7(this));
  }
  
  public long a(long paramLong)
  {
    return System.currentTimeMillis() - paramLong;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.b = ((RelativeLayout)paramView.findViewById(2131442090));
    this.e = ((RelativeLayout)paramView.findViewById(2131442096));
    this.f = ((RelativeLayout)paramView.findViewById(2131442095));
    this.g = ((RelativeLayout)paramView.findViewById(2131442098));
    this.h = ((RelativeLayout)paramView.findViewById(2131442092));
    this.i = ((RelativeLayout)paramView.findViewById(2131442101));
    this.p = ((ImageView)paramView.findViewById(2131442097));
    this.q = ((ImageView)paramView.findViewById(2131442091));
    this.j = ((RelativeLayout)paramView.findViewById(2131442107));
    this.k = ((RelativeLayout)paramView.findViewById(2131442109));
    this.r = ((TextView)paramView.findViewById(2131442103));
    this.s = ((TextView)paramView.findViewById(2131442104));
    this.t = ((FSSwitch)paramView.findViewById(2131442110));
    this.u = ((ImageView)paramView.findViewById(2131442102));
    this.w = ((PublishJurisdictionViewModel)a(PublishJurisdictionViewModel.class));
    this.p.setVisibility(0);
    this.t.setChecked(true);
    if (QzoneConfig.getQFSPublishEnableJurisdiction())
    {
      this.b.setVisibility(0);
      this.b.setOnClickListener(this);
    }
    this.l = new PublishJurisdictionPart.1(this);
    this.m = new PublishJurisdictionPart.2(this);
    this.n = new PublishJurisdictionPart.3(this);
    this.o = new PublishJurisdictionPart.4(this);
    this.g.setOnClickListener(this.l);
    this.h.setOnClickListener(this.l);
    this.i.setOnClickListener(this.l);
    this.k.setOnClickListener(this.m);
    this.j.setOnClickListener(this.m);
    this.t.setOnClickListener(this.n);
    this.t.setCityRecommendationCheckClick(this.o);
    l();
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    PublishJurisdictionViewModel localPublishJurisdictionViewModel = this.w;
    localPublishJurisdictionViewModel.f = paramString1;
    localPublishJurisdictionViewModel.g = paramString2;
    localPublishJurisdictionViewModel.d = paramString3;
    localPublishJurisdictionViewModel.e = paramString4;
    localPublishJurisdictionViewModel.i = paramString5;
    paramString1 = new StringBuilder();
    paramString2 = this.w.f.split(",");
    paramString3 = this.w.g.split(",");
    if ((paramString3.length == 0) && (paramString2.length == 1))
    {
      if (!paramString2[0].equals("")) {
        paramString1.append(paramString2[0]);
      }
    }
    else if (!this.w.i.equals("0"))
    {
      int i1 = 0;
      while (i1 < paramString3.length)
      {
        if (!paramString3[i1].equals(""))
        {
          paramString1.append(paramString3[i1]);
          paramString1.append("、");
        }
        i1 += 1;
      }
      i1 = 0;
      while (i1 < paramString2.length)
      {
        if (!paramString2[i1].equals(""))
        {
          paramString1.append(paramString2[i1]);
          paramString1.append("、");
        }
        i1 += 1;
      }
      if (paramString1.length() != 0)
      {
        paramString1.insert(0, "不给谁看·");
        if (paramString1.charAt(paramString1.length() - 1) == '、') {
          paramString1.deleteCharAt(paramString1.length() - 1);
        }
      }
    }
    paramString1 = paramString1.toString();
    paramString2 = this.w;
    paramString2.h = paramString1;
    if (paramString2.h.equals(""))
    {
      this.r.setText("不给谁看");
      this.u.setImageDrawable(g().getResources().getDrawable(2130846083));
      this.r.setTextColor(g().getResources().getColor(2131167183));
      return;
    }
    paramString1 = this.r;
    paramString2 = new StringBuilder();
    paramString2.append(this.w.h);
    paramString2.append("等");
    paramString2.append(this.w.i);
    paramString2.append("人");
    paramString1.setText(paramString2.toString());
    this.u.setImageDrawable(g().getResources().getDrawable(2130846084));
    this.r.setTextColor(g().getResources().getColor(2131167184));
  }
  
  public boolean ah_()
  {
    RelativeLayout localRelativeLayout = this.e;
    if ((localRelativeLayout != null) && (localRelativeLayout.getVisibility() == 0))
    {
      e();
      return true;
    }
    return false;
  }
  
  public void d()
  {
    Object localObject = this.e;
    if ((localObject != null) && (((RelativeLayout)localObject).getVisibility() != 0))
    {
      if (this.f == null) {
        return;
      }
      if (c().isFinishing()) {
        return;
      }
      this.e.setVisibility(0);
      this.f.setVisibility(0);
      localObject = AnimationUtils.loadAnimation(g(), 2130772351);
      ((Animation)localObject).setDuration(200L);
      this.f.clearAnimation();
      this.f.startAnimation((Animation)localObject);
      this.w.c = true;
    }
  }
  
  public void e()
  {
    if (this.w.b())
    {
      if (this.w.h.equals(""))
      {
        this.s.setText(g().getResources().getString(2131896380));
        this.s.setTextColor(g().getResources().getColor(2131167183));
      }
      else
      {
        localObject = this.s;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.w.h);
        localStringBuilder.append("等");
        localStringBuilder.append(this.w.i);
        localStringBuilder.append("人");
        ((TextView)localObject).setText(localStringBuilder.toString());
        this.s.setTextColor(g().getResources().getColor(2131167184));
      }
    }
    else
    {
      this.s.setText(g().getResources().getString(2131896376));
      this.s.setTextColor(g().getResources().getColor(2131167183));
    }
    Object localObject = this.e;
    if ((localObject != null) && (((RelativeLayout)localObject).getVisibility() != 8))
    {
      if (this.f == null) {
        return;
      }
      localObject = AnimationUtils.loadAnimation(g(), 2130772352);
      ((Animation)localObject).setDuration(200L);
      ((Animation)localObject).setAnimationListener(new PublishJurisdictionPart.5(this));
      this.f.clearAnimation();
      this.f.startAnimation((Animation)localObject);
      this.w.c = false;
    }
  }
  
  public void f()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("ACTION_USER_PUBLISH_DISABLE_INFO");
      RFApplication.getApplication().registerReceiver(this.a, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    return null;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    f();
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    RFApplication.getApplication().unregisterReceiver(this.a);
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
    d();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishJurisdictionPart
 * JD-Core Version:    0.7.0.1
 */