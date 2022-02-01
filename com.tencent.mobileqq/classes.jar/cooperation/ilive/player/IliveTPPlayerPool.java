package cooperation.ilive.player;

import android.content.Context;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.TPPlayerFactory;
import java.util.ArrayList;
import java.util.List;

public class IliveTPPlayerPool
{
  private static IliveTPPlayerPool a;
  private static final List<ITPPlayer> b = new ArrayList();
  private static final List<ITPPlayer> c = new ArrayList();
  
  public static IliveTPPlayerPool a()
  {
    try
    {
      if (a == null) {
        a = new IliveTPPlayerPool();
      }
      IliveTPPlayerPool localIliveTPPlayerPool = a;
      return localIliveTPPlayerPool;
    }
    finally {}
  }
  
  private ITPPlayer b(Context arg1, Looper paramLooper1, Looper paramLooper2)
  {
    paramLooper1 = TPPlayerFactory.createTPPlayer(???, paramLooper1, paramLooper2);
    synchronized (c)
    {
      c.add(paramLooper1);
      return paramLooper1;
    }
  }
  
  public ITPPlayer a(Context paramContext, Looper paramLooper1, Looper paramLooper2)
  {
    for (;;)
    {
      synchronized (b)
      {
        if (b.size() > 0)
        {
          localITPPlayer = (ITPPlayer)b.remove(0);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("reuse  player ");
          localStringBuilder.append(localITPPlayer);
          QLog.d("IliveTPPlayerPool", 1, localStringBuilder.toString());
          ??? = localITPPlayer;
          if (localITPPlayer == null)
          {
            QLog.d("IliveTPPlayerPool", 1, "create new player");
            ??? = b(paramContext, paramLooper1, paramLooper2);
          }
          return ???;
        }
      }
      ITPPlayer localITPPlayer = null;
    }
  }
  
  public void a(ITPPlayer paramITPPlayer)
  {
    synchronized (b)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recyclePlayer:");
      localStringBuilder.append(paramITPPlayer);
      QLog.d("IliveTPPlayerPool", 1, localStringBuilder.toString());
      b.add(paramITPPlayer);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.player.IliveTPPlayerPool
 * JD-Core Version:    0.7.0.1
 */