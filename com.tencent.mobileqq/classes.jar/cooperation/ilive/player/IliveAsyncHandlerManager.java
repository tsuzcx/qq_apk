package cooperation.ilive.player;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class IliveAsyncHandlerManager
{
  private static IliveAsyncHandlerManager a;
  private static final List<IlivePlayerHandlerWrapper> b = new ArrayList();
  
  public static IliveAsyncHandlerManager a()
  {
    try
    {
      if (a == null)
      {
        a = new IliveAsyncHandlerManager();
        b();
      }
      IliveAsyncHandlerManager localIliveAsyncHandlerManager = a;
      return localIliveAsyncHandlerManager;
    }
    finally {}
  }
  
  private static void b()
  {
    synchronized (b)
    {
      if (b.size() < 4)
      {
        int i = b.size();
        while (i < 4)
        {
          b.add(new IlivePlayerHandlerWrapper(i));
          i += 1;
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public IlivePlayerHandlerWrapper a(int paramInt)
  {
    for (;;)
    {
      synchronized (b)
      {
        if (b.size() > 0)
        {
          IlivePlayerHandlerWrapper localIlivePlayerHandlerWrapper = (IlivePlayerHandlerWrapper)b.remove(0);
          localIlivePlayerHandlerWrapper.a(String.valueOf(paramInt));
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getHandler ");
          localStringBuilder.append(paramInt);
          QLog.d("IliveAsyncHandlerManager", 1, localStringBuilder.toString());
          ??? = localIlivePlayerHandlerWrapper;
          if (localIlivePlayerHandlerWrapper == null)
          {
            QLog.d("IliveAsyncHandlerManager", 1, "new handler");
            ??? = new IlivePlayerHandlerWrapper(paramInt);
          }
          return ???;
        }
      }
      Object localObject2 = null;
    }
  }
  
  public void a(IlivePlayerHandlerWrapper paramIlivePlayerHandlerWrapper)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("recycleHandler asyncHandler =");
    ((StringBuilder)???).append(paramIlivePlayerHandlerWrapper);
    QLog.d("IliveAsyncHandlerManager", 1, ((StringBuilder)???).toString());
    synchronized (b)
    {
      b.add(paramIlivePlayerHandlerWrapper);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.player.IliveAsyncHandlerManager
 * JD-Core Version:    0.7.0.1
 */