package com.tencent.mobileqq.qassistant.core;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.mobileqq.qassistant.api.IVoiceAssistantCore;
import com.tencent.mobileqq.qassistant.listener.IPanelSlideListener;
import com.tencent.mobileqq.qassistant.util.ReportUtils;
import com.tencent.mobileqq.qassistant.view.VoicePanelContainer;
import com.tencent.mobileqq.qassistant.view.VoicePanelSlideContainer;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.DecelerateAccelerateInterpolator;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class AssistantPanelManager
  implements View.OnClickListener, IPanelSlideListener
{
  private VoicePanelContainer a;
  private AtomicBoolean b = new AtomicBoolean(false);
  
  private void a(boolean paramBoolean)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.a, "translationY", new float[] { 0.0F, -100.0F, ScreenUtil.getRealHeight(AssistantUtils.d()) });
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.setInterpolator(new DecelerateAccelerateInterpolator());
    localObjectAnimator.addListener(new AssistantPanelManager.1(this, paramBoolean));
    localObjectAnimator.start();
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject;
    if (this.b.compareAndSet(true, false))
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((VoicePanelContainer)localObject).setVisibility(8);
        this.a.removeAllViews();
        this.a.b();
        this.a = null;
      }
    }
    if (paramBoolean)
    {
      localObject = AssistantUtils.a();
      if (localObject != null) {
        ((IVoiceAssistantCore)localObject).sendMessage(4);
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    IVoiceAssistantCore localIVoiceAssistantCore = (IVoiceAssistantCore)AssistantUtils.c().getRuntimeService(IVoiceAssistantCore.class, "");
    if (localIVoiceAssistantCore != null) {
      localIVoiceAssistantCore.quiteVoicePanel(paramBoolean, false);
    }
  }
  
  private void d()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.a, "translationY", new float[] { ScreenUtil.getRealHeight(AssistantUtils.d()), 0.0F, -100.0F, 50.0F, 0.0F });
    localObjectAnimator.setDuration(800L);
    localObjectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    localObjectAnimator.start();
  }
  
  public int a(View paramView)
  {
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AssistantPanelManager", 2, "contentView is null");
      }
      return 2;
    }
    if (!((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).checkPermission(AssistantUtils.d())) {
      return 1;
    }
    if (b()) {
      a(false, false);
    }
    if (this.b.compareAndSet(false, true))
    {
      if (this.a == null)
      {
        this.a = new VoicePanelContainer(AssistantUtils.d());
        this.a.setOnClickListener(this);
      }
      if (this.a != null)
      {
        View localView = paramView.findViewById(2131446076);
        if ((localView instanceof VoicePanelSlideContainer)) {
          ((VoicePanelSlideContainer)localView).setPanelSlideListener(this);
        }
        this.a.addView(paramView);
        this.a.setVisibility(0);
        this.a.a();
      }
      d();
    }
    return 0;
  }
  
  public void a()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.a, "alpha", new float[] { 1.0F, 0.0F, 1.0F });
    localObjectAnimator.setDuration(800L);
    localObjectAnimator.start();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      a(paramBoolean2);
      return;
    }
    b(paramBoolean2);
  }
  
  public boolean b()
  {
    return this.b.get();
  }
  
  public void c()
  {
    c(false);
    ReportUtils.d(1);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131449975)
    {
      c(true);
      ReportUtils.d(2);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.AssistantPanelManager
 * JD-Core Version:    0.7.0.1
 */