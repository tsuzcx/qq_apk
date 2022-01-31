package com.tencent.mobileqq.intervideo.now.lifecycle;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqinterface.IForeground;
import mqq.app.AppRuntime;
import mqq.app.Foreground;

public class NowForegroundImpl
  implements IForeground
{
  Activity a;
  protected AppRuntime a;
  
  public NowForegroundImpl()
  {
    updateRuntime();
  }
  
  public void onCreate(Context paramContext)
  {
    QLog.d("NowForegroundImpl", 2, "onCreate context = " + paramContext);
    Foreground.updateRuntimeState(this.jdField_a_of_type_MqqAppAppRuntime);
    if ((paramContext instanceof Activity)) {
      this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    }
  }
  
  public void onDestroy()
  {
    QLog.d("NowForegroundImpl", 2, "onDestroy mRuntime = " + this.jdField_a_of_type_MqqAppAppRuntime);
    Foreground.onDestroy(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public void onPause()
  {
    Foreground.onPause(this.jdField_a_of_type_MqqAppAppRuntime);
  }
  
  public void onResume()
  {
    Foreground.onResume(this.jdField_a_of_type_MqqAppAppRuntime);
  }
  
  public void onStart()
  {
    QLog.d("NowForegroundImpl", 2, "onStart mActivity = " + this.jdField_a_of_type_AndroidAppActivity);
    Foreground.onStart(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public void onStop()
  {
    QLog.d("NowForegroundImpl", 2, "onStop mRuntime = " + this.jdField_a_of_type_MqqAppAppRuntime);
    Foreground.onStop(this.jdField_a_of_type_MqqAppAppRuntime);
  }
  
  public void updateRuntime()
  {
    this.jdField_a_of_type_MqqAppAppRuntime = BaseApplicationImpl.getApplication().waitAppRuntime(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.lifecycle.NowForegroundImpl
 * JD-Core Version:    0.7.0.1
 */