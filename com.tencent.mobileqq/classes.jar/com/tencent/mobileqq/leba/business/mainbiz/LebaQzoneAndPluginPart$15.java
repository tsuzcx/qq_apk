package com.tencent.mobileqq.leba.business.mainbiz;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;

class LebaQzoneAndPluginPart$15
  implements Runnable
{
  LebaQzoneAndPluginPart$15(LebaQzoneAndPluginPart paramLebaQzoneAndPluginPart, String paramString, QQAppInterface paramQQAppInterface, BusinessInfoCheckUpdate.AppInfo paramAppInfo) {}
  
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("web_process_preload_file", 4);
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_web_plugin_click_num");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    int i = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_web_plugin_click_num");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localEditor.putInt(localStringBuilder.toString(), i + 1);
    if (this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() != 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_web_plugin_click_red_num");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      i = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("key_web_plugin_click_red_num");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localEditor.putInt(((StringBuilder)localObject).toString(), i + 1);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("key_come_webview_time");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localEditor.putLong(((StringBuilder)localObject).toString(), System.currentTimeMillis());
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.15
 * JD-Core Version:    0.7.0.1
 */