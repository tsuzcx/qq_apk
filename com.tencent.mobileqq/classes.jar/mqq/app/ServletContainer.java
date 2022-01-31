package mqq.app;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Looper;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import mqq.util.MqqConnRateReport;
import mqq.util.MqqConnRateReport.EventType;

public class ServletContainer
{
  private final ConcurrentHashMap<String, Set<String>> actionMap = new ConcurrentHashMap();
  private AppRuntime app;
  private ExecutorService mService = Executors.newSingleThreadExecutor();
  final ConcurrentHashMap<String, Servlet> managedServlet = new ConcurrentHashMap();
  
  public ServletContainer(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
  }
  
  public void destroy()
  {
    this.mService.shutdown();
    Iterator localIterator = this.managedServlet.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((Servlet)((Map.Entry)localIterator.next()).getValue()).onDestroy();
    }
    this.managedServlet.clear();
  }
  
  public void forward(AppRuntime paramAppRuntime, final Intent paramIntent)
  {
    if (!this.mService.isShutdown())
    {
      paramAppRuntime = new Runnable()
      {
        public void run()
        {
          try
          {
            Servlet localServlet = ServletContainer.this.getServlet(this.val$className);
            if (localServlet != null) {
              localServlet.service(paramIntent);
            }
            return;
          }
          catch (Exception localException)
          {
            QLog.e("mqq", 1, "", localException);
          }
        }
      };
      boolean bool = false;
      if ((paramIntent instanceof NewIntent)) {
        bool = ((NewIntent)paramIntent).runNow;
      }
      if ((bool) || (Thread.currentThread() != Looper.getMainLooper().getThread()))
      {
        paramAppRuntime.run();
        return;
      }
      this.mService.execute(paramAppRuntime);
      return;
    }
    QLog.e("mqq", 1, "ServletContainer has destoryed," + paramIntent.getComponent().getClassName() + " can not be started.");
  }
  
  Servlet getServlet(String paramString)
  {
    Servlet localServlet = (Servlet)this.managedServlet.get(paramString);
    Object localObject = localServlet;
    Class localClass;
    if (localServlet == null) {
      synchronized (this.managedServlet)
      {
        localServlet = (Servlet)this.managedServlet.get(paramString);
        localObject = localServlet;
        if (localServlet == null) {
          try
          {
            localObject = Class.forName(paramString);
          }
          catch (Throwable localThrowable)
          {
            try
            {
              for (;;)
              {
                localServlet = (Servlet)((Class)localObject).newInstance();
                localServlet.init(this.app, this);
                localServlet.onCreate();
                this.managedServlet.put(paramString, localServlet);
                QLog.d("mqq", 1, "newServlet = " + localServlet);
                localObject = localServlet;
                if (!(localServlet instanceof MSFServlet)) {
                  break;
                }
                String[] arrayOfString = ((MSFServlet)localServlet).getPreferSSOCommands();
                localObject = localServlet;
                if (arrayOfString == null) {
                  break;
                }
                int j = arrayOfString.length;
                int i = 0;
                for (;;)
                {
                  localObject = localServlet;
                  if (i >= j) {
                    break;
                  }
                  String str = arrayOfString[i];
                  Set localSet = (Set)this.actionMap.get(str);
                  localObject = localSet;
                  if (localSet == null)
                  {
                    localObject = new HashSet();
                    this.actionMap.put(str, localObject);
                  }
                  ((Set)localObject).add(paramString);
                  i += 1;
                }
                localThrowable = localThrowable;
                localClass = this.app.getClass().getClassLoader().loadClass(paramString);
              }
            }
            catch (Throwable paramString)
            {
              paramString.printStackTrace();
              return null;
            }
          }
        }
      }
    }
    return localClass;
  }
  
  public void notifyMSFServlet(Class<? extends MSFServlet> paramClass, FromServiceMsg paramFromServiceMsg)
  {
    Class<? extends MSFServlet> localClass = null;
    if (paramClass != null)
    {
      paramClass = (MSFServlet)getServlet(paramClass.getName());
      localClass = paramClass;
      if (paramClass != null)
      {
        paramClass.onReceive(paramFromServiceMsg);
        localClass = paramClass;
      }
    }
    paramClass = (Set)this.actionMap.get(paramFromServiceMsg.getServiceCmd());
    if (paramClass != null)
    {
      paramClass = paramClass.iterator();
      while (paramClass.hasNext())
      {
        MSFServlet localMSFServlet = (MSFServlet)getServlet((String)paramClass.next());
        if ((localMSFServlet != null) && (localMSFServlet != localClass)) {
          localMSFServlet.onReceive(paramFromServiceMsg);
        } else if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getServiceCmd() != null) && (paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c"))) {
          MqqConnRateReport.getInstance().doReport(MqqConnRateReport.EventType.eMSFRecvInviteMsg, paramFromServiceMsg.getWupBuffer(), 20);
        }
      }
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getServiceCmd() != null) && (paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c"))) {
      MqqConnRateReport.getInstance().doReport(MqqConnRateReport.EventType.eMSFRecvInviteMsg, paramFromServiceMsg.getWupBuffer(), 19);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.ServletContainer
 * JD-Core Version:    0.7.0.1
 */