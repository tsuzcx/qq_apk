package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

public class TbsPVConfig
  extends TbsBaseConfig
{
  private static TbsPVConfig b;
  public SharedPreferences mPreferences;
  
  public static TbsPVConfig getInstance(Context paramContext)
  {
    try
    {
      if (b == null)
      {
        b = new TbsPVConfig();
        b.init(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  public static void releaseInstance()
  {
    try
    {
      b = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getConfigFileName()
  {
    return "tbs_pv_config";
  }
  
  /* Error */
  public int getDisabledCoreVersion()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_2
    //   4: aload_0
    //   5: getfield 35	com/tencent/smtt/sdk/TbsPVConfig:a	Ljava/util/Map;
    //   8: ldc 37
    //   10: invokeinterface 43 2 0
    //   15: checkcast 45	java/lang/String
    //   18: astore_3
    //   19: iload_2
    //   20: istore_1
    //   21: aload_3
    //   22: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   25: ifne +22 -> 47
    //   28: aload_3
    //   29: invokestatic 57	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   32: istore_1
    //   33: goto +14 -> 47
    //   36: astore_3
    //   37: goto +14 -> 51
    //   40: astore_3
    //   41: aload_3
    //   42: invokevirtual 60	java/lang/Exception:printStackTrace	()V
    //   45: iload_2
    //   46: istore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: iload_1
    //   50: ireturn
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_3
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	TbsPVConfig
    //   20	30	1	i	int
    //   3	43	2	j	int
    //   18	11	3	str	String
    //   36	1	3	localObject	Object
    //   40	14	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   4	19	36	finally
    //   21	33	36	finally
    //   41	45	36	finally
    //   4	19	40	java/lang/Exception
    //   21	33	40	java/lang/Exception
  }
  
  /* Error */
  public int getEmergentCoreVersion()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_2
    //   4: aload_0
    //   5: getfield 35	com/tencent/smtt/sdk/TbsPVConfig:a	Ljava/util/Map;
    //   8: ldc 63
    //   10: invokeinterface 43 2 0
    //   15: checkcast 45	java/lang/String
    //   18: astore_3
    //   19: iload_2
    //   20: istore_1
    //   21: aload_3
    //   22: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   25: ifne +22 -> 47
    //   28: aload_3
    //   29: invokestatic 57	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   32: istore_1
    //   33: goto +14 -> 47
    //   36: astore_3
    //   37: goto +14 -> 51
    //   40: astore_3
    //   41: aload_3
    //   42: invokevirtual 60	java/lang/Exception:printStackTrace	()V
    //   45: iload_2
    //   46: istore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: iload_1
    //   50: ireturn
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_3
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	TbsPVConfig
    //   20	30	1	i	int
    //   3	43	2	j	int
    //   18	11	3	str	String
    //   36	1	3	localObject	Object
    //   40	14	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   4	19	36	finally
    //   21	33	36	finally
    //   41	45	36	finally
    //   4	19	40	java/lang/Exception
    //   21	33	40	java/lang/Exception
  }
  
  /* Error */
  public int getLocalCoreVersionMoreTimes()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_2
    //   4: aload_0
    //   5: getfield 35	com/tencent/smtt/sdk/TbsPVConfig:a	Ljava/util/Map;
    //   8: ldc 66
    //   10: invokeinterface 43 2 0
    //   15: checkcast 45	java/lang/String
    //   18: astore_3
    //   19: iload_2
    //   20: istore_1
    //   21: aload_3
    //   22: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   25: ifne +22 -> 47
    //   28: aload_3
    //   29: invokestatic 57	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   32: istore_1
    //   33: goto +14 -> 47
    //   36: astore_3
    //   37: goto +14 -> 51
    //   40: astore_3
    //   41: aload_3
    //   42: invokevirtual 60	java/lang/Exception:printStackTrace	()V
    //   45: iload_2
    //   46: istore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: iload_1
    //   50: ireturn
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_3
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	TbsPVConfig
    //   20	30	1	i	int
    //   3	43	2	j	int
    //   18	11	3	str	String
    //   36	1	3	localObject	Object
    //   40	14	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   4	19	36	finally
    //   21	33	36	finally
    //   41	45	36	finally
    //   4	19	40	java/lang/Exception
    //   21	33	40	java/lang/Exception
  }
  
  /* Error */
  public int getReadApk()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_2
    //   4: aload_0
    //   5: getfield 35	com/tencent/smtt/sdk/TbsPVConfig:a	Ljava/util/Map;
    //   8: ldc 69
    //   10: invokeinterface 43 2 0
    //   15: checkcast 45	java/lang/String
    //   18: astore_3
    //   19: iload_2
    //   20: istore_1
    //   21: aload_3
    //   22: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   25: ifne +22 -> 47
    //   28: aload_3
    //   29: invokestatic 57	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   32: istore_1
    //   33: goto +14 -> 47
    //   36: astore_3
    //   37: goto +14 -> 51
    //   40: astore_3
    //   41: aload_3
    //   42: invokevirtual 60	java/lang/Exception:printStackTrace	()V
    //   45: iload_2
    //   46: istore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: iload_1
    //   50: ireturn
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_3
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	TbsPVConfig
    //   20	30	1	i	int
    //   3	43	2	j	int
    //   18	11	3	str	String
    //   36	1	3	localObject	Object
    //   40	14	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   4	19	36	finally
    //   21	33	36	finally
    //   41	45	36	finally
    //   4	19	40	java/lang/Exception
    //   21	33	40	java/lang/Exception
  }
  
  public String getSyncMapValue(String paramString)
  {
    try
    {
      paramString = (String)this.a.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public boolean getTbsCoreSandboxModeEnable()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 75
    //   4: aload_0
    //   5: getfield 35	com/tencent/smtt/sdk/TbsPVConfig:a	Ljava/util/Map;
    //   8: ldc 77
    //   10: invokeinterface 43 2 0
    //   15: checkcast 45	java/lang/String
    //   18: invokevirtual 81	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   21: istore_1
    //   22: iload_1
    //   23: ifeq +18 -> 41
    //   26: iconst_1
    //   27: istore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_1
    //   31: ireturn
    //   32: astore_2
    //   33: goto +13 -> 46
    //   36: astore_2
    //   37: aload_2
    //   38: invokevirtual 60	java/lang/Exception:printStackTrace	()V
    //   41: iconst_0
    //   42: istore_1
    //   43: goto -15 -> 28
    //   46: aload_0
    //   47: monitorexit
    //   48: goto +5 -> 53
    //   51: aload_2
    //   52: athrow
    //   53: goto -2 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	TbsPVConfig
    //   21	22	1	bool	boolean
    //   32	1	2	localObject	Object
    //   36	16	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	22	32	finally
    //   37	41	32	finally
    //   2	22	36	java/lang/Exception
  }
  
  /* Error */
  public boolean isDisableHostBackupCore()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 35	com/tencent/smtt/sdk/TbsPVConfig:a	Ljava/util/Map;
    //   6: ldc 84
    //   8: invokeinterface 43 2 0
    //   13: checkcast 45	java/lang/String
    //   16: astore_2
    //   17: aload_2
    //   18: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifne +29 -> 50
    //   24: aload_2
    //   25: ldc 75
    //   27: invokevirtual 81	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   30: istore_1
    //   31: iload_1
    //   32: ifeq +18 -> 50
    //   35: iconst_1
    //   36: istore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: iload_1
    //   40: ireturn
    //   41: astore_2
    //   42: goto +13 -> 55
    //   45: astore_2
    //   46: aload_2
    //   47: invokevirtual 60	java/lang/Exception:printStackTrace	()V
    //   50: iconst_0
    //   51: istore_1
    //   52: goto -15 -> 37
    //   55: aload_0
    //   56: monitorexit
    //   57: goto +5 -> 62
    //   60: aload_2
    //   61: athrow
    //   62: goto -2 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	TbsPVConfig
    //   30	22	1	bool	boolean
    //   16	9	2	str	String
    //   41	1	2	localObject	Object
    //   45	16	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	31	41	finally
    //   46	50	41	finally
    //   2	31	45	java/lang/Exception
  }
  
  /* Error */
  public boolean isEnableNoCoreGray()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 35	com/tencent/smtt/sdk/TbsPVConfig:a	Ljava/util/Map;
    //   6: ldc 87
    //   8: invokeinterface 43 2 0
    //   13: checkcast 45	java/lang/String
    //   16: astore_2
    //   17: aload_2
    //   18: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifne +29 -> 50
    //   24: aload_2
    //   25: ldc 75
    //   27: invokevirtual 81	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   30: istore_1
    //   31: iload_1
    //   32: ifeq +18 -> 50
    //   35: iconst_1
    //   36: istore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: iload_1
    //   40: ireturn
    //   41: astore_2
    //   42: goto +13 -> 55
    //   45: astore_2
    //   46: aload_2
    //   47: invokevirtual 60	java/lang/Exception:printStackTrace	()V
    //   50: iconst_0
    //   51: istore_1
    //   52: goto -15 -> 37
    //   55: aload_0
    //   56: monitorexit
    //   57: goto +5 -> 62
    //   60: aload_2
    //   61: athrow
    //   62: goto -2 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	TbsPVConfig
    //   30	22	1	bool	boolean
    //   16	9	2	str	String
    //   41	1	2	localObject	Object
    //   45	16	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	31	41	finally
    //   46	50	41	finally
    //   2	31	45	java/lang/Exception
  }
  
  public void putData(String paramString1, String paramString2)
  {
    try
    {
      this.a.put(paramString1, paramString2);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsPVConfig
 * JD-Core Version:    0.7.0.1
 */