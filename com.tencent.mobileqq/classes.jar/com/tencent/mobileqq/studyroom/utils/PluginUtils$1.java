package com.tencent.mobileqq.studyroom.utils;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.studyroom.shadow.IVPluginManager;
import com.tencent.mobileqq.studyroom.shadow.Shadow;
import com.tencent.qphone.base.util.QLog;

final class PluginUtils$1
  implements Runnable
{
  PluginUtils$1(Context paramContext, Bundle paramBundle, PluginUtils.PluginCallback paramPluginCallback) {}
  
  public void run()
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (PluginUtils.a() == null) {
        PluginUtils.a(Shadow.a(BaseApplicationImpl.getContext(), "StudyRoom", localQQAppInterface.getCurrentUin()));
      }
      QLog.i("studyroom.PluginUtils", 1, "ThreadManagerExecutor pluginManager.enter threadId = " + Thread.currentThread().getId());
      PluginUtils.a().enter(this.jdField_a_of_type_AndroidContentContext, 1L, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentMobileqqStudyroomUtilsPluginUtils$PluginCallback);
      return;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        QLog.e("studyroom.PluginUtils", 4, "load plugin error", localThrowable);
      } while (this.jdField_a_of_type_ComTencentMobileqqStudyroomUtilsPluginUtils$PluginCallback == null);
      this.jdField_a_of_type_ComTencentMobileqqStudyroomUtilsPluginUtils$PluginCallback.a(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.utils.PluginUtils.1
 * JD-Core Version:    0.7.0.1
 */