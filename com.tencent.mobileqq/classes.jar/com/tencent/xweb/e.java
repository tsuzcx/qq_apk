package com.tencent.xweb;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public class e
{
  private static final Object a = new Object();
  
  public static void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null) {
      if (paramArrayOfString.length == 0) {
        return;
      }
    }
    for (;;)
    {
      int i;
      synchronized (a)
      {
        Object localObject2 = XWalkEnvironment.getSharedPreferencesForFileReaderRecord();
        if (localObject2 == null)
        {
          Log.e("XFilesReaderCrashDetect", "resetCrashInfo sp is null");
          return;
        }
        localObject2 = ((SharedPreferences)localObject2).edit();
        if (localObject2 == null)
        {
          Log.e("XFilesReaderCrashDetect", "resetCrashInfo editor is null");
          return;
        }
        int j = paramArrayOfString.length;
        i = 0;
        if (i < j)
        {
          String str = paramArrayOfString[i];
          if ((str == null) || (str.isEmpty())) {
            break label194;
          }
          str = str.toLowerCase();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_count");
          ((SharedPreferences.Editor)localObject2).remove(localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_time");
          ((SharedPreferences.Editor)localObject2).remove(localStringBuilder.toString());
          break label194;
        }
        ((SharedPreferences.Editor)localObject2).commit();
        return;
      }
      return;
      label194:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.e
 * JD-Core Version:    0.7.0.1
 */