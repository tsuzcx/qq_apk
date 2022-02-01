import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings.System;
import com.tencent.qphone.base.util.QLog;

public class rvb
  extends ContentObserver
{
  public rvb(ruy paramruy, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public ContentResolver a()
  {
    if (this.a.a() != null) {
      return this.a.a().getContentResolver();
    }
    return null;
  }
  
  public void a()
  {
    if (a() != null) {
      a().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this);
    }
  }
  
  public void b()
  {
    if (a() != null) {
      a().unregisterContentObserver(this);
    }
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    if (this.a.a() == null) {}
    for (;;)
    {
      return;
      int i = Settings.System.getInt(this.a.a().getContentResolver(), "accelerometer_rotation", -1);
      if (i == 1)
      {
        ruy.a(this.a, true);
        this.a.a(true);
      }
      while (QLog.isColorLevel())
      {
        QLog.d(ruy.a, 2, "RotationObserver.onChange() : rotateState=" + i);
        return;
        ruy.a(this.a, false);
        this.a.a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rvb
 * JD-Core Version:    0.7.0.1
 */