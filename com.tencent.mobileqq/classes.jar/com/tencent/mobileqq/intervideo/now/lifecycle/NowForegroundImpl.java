package com.tencent.mobileqq.intervideo.now.lifecycle;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqinterface.IForeground;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.app.Foreground;

public class NowForegroundImpl
  implements IForeground
{
  private int jdField_a_of_type_Int = 0;
  WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  protected AppRuntime a;
  
  public NowForegroundImpl()
  {
    a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_MqqAppAppRuntime = BaseApplicationImpl.getApplication().waitAppRuntime(null);
  }
  
  public void onCreate(Context paramContext)
  {
    QLog.d("NowForegroundImpl", 2, "onCreate context = " + paramContext);
    Foreground.updateRuntimeState(this.jdField_a_of_type_MqqAppAppRuntime);
    if ((paramContext instanceof Activity)) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((Activity)paramContext);
    }
  }
  
  public void onDestroy()
  {
    QLog.d("NowForegroundImpl", 2, "onDestroy mRuntime = " + this.jdField_a_of_type_MqqAppAppRuntime);
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onStart()
  {
    QLog.d("NowForegroundImpl", 2, "onStart mActivity = " + this.jdField_a_of_type_JavaLangRefWeakReference);
  }
  
  public void onStop()
  {
    QLog.d("NowForegroundImpl", 2, "onStop mRuntime = " + this.jdField_a_of_type_MqqAppAppRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.lifecycle.NowForegroundImpl
 * JD-Core Version:    0.7.0.1
 */