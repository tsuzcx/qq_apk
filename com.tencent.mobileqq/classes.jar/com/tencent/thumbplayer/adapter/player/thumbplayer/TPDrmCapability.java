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
    try
    {
      if (paramHashSet.size() <= 0) {
        break label69;
      }
      paramHashSet = paramHashSet.toArray();
      capArray = new int[paramHashSet.length];
      i = 0;
    }
    finally
    {
      for (;;)
      {
        int i;
        for (;;)
        {
          label69:
          throw paramHashSet;
        }
        i += 1;
      }
    }
    if (i < paramHashSet.length)
    {
      if ((paramHashSet[i] instanceof String)) {
        capArray[i] = Integer.parseInt((String)paramHashSet[i]);
      } else {
        capArray[i] = -1;
      }
    }
    else
    {
      paramHashSet = new StringBuilder();
      paramHashSet.append("TPDrmCapability, read sp ret:");
      paramHashSet.append(Arrays.toString(capArray));
      TPLogUtil.i("TPDrmCapability", paramHashSet.toString());
      return;
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
  
  public static boolean isDRMSupport(int paramInt)
  {
    try
    {
      int[] arrayOfInt = capArray;
      int j = arrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = arrayOfInt[i];
        if (k == paramInt) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    finally
    {
      localObject = finally;
    }
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.thumbplayer.TPDrmCapability
 * JD-Core Version:    0.7.0.1
 */