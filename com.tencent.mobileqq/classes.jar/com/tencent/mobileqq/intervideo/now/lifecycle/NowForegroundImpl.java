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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreate context = ");
    localStringBuilder.append(paramContext);
    QLog.d("NowForegroundImpl", 2, localStringBuilder.toString());
    Foreground.updateRuntimeState(this.jdField_a_of_type_MqqAppAppRuntime);
    if ((paramContext instanceof Activity)) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((Activity)paramContext);
    }
  }
  
  public void onDestroy()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDestroy mRuntime = ");
    localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime);
    QLog.d("NowForegroundImpl", 2, localStringBuilder.toString());
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onStart()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStart mActivity = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangRefWeakReference);
    QLog.d("NowForegroundImpl", 2, localStringBuilder.toString());
  }
  
  public void onStop()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStop mRuntime = ");
    localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime);
    QLog.d("NowForegroundImpl", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.lifecycle.NowForegroundImpl
 * JD-Core Version:    0.7.0.1
 */