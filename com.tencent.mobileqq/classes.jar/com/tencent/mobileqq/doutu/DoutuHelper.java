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
  public IDoutuService a;
  private final AIOContext b;
  
  public DoutuHelper(AIOContext paramAIOContext)
  {
    this.b = paramAIOContext;
  }
  
  public void a()
  {
    IDoutuService localIDoutuService = this.a;
    if (localIDoutuService != null) {
      localIDoutuService.hideDoutuEmotionLayout();
    }
  }
  
  public void a(AIOContext paramAIOContext) {}
  
  public void a(AIOContext paramAIOContext, com.tencent.imcore.message.Message paramMessage)
  {
    paramAIOContext = this.a;
    if (paramAIOContext != null) {
      paramAIOContext.clearComboViews();
    }
  }
  
  public boolean a(BaseAIOContext paramBaseAIOContext, View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a != null)
    {
      paramBaseAIOContext = (AIOShortcutBarHelper)paramBaseAIOContext.a(52);
      boolean bool;
      if (paramBaseAIOContext != null) {
        bool = paramBaseAIOContext.w();
      } else {
        bool = false;
      }
      this.a.hideDoutuEmotionLayout();
      if ((paramBaseAIOContext != null) && (bool))
      {
        paramBaseAIOContext.d(15);
        paramBaseAIOContext.d(12);
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
    IDoutuService localIDoutuService = this.a;
    if (localIDoutuService != null)
    {
      localIDoutuService.clearComboViews();
      this.a.setComboShowSwitch(false);
    }
  }
  
  public int bM_()
  {
    return 0;
  }
  
  public boolean d(int paramInt)
  {
    return false;
  }
  
  public void e(int paramInt)
  {
    IDoutuService localIDoutuService = this.a;
    if (localIDoutuService != null)
    {
      localIDoutuService.hideDoutuEmotionLayout();
      this.a.interruptAnimation();
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
      paramMessage = this.a;
      if (paramMessage != null)
      {
        paramMessage.refreshDoutuEmoData();
        return false;
      }
      break;
    case 80: 
      paramMessage = this.a;
      if (paramMessage != null) {
        paramMessage.hideDoutuEmotionLayout();
      }
      paramMessage = (AIOShortcutBarHelper)this.b.a(52);
      if (paramMessage != null)
      {
        localObject = new AIOShortcutBarHelper.AIOShortcutBarEvent(12);
        ((AIOShortcutBarHelper.AIOShortcutBarEvent)localObject).a().putBoolean("mDoutuShow", false);
        paramMessage.a((AIOShortcutBarHelper.AIOShortcutBarEvent)localObject);
        paramMessage.d(15);
        return false;
      }
      break;
    case 79: 
      ReportController.b(this.b.a(), "dc00898", "", "", "0X8007FA8", "0X8007FA8", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("DoutuHelper", 2, "[Doutu] handleMessage : MSG_SHOW_DOUTU_EMOTION_LAYOUT");
      }
      localObject = this.a;
      if (localObject != null) {
        ((IDoutuService)localObject).showDoutuEmotionLayout(this.b.g(), (DoutuItem)paramMessage.obj, 2131435809);
      }
      paramMessage = (StickerRecHelper)this.b.a(14);
      if (paramMessage != null)
      {
        paramMessage.b();
        this.b.g().removeMessages(67);
      }
      paramMessage = (AIOShortcutBarHelper)this.b.a(52);
      if (paramMessage != null)
      {
        localObject = new AIOShortcutBarHelper.AIOShortcutBarEvent(11);
        ((AIOShortcutBarHelper.AIOShortcutBarEvent)localObject).a().putBoolean("mDoutuShow", true);
        paramMessage.a((AIOShortcutBarHelper.AIOShortcutBarEvent)localObject);
        paramMessage.d(16);
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
      localIDoutuService = this.a;
      if (localIDoutuService != null)
      {
        localIDoutuService.doOnChatDestory();
        this.a = null;
      }
    }
    else
    {
      localIDoutuService = this.a;
      if (localIDoutuService != null)
      {
        localIDoutuService.hideDoutuEmotionLayout();
        this.a.removeDoutuEmoLayout();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuHelper
 * JD-Core Version:    0.7.0.1
 */