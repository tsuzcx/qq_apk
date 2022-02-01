package com.tencent.mobileqq.studyroom.utils;

import android.content.Context;
import android.os.Bundle;
import bddd;
import bddf;
import bdds;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public final class PluginUtils$1
  implements Runnable
{
  public PluginUtils$1(Context paramContext, Bundle paramBundle, bdds parambdds) {}
  
  public void run()
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      bddf.a(BaseApplicationImpl.getContext(), "StudyRoom", localQQAppInterface.c()).enter(this.jdField_a_of_type_AndroidContentContext, 1L, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Bdds);
      return;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        QLog.e("studyroom.PluginUtils", 4, "load plugin error", localThrowable);
      } while (this.jdField_a_of_type_Bdds == null);
      this.jdField_a_of_type_Bdds.a(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.utils.PluginUtils.1
 * JD-Core Version:    0.7.0.1
 */