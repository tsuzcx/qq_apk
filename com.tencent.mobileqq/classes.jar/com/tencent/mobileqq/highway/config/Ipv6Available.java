package com.tencent.mobileqq.highway.config;

import android.content.Context;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.BdhUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Ipv6Available
{
  public static final int IPV6_AVALIBLE = 1;
  public static final int IPV6_AVALIBLE_UNKNOW = -1;
  public static final int IPV6_UNAVALIBLE = 0;
  public static final String TAG = "Ipv6Available";
  private HashMap<String, Integer> record = new HashMap();
  
  public void clearIpv6Available(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return;
      paramContext = BdhUtils.getCurNetKey(paramContext);
      if ((paramContext != null) && (!paramContext.isEmpty()))
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          String str = (String)paramContext.next();
          this.record.remove(str);
        }
      }
    }
  }
  
  public int getAvailable(Context paramContext)
  {
    if (paramContext == null) {
      return -1;
    }
    paramContext = BdhUtils.getCurNetKey(paramContext);
    if ((paramContext == null) || (paramContext.isEmpty())) {
      return -1;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      String str = (String)paramContext.next();
      if (this.record.get(str) != null) {
        return ((Integer)this.record.get(str)).intValue();
      }
    }
    return -1;
  }
  
  /* Error */
  public void recordIpv6Available(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_1
    //   10: invokestatic 36	com/tencent/mobileqq/highway/utils/BdhUtils:getCurNetKey	(Landroid/content/Context;)Ljava/util/ArrayList;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnull -9 -> 6
    //   18: aload_1
    //   19: invokevirtual 42	java/util/ArrayList:isEmpty	()Z
    //   22: ifne -16 -> 6
    //   25: aload_1
    //   26: invokevirtual 46	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   29: astore_1
    //   30: aload_1
    //   31: invokeinterface 51 1 0
    //   36: ifeq -30 -> 6
    //   39: aload_1
    //   40: invokeinterface 55 1 0
    //   45: checkcast 57	java/lang/String
    //   48: astore_2
    //   49: aload_0
    //   50: getfield 27	com/tencent/mobileqq/highway/config/Ipv6Available:record	Ljava/util/HashMap;
    //   53: aload_2
    //   54: iconst_1
    //   55: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   58: invokevirtual 81	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   61: pop
    //   62: ldc 83
    //   64: new 85	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   71: ldc 88
    //   73: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_2
    //   77: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 102	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: goto -56 -> 30
    //   89: astore_1
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	Ipv6Available
    //   0	94	1	paramContext	Context
    //   48	29	2	str	String
    // Exception table:
    //   from	to	target	type
    //   9	14	89	finally
    //   18	30	89	finally
    //   30	86	89	finally
  }
  
  public void recordIpv6Unavailable(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return;
      paramContext = BdhUtils.getCurNetKey(paramContext);
      if ((paramContext != null) && (!paramContext.isEmpty()))
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          String str = (String)paramContext.next();
          if ((this.record.get(str) == null) || (((Integer)this.record.get(str)).intValue() != 1))
          {
            this.record.put(str, Integer.valueOf(0));
            BdhLogUtil.LogEvent("C", "recordIpv6Unavailable, key =" + str);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.config.Ipv6Available
 * JD-Core Version:    0.7.0.1
 */