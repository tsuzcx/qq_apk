package com.tencent.mobileqq.lunarplugin.ams_hook;

import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import java.lang.reflect.Field;

public class ActivityThreadHandlerCallback
  implements Handler.Callback
{
  Handler a;
  
  private void a(Message paramMessage)
  {
    paramMessage = paramMessage.obj;
    try
    {
      Field localField = paramMessage.getClass().getDeclaredField("intent");
      localField.setAccessible(true);
      paramMessage = (Intent)localField.get(paramMessage);
      paramMessage.setComponent(((Intent)paramMessage.getParcelableExtra("extra_target_intent")).getComponent());
      return;
    }
    catch (NoSuchFieldException paramMessage)
    {
      paramMessage.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramMessage)
    {
      paramMessage.printStackTrace();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      this.a.handleMessage(paramMessage);
      return true;
      a(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.lunarplugin.ams_hook.ActivityThreadHandlerCallback
 * JD-Core Version:    0.7.0.1
 */