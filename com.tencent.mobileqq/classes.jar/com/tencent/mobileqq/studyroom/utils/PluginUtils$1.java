package com.tencent.mobileqq.studyroom.utils;

import android.content.Context;
import android.os.Bundle;
import bdwo;
import bdwq;
import bdxd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public final class PluginUtils$1
  implements Runnable
{
  public PluginUtils$1(Context paramContext, Bundle paramBundle, bdxd parambdxd) {}
  
  public void run()
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      bdwq.a(BaseApplicationImpl.getContext(), "StudyRoom", localQQAppInterface.getCurrentUin()).enter(this.jdField_a_of_type_AndroidContentContext, 1L, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Bdxd);
      return;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        QLog.e("studyroom.PluginUtils", 4, "load plugin error", localThrowable);
      } while (this.jdField_a_of_type_Bdxd == null);
      this.jdField_a_of_type_Bdxd.a(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.utils.PluginUtils.1
 * JD-Core Version:    0.7.0.1
 */