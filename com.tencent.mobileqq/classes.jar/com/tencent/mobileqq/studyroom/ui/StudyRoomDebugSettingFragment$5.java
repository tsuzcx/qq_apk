package com.tencent.mobileqq.studyroom.ui;

import android.content.Context;
import android.os.IBinder;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class StudyRoomDebugSettingFragment$5
  implements OnPluginInstallListener
{
  StudyRoomDebugSettingFragment$5(StudyRoomDebugSettingFragment paramStudyRoomDebugSettingFragment, QQProgressDialog paramQQProgressDialog, String paramString) {}
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    StudyRoomDebugSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqStudyroomUiStudyRoomDebugSettingFragment, "studyroom_plugin_name", this.jdField_a_of_type_JavaLangString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onInstallError: [");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("]");
    ((StringBuilder)localObject).append(paramString);
    QLog.e("StudyRoomDebugSettingFragment", 1, ((StringBuilder)localObject).toString());
    if (paramInt == 2)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqStudyroomUiStudyRoomDebugSettingFragment.getQBaseActivity(), "插件正在运行，请重启手Q", 1).a();
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqStudyroomUiStudyRoomDebugSettingFragment.getQBaseActivity();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("插件安装失败: ");
    localStringBuilder.append(paramString);
    QQToast.a((Context)localObject, localStringBuilder.toString(), 1).a();
  }
  
  public void onInstallFinish(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    paramString = new StringBuilder();
    paramString.append("onInstallFinish: branch=");
    paramString.append(this.jdField_a_of_type_JavaLangString);
    QLog.d("StudyRoomDebugSettingFragment", 1, paramString.toString());
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqStudyroomUiStudyRoomDebugSettingFragment.getQBaseActivity(), "重置成功，返回打开自习室吧。", 2).a();
    StudyRoomDebugSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqStudyroomUiStudyRoomDebugSettingFragment, "studyroom_plugin_name", this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.ui.StudyRoomDebugSettingFragment.5
 * JD-Core Version:    0.7.0.1
 */