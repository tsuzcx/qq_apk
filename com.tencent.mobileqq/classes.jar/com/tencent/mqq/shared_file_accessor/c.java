package com.tencent.mqq.shared_file_accessor;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class c
  extends Handler
{
  public c(a parama, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    paramMessage = LogUtil.timeLogBegin();
    List localList;
    if (this.a.b) {
      synchronized (this.a)
      {
        localList = a.a(this.a);
        a.a(this.a, a.b(this.a));
        a.a(this.a, a.c(this.a));
        a.b(this.a, false);
        this.a.a = true;
        a.a(this.a, new ArrayList());
        a.b(this.a, new HashMap());
      }
    }
    try
    {
      this.a.a(localList);
      for (;;)
      {
        label141:
        synchronized (this.a)
        {
          a.a(this.a, false);
          this.a.a = false;
          a.d(this.a).clear();
          a.a(this.a, null);
          this.a.notifyAll();
          LogUtil.timeLogEnd(SharedPreferencesProxyManager.getInstance().a(), null, this.a.c, null, null, "save-file", d.c, true, paramMessage);
          LogUtil.timeLogEnd("save file " + this.a.c, paramMessage);
          return;
          paramMessage = finally;
          throw paramMessage;
        }
        try
        {
          this.a.a(null);
        }
        catch (Throwable localThrowable1) {}
      }
    }
    catch (Throwable localThrowable2)
    {
      break label141;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.c
 * JD-Core Version:    0.7.0.1
 */