package oicq.wlogin_sdk.report;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import oicq.wlogin_sdk.listener.ReportListener;
import oicq.wlogin_sdk.report.event.EventSaver;
import oicq.wlogin_sdk.request.t;
import oicq.wlogin_sdk.tools.util;

public class c
  implements Handler.Callback
{
  public ReportListener a = null;
  public final EventSaver b = new EventSaver();
  private HandlerThread c = new HandlerThread("CostTracer");
  private Handler d;
  
  private c()
  {
    try
    {
      this.c.start();
      if (this.c.isAlive()) {
        this.d = new Handler(this.c.getLooper(), this);
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void a()
  {
    if (c.a.a.d != null) {
      c.a.a.d.sendEmptyMessage(2);
    }
  }
  
  public static void a(Thread paramThread)
  {
    if (c.a.a.d != null)
    {
      Message localMessage = c.a.a.d.obtainMessage();
      localMessage.what = 1;
      localMessage.obj = paramThread;
      c.a.a.d.sendMessageDelayed(localMessage, 1000L);
    }
  }
  
  public static void a(ReportListener paramReportListener)
  {
    c.a.a.a = paramReportListener;
  }
  
  public static void a(oicq.wlogin_sdk.report.event.a parama)
  {
    if (c.a.a.d != null)
    {
      Message localMessage = c.a.a.d.obtainMessage();
      localMessage.what = 3;
      localMessage.obj = parama;
      c.a.a.d.sendMessage(localMessage);
    }
  }
  
  public static void b(Thread paramThread)
  {
    if (c.a.a.d != null) {
      c.a.a.d.removeMessages(1, paramThread);
    }
  }
  
  public static void b(oicq.wlogin_sdk.report.event.a parama)
  {
    if (c.a.a.d != null)
    {
      Message localMessage = c.a.a.d.obtainMessage();
      localMessage.what = 4;
      localMessage.obj = parama;
      c.a.a.d.sendMessage(localMessage);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    Object localObject1;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return true;
          }
          paramMessage = (oicq.wlogin_sdk.report.event.a)paramMessage.obj;
          if (paramMessage != null) {
            try
            {
              this.b.realSaveItem(t.u, paramMessage.a(), paramMessage.d());
              return true;
            }
            catch (Exception paramMessage)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(util.LOG_TAG_EVENT_REPORT);
              ((StringBuilder)localObject1).append(Log.getStackTraceString(paramMessage));
              util.LOGI(((StringBuilder)localObject1).toString(), "");
              return true;
            }
          }
          paramMessage = new StringBuilder();
          paramMessage.append(util.LOG_TAG_EVENT_REPORT);
          paramMessage.append("saveEvent error ,saveEvent = null");
          util.LOGI(paramMessage.toString(), "");
          return true;
        }
        paramMessage = (oicq.wlogin_sdk.report.event.a)paramMessage.obj;
        localObject1 = this.a;
        if ((localObject1 != null) && (paramMessage != null))
        {
          ((ReportListener)localObject1).onReport(paramMessage.a(), paramMessage.c(), paramMessage.e(), paramMessage.f());
          return true;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(util.LOG_TAG_EVENT_REPORT);
        ((StringBuilder)localObject1).append(" reportEvent error ,event = ");
        ((StringBuilder)localObject1).append(paramMessage);
        ((StringBuilder)localObject1).append(",reportListener");
        ((StringBuilder)localObject1).append(this.a);
        util.LOGI(((StringBuilder)localObject1).toString(), "");
        return true;
      }
      if (t.u != null)
      {
        a.a().a(t.u);
        return true;
      }
    }
    else
    {
      paramMessage = (Thread)paramMessage.obj;
      localObject1 = Thread.getAllStackTraces().entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        Object localObject3 = (Thread)((Map.Entry)localObject2).getKey();
        localObject2 = (StackTraceElement[])((Map.Entry)localObject2).getValue();
        if (localObject3 == paramMessage)
        {
          localObject3 = new StringBuilder("    ");
          i = 0;
          while (i < localObject2.length)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(localObject2[i].getClassName());
            localStringBuilder.append(".");
            ((StringBuilder)localObject3).append(localStringBuilder.toString());
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(localObject2[i].getMethodName());
            localStringBuilder.append("(");
            ((StringBuilder)localObject3).append(localStringBuilder.toString());
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(localObject2[i].getFileName());
            localStringBuilder.append(":");
            ((StringBuilder)localObject3).append(localStringBuilder.toString());
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(localObject2[i].getLineNumber());
            localStringBuilder.append(")");
            ((StringBuilder)localObject3).append(localStringBuilder.toString());
            ((StringBuilder)localObject3).append("\n");
            i += 1;
          }
          a.a().a(((StringBuilder)localObject3).toString());
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.report.c
 * JD-Core Version:    0.7.0.1
 */