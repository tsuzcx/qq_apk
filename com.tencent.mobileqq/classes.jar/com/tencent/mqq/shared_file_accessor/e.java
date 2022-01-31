package com.tencent.mqq.shared_file_accessor;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

final class e
{
  private WeakReference a;
  private Uri b;
  
  public e(WeakReference paramWeakReference, String paramString)
  {
    this.a = paramWeakReference;
    StringBuilder localStringBuilder = new StringBuilder("content://com.tencent.mqq.shared_file_accessor.ContentProviderImpl/params?file=");
    paramWeakReference = paramString;
    if (paramString == null) {
      paramWeakReference = "default";
    }
    this.b = Uri.parse(paramWeakReference);
  }
  
  public final void a(String paramString)
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      Context localContext = (Context)this.a.get();
      if ((localContext == null) && (TextUtils.isEmpty(paramString))) {
        continue;
      }
      try
      {
        paramString = localContext.getContentResolver().query(this.b, new String[] { "cmd", "101", "process", k.a, "log", paramString }, null, null, null);
        if (paramString == null) {
          continue;
        }
        try
        {
          paramString.close();
          return;
        }
        catch (Throwable paramString) {}
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.e
 * JD-Core Version:    0.7.0.1
 */