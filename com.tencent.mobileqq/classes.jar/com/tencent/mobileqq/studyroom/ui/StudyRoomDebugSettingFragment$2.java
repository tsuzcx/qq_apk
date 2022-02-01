package com.tencent.mobileqq.studyroom.ui;

import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginUpdater;

class StudyRoomDebugSettingFragment$2
  implements CompoundButton.OnCheckedChangeListener
{
  StudyRoomDebugSettingFragment$2(StudyRoomDebugSettingFragment paramStudyRoomDebugSettingFragment, EditText paramEditText, Button paramButton) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    PluginUpdater.a(paramBoolean, this.jdField_a_of_type_ComTencentMobileqqStudyroomUiStudyRoomDebugSettingFragment.getQBaseActivity());
    if (!paramBoolean)
    {
      paramCompoundButton = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqStudyroomUiStudyRoomDebugSettingFragment.getQBaseActivity().getAppRuntime();
      if (paramCompoundButton != null) {
        ((IPluginManager)paramCompoundButton.getManager(QQManagerFactory.MGR_PLUGIN)).b();
      }
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(paramBoolean);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.ui.StudyRoomDebugSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */