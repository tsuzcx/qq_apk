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
  private VoicePanelContainer jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelContainer;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  private void a(boolean paramBoolean)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelContainer, "translationY", new float[] { 0.0F, -100.0F, ScreenUtil.getRealHeight(AssistantUtils.a()) });
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.setInterpolator(new DecelerateAccelerateInterpolator());
    localObjectAnimator.addListener(new AssistantPanelManager.1(this, paramBoolean));
    localObjectAnimator.start();
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelContainer;
      if (localObject != null)
      {
        ((VoicePanelContainer)localObject).setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelContainer.removeAllViews();
        this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelContainer.b();
        this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelContainer = null;
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
  
  private void c()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelContainer, "translationY", new float[] { ScreenUtil.getRealHeight(AssistantUtils.a()), 0.0F, -100.0F, 50.0F, 0.0F });
    localObjectAnimator.setDuration(800L);
    localObjectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    localObjectAnimator.start();
  }
  
  private void c(boolean paramBoolean)
  {
    IVoiceAssistantCore localIVoiceAssistantCore = (IVoiceAssistantCore)AssistantUtils.a().getRuntimeService(IVoiceAssistantCore.class, "");
    if (localIVoiceAssistantCore != null) {
      localIVoiceAssistantCore.quiteVoicePanel(paramBoolean, false);
    }
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
    if (!((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).checkPermission(AssistantUtils.a())) {
      return 1;
    }
    if (a()) {
      a(false, false);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelContainer == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelContainer = new VoicePanelContainer(AssistantUtils.a());
        this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelContainer.setOnClickListener(this);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelContainer != null)
      {
        View localView = paramView.findViewById(2131377657);
        if ((localView instanceof VoicePanelSlideContainer)) {
          ((VoicePanelSlideContainer)localView).setPanelSlideListener(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelContainer.addView(paramView);
        this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelContainer.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelContainer.a();
      }
      c();
    }
    return 0;
  }
  
  public void a()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelContainer, "alpha", new float[] { 1.0F, 0.0F, 1.0F });
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
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void b()
  {
    c(false);
    ReportUtils.d(1);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131380984)
    {
      c(true);
      ReportUtils.d(2);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.AssistantPanelManager
 * JD-Core Version:    0.7.0.1
 */