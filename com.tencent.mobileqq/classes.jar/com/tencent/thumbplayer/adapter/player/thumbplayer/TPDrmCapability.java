package com.tencent.thumbplayer.adapter.player.thumbplayer;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.TPThreadUtil;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.ScheduledExecutorService;

public class TPDrmCapability
{
  private static final String DRM_KEY = "DRM_CAP_LIST";
  private static final String DRM_SP_NAME = "DRM_CAP";
  private static final String TAG = "TPDrmCapability";
  private static int[] capArray = new int[0];
  
  private static void capRead(HashSet<String> paramHashSet)
  {
    if (paramHashSet != null) {}
    for (;;)
    {
      int i;
      try
      {
        if (paramHashSet.size() > 0)
        {
          paramHashSet = paramHashSet.toArray();
          capArray = new int[paramHashSet.length];
          i = 0;
          if (i < paramHashSet.length) {
            if ((paramHashSet[i] instanceof String)) {
              capArray[i] = Integer.parseInt((String)paramHashSet[i]);
            } else {
              capArray[i] = -1;
            }
          }
        }
      }
      finally {}
      TPLogUtil.i("TPDrmCapability", "TPDrmCapability, read sp ret:" + Arrays.toString(capArray));
      return;
      i += 1;
    }
  }
  
  public static int[] getDRMCapabilities()
  {
    try
    {
      int[] arrayOfInt = capArray;
      return arrayOfInt;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void init(Context paramContext)
  {
    TPLogUtil.i("TPDrmCapability", "TPDrmCapability, init");
    if (!TPPlayerMgr.isThumbPlayerEnable()) {
      return;
    }
    TPLogUtil.i("TPDrmCapability", "TPDrmCapability, read sp.");
    paramContext = paramContext.getSharedPreferences("DRM_CAP", 0);
    capRead((HashSet)paramContext.getStringSet("DRM_CAP_LIST", new HashSet()));
    TPThreadUtil.getScheduledExecutorServiceInstance().execute(new TPDrmCapability.1(paramContext));
  }
  
  /* Error */
  public static boolean isDRMSupport(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: ldc 2
    //   5: monitorenter
    //   6: getstatic 20	com/tencent/thumbplayer/adapter/player/thumbplayer/TPDrmCapability:capArray	[I
    //   9: astore 6
    //   11: aload 6
    //   13: arraylength
    //   14: istore_2
    //   15: iconst_0
    //   16: istore_1
    //   17: iload 5
    //   19: istore 4
    //   21: iload_1
    //   22: iload_2
    //   23: if_icmpge +16 -> 39
    //   26: aload 6
    //   28: iload_1
    //   29: iaload
    //   30: istore_3
    //   31: iload_3
    //   32: iload_0
    //   33: if_icmpne +12 -> 45
    //   36: iconst_1
    //   37: istore 4
    //   39: ldc 2
    //   41: monitorexit
    //   42: iload 4
    //   44: ireturn
    //   45: iload_1
    //   46: iconst_1
    //   47: iadd
    //   48: istore_1
    //   49: goto -32 -> 17
    //   52: astore 6
    //   54: ldc 2
    //   56: monitorexit
    //   57: aload 6
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	paramInt	int
    //   16	33	1	i	int
    //   14	10	2	j	int
    //   30	4	3	k	int
    //   19	24	4	bool1	boolean
    //   1	17	5	bool2	boolean
    //   9	18	6	arrayOfInt	int[]
    //   52	6	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	15	52	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.thumbplayer.TPDrmCapability
 * JD-Core Version:    0.7.0.1
 */