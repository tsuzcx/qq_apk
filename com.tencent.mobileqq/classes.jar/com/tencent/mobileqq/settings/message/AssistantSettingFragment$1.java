package com.tencent.mobileqq.settings.message;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntry;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryListener;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.HeightAdaptableListView;
import java.util.Map;

class AssistantSettingFragment$1
  extends CardObserver
{
  AssistantSettingFragment$1(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onGetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!this.a.getActivity().isFinishing())) {
      AssistantSettingFragment.a(this.a, AssistantSettingFragment.a(this.a).a(), paramBoolean2);
    }
  }
  
  public void onGetCommonSwitchFromDetailInfo(boolean paramBoolean, short[] paramArrayOfShort, Map<Short, Short> paramMap)
  {
    if ((paramBoolean) && (AssistantSettingFragment.a(this.a) != null) && (this.a.jdField_a_of_type_ComTencentMobileqqSettingsMessageAssistantSettingFragment$EntryListAdapter != null) && (this.a.jdField_a_of_type_ComTencentMobileqqSettingsMessageAssistantSettingFragment$EntryListAdapter.a(paramArrayOfShort)))
    {
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.i("AssistantSettingFragment", 0, "onGetCommonSwitchFromDetailInfo");
      }
      AssistantSettingFragment.a(this.a).a();
    }
  }
  
  public void onGetConnectionsSwitch(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.i("AssistantSettingFragment", 2, "onGetConnectionsSwitch:" + paramBoolean + " " + paramInt1 + " " + paramInt2);
    }
    AssistantSettingFragment localAssistantSettingFragment;
    if (paramBoolean)
    {
      localAssistantSettingFragment = this.a;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.c()) {
        break label81;
      }
    }
    label81:
    for (paramBoolean = true;; paramBoolean = false)
    {
      AssistantSettingFragment.b(localAssistantSettingFragment, paramBoolean);
      return;
    }
  }
  
  public void onSetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.a.getActivity().isFinishing()) {
      AssistantSettingFragment.a(this.a, AssistantSettingFragment.a(this.a).a(), paramBoolean2);
    }
  }
  
  public void onSetCommonSwitchFromDetailInfo(boolean paramBoolean, short paramShort1, short paramShort2)
  {
    boolean bool2 = true;
    if (this.a.jdField_a_of_type_ComTencentMobileqqSettingsMessageAssistantSettingFragment$EntryListAdapter == null) {}
    for (CTEntry localCTEntry = null; localCTEntry == null; localCTEntry = this.a.jdField_a_of_type_ComTencentMobileqqSettingsMessageAssistantSettingFragment$EntryListAdapter.a(paramShort1)) {
      return;
    }
    boolean bool1;
    if (paramShort2 == 1)
    {
      bool1 = true;
      label46:
      if ((paramBoolean) || (bool1 != localCTEntry.e)) {
        break label103;
      }
      if (localCTEntry.e) {
        break label105;
      }
    }
    label103:
    label105:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      localCTEntry.e = paramBoolean;
      this.a.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.post(new AssistantSettingFragment.1.1(this, bool1));
      return;
      bool1 = false;
      break label46;
      break;
    }
  }
  
  public void onSetConnectionsSwitch(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.i("AssistantSettingFragment", 2, "onSetConnectionsSwitch:" + paramBoolean + " " + paramInt1 + " " + paramInt2);
    }
    AssistantSettingFragment localAssistantSettingFragment;
    if (!paramBoolean)
    {
      AssistantSettingFragment.a(this.a, 2131719116, 1);
      localAssistantSettingFragment = this.a;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.c()) {
        break label95;
      }
    }
    label95:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      AssistantSettingFragment.b(localAssistantSettingFragment, paramBoolean);
      return;
    }
  }
  
  public void onSetEmotionRecSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.a.getActivity().isFinishing()) || (AssistantSettingFragment.a(this.a) == null)) {
      return;
    }
    if (!paramBoolean1)
    {
      AssistantSettingFragment.a(this.a, 2131719116, 1);
      AssistantSettingFragment.a(this.a, StickerRecManager.a(AssistantSettingFragment.a(this.a)).b(), AssistantSettingFragment.a(this.a));
      return;
    }
    AssistantSettingFragment.a(this.a, paramBoolean2, AssistantSettingFragment.a(this.a));
  }
  
  public void onSetPttAutoToTxtSwitch(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
    {
      QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131700858), 0).b(this.a.getActivity().getTitleBarHeight());
      paramBoolean = ((Boolean)paramObject).booleanValue();
      AssistantSettingFragment.a(this.a, true);
      AssistantSettingFragment.b(this.a).setChecked(paramBoolean);
      AssistantSettingFragment.a(this.a, paramBoolean);
      AssistantSettingFragment.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */