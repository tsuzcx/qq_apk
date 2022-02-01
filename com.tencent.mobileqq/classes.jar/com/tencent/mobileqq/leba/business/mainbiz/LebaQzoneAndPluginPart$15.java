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
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("web_process_preload_file", 4);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    int i = localSharedPreferences.getInt("key_web_plugin_click_num" + this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    localEditor.putInt("key_web_plugin_click_num" + this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i + 1);
    if (this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() != 0)
    {
      i = localSharedPreferences.getInt("key_web_plugin_click_red_num" + this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
      localEditor.putInt("key_web_plugin_click_red_num" + this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i + 1);
    }
    localEditor.putLong("key_come_webview_time" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), System.currentTimeMillis());
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.15
 * JD-Core Version:    0.7.0.1
 */