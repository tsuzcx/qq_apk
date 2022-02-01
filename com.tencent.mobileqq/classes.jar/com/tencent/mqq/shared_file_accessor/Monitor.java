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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("content://com.tencent.mqq.shared_file_accessor.ContentProviderImpl/params?file=");
    paramWeakReference = paramString;
    if (paramString == null) {
      paramWeakReference = "default";
    }
    localStringBuilder.append(paramWeakReference);
    this.mUri = Uri.parse(localStringBuilder.toString());
  }
  
  public void log(String paramString)
  {
    WeakReference localWeakReference = this.mContext;
    if (localWeakReference == null) {
      return;
    }
    Context localContext = (Context)localWeakReference.get();
    if ((localContext == null) && (TextUtils.isEmpty(paramString))) {
      return;
    }
    localWeakReference = null;
    try
    {
      paramString = localContext.getContentResolver().query(this.mUri, new String[] { "cmd", "101", "process", Utils.sCurrentProcessName, "log", paramString }, null, null, null);
      if (paramString == null) {}
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        try
        {
          paramString.close();
          return;
        }
        catch (Throwable paramString) {}
        paramString = paramString;
        paramString = localWeakReference;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.Monitor
 * JD-Core Version:    0.7.0.1
 */