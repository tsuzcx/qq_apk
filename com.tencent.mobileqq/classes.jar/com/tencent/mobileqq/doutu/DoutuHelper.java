package com.tencent.mobileqq.doutu;

import android.os.Bundle;
import android.os.Handler.Callback;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.activity.aio.core.helper.AIOOnTouchListener;
import com.tencent.mobileqq.activity.aio.core.helper.OnFinishListener;
import com.tencent.mobileqq.activity.aio.coreui.tips.IMsgTipsListener;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.helper.StickerRecHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper.AIOShortcutBarEvent;
import com.tencent.mobileqq.doutu.api.IDoutuService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class DoutuHelper
  implements Handler.Callback, AIOOnTouchListener, OnFinishListener, IMsgTipsListener, ILifeCycleHelper
{
  private final AIOContext a;
  public IDoutuService a;
  
  public DoutuHelper(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
  }
  
  public int a()
  {
    return 0;
  }
  
  public void a()
  {
    IDoutuService localIDoutuService = this.jdField_a_of_type_ComTencentMobileqqDoutuApiIDoutuService;
    if (localIDoutuService != null) {
      localIDoutuService.hideDoutuEmotionLayout();
    }
  }
  
  public void a(AIOContext paramAIOContext) {}
  
  public void a(AIOContext paramAIOContext, com.tencent.imcore.message.Message paramMessage)
  {
    paramAIOContext = this.jdField_a_of_type_ComTencentMobileqqDoutuApiIDoutuService;
    if (paramAIOContext != null) {
      paramAIOContext.clearComboViews();
    }
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public boolean a(BaseAIOContext paramBaseAIOContext, View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDoutuApiIDoutuService != null)
    {
      paramBaseAIOContext = (AIOShortcutBarHelper)paramBaseAIOContext.a(52);
      boolean bool;
      if (paramBaseAIOContext != null) {
        bool = paramBaseAIOContext.e();
      } else {
        bool = false;
      }
      this.jdField_a_of_type_ComTencentMobileqqDoutuApiIDoutuService.hideDoutuEmotionLayout();
      if ((paramBaseAIOContext != null) && (bool))
      {
        paramBaseAIOContext.c(15);
        paramBaseAIOContext.c(12);
      }
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  public void b()
  {
    IDoutuService localIDoutuService = this.jdField_a_of_type_ComTencentMobileqqDoutuApiIDoutuService;
    if (localIDoutuService != null)
    {
      localIDoutuService.clearComboViews();
      this.jdField_a_of_type_ComTencentMobileqqDoutuApiIDoutuService.setComboShowSwitch(false);
    }
  }
  
  public void d(int paramInt)
  {
    IDoutuService localIDoutuService = this.jdField_a_of_type_ComTencentMobileqqDoutuApiIDoutuService;
    if (localIDoutuService != null)
    {
      localIDoutuService.hideDoutuEmotionLayout();
      this.jdField_a_of_type_ComTencentMobileqqDoutuApiIDoutuService.interruptAnimation();
    }
  }
  
  @NonNull
  public String getTag()
  {
    return "DoutuHelper";
  }
  
  public boolean handleMessage(android.os.Message paramMessage)
  {
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 81: 
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqDoutuApiIDoutuService;
      if (paramMessage != null)
      {
        paramMessage.refreshDoutuEmoData();
        return false;
      }
      break;
    case 80: 
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqDoutuApiIDoutuService;
      if (paramMessage != null) {
        paramMessage.hideDoutuEmotionLayout();
      }
      paramMessage = (AIOShortcutBarHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(52);
      if (paramMessage != null)
      {
        localObject = new AIOShortcutBarHelper.AIOShortcutBarEvent(12);
        ((AIOShortcutBarHelper.AIOShortcutBarEvent)localObject).a().putBoolean("mDoutuShow", false);
        paramMessage.a((AIOShortcutBarHelper.AIOShortcutBarEvent)localObject);
        paramMessage.c(15);
        return false;
      }
      break;
    case 79: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), "dc00898", "", "", "0X8007FA8", "0X8007FA8", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("DoutuHelper", 2, "[Doutu] handleMessage : MSG_SHOW_DOUTU_EMOTION_LAYOUT");
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqDoutuApiIDoutuService;
      if (localObject != null) {
        ((IDoutuService)localObject).showDoutuEmotionLayout(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), (DoutuItem)paramMessage.obj, 2131368875);
      }
      paramMessage = (StickerRecHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(14);
      if (paramMessage != null)
      {
        paramMessage.b();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().removeMessages(67);
      }
      paramMessage = (AIOShortcutBarHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(52);
      if (paramMessage != null)
      {
        localObject = new AIOShortcutBarHelper.AIOShortcutBarEvent(11);
        ((AIOShortcutBarHelper.AIOShortcutBarEvent)localObject).a().putBoolean("mDoutuShow", true);
        paramMessage.a((AIOShortcutBarHelper.AIOShortcutBarEvent)localObject);
        paramMessage.c(16);
      }
      return true;
    }
    return false;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 6, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    IDoutuService localIDoutuService;
    if (paramInt != 6)
    {
      if (paramInt != 15) {
        return;
      }
      localIDoutuService = this.jdField_a_of_type_ComTencentMobileqqDoutuApiIDoutuService;
      if (localIDoutuService != null)
      {
        localIDoutuService.doOnChatDestory();
        this.jdField_a_of_type_ComTencentMobileqqDoutuApiIDoutuService = null;
      }
    }
    else
    {
      localIDoutuService = this.jdField_a_of_type_ComTencentMobileqqDoutuApiIDoutuService;
      if (localIDoutuService != null)
      {
        localIDoutuService.hideDoutuEmotionLayout();
        this.jdField_a_of_type_ComTencentMobileqqDoutuApiIDoutuService.removeDoutuEmoLayout();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuHelper
 * JD-Core Version:    0.7.0.1
 */