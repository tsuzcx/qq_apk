import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

public class rac
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private ContentObserver jdField_a_of_type_AndroidDatabaseContentObserver = new rad(this, new Handler());
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public rac(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void c()
  {
    if (!this.b)
    {
      this.b = true;
      this.jdField_a_of_type_AndroidAppActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("screen_brightness"), true, this.jdField_a_of_type_AndroidDatabaseContentObserver);
    }
  }
  
  private void d()
  {
    if (this.b)
    {
      this.b = false;
      this.jdField_a_of_type_AndroidAppActivity.getContentResolver().unregisterContentObserver(this.jdField_a_of_type_AndroidDatabaseContentObserver);
    }
  }
  
  public int a()
  {
    ContentResolver localContentResolver = this.jdField_a_of_type_AndroidAppActivity.getContentResolver();
    try
    {
      int i = Settings.System.getInt(localContentResolver, "screen_brightness");
      return i;
    }
    catch (Settings.SettingNotFoundException localSettingNotFoundException) {}
    return 0;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidAppActivity.getWindow().getAttributes();
      localLayoutParams.screenBrightness = -1.0F;
      this.jdField_a_of_type_AndroidAppActivity.getWindow().setAttributes(localLayoutParams);
    }
  }
  
  public void a(float paramFloat)
  {
    c();
    this.jdField_a_of_type_Boolean = true;
    WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidAppActivity.getWindow().getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    this.jdField_a_of_type_AndroidAppActivity.getWindow().setAttributes(localLayoutParams);
  }
  
  public boolean a()
  {
    ContentResolver localContentResolver = this.jdField_a_of_type_AndroidAppActivity.getContentResolver();
    try
    {
      int i = Settings.System.getInt(localContentResolver, "screen_brightness_mode");
      return i == 1;
    }
    catch (Settings.SettingNotFoundException localSettingNotFoundException)
    {
      localSettingNotFoundException.printStackTrace();
    }
    return false;
  }
  
  public void b()
  {
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rac
 * JD-Core Version:    0.7.0.1
 */