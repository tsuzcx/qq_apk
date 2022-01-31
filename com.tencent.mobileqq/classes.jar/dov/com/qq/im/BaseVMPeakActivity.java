package dov.com.qq.im;

import android.os.Bundle;
import android.support.annotation.NonNull;
import bjno;
import bjnp;
import bjns;
import bjot;
import bjpb;
import bjpc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.qphone.base.util.QLog;

public class BaseVMPeakActivity
  extends PeakActivity
  implements bjns, bjpc
{
  private bjot jdField_a_of_type_Bjot = new bjot(this);
  private bjpb jdField_a_of_type_Bjpb;
  
  public bjno a()
  {
    return this.jdField_a_of_type_Bjot;
  }
  
  @NonNull
  public bjpb a()
  {
    if (BaseApplicationImpl.getApplication() == null) {
      throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }
    if (this.jdField_a_of_type_Bjpb == null) {
      this.jdField_a_of_type_Bjpb = new bjpb();
    }
    return this.jdField_a_of_type_Bjpb;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Bjot = new bjot(this);
    try
    {
      this.jdField_a_of_type_Bjot.a(bjnp.a);
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
      this.jdField_a_of_type_Bjot.a(bjnp.f);
      if ((this.jdField_a_of_type_Bjpb != null) && (!isChangingConfigurations())) {
        this.jdField_a_of_type_Bjpb.a();
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
      this.jdField_a_of_type_Bjot.a(bjnp.d);
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
      this.jdField_a_of_type_Bjot.a(bjnp.c);
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
      this.jdField_a_of_type_Bjot.a(bjnp.b);
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
      this.jdField_a_of_type_Bjot.a(bjnp.e);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BaseActivity2", 1, "mLifecycleRegistry 初始化失败");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.BaseVMPeakActivity
 * JD-Core Version:    0.7.0.1
 */