package com.tencent.secprotocol.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class ByteCodeCrashProtector
{
  private static final Object checkCrashTiemlsock = new Object();
  private static final Object cleanSplock = new Object();
  private String CRASH_PROTECTOR_SP;
  private Context mContext;
  private String mCrashKey;
  private boolean mNeedClearCrashTime;
  private SharedPreferences mSp;
  private long mTimeInterval;
  
  public ByteCodeCrashProtector(Context paramContext, SharedPreferences paramSharedPreferences, String paramString, long paramLong)
  {
    this.mContext = paramContext;
    this.mSp = paramSharedPreferences;
    this.mCrashKey = paramString;
    this.mTimeInterval = paramLong;
  }
  
  private boolean checkAndSetCrashTime()
  {
    bool2 = true;
    bool1 = true;
    for (;;)
    {
      try
      {
        localObject1 = this.mSp;
        this.mNeedClearCrashTime = true;
        long l3 = ((SharedPreferences)localObject1).getLong(this.mCrashKey, 0L);
        l1 = System.currentTimeMillis();
        long l2 = l1 - l3;
        if (l3 != 0L)
        {
          l3 = this.mTimeInterval;
          if ((l2 >= l3) || (l2 <= 0L)) {}
        }
      }
      catch (Exception localException1)
      {
        Object localObject1;
        long l1;
        bool1 = false;
        localException1.printStackTrace();
        continue;
      }
      finally {}
      try
      {
        this.mNeedClearCrashTime = false;
        return bool1;
      }
      catch (Exception localException2)
      {
        bool1 = bool2;
        continue;
      }
      localObject1 = ((SharedPreferences)localObject1).edit();
      ((SharedPreferences.Editor)localObject1).putLong(this.mCrashKey, l1);
      ((SharedPreferences.Editor)localObject1).commit();
      bool1 = false;
    }
  }
  
  /* Error */
  private void clearCrashTime()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 43	com/tencent/secprotocol/utils/ByteCodeCrashProtector:mNeedClearCrashTime	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 33	com/tencent/secprotocol/utils/ByteCodeCrashProtector:mSp	Landroid/content/SharedPreferences;
    //   18: invokeinterface 59 1 0
    //   23: astore_2
    //   24: aload_2
    //   25: aload_0
    //   26: getfield 35	com/tencent/secprotocol/utils/ByteCodeCrashProtector:mCrashKey	Ljava/lang/String;
    //   29: invokeinterface 76 2 0
    //   34: pop
    //   35: aload_2
    //   36: invokeinterface 79 1 0
    //   41: goto -30 -> 11
    //   44: astore_2
    //   45: aload_2
    //   46: invokevirtual 71	java/lang/Exception:printStackTrace	()V
    //   49: goto -38 -> 11
    //   52: astore_2
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_2
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	ByteCodeCrashProtector
    //   6	2	1	bool	boolean
    //   23	13	2	localEditor	SharedPreferences.Editor
    //   44	2	2	localException	Exception
    //   52	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	41	44	java/lang/Exception
    //   2	7	52	finally
    //   14	41	52	finally
    //   45	49	52	finally
  }
  
  public void runProtectedMethod(ByteCodeCrashProtector.IProtectedMethod paramIProtectedMethod)
  {
    if (paramIProtectedMethod != null)
    {
      if (checkAndSetCrashTime()) {
        break label22;
      }
      paramIProtectedMethod.run();
    }
    for (;;)
    {
      clearCrashTime();
      return;
      label22:
      paramIProtectedMethod.onCrashDetected();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.secprotocol.utils.ByteCodeCrashProtector
 * JD-Core Version:    0.7.0.1
 */