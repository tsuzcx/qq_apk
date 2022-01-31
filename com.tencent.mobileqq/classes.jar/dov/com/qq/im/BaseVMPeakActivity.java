package dov.com.qq.im;

import android.os.Bundle;
import android.support.annotation.NonNull;
import bhvc;
import bhvd;
import bhvg;
import bhwh;
import bhwp;
import bhwq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.qphone.base.util.QLog;

public class BaseVMPeakActivity
  extends PeakActivity
  implements bhvg, bhwq
{
  private bhwh jdField_a_of_type_Bhwh = new bhwh(this);
  private bhwp jdField_a_of_type_Bhwp;
  
  public bhvc a()
  {
    return this.jdField_a_of_type_Bhwh;
  }
  
  @NonNull
  public bhwp a()
  {
    if (BaseApplicationImpl.getApplication() == null) {
      throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }
    if (this.jdField_a_of_type_Bhwp == null) {
      this.jdField_a_of_type_Bhwp = new bhwp();
    }
    return this.jdField_a_of_type_Bhwp;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Bhwh = new bhwh(this);
    try
    {
      this.jdField_a_of_type_Bhwh.a(bhvd.a);
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
      this.jdField_a_of_type_Bhwh.a(bhvd.f);
      if ((this.jdField_a_of_type_Bhwp != null) && (!isChangingConfigurations())) {
        this.jdField_a_of_type_Bhwp.a();
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
      this.jdField_a_of_type_Bhwh.a(bhvd.d);
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
      this.jdField_a_of_type_Bhwh.a(bhvd.c);
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
      this.jdField_a_of_type_Bhwh.a(bhvd.b);
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
      this.jdField_a_of_type_Bhwh.a(bhvd.e);
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