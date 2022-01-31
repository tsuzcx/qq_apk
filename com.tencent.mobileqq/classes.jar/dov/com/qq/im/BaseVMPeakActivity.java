package dov.com.qq.im;

import android.os.Bundle;
import android.support.annotation.NonNull;
import blyx;
import blyy;
import blzb;
import bmad;
import bmal;
import bmam;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.qphone.base.util.QLog;

public class BaseVMPeakActivity
  extends PeakActivity
  implements blzb, bmam
{
  private bmad jdField_a_of_type_Bmad = new bmad(this);
  private bmal jdField_a_of_type_Bmal;
  
  public blyx a()
  {
    return this.jdField_a_of_type_Bmad;
  }
  
  @NonNull
  public bmal a()
  {
    if (BaseApplicationImpl.getApplication() == null) {
      throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }
    if (this.jdField_a_of_type_Bmal == null) {
      this.jdField_a_of_type_Bmal = new bmal();
    }
    return this.jdField_a_of_type_Bmal;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Bmad = new bmad(this);
    try
    {
      this.jdField_a_of_type_Bmad.a(blyy.a);
      return;
    }
    catch (Throwable paramBundle)
    {
      QLog.e("BaseActivity2", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      this.jdField_a_of_type_Bmad.a(blyy.f);
      if ((this.jdField_a_of_type_Bmal != null) && (!isChangingConfigurations())) {
        this.jdField_a_of_type_Bmal.a();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("BaseActivity2", 1, "mLifecycleRegistry 初始化失败");
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    try
    {
      this.jdField_a_of_type_Bmad.a(blyy.d);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BaseActivity2", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public void onResume()
  {
    super.onResume();
    try
    {
      this.jdField_a_of_type_Bmad.a(blyy.c);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BaseActivity2", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public void onStart()
  {
    super.onStart();
    try
    {
      this.jdField_a_of_type_Bmad.a(blyy.b);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BaseActivity2", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public void onStop()
  {
    super.onStop();
    try
    {
      this.jdField_a_of_type_Bmad.a(blyy.e);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BaseActivity2", 1, "mLifecycleRegistry 初始化失败");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.BaseVMPeakActivity
 * JD-Core Version:    0.7.0.1
 */