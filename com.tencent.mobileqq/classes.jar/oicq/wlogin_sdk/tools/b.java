package oicq.wlogin_sdk.tools;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;

public class b
  implements Handler.Callback
{
  private static b a = null;
  private static final Object c = new Object();
  private static StringBuilder d = new StringBuilder();
  private static StringBuilder e = new StringBuilder();
  private volatile boolean b = false;
  private Context f;
  private HandlerThread g;
  private Handler h;
  
  private b(Context paramContext)
  {
    this.f = paramContext;
    this.g = new HandlerThread("FileTracer");
    try
    {
      this.g.start();
      if (this.g.isAlive()) {
        this.h = new Handler(this.g.getLooper(), this);
      }
      this.h.sendEmptyMessage(1024);
      return;
    }
    catch (Error paramContext) {}
  }
  
  private void a()
  {
    try
    {
      this.h.sendEmptyMessageDelayed(1024, 2000L);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void a(Context arg0, String paramString1, String paramString2)
  {
    if ((??? == null) || (paramString2 == null)) {
      return;
    }
    if (a == null) {
      a = new b(???);
    }
    synchronized (c)
    {
      if (e.length() > 40960)
      {
        e.delete(0, e.length() / 2);
        e.append("log has been cut len ").append(e.length()).append("\n");
      }
    }
    try
    {
      e.append(util.getDate()).append(util.getCurrentPid()).append(util.getThreadId()).append(util.getLineInfo(3)).append(util.getUser(paramString1)).append(paramString2).append("\n");
      return;
      paramString1 = finally;
      throw paramString1;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        e = new StringBuilder();
      }
    }
  }
  
  private void b()
  {
    if (Thread.currentThread() != this.g) {}
    while (this.b) {
      return;
    }
    this.b = true;
    c();
    this.b = false;
  }
  
  private void c()
  {
    try
    {
      if ((e != null) && (e.length() != 0))
      {
        d = e;
        e = new StringBuilder();
        byte[] arrayOfByte1 = util.compress(d.toString().getBytes());
        if (arrayOfByte1 != null)
        {
          if (arrayOfByte1.length == 0) {
            return;
          }
          byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 4];
          util.int32_to_buf(arrayOfByte2, 0, arrayOfByte1.length);
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 4, arrayOfByte1.length);
          util.writeFile(util.getLogFileName(this.f, util.getCurrentDay()), arrayOfByte2);
          return;
        }
      }
    }
    catch (Error localError) {}
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      b();
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.b
 * JD-Core Version:    0.7.0.1
 */