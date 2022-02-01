package com.tencent.mqq.shared_file_accessor;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

final class Monitor
{
  private static final String CP_URI_BASE = "content://com.tencent.mqq.shared_file_accessor.ContentProviderImpl";
  private static final String DEFAULT_SP_NAME = "default";
  private static final String TAG = "Monitor";
  private WeakReference<Context> mContext;
  private Uri mUri;
  
  public Monitor(WeakReference<Context> paramWeakReference, String paramString)
  {
    this.mContext = paramWeakReference;
    StringBuilder localStringBuilder = new StringBuilder().append("content://com.tencent.mqq.shared_file_accessor.ContentProviderImpl/params?file=");
    paramWeakReference = paramString;
    if (paramString == null) {
      paramWeakReference = "default";
    }
    this.mUri = Uri.parse(paramWeakReference);
  }
  
  public void log(String paramString)
  {
    if (this.mContext == null) {}
    for (;;)
    {
      return;
      Context localContext = (Context)this.mContext.get();
      if ((localContext == null) && (TextUtils.isEmpty(paramString))) {
        continue;
      }
      try
      {
        paramString = localContext.getContentResolver().query(this.mUri, new String[] { "cmd", "101", "process", Utils.sCurrentProcessName, "log", paramString }, null, null, null);
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
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.Monitor
 * JD-Core Version:    0.7.0.1
 */