package com.tencent.rmonitor.memory.leakdetect;

import android.content.Context;
import android.media.AudioManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.AndroidVersion;
import java.lang.reflect.Field;

public class ActivityLeakSolution
{
  private static boolean a = false;
  
  private static void a(Context paramContext, InputMethodManager paramInputMethodManager)
  {
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "mCurRootView";
    arrayOfString[1] = "mServedView";
    arrayOfString[2] = "mNextServedView";
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject1 = arrayOfString[i];
      try
      {
        localObject1 = paramInputMethodManager.getClass().getDeclaredField((String)localObject1);
        if (!((Field)localObject1).isAccessible()) {
          ((Field)localObject1).setAccessible(true);
        }
        Object localObject2 = ((Field)localObject1).get(paramInputMethodManager);
        if ((localObject2 instanceof View))
        {
          localObject2 = (View)localObject2;
          if (((View)localObject2).getContext() == paramContext)
          {
            ((Field)localObject1).set(paramInputMethodManager, null);
          }
          else
          {
            Logger.b.d(new String[] { "RMonitor_memory_ActivityLeakSolution", "fixInputMethodManagerLeak break, context not suitable", ", get_context=", ((View)localObject2).getContext().toString(), ", dest_context=", paramContext.toString() });
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Logger.b.a("RMonitor_memory_ActivityLeakSolution", localThrowable);
        i += 1;
      }
    }
  }
  
  public static void fixAudioManagerLeak(@NonNull Context paramContext)
  {
    if (a)
    {
      if (AndroidVersion.d()) {
        return;
      }
      try
      {
        paramContext = (AudioManager)paramContext.getSystemService("audio");
        Field localField = paramContext.getClass().getDeclaredField("mContext");
        localField.setAccessible(true);
        localField.set(paramContext, null);
        return;
      }
      catch (Exception paramContext)
      {
        Logger.b.e(new String[] { "RMonitor_memory_ActivityLeakSolution", paramContext.toString() });
      }
    }
  }
  
  public static void fixInputMethodManagerLeak(@Nullable Context paramContext)
  {
    if (!a) {
      return;
    }
    if (paramContext == null) {
      return;
    }
    Object localObject = null;
    try
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
      localObject = localInputMethodManager;
    }
    catch (Throwable localThrowable)
    {
      Logger.b.a("RMonitor_memory_ActivityLeakSolution", localThrowable);
    }
    if (localObject == null) {
      return;
    }
    a(paramContext, localObject);
  }
  
  public static void setSwitchLeakSolution(boolean paramBoolean)
  {
    a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.memory.leakdetect.ActivityLeakSolution
 * JD-Core Version:    0.7.0.1
 */