package cooperation.ilive.lite.event;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class IliveLiteEventCenter
{
  private static final Object a = new Object();
  private static IliveLiteEventCenter b;
  private List<IliveLiteEventCenter.Observer> c = new Vector();
  
  public static IliveLiteEventCenter a()
  {
    if (b == null) {
      synchronized (a)
      {
        if (b == null) {
          b = new IliveLiteEventCenter();
        }
      }
    }
    return b;
  }
  
  public void a(IliveLiteEventCenter.Observer paramObserver)
  {
    synchronized (this.c)
    {
      if (!this.c.contains(paramObserver)) {
        this.c.add(paramObserver);
      }
      return;
    }
  }
  
  public boolean a(String paramString, Bundle paramBundle)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    try
    {
      Iterator localIterator = this.c.iterator();
      boolean bool3;
      for (;;)
      {
        bool2 = bool1;
        bool3 = bool1;
        if (!localIterator.hasNext()) {
          break;
        }
        bool2 = bool1;
        IliveLiteEventCenter.Observer localObserver = (IliveLiteEventCenter.Observer)localIterator.next();
        if (localObserver != null)
        {
          bool2 = bool1;
          bool3 = localObserver.onCall(paramString, paramBundle);
          if (bool3) {
            bool1 = true;
          }
        }
      }
      return bool3;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      QLog.e("IliveLiteEventCenter", 1, "call error", paramString);
      bool3 = bool2;
    }
  }
  
  public void b(IliveLiteEventCenter.Observer paramObserver)
  {
    synchronized (this.c)
    {
      this.c.remove(paramObserver);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.event.IliveLiteEventCenter
 * JD-Core Version:    0.7.0.1
 */