package com.tencent.mobileqq.settings.message;

import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntry;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryListener;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.HeightAdaptableListView;
import java.util.Map;

class AssistantSettingFragment$1
  extends CardObserver
{
  AssistantSettingFragment$1(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  protected void onGetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!this.a.getBaseActivity().isFinishing()))
    {
      AssistantSettingFragment localAssistantSettingFragment = this.a;
      AssistantSettingFragment.a(localAssistantSettingFragment, AssistantSettingFragment.a(localAssistantSettingFragment).getSwitch(), paramBoolean2);
    }
  }
  
  protected void onGetCommonSwitchFromDetailInfo(boolean paramBoolean, short[] paramArrayOfShort, Map<Short, Short> paramMap)
  {
    if ((paramBoolean) && (AssistantSettingFragment.b(this.a) != null) && (this.a.h != null) && (this.a.h.a(paramArrayOfShort)))
    {
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.i("AssistantSettingFragment", 0, "onGetCommonSwitchFromDetailInfo");
      }
      AssistantSettingFragment.b(this.a).a();
    }
  }
  
  protected void onGetConnectionsSwitch(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (com.tencent.qphone.base.util.QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetConnectionsSwitch:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramInt2);
      com.tencent.qphone.base.util.QLog.i("AssistantSettingFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      localObject = this.a;
      AssistantSettingFragment.c((AssistantSettingFragment)localObject, ((AssistantSettingFragment)localObject).i.e() ^ true);
    }
  }
  
  protected void onSetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.a.getBaseActivity().isFinishing())
    {
      AssistantSettingFragment localAssistantSettingFragment = this.a;
      AssistantSettingFragment.a(localAssistantSettingFragment, AssistantSettingFragment.a(localAssistantSettingFragment).getSwitch(), paramBoolean2);
    }
  }
  
  protected void onSetCommonSwitchFromDetailInfo(boolean paramBoolean, short paramShort1, short paramShort2)
  {
    CTEntry localCTEntry;
    if (this.a.h == null) {
      localCTEntry = null;
    } else {
      localCTEntry = this.a.h.a(paramShort1);
    }
    if (localCTEntry == null) {
      return;
    }
    boolean bool;
    if (paramShort2 == 1) {
      bool = true;
    } else {
      bool = false;
    }
    if ((!paramBoolean) && (bool == localCTEntry.m))
    {
      localCTEntry.m ^= true;
      this.a.g.post(new AssistantSettingFragment.1.1(this, bool));
    }
  }
  
  protected void onSetConnectionsSwitch(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (com.tencent.qphone.base.util.QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSetConnectionsSwitch:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramInt2);
      com.tencent.qphone.base.util.QLog.i("AssistantSettingFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (!paramBoolean)
    {
      AssistantSettingFragment.a(this.a, 2131916364, 1);
      localObject = this.a;
      AssistantSettingFragment.c((AssistantSettingFragment)localObject, ((AssistantSettingFragment)localObject).i.e() ^ true);
    }
  }
  
  protected void onSetEmotionRecSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.a.getBaseActivity().isFinishing())
    {
      if (AssistantSettingFragment.c(this.a) == null) {
        return;
      }
      if (!paramBoolean1)
      {
        AssistantSettingFragment.a(this.a, 2131916364, 1);
        localAssistantSettingFragment = this.a;
        AssistantSettingFragment.a(localAssistantSettingFragment, ((IStickerRecManager)AssistantSettingFragment.c(localAssistantSettingFragment).getRuntimeService(IStickerRecManager.class)).isEmotionRecSettingOpen(), AssistantSettingFragment.d(this.a));
        return;
      }
      AssistantSettingFragment localAssistantSettingFragment = this.a;
      AssistantSettingFragment.a(localAssistantSettingFragment, paramBoolean2, AssistantSettingFragment.d(localAssistantSettingFragment));
    }
  }
  
  protected void onSetPttAutoToTxtSwitch(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
    {
      QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131899023), 0).show(this.a.getBaseActivity().getTitleBarHeight());
      paramBoolean = ((Boolean)paramObject).booleanValue();
      AssistantSettingFragment.a(this.a, true);
      AssistantSettingFragment.e(this.a).setChecked(paramBoolean);
      AssistantSettingFragment.b(this.a, paramBoolean);
      AssistantSettingFragment.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */