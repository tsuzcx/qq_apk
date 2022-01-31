package cooperation.qzone;

import anbf;
import android.app.Activity;
import android.content.IntentFilter;
import android.view.KeyEvent;
import cooperation.qzone.util.QZLog;

public class WatchActivityManager
{
  public static String a;
  public anbf a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "WatchActivityManager";
  }
  
  public WatchActivityManager()
  {
    this.jdField_a_of_type_Anbf = new anbf(this, null);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    this.c = false;
    this.d = false;
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
      this.jdField_a_of_type_AndroidAppActivity.registerReceiver(this.jdField_a_of_type_Anbf, localIntentFilter);
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidAppActivity != null) {
      this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver(this.jdField_a_of_type_Anbf);
    }
  }
  
  public void a()
  {
    d();
  }
  
  public void a(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.c = true;
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    e();
  }
  
  public boolean a()
  {
    QZLog.i(jdField_a_of_type_JavaLangString, 4, "ljh, mActivityStopped = " + this.d + ", mPressScreenOff = " + this.jdField_a_of_type_Boolean + ", mPressMenuKey = " + this.c + ", mPressHomeKey = " + this.b);
    return (this.d) && (!this.jdField_a_of_type_Boolean) && (!this.c) && (!this.b);
  }
  
  public void b()
  {
    this.d = true;
  }
  
  public void c()
  {
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.WatchActivityManager
 * JD-Core Version:    0.7.0.1
 */