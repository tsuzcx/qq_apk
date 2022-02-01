package oicq.wlogin_sdk.report;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import oicq.wlogin_sdk.request.t;

public class c
  implements Handler.Callback
{
  private HandlerThread a = new HandlerThread("CostTracer");
  private Handler b;
  
  private c()
  {
    try
    {
      this.a.start();
      if (this.a.isAlive()) {
        this.b = new Handler(this.a.getLooper(), this);
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void a()
  {
    if (c.a.a.b != null) {
      c.a.a.b.sendEmptyMessage(2);
    }
  }
  
  public static void a(Thread paramThread)
  {
    if (c.a.a.b != null)
    {
      Message localMessage = c.a.a.b.obtainMessage();
      localMessage.what = 1;
      localMessage.obj = paramThread;
      c.a.a.b.sendMessageDelayed(localMessage, 1000L);
    }
  }
  
  public static void b(Thread paramThread)
  {
    if (c.a.a.b != null) {
      c.a.a.b.removeMessages(1, paramThread);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      paramMessage = (Thread)paramMessage.obj;
      Iterator localIterator = Thread.getAllStackTraces().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        Object localObject1 = (Thread)((Map.Entry)localObject2).getKey();
        localObject2 = (StackTraceElement[])((Map.Entry)localObject2).getValue();
        if (localObject1 == paramMessage)
        {
          localObject1 = new StringBuilder("    ");
          int i = 0;
          while (i < localObject2.length)
          {
            ((StringBuilder)localObject1).append(localObject2[i].getClassName() + ".").append(localObject2[i].getMethodName() + "(").append(localObject2[i].getFileName() + ":").append(localObject2[i].getLineNumber() + ")").append("\n");
            i += 1;
          }
          a.a().a(((StringBuilder)localObject1).toString());
        }
      }
      if (t.u != null) {
        a.a().a(t.u);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.report.c
 * JD-Core Version:    0.7.0.1
 */