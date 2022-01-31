package com.tencent.mobileqq.triton.game;

import android.content.Context;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.sdk.game.GameLifecycle;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LifecycleManager
  implements GameLifecycle
{
  private static final String TAG = "LifecycleManager";
  private List<GameLifecycle> lifeCycles = new ArrayList();
  private ReadWriteLock mLock = new ReentrantReadWriteLock();
  
  private void clearGameLifeCycle()
  {
    try
    {
      this.mLock.writeLock().lock();
      this.lifeCycles.clear();
      return;
    }
    catch (Exception localException)
    {
      TTLog.e("LifecycleManager", "clearGameLifeCucle error:" + localException.getMessage());
      return;
    }
    finally
    {
      this.mLock.writeLock().unlock();
    }
  }
  
  /* Error */
  private void notifyOnCreate(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	com/tencent/mobileqq/triton/game/LifecycleManager:mLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   4: invokeinterface 79 1 0
    //   9: invokeinterface 44 1 0
    //   14: aload_0
    //   15: getfield 24	com/tencent/mobileqq/triton/game/LifecycleManager:lifeCycles	Ljava/util/List;
    //   18: invokeinterface 83 1 0
    //   23: astore_2
    //   24: aload_2
    //   25: invokeinterface 89 1 0
    //   30: ifeq +65 -> 95
    //   33: aload_2
    //   34: invokeinterface 93 1 0
    //   39: checkcast 6	com/tencent/mobileqq/triton/sdk/game/GameLifecycle
    //   42: aload_1
    //   43: invokeinterface 96 2 0
    //   48: goto -24 -> 24
    //   51: astore_1
    //   52: ldc 10
    //   54: new 54	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   61: ldc 98
    //   63: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_1
    //   67: invokevirtual 65	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   70: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 74	com/tencent/mobileqq/triton/engine/TTLog:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   79: pop
    //   80: aload_0
    //   81: getfield 29	com/tencent/mobileqq/triton/game/LifecycleManager:mLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   84: invokeinterface 79 1 0
    //   89: invokeinterface 52 1 0
    //   94: return
    //   95: aload_0
    //   96: getfield 29	com/tencent/mobileqq/triton/game/LifecycleManager:mLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   99: invokeinterface 79 1 0
    //   104: invokeinterface 52 1 0
    //   109: return
    //   110: astore_1
    //   111: aload_0
    //   112: getfield 29	com/tencent/mobileqq/triton/game/LifecycleManager:mLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   115: invokeinterface 79 1 0
    //   120: invokeinterface 52 1 0
    //   125: aload_1
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	LifecycleManager
    //   0	127	1	paramContext	Context
    //   23	11	2	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   0	24	51	java/lang/Exception
    //   24	48	51	java/lang/Exception
    //   0	24	110	finally
    //   24	48	110	finally
    //   52	80	110	finally
  }
  
  /* Error */
  private void notifyOnDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	com/tencent/mobileqq/triton/game/LifecycleManager:mLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   4: invokeinterface 79 1 0
    //   9: invokeinterface 44 1 0
    //   14: aload_0
    //   15: getfield 24	com/tencent/mobileqq/triton/game/LifecycleManager:lifeCycles	Ljava/util/List;
    //   18: invokeinterface 83 1 0
    //   23: astore_1
    //   24: aload_1
    //   25: invokeinterface 89 1 0
    //   30: ifeq +64 -> 94
    //   33: aload_1
    //   34: invokeinterface 93 1 0
    //   39: checkcast 6	com/tencent/mobileqq/triton/sdk/game/GameLifecycle
    //   42: invokeinterface 102 1 0
    //   47: goto -23 -> 24
    //   50: astore_1
    //   51: ldc 10
    //   53: new 54	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   60: ldc 104
    //   62: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_1
    //   66: invokevirtual 65	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   69: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 74	com/tencent/mobileqq/triton/engine/TTLog:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   78: pop
    //   79: aload_0
    //   80: getfield 29	com/tencent/mobileqq/triton/game/LifecycleManager:mLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   83: invokeinterface 79 1 0
    //   88: invokeinterface 52 1 0
    //   93: return
    //   94: aload_0
    //   95: getfield 29	com/tencent/mobileqq/triton/game/LifecycleManager:mLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   98: invokeinterface 79 1 0
    //   103: invokeinterface 52 1 0
    //   108: return
    //   109: astore_1
    //   110: aload_0
    //   111: getfield 29	com/tencent/mobileqq/triton/game/LifecycleManager:mLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   114: invokeinterface 79 1 0
    //   119: invokeinterface 52 1 0
    //   124: aload_1
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	LifecycleManager
    //   23	11	1	localIterator	java.util.Iterator
    //   50	16	1	localException	Exception
    //   109	16	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	24	50	java/lang/Exception
    //   24	47	50	java/lang/Exception
    //   0	24	109	finally
    //   24	47	109	finally
    //   51	79	109	finally
  }
  
  /* Error */
  private void notifyOnLaunched()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	com/tencent/mobileqq/triton/game/LifecycleManager:mLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   4: invokeinterface 79 1 0
    //   9: invokeinterface 44 1 0
    //   14: aload_0
    //   15: getfield 24	com/tencent/mobileqq/triton/game/LifecycleManager:lifeCycles	Ljava/util/List;
    //   18: invokeinterface 83 1 0
    //   23: astore_1
    //   24: aload_1
    //   25: invokeinterface 89 1 0
    //   30: ifeq +64 -> 94
    //   33: aload_1
    //   34: invokeinterface 93 1 0
    //   39: checkcast 6	com/tencent/mobileqq/triton/sdk/game/GameLifecycle
    //   42: invokeinterface 108 1 0
    //   47: goto -23 -> 24
    //   50: astore_1
    //   51: ldc 10
    //   53: new 54	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   60: ldc 110
    //   62: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_1
    //   66: invokevirtual 65	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   69: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 74	com/tencent/mobileqq/triton/engine/TTLog:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   78: pop
    //   79: aload_0
    //   80: getfield 29	com/tencent/mobileqq/triton/game/LifecycleManager:mLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   83: invokeinterface 79 1 0
    //   88: invokeinterface 52 1 0
    //   93: return
    //   94: aload_0
    //   95: getfield 29	com/tencent/mobileqq/triton/game/LifecycleManager:mLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   98: invokeinterface 79 1 0
    //   103: invokeinterface 52 1 0
    //   108: return
    //   109: astore_1
    //   110: aload_0
    //   111: getfield 29	com/tencent/mobileqq/triton/game/LifecycleManager:mLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   114: invokeinterface 79 1 0
    //   119: invokeinterface 52 1 0
    //   124: aload_1
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	LifecycleManager
    //   23	11	1	localIterator	java.util.Iterator
    //   50	16	1	localException	Exception
    //   109	16	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	24	50	java/lang/Exception
    //   24	47	50	java/lang/Exception
    //   0	24	109	finally
    //   24	47	109	finally
    //   51	79	109	finally
  }
  
  /* Error */
  private void notifyOnPause()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	com/tencent/mobileqq/triton/game/LifecycleManager:mLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   4: invokeinterface 79 1 0
    //   9: invokeinterface 44 1 0
    //   14: aload_0
    //   15: getfield 24	com/tencent/mobileqq/triton/game/LifecycleManager:lifeCycles	Ljava/util/List;
    //   18: invokeinterface 83 1 0
    //   23: astore_1
    //   24: aload_1
    //   25: invokeinterface 89 1 0
    //   30: ifeq +64 -> 94
    //   33: aload_1
    //   34: invokeinterface 93 1 0
    //   39: checkcast 6	com/tencent/mobileqq/triton/sdk/game/GameLifecycle
    //   42: invokeinterface 114 1 0
    //   47: goto -23 -> 24
    //   50: astore_1
    //   51: ldc 10
    //   53: new 54	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   60: ldc 116
    //   62: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_1
    //   66: invokevirtual 65	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   69: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 74	com/tencent/mobileqq/triton/engine/TTLog:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   78: pop
    //   79: aload_0
    //   80: getfield 29	com/tencent/mobileqq/triton/game/LifecycleManager:mLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   83: invokeinterface 79 1 0
    //   88: invokeinterface 52 1 0
    //   93: return
    //   94: aload_0
    //   95: getfield 29	com/tencent/mobileqq/triton/game/LifecycleManager:mLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   98: invokeinterface 79 1 0
    //   103: invokeinterface 52 1 0
    //   108: return
    //   109: astore_1
    //   110: aload_0
    //   111: getfield 29	com/tencent/mobileqq/triton/game/LifecycleManager:mLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   114: invokeinterface 79 1 0
    //   119: invokeinterface 52 1 0
    //   124: aload_1
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	LifecycleManager
    //   23	11	1	localIterator	java.util.Iterator
    //   50	16	1	localException	Exception
    //   109	16	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	24	50	java/lang/Exception
    //   24	47	50	java/lang/Exception
    //   0	24	109	finally
    //   24	47	109	finally
    //   51	79	109	finally
  }
  
  /* Error */
  private void notifyOnResume()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	com/tencent/mobileqq/triton/game/LifecycleManager:mLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   4: invokeinterface 79 1 0
    //   9: invokeinterface 44 1 0
    //   14: aload_0
    //   15: getfield 24	com/tencent/mobileqq/triton/game/LifecycleManager:lifeCycles	Ljava/util/List;
    //   18: invokeinterface 83 1 0
    //   23: astore_1
    //   24: aload_1
    //   25: invokeinterface 89 1 0
    //   30: ifeq +64 -> 94
    //   33: aload_1
    //   34: invokeinterface 93 1 0
    //   39: checkcast 6	com/tencent/mobileqq/triton/sdk/game/GameLifecycle
    //   42: invokeinterface 120 1 0
    //   47: goto -23 -> 24
    //   50: astore_1
    //   51: ldc 10
    //   53: new 54	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   60: ldc 122
    //   62: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_1
    //   66: invokevirtual 65	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   69: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 74	com/tencent/mobileqq/triton/engine/TTLog:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   78: pop
    //   79: aload_0
    //   80: getfield 29	com/tencent/mobileqq/triton/game/LifecycleManager:mLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   83: invokeinterface 79 1 0
    //   88: invokeinterface 52 1 0
    //   93: return
    //   94: aload_0
    //   95: getfield 29	com/tencent/mobileqq/triton/game/LifecycleManager:mLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   98: invokeinterface 79 1 0
    //   103: invokeinterface 52 1 0
    //   108: return
    //   109: astore_1
    //   110: aload_0
    //   111: getfield 29	com/tencent/mobileqq/triton/game/LifecycleManager:mLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   114: invokeinterface 79 1 0
    //   119: invokeinterface 52 1 0
    //   124: aload_1
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	LifecycleManager
    //   23	11	1	localIterator	java.util.Iterator
    //   50	16	1	localException	Exception
    //   109	16	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	24	50	java/lang/Exception
    //   24	47	50	java/lang/Exception
    //   0	24	109	finally
    //   24	47	109	finally
    //   51	79	109	finally
  }
  
  public void addGameLifeCycle(GameLifecycle paramGameLifecycle)
  {
    try
    {
      this.mLock.writeLock().lock();
      this.lifeCycles.add(paramGameLifecycle);
      return;
    }
    catch (Exception paramGameLifecycle)
    {
      TTLog.e("LifecycleManager", "addGameLifeCycle error:" + paramGameLifecycle.getMessage());
      return;
    }
    finally
    {
      this.mLock.writeLock().unlock();
    }
  }
  
  public void onCreate(Context paramContext)
  {
    notifyOnCreate(paramContext);
  }
  
  public void onDestroy()
  {
    notifyOnDestroy();
    clearGameLifeCycle();
  }
  
  public void onGameLaunched()
  {
    notifyOnLaunched();
  }
  
  public void onPause()
  {
    notifyOnPause();
  }
  
  public void onResume()
  {
    notifyOnResume();
  }
  
  public void removeGameLifeCycle(GameLifecycle paramGameLifecycle)
  {
    try
    {
      this.mLock.writeLock().lock();
      this.lifeCycles.remove(paramGameLifecycle);
      return;
    }
    catch (Exception paramGameLifecycle)
    {
      TTLog.e("LifecycleManager", "removeGameLifeCycle error:" + paramGameLifecycle.getMessage());
      return;
    }
    finally
    {
      this.mLock.writeLock().unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.game.LifecycleManager
 * JD-Core Version:    0.7.0.1
 */