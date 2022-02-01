import android.app.Activity;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings.System;

class rms
  extends ContentObserver
{
  rms(rmr paramrmr, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void onChange(boolean paramBoolean, Uri paramUri)
  {
    super.onChange(paramBoolean, paramUri);
    int i = Settings.System.getInt(rmr.a(this.a).getContentResolver(), "screen_brightness", 125);
    if ((rmr.a(this.a)) && (i > 0)) {
      this.a.a(i / 255.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rms
 * JD-Core Version:    0.7.0.1
 */