package com.tencent.qqperf.monitor.memory;

import android.app.Dialog;
import android.os.Message;
import java.lang.reflect.Field;

public class ActivityLeakSolution
{
  public static void a(Dialog paramDialog)
  {
    if (paramDialog == null) {
      return;
    }
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "mDismissMessage";
    arrayOfString[1] = "mCancelMessage";
    arrayOfString[2] = "mShowMessage";
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfString[i];
      try
      {
        localObject = Dialog.class.getDeclaredField((String)localObject);
        if (localObject != null)
        {
          if (!((Field)localObject).isAccessible()) {
            ((Field)localObject).setAccessible(true);
          }
          localObject = ((Field)localObject).get(paramDialog);
          if ((localObject instanceof Message))
          {
            localObject = (Message)localObject;
            if (((Message)localObject).obj != null)
            {
              ((Message)localObject).obj = null;
              ((Message)localObject).what = 0;
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localNoSuchFieldException.printStackTrace();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.memory.ActivityLeakSolution
 * JD-Core Version:    0.7.0.1
 */