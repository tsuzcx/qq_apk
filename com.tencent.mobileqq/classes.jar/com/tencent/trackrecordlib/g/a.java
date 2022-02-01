package com.tencent.trackrecordlib.g;

import android.content.Context;
import android.provider.Settings.Secure;
import android.text.TextUtils.SimpleStringSplitter;
import android.util.Log;

public class a
{
  private static final String a = "com.tencent.trackrecordlib.g.a";
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    int i;
    try
    {
      i = Settings.Secure.getInt(paramContext.getApplicationContext().getContentResolver(), "accessibility_enabled");
    }
    catch (Throwable localThrowable)
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Error finding setting, default accessibility to not found: ");
      localStringBuilder.append(localThrowable.getMessage());
      Log.e(str, localStringBuilder.toString());
      i = 0;
    }
    TextUtils.SimpleStringSplitter localSimpleStringSplitter = new TextUtils.SimpleStringSplitter(':');
    if (i == 1)
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "enabled_accessibility_services");
      if (paramContext != null)
      {
        localSimpleStringSplitter.setString(paramContext);
        while (localSimpleStringSplitter.hasNext()) {
          if (localSimpleStringSplitter.next().equalsIgnoreCase("com.google.android.marvin.talkback/com.google.android.marvin.talkback.TalkBackService")) {
            return true;
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trackrecordlib.g.a
 * JD-Core Version:    0.7.0.1
 */