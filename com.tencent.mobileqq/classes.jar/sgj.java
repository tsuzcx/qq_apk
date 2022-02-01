import android.app.Activity;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings.System;

class sgj
  extends ContentObserver
{
  sgj(sgi paramsgi, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void onChange(boolean paramBoolean, Uri paramUri)
  {
    super.onChange(paramBoolean, paramUri);
    int i = Settings.System.getInt(sgi.a(this.a).getContentResolver(), "screen_brightness", 125);
    if ((sgi.a(this.a)) && (i > 0)) {
      this.a.a(i / 255.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sgj
 * JD-Core Version:    0.7.0.1
 */