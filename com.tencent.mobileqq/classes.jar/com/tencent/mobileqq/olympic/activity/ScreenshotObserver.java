package com.tencent.mobileqq.olympic.activity;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore.Images.Media;

public class ScreenshotObserver
  extends ContentObserver
{
  static final String[] a = { "_data", "date_added" };
  private static final String b = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
  private ContentResolver c;
  private ScreenshotObserver.Listener d;
  
  public ScreenshotObserver(Handler paramHandler, Context paramContext)
  {
    super(paramHandler);
    this.c = paramContext.getContentResolver();
  }
  
  public void a()
  {
    this.c.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this);
  }
  
  public void a(ScreenshotObserver.Listener paramListener)
  {
    this.d = paramListener;
  }
  
  public void b()
  {
    this.c.unregisterContentObserver(this);
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    onChange(paramBoolean, null);
  }
  
  public void onChange(boolean paramBoolean, Uri paramUri)
  {
    Object localObject1;
    Object localObject2;
    long l;
    if (paramUri == null)
    {
      localObject1 = this.c.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, a, null, null, "date_added DESC");
      if ((localObject1 != null) && (((Cursor)localObject1).moveToFirst()))
      {
        localObject2 = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("_data"));
        l = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndex("date_added"));
        if ((Math.abs(System.currentTimeMillis() / 1000L - l) <= 3L) && (((String)localObject2).toLowerCase().contains("screenshot")))
        {
          localObject2 = this.d;
          if (localObject2 != null) {
            ((ScreenshotObserver.Listener)localObject2).onDetectScreenshot(paramUri);
          }
        }
      }
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
    }
    else
    {
      localObject1 = paramUri.toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(b);
      ((StringBuilder)localObject2).append("/\\d+");
      if (((String)localObject1).matches(((StringBuilder)localObject2).toString()))
      {
        localObject1 = this.c.query(paramUri, a, null, null, null);
        if ((localObject1 != null) && (((Cursor)localObject1).moveToFirst()))
        {
          localObject2 = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("_data"));
          l = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndex("date_added"));
          if ((Math.abs(System.currentTimeMillis() / 1000L - l) <= 3L) && (((String)localObject2).toLowerCase().contains("screenshot")))
          {
            localObject2 = this.d;
            if (localObject2 != null) {
              ((ScreenshotObserver.Listener)localObject2).onDetectScreenshot(paramUri);
            }
          }
        }
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.ScreenshotObserver
 * JD-Core Version:    0.7.0.1
 */